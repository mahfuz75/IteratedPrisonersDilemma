import java.util.ArrayList;
import java.util.List;

/**
* Class containing the gradual evolve strategy.
*/
public class StrategyGradualEvolve extends Strategy
{
  /**
  * Encoding for gradual evolve strategy.
  */

  int defect_n;// = 0;
  int punish_count;/// = 0;
  boolean isHot;// = false;
  String probe;
  int punish_scale;
  int cooldown_scale;

  int calm_count;
  int iteration;

  // 0 = defect, 1 = cooperate

  public StrategyGradualEvolve(String probe)
  {
    name = "Gradual Evolve";
    opponentLastMove = 1;
    isHot = false;
    punish_count = 0;
    defect_n = 0;
    this.probe = probe;
    this.punish_scale = calculatePunishScale(probe);
    this.cooldown_scale = calculateCooldownScale(probe);

    calm_count = 0;
    iteration = -1;

    // System.out.println("punish_scale: " + punish_scale);
    // System.out.println("cooldown_scale: " + cooldown_scale);
  }  /* StrategyGradualEvolve */

  private int bin2dec(String bin){
    int result = 0;
    int base = 1;
    for(int i=bin.length()-1; i>=0; i--){
      result += (bin.charAt(i) - '0') * base;
      base *= 2;
    }
    return result;
  }
  private int calculatePunishScale(String p){
    String punishBits = p.substring(0, (p.length()+1)/2);
    return bin2dec(punishBits);
  }

  private int calculateCooldownScale(String p){
    String coolingBits = p.substring((p.length()+1)/2);
    return bin2dec(coolingBits);
  }

  public int nextMove()
  {
    int maxPunishScale = (int)(Math.pow(2, (int)((probe.length()+1)/2))) - 1;

    iteration++;
    if(iteration == 0) return 1;
    if(punish_count > 0){
      punish_count--;
      if(opponentLastMove == 0) defect_n++;
      return 0;
    }
    if(calm_count > 0){
      calm_count--;
      if(opponentLastMove == 0) defect_n++;
      return 1;
    }
    if(opponentLastMove == 0){
      defect_n++;
      // punish_count = defect_n - 1;
      if(punish_scale == maxPunishScale){
        punish_count = defect_n - 1;
      }
      else{
        punish_count = punish_scale - 1;
      }
      // calm_count = 2;
      calm_count = cooldown_scale;
      return 0;
    }
    return 1;


    // if(opponentLastMove == 0){
    //   // System.out.println("Opp Last: " + opponentLastMove);
    //   isHot = true;
    //   defect_n++;
    //   if(punish_scale == maxPunishScale){
    //     punish_count = defect_n;
    //   }
    //   else{
    //     punish_count = punish_scale;
    //   }
    //   // punish_count = defect_n;
    // }
    //
    // if(isHot == true){
    //   punish_count--;
    //   if(punish_count == -1 * cooldown_scale){
    //     isHot = false;
    //   }
    //   if(punish_count < 0){
    //     return 1;
    //   }
    //   return 0;
    // }
    // return 1;
  }

}  /* class StrategyGradualEvolve */
