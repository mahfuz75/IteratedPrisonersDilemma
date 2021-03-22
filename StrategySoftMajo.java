import java.util.ArrayList;
import java.util.List;

/**
* Class containing the soft-majo strategy.
*/
public class StrategySoftMajo extends Strategy
{
  /**
  * Encoding for soft-majo strategy.
  */

  int defect_count;
  int cooperate_count;

  // 0 = defect, 1 = cooperate

  public StrategySoftMajo()
  {
    name = "Soft-majo";
    opponentLastMove = 1;
    defect_count = 0;
    cooperate_count = 0;
  }  /* StrategySoftMajo */

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
    if(cooperate_count >= defect_count){
      return 1;
    }
    return 0;
  }

}  /* class StrategySoftMajo */
