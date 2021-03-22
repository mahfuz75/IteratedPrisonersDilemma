import java.util.ArrayList;
import java.util.List;

/**
 * Class containing the gradual strategy.
 */
public class StrategyGradual extends Strategy
{
  /**
  * Encoding for gradual strategy.
  */

  int defect_n;
  int punish_count;
  int calm_count;
  boolean isHot;
  int iteration;

  // 0 = defect, 1 = cooperate

  public StrategyGradual()
  {
    name = "Gradual";
    opponentLastMove = 1;
    isHot = false;
    punish_count = 0;
    calm_count = 0;
    defect_n = 0;
    iteration = -1;
  }  /* StrategyGradual */

  public int nextMove()
  {
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
      punish_count = defect_n - 1;
      calm_count = 2;
      return 0;
    }
    return 1;


    // if(opponentLastMove == 0){
    //   // System.out.println("Opp Last: " + opponentLastMove);
    //   isHot = true;
    //   defect_n++;
    //   punish_count = defect_n;
    // }
    //
    // if(isHot == true){
    //   punish_count--;
    //   if(punish_count == -2){
    //     isHot = false;
    //   }
    //   if(punish_count < 0){
    //     return 1;
    //   }
    //   return 0;
    // }
    // return 1;
  }

}  /* class StrategyGradual */
