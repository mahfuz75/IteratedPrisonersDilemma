import java.util.ArrayList;
import java.util.List;

public class StrategyHardTitForTat extends Strategy
{
  /**
  * Encoding for hard tit-for-tat strategy.
  */

  int iteration;
  List<Integer> opponentMoves;

  // 0 = defect, 1 = cooperate

  public StrategyHardTitForTat()
  {
    name = "Hard Tit for Tat";
    // opponentLastMove = 1;
    // numDefects = 0;
    iteration = -1;
    opponentMoves = new ArrayList<Integer>();
  }  /* StrategyHardTitForTat */

  public void saveOpponentMove(int move){
    opponentLastMove = move;
    opponentMoves.add(opponentLastMove);
    // System.out.println("Adding " + opponentLastMove);
  }

  public int nextMove()
  {
    iteration++;

    if(iteration < 2) return 1;

    if(opponentLastMove == 0 || opponentMoves.get(iteration-2) == 0){
      return 0;
    }
    return 1;

  }  /* nextMove */

}  /* class StrategyHardTitForTat */
