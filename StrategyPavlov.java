/**
* Class containing the pavlov strategy.
*/
public class StrategyPavlov extends Strategy
{
  /**
  * Encoding for pavlov strategy.
  */

  // 0 = defect, 1 = cooperate
  int iteration;

  public StrategyPavlov()
  {
    name = "Pavlov";
    iteration = -1;
    // opponentLastMove = 1;
  }  /* StrategyPavlov */

  public int nextMove()
  {
    iteration++;

    if(iteration < 1) return 1;

    if(myLastMove != opponentLastMove){
      return 0;
    }
    return 1;
  }  /* nextMove */

}  /* class StrategyPavlov */
