package window.model;

import java.util.Random;

public class Tp_Model {
	private Light_Bulb[][] pattern;
    private int numberAttempts;
	public Tp_Model() {
		pattern = new Light_Bulb[4][4];
        Random rand = new Random();

        for (int i = 0; i < pattern.length; i++) {
            for (int j = 0; j < pattern[i].length; j++) {
            	pattern[i][j] = new Light_Bulb(rand.nextBoolean());
            }
        }
        numberAttempts = 0;
    }

    public Light_Bulb[][] getStateGame() {
        return pattern;
    }

    public void toggleState(int row, int col) {
    	numberAttempts++;
    	
    	for(int i = 0; i < pattern.length; i++) {
    		pattern[i][col].toggleState();
    	}
    	
    	for(int j = 0; j < pattern.length; j++) {
    		pattern[row][j].toggleState();
    	}
    	pattern[row][col].toggleState();
    }
    
    
    
    //esta parte se nesesita testear
    
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
