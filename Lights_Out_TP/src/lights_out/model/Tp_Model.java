package lights_out.model;

import java.util.Random;

public class Tp_Model {
	private Light_Bulb[][] pattern;
    private int numberAttempts;
	public Tp_Model() {
		// Every time you call a new TP_Model you have to put new date in the matrix
		pattern = new Light_Bulb[4][4];
        Random rand = new Random();

        for (int row = 0; row < pattern.length; row++) {
            for (int col = 0; col < pattern[row].length; col++) {
            	pattern[row][col] = new Light_Bulb(rand.nextBoolean());
            }
        }
        numberAttempts = 0;
    }

    public Light_Bulb[][] getStateGame() {
        return pattern;
    }
    
    //this is to change the change the state from true or false
    public void toggleState(int specificRow, int specificCol) {
    	numberAttempts++;
    	//specific
    	for(int row = 0; row < pattern.length; row++) {
    		
    		// toggleState you can change from true to false and vice bersa
    		pattern[row][specificCol].toggleState();
    	}
    	
    	for(int col = 0; col < pattern.length; col++) {
    		pattern[specificRow][col].toggleState();
    	}
    	pattern[specificRow][specificCol].toggleState();
    }
    
    
    
    //this check if the matrix, so see if the ALL of the matrix is true
    public boolean wonAllLihhtOut(){
    	boolean ret = true;
    	for(int col = 0; col < pattern.length; col++) {
    		for(int row = 0; row < pattern[0].length; row++) {
    			ret = ret && pattern[col][row].getSwich_On_Or_Off();
    		}
    	}
    	return ret;
    }

    public int getNumberAttemps() {
        return numberAttempts;
    }

}
