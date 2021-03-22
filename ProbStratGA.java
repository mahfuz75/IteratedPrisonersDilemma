
import java.io.*;
import java.util.*;
import java.text.*;

public class ProbStratGA extends FitnessFunction {


/*******************************************************************************
*                              CONSTRUCTORS                                    *
*******************************************************************************/

	public ProbStratGA(){
		name = "ProbStrat Problem";
	}

/*******************************************************************************
*                                MEMBER METHODS                                *
*******************************************************************************/

//  COMPUTE A CHROMOSOME'S RAW FITNESS *************************************

	public void doRawFitness(Chromo X){

		X.rawFitness = 0;
        
        //Runs Tourney to get Fitness
        X.rawFitness += RunIPD.runTourney(X.chromo, new StrategyAlwaysCooperate());
        X.rawFitness += RunIPD.runTourney(X.chromo, new StrategyAlwaysDefect());
        X.rawFitness += RunIPD.runTourney(X.chromo, new StrategyGradual());
        X.rawFitness += RunIPD.runTourney(X.chromo, new StrategyGradualEvolve(X.chromo));
        X.rawFitness += RunIPD.runTourney(X.chromo, new StrategyHardMajo());
        X.rawFitness += RunIPD.runTourney(X.chromo, new StrategyHardTitForTat());
        X.rawFitness += RunIPD.runTourney(X.chromo, new StrategyPavlov());
        X.rawFitness += RunIPD.runTourney(X.chromo, new StrategyProbe("100"));
        X.rawFitness += RunIPD.runTourney(X.chromo, new StrategyProbe(X.chromo));
        X.rawFitness += RunIPD.runTourney(X.chromo, new StrategyRandom());
        X.rawFitness += RunIPD.runTourney(X.chromo, new StrategySlowTitForTat());
        X.rawFitness += RunIPD.runTourney(X.chromo, new StrategySoftMajo());
        X.rawFitness += RunIPD.runTourney(X.chromo, new StrategySuspiciousTitForTat());
        X.rawFitness += RunIPD.runTourney(X.chromo, new StrategyTitForTat());
        X.rawFitness += RunIPD.runTourney(X.chromo, new StrategyTitForTwoTats());

        X.rawFitness /= 15; //averaged across 14 opponents
	}

//  PRINT OUT AN INDIVIDUAL GENE TO THE SUMMARY FILE *********************************

	public void doPrintGenes(Chromo X, FileWriter output) throws java.io.IOException{

		for (int i=0; i<Parameters.numGenes; i++){
			Hwrite.right(X.getGeneAlpha(i),11,output);
		}
		output.write("   RawFitness");
		output.write("\n        ");
		for (int i=0; i<Parameters.numGenes; i++){
			Hwrite.right(X.getPosIntGeneValue(i), 11, 3, output);
		}
		Hwrite.right( X.rawFitness, 13, 3, output);
		output.write("\n\n");
		return;
	}

/*******************************************************************************
*                             STATIC METHODS                                   *
*******************************************************************************/

} 
