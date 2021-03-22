import java.util.ArrayList;
import java.util.List;

/**
* Class containing the hard-majo strategy.
*/
public class StrategyHardMajo extends Strategy
{
  /**
  * Encoding for hard-majo strategy.
  */

  int defect_count;
  int cooperate_count;

  // 0 = defect, 1 = cooperate

  public StrategyHardMajo()
  {
    name = "Hard-majo";
    opponentLastMove = 1;
    defect_count = 0;
    cooperate_count = 0;
  }  /* StrategyHardMajo */

  public void saveOpponentMove(int move){
    opponentLastMove = move;
    if(move == 0){
      defect_count++;
    }
    else{
      cooperate_count++;
    }
  }

  public int nextMove()
  {
    if(defect_count >= cooperate_count){
      return 0;
    }
    return 1;
  }

}  /* class StrategyHardMajo */
