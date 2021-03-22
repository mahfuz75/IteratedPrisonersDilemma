/**
 * Class containing the suspicious tit-for-tat strategy.
 */
public class StrategySuspiciousTitForTat extends Strategy
{
  /**
  * Encoding for suspicious tit-for-tat strategy.
  */

  // 0 = defect, 1 = cooperate

  public StrategySuspiciousTitForTat()
  {
    name = "Suspicious Tit for Tat";
    opponentLastMove = 0;
  }  /* StrategySuspiciousTitForTat */

  public int nextMove()
  {
    return opponentLastMove;
  }  /* nextMove */

}  /* class StrategySuspiciousTitForTat */
