import java.util.ArrayList;
import java.util.List;

public class StrategySlowTitForTat extends Strategy
{
  /**
  * Encoding for slow tit-for-tat strategy.
  */

  int iteration;
  List<Integer> opponentMoves;
  boolean isDefecting;

  // 0 = defect, 1 = cooperate

  public StrategySlowTitForTat()
  {
    name = "Slow Tit for Tat";
    iteration = -1;
    opponentMoves = new ArrayList<Integer>();
    isDefecting = false;
  }  /* StrategySlowTitForTat */

  public void saveOpponentMove(int move){
    opponentLastMove = move;
    opponentMoves.add(opponentLastMove);
    // System.out.println("Adding " + opponentLastMove);
  }

  public int nextMove()
  {
    iteration++;

    if(iteration < 2) return 1;

    if(opponentLastMove == 0 && opponentMoves.get(iteration-2) == 0){
      isDefecting = true;
    }
    if(opponentLastMove == 1 && opponentMoves.get(iteration-2) == 1){
      isDefecting = false;
    }

    if(isDefecting == true) return 0;
    return 1;

  }  /* nextMove */

}  /* class StrategySlowTitForTat */
