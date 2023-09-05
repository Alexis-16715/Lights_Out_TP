package lights_out.view;

import javax.swing.*;


import java.awt.*;
import java.net.URL;

public class Tp_View {
    private JFrame frame;
    
    
    private JButton[][] lights;
    
    
    private JButton bottonStart;
    private JButton bottonExit;
    private JButton bottonNewGame;
    
    
    private JLabel attemptsLabel;
    private JLabel victoryLabel;
    
    
    private URL lighOff = getClass().getResource("/images/Light Off.png");
    
    public Tp_View() {
		initialize();
	}


    private void initialize() {
    	frame = new JFrame();
        frame.getContentPane().setBackground(new Color(255, 255, 255));
        frame.getContentPane().setLayout(null);
        frame.setBounds(100, 100, 645, 440);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Lights Out");
        
        ImageIcon icon = new ImageIcon(lighOff);
        frame.setIconImage(icon.getImage());
		
		bottonStart = new JButton("Game Start");
		bottonStart.setBounds(33, 63, 138, 45);
		getFrame().getContentPane().add(bottonStart);
		
		bottonExit = new JButton("Exit");
		bottonExit.setBounds(33, 134, 138, 45);
		frame.getContentPane().add(bottonExit);
		
		
		
    }
    
    private JButton bottonNewGame() {
    	bottonNewGame = new JButton("New Game");
		bottonNewGame.setBounds(510, 63, 109, 45);
		frame.getContentPane().add(bottonNewGame);
		return bottonNewGame;
    }
    
    public JButton getBottonNewGame() {
    	return bottonNewGame();
    }
    
    
    private JButton[][] gameInterfaceBottons () {
    	lights = new JButton[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                JButton button = new JButton("");
                // Set button properties here
                
                button.setIcon(new ImageIcon(""));
                button.setBounds(140+j*100, 30+i*90, 50, 50);
                frame.getContentPane().add(button);
                lights[j][i] = button;
            }
        }
        
        return lights;
    }
    
    private JLabel attemtsLabel() {
    	attemptsLabel = new JLabel("");
        attemptsLabel.setBounds(513, 361, 106, 30);
        frame.getContentPane().add(attemptsLabel);
		return attemptsLabel;
    }
    
    public JLabel getAttemtsLabel () {
    	return attemtsLabel();
    }
    
    private JLabel victoryLabel() {
    	victoryLabel = new JLabel("");
    	victoryLabel.setBounds(513, 278, 106, 30);
        frame.getContentPane().add(victoryLabel);
		return victoryLabel;
    }
    
    public JLabel getVictory () {
    	return victoryLabel();
    }
    
    
    public JButton[][] getGameInterface() {
    	return gameInterfaceBottons();
    }
    
    
    public JButton getBottonsStart() {
    	return bottonStart;
    }
    
    public JButton getBottonsExit() {
    	return bottonExit;
    }

	public JFrame getFrame() {
		return frame;
	}
	public JLabel getlabel() {
        return victoryLabel;
    }


	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
