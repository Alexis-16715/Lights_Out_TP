package lights_out.model;

import java.util.Random;

public class Tp_Model {
	private Light_Bulb[][] pattern;
    private int numberAttempts;
    
    //Cada vez que se llama a esta funcion, se crea la matrix
	public Tp_Model(int x) {
		pattern = new Light_Bulb[x][x];
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
    
    
    //Esto cambia el estado matrix, de Verdadero a Falso, tambien para lo contrario
    //Tambien cambia el estado de la matrix de la columna y fila selecionada
    public void toggleState(int specificRow, int specificCol) {
    	numberAttempts++;
    	for(int row = 0; row < pattern.length; row++) {
    		
    		// Cambia de verdadero a falso, y viseversa 
    		pattern[row][specificCol].toggleState();
    	}
    	
    	for(int col = 0; col < pattern.length; col++) {
    		pattern[specificRow][col].toggleState();
    	}
    	pattern[specificRow][specificCol].toggleState();
    }
    
    
    
    //Checkea si se gano el juego.
    public boolean wonAllLightsOut(){
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
