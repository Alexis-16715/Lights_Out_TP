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
	private URL lighOff = getClass().getResource("/images/Light Off.png");
	private JLabel attemptsLabel;
	private JLabel labelVictory;
	private static int nivel = 3;
	private JButton newGame;
	private JButton buttonStart;
	private JButton buttonExit;
	private JButton buttonDificulty;
	private JButton buttonvolverAlMenu;
    private JButton button3x3;
    private JButton button4x4;
    private JButton button5x5;
    private JButton buttonMenu;
	
	
	
	
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
	        				hideButtons(button3x3,button3x3.isVisible());
	     	        		hideButtons(button4x4,button4x4.isVisible());
	     	        		hideButtons(button5x5,button5x5.isVisible());
	     	        		hideButtons(buttonStart,buttonStart.isVisible());
	    	        		hideButtons(buttonExit,buttonExit.isVisible());
	    	        		hideButtons(buttonDificulty,buttonDificulty.isVisible());
	    	        		nivel = 3;
	    	        		model = new Tp_Model(nivel);
	    	        		
	     	        		
	        			 
	        			 }
	        		});
	        		button4x4 = view.getButton4x4();
	        		button4x4.addActionListener (new ActionListener(){
	        			 public void actionPerformed(ActionEvent e) {
	        				hideButtons(button3x3,button3x3.isVisible());
		     	        	hideButtons(button4x4,button4x4.isVisible());
		     	        	hideButtons(button5x5,button5x5.isVisible());
		     	        	hideButtons(buttonStart,buttonStart.isVisible());
		    	        	hideButtons(buttonExit,buttonExit.isVisible());
		    	        	hideButtons(buttonDificulty,buttonDificulty.isVisible());
		    	        	nivel = 4;
		    	        	model = new Tp_Model(nivel);
	        			 }
	        		});
	        		button5x5 = view.getButton5x5();
	        		button5x5.addActionListener (new ActionListener(){
	        			 public void actionPerformed(ActionEvent e) {
	        				hideButtons(button3x3,button3x3.isVisible());
		     	        	hideButtons(button4x4,button4x4.isVisible());
		     	        	hideButtons(button5x5,button5x5.isVisible());
		     	        	hideButtons(buttonStart,buttonStart.isVisible());
		    	        	hideButtons(buttonExit,buttonExit.isVisible());
		    	        	hideButtons(buttonDificulty,buttonDificulty.isVisible());
		    	        	nivel = 5;
		    	        	model = new Tp_Model(nivel);
	        			 }
	        		});
	            }
	        });
		
	}
	
	
	//As the name implide, this hide a button.
	private void hideButtons(JButton button, Boolean visible) {
		button.setVisible(!visible);
	}
	
	
	private void initializeViewGame() {
		Light_Bulb[][] stateLightBulb = model.getStateGame();
		if(nivel == 3)
			buttons = view.getGameInterface3x3();
		if(nivel == 4)
	        buttons = view.getGameInterface4x4();
		if(nivel == 5)
	        buttons = view.getGameInterface5x5();
        attemptsLabel = view.getAttemtsLabel();
        labelVictory = view.getVictory();
        
        
        //This to Set-Up de New Game Botton
        newGame = view.getBottonNewGame();
			attachListenerNewGame(newGame);
			
		buttonMenu = view.getButtonMenu();
			attachListenerbuttonMenu(buttonMenu);
	        
        
        // Set up the Label Attempts
        
        attemptsLabel.setText("Attempts : " + model.getNumberAttemps());
        
        for (int i = 0; i < stateLightBulb.length; i++) {
            for (int j = 0; j < stateLightBulb[0].length; j++) {
            	buttons[i][j].setIcon(new ImageIcon(stateLightBulb[i][j].getSwich_On_Or_Off() ? lighOff : lightOn));
            	attachListenerToButton(i, j);
            }
        }
        
        // Calls it to update the game
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
            	for(int i = 0 ; i < buttons.length; i++) {
        			for(int j = 0 ; j < buttons.length; j++) {
        				hideButtons(buttons[j][i],buttons[j][i].isVisible());
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

	private void attachListenerbuttonvolverAlMenu(JButton buttonvolverAlMenu) {
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
	
	//This change the light state, and before you ask, this have to Model first to change it, it change the row and the col of the matrix. 
	private void attachListenerToButton(int row, int col) {
        buttons[row][col].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.toggleState(row, col);
                //this is for the update in the icons
                updateView();
            }
        });
    }
	
	
	private void updateView() {
		Light_Bulb[][] stateLightBulb = model.getStateGame();
        
        //Update on the lights Icon
        
        for (int column = 0; column < stateLightBulb.length; column++) {
            for (int row = 0; row < stateLightBulb[column].length; row++) {
                buttons[column][row].setIcon(new ImageIcon(stateLightBulb[column][row].getSwich_On_Or_Off() ? lighOff : lightOn));
            }
        }
        
        // Updastes the label and check if it won the game
        attemptsLabel.setText("Clicks : " + model.getNumberAttemps());
        if (model.wonAllLihhtOut()) {
        		for(int i = 0 ; i < buttons.length; i++) {
        			for(int j = 0 ; j < buttons.length; j++) {
        				hideButtons(buttons[j][i],buttons[j][i].isVisible());
        			}
        		}
        		hideButtons(newGame,newGame.isVisible());
        		attemptsLabel.setVisible(false);

        		buttonvolverAlMenu = view.getBottonvolverAlMenu();
        		attachListenerbuttonvolverAlMenu(buttonvolverAlMenu); 
        		startNewGame();

        	
            
        }
        
    }
	
	private void startNewGame() {
        model = new Tp_Model(nivel);
        updateView();
    }
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Tp_Model model = new Tp_Model(nivel);
            	Tp_View view = new Tp_View();
                new TP_Controller(model, view);
                view.getFrame().setVisible(true);
            }
        });
	}
	
	
}
