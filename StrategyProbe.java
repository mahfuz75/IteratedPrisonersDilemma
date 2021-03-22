import java.util.ArrayList;
import java.util.List;

public class StrategyProbe extends Strategy {
    /**
     * Encoding for Probe strategy.
     */

    // 0 = defect, 1 = cooperate
    
    String probe;
    int iteration;
    List<Integer> opponentMoves;
    boolean isTitForTat; 

    public StrategyProbe(String probe) {
        name = "Probe";
        this.probe = probe;
        iteration = -1;
        opponentMoves = new ArrayList<Integer>();
        isTitForTat = true; 
    } 

    public int nextMove() {
        iteration++;
        if(iteration < probe.length() && iteration > 0) {
            opponentMoves.add(opponentLastMove); 
        }

        if(iteration <= probe.length() && iteration > 1 && opponentLastMove != Character.getNumericValue(probe.charAt(iteration - 2))) {
            isTitForTat = false;
        }
        
        if(iteration < probe.length()) {
            return Character.getNumericValue(probe.charAt(iteration));
        }
        else if(isTitForTat) {
            //always cooperate when playing agaisnt TitForTat
            //return opponentLastMove;
            return 1;
        }
        else {
            //Always Defect
            return 0;
        }

    }

}
