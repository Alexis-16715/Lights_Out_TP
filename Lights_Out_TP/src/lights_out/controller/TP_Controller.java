package lights_out.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import lights_out.model.Light_Bulb;
import lights_out.model.Tp_Model;
import lights_out.view.Tp_View;

public class TP_Controller {
	
	private Tp_View view;
	private Tp_Model model;
	private URL lightOn = getClass().getResource("/images/Light On.png");
	private URL lightOff = getClass().getResource("/images/Light Off.png");
	
	
	private JLabel attemptsLabel;
	private JLabel labelVictory;
	
	
	
	private static int level = 3;
	private JButton newGame;
	private JButton buttonStart;
	private JButton buttonExit;
	private JButton buttonDificulty;
	private JButton buttonBackToMenu;
	private JButton buttonMenu;
	
	
    private JButton button3x3;
    private JButton button4x4;
    private JButton button5x5;
	
	private JButton[][] buttons;
	
	public TP_Controller(Tp_Model model, Tp_View view) {
		this.model = model;
        this.view = view;
        attachListenersMenu();
        
	}
	
	private void attachListenersMenu() {
		 buttonStart = view.getBottonsStart();
		 buttonExit = view.getBottonsExit();
		 buttonDificulty = view.getBottonsDificulty();
		
		buttonStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	hideButtons(buttonStart, buttonStart.isVisible());
            	hideButtons(buttonExit, buttonExit.isVisible());
            	hideButtons(buttonDificulty, buttonDificulty.isVisible());
            	initializeViewGame();
            }
        });
	
		buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	System.exit(0);
            }
        });
	
			buttonDificulty.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	hideButtons(buttonStart,buttonStart.isVisible());
	        		hideButtons(buttonExit,buttonExit.isVisible());
	        		hideButtons(buttonDificulty,buttonDificulty.isVisible());
	        	
	        		button3x3 = view.getButton3x3();
	        		
	        		
	        		button3x3.addActionListener (new ActionListener(){
	        			 public void actionPerformed(ActionEvent e) {
	        				hideMultipleButtons ();
	    	        		level = 3;
	    	        		model = new Tp_Model(level);
	    	        		
	     	        		
	        			 
	        			 }
	        		});
	        		
	        		button4x4 = view.getButton4x4();
	        		button4x4.addActionListener (new ActionListener(){
	        			 public void actionPerformed(ActionEvent e) {
	        				hideMultipleButtons ();
		    	        	level = 4;
		    	        	model = new Tp_Model(level);
	        			 }
	        		});
	        		
	        		button5x5 = view.getButton5x5();
	        		button5x5.addActionListener (new ActionListener(){
	        			 public void actionPerformed(ActionEvent e) {
		    	        	hideMultipleButtons();
		    	        	level = 5;
		    	        	model = new Tp_Model(level);
	        			 }
	        		});
	            }
	        });
		
	}
	
	
	
	
	
	
	
	//Como el nombre lo implica, esto solo esconde un boton si llamado
	private void hideButtons(JButton button, Boolean visible) {
		button.setVisible(!visible);
	}
	
	//Esta funcion esta hecha para esconder los menus, ayuda a minimizar el codigo y permitir que se entienda mejor
	private void hideMultipleButtons () {
		hideButtons(button3x3, button3x3.isVisible());
		hideButtons(button4x4, button4x4.isVisible());
		hideButtons(button5x5, button5x5.isVisible());
		hideButtons(buttonStart, buttonStart.isVisible());
		hideButtons(buttonExit, buttonExit.isVisible());
		hideButtons(buttonDificulty, buttonDificulty.isVisible());
	}
	
	
	private void initializeViewGame() {
		Light_Bulb[][] stateLightBulb = model.getStateGame();
		if(level == 3)
			buttons = view.getGameInterface3x3();
		if(level == 4)
	        buttons = view.getGameInterface4x4();
		if(level == 5)
	        buttons = view.getGameInterface5x5();
        attemptsLabel = view.getAttemtsLabel();
        
        
        //Esto para configurar un nuevo botón de juego
        newGame = view.getBottonNewGame();
			attachListenerNewGame(newGame);
			
		buttonMenu = view.getButtonMenu();
			attachListenerbuttonMenu(buttonMenu);
	        
        
        // Configurar los "Label Attempts"
        
        attemptsLabel.setText("Attempts : " + model.getNumberAttemps());
        
        for (int row = 0; row < stateLightBulb.length; row++) {
            for (int column = 0; column < stateLightBulb[0].length; column++) {
            	buttons[row][column].setIcon(new ImageIcon(stateLightBulb[row][column].getSwich_On_Or_Off() ? lightOff : lightOn));
            	attachListenerToButton(row, column);
            }
        }
        
        // Esto actualiza el juego.
        updateView();
    }
	
	
	private void attachListenerNewGame(JButton bottonNewGame) {
		bottonNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGame();
            }
        });
	}
	
	private void attachListenerbuttonMenu(JButton buttonMenu) {
		buttonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	for(int row = 0 ; row < buttons.length; row++) {
        			for(int column = 0 ; column < buttons.length; column++) {
        				hideButtons(buttons[column][row],buttons[column][row].isVisible());
        			}
        		}
            	
        		hideButtons(newGame,newGame.isVisible());
        		attemptsLabel.setVisible(false);
        		hideButtons(buttonStart,buttonStart.isVisible());
        		hideButtons(buttonExit,buttonExit.isVisible());
        		hideButtons(buttonDificulty,buttonDificulty.isVisible());
        		hideButtons(buttonMenu,buttonMenu.isVisible());
        		startNewGame();
            }
        });
	}
	
	//Esta funcion se llama para traer el menu de vuelta

	private void attachListenerButtonBackToMenu(JButton buttonvolverAlMenu) {
		buttonvolverAlMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		hideButtons(buttonStart,buttonStart.isVisible());
        		hideButtons(buttonExit,buttonExit.isVisible());
        		hideButtons(buttonDificulty,buttonDificulty.isVisible());
                startNewGame();
                hideButtons(buttonvolverAlMenu,buttonvolverAlMenu.isVisible());
            }
        });
	}
	
	//Esto llama a funcion para cambiar el valor de la matrix, dentro de esa funcion de toggleState, cambia el estado de la fila y la columna de la matrix
	//Para que cumpla con el juego
	private void attachListenerToButton(int row, int col) {
        buttons[row][col].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.toggleState(row, col);
                //Esto es para actualizar los botones
                updateView();
            }
        });
    }
	
	
	
	private void updateView() {
		Light_Bulb[][] stateLightBulb = model.getStateGame();
        
        //Actualiza los iconos de las luces
        
        for (int column = 0; column < stateLightBulb.length; column++) {
            for (int row = 0; row < stateLightBulb[column].length; row++) {
                buttons[column][row].setIcon(new ImageIcon(stateLightBulb[column][row].getSwich_On_Or_Off() ? lightOff : lightOn));
            }
        }
        
        //Actualiza el texto para llevar en cuenta la cantidad de clicks
        attemptsLabel.setText("Clicks : " + model.getNumberAttemps());
        
        //Verifica si gano el juego, si es asi, se esconde los botones y se coloca una pantalla felizitanto al jugador
        if (model.wonAllLightsOut()) {
        		for(int i = 0 ; i < buttons.length; i++) {
        			for(int j = 0 ; j < buttons.length; j++) {
        				hideButtons(buttons[j][i],buttons[j][i].isVisible());
        			}
        		}
        		hideButtons(newGame,newGame.isVisible());
        		hideButtons(buttonMenu,buttonMenu.isVisible());
        		attemptsLabel.setVisible(false);
        		
        		labelVictory = view.getLabelVictory();

        		buttonBackToMenu = view.getBottonvolverAlMenu();
        		attachListenerButtonBackToMenu(buttonBackToMenu); 
        		startNewGame();

        	
            
        }
        
    }
	
	
	//Si se llama empienza un nuevo juego.
	private void startNewGame() {
        model = new Tp_Model(level);
        updateView();
    }
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Tp_Model model = new Tp_Model(level);
            	Tp_View view = new Tp_View();
                new TP_Controller(model, view);
                view.getFrame().setVisible(true);
            }
        });
	}
	
	
}
