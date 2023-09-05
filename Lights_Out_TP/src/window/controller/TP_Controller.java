package window.controller;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import window.model.Tp_Model;
import window.model.Light_Bulb;
import window.view.Tp_View;

public class TP_Controller {
	
	private Tp_View view;
	private Tp_Model model;
	private URL lightOn = getClass().getResource("/images/Light On.png");
	private URL lighOff = getClass().getResource("/images/Light Off.png");
	private JLabel attemptsLabel;
	private JLabel labelVictory;
	
	
	
	private JButton[][] buttons;
	
	public TP_Controller(Tp_Model model, Tp_View view) {
		this.model = model;
        this.view = view;
        attachListenersMenu();
	}
	
	private void attachListenersMenu() {
		JButton buttonStart = view.getBottonsStart();
		JButton buttonExit = view.getBottonsExit();
		
		buttonStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	hideButtons(buttonStart, buttonStart.isVisible());
            	hideButtons(buttonExit, buttonExit.isVisible());
            	initializeViewGame();
            }
        });
	
		buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	System.exit(0);
            }
        });
	}
	
	
	//As the name implide, this hide a button.
	private void hideButtons(JButton button, Boolean visible) {
		button.setVisible(!visible);
	}
	
	private void initializeViewGame() {
		Light_Bulb[][] stateLightBulb = model.getStateGame();
        buttons = view.getGameInterface();
        attemptsLabel = view.getAttemtsLabel();
        labelVictory = view.getVictory();
        
        
        //This to Set-Up de New Game Botton
        JButton bottonNewGame = view.getBottonNewGame();
        attachListenerNewGame(bottonNewGame);
        
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
	
	//This change the light state, and before you ask, this have to Model first to change it, it change the row and the col of the matrix. 
	private void attachListenerToButton(int row, int col) {
        buttons[row][col].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.toggleState(row, col);
                //this for the update of the icons
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
        attemptsLabel.setText("Attempts : " + model.getNumberAttemps());
        if (model.wonAllLihhtOut()) {
            labelVictory.setText("Won");
        }
        
    }
	
	private void startNewGame() {
        model = new Tp_Model();
        updateView();
    }
	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Tp_Model model = new Tp_Model();
            	Tp_View view = new Tp_View();
                new TP_Controller(model, view);
                view.getFrame().setVisible(true);
            }
        });
	}
}
