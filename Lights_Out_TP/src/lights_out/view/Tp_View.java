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
    private JButton bottonDificulty;
    private JButton bottonvolverAlMenu;
    private JButton button3x3;
    private JButton button4x4;
    private JButton button5x5;
    private JButton buttonMenu;
    
    private JLabel attemptsLabel;
    private JLabel victoryLabel;
    
    
    private URL lighOff = getClass().getResource("/images/Light Off.png");
    
    public Tp_View() {
		initialize();
	}


    private void initialize() {
    	frame = new JFrame();
        frame.getContentPane().setBackground(new Color(238, 184, 18));
        frame.getContentPane().setLayout(null);
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Lights Out");
        
        ImageIcon icon = new ImageIcon(lighOff);
        frame.setIconImage(icon.getImage());
		
		bottonStart = new JButton("Game Start");
		bottonStart.setBounds(325, 125, 138, 45);
		getFrame().getContentPane().add(bottonStart);
		
		bottonDificulty = new JButton("Dificulty");
		bottonDificulty.setBounds(325, 225, 138, 45);
		frame.getContentPane().add(bottonDificulty);
		
		bottonExit = new JButton("Exit");
		bottonExit.setBounds(325, 325, 138, 45);
		frame.getContentPane().add(bottonExit);
	
		
    }
    
    private JButton bottonNewGame() {
    	bottonNewGame = new JButton("New Game");
		bottonNewGame.setBounds(650, 63, 109, 45);
		frame.getContentPane().add(bottonNewGame);
		return bottonNewGame;
    }
    
    public JButton getBottonNewGame() {
    	return bottonNewGame();
    }
    
    private JButton buttonMenu() {
    	buttonMenu = new JButton("Menu");
		buttonMenu.setBounds(650, 160,109, 45);
		frame.getContentPane().add(buttonMenu);
		return buttonMenu;
    }
    
    public JButton getButtonMenu() {
    	return buttonMenu();
    }
    
    private JButton bottonvolverAlMenu() {
    	bottonvolverAlMenu = new JButton("volverAlMenu");
    	bottonvolverAlMenu.setBounds(310, 400, 150, 45);
		frame.getContentPane().add(bottonvolverAlMenu);
		return bottonvolverAlMenu;
    }
    
    public JButton getBottonvolverAlMenu() {
    	return bottonvolverAlMenu();
    }
    
    
    private JLabel labelVictory() {
    	victoryLabel = new JLabel("Felicitaciones!!!");
		victoryLabel.setForeground(Color.BLUE);
  
    	frame.getContentPane().setLayout(null);
    	victoryLabel.setFont(new Font("MV Boli", Font.BOLD, 30));
    	victoryLabel.setBounds(216, 37, 233, 60);
    	frame.getContentPane().add(victoryLabel);
		return victoryLabel;
    }
    
    public JLabel getLabelVictory() {
    	return labelVictory();
    }
    private JButton button3x3() {
    	button3x3 = new JButton("3x3");
		button3x3.setBounds(325, 125, 138, 45);
		frame.getContentPane().add(button3x3);
		return button3x3;
    }
    
    public JButton getButton3x3() {
    	return button3x3();
    }
    private JButton button4x4() {
    	button4x4 = new JButton("4x4");
		button4x4.setBounds(325, 225, 138, 45);
		frame.getContentPane().add(button4x4);
		return button4x4;
    }
    
    public JButton getButton4x4() {
    	return button4x4();
    }
    private JButton button5x5() {
    	button5x5 = new JButton("5x5");
		button5x5.setBounds(325, 325, 138, 45);
		frame.getContentPane().add(button5x5);
		return button5x5;
    }
    
    public JButton getButton5x5() {
    	return button5x5();
    }
    
    
    private JButton[][] gameInterfaceBottons3x3 () {
    	lights = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton("");
                // Set button properties here
                
                button.setIcon(new ImageIcon(""));
                button.setBounds(220+j*100, 120+i*90, 50, 50);
                frame.getContentPane().add(button);
                lights[j][i] = button;
            }
        }
        
        return lights;
    }
    private JButton[][] gameInterfaceBottons4x4 () {
    	lights = new JButton[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                JButton button = new JButton("");
                // Set button properties here
                
                button.setIcon(new ImageIcon(""));
                button.setBounds(180+j*100, 70+i*90, 50, 50);
                frame.getContentPane().add(button);
                lights[j][i] = button;
            }
        }
        
        return lights;
    }
    
    private JButton[][] gameInterfaceBottons5x5 () {
    	lights = new JButton[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
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
        attemptsLabel.setBounds(650, 361, 106, 30);
        frame.getContentPane().add(attemptsLabel);
		return attemptsLabel;
    }
    
    public JLabel getAttemtsLabel () {
    	return attemtsLabel();
    }
 
    
    public JButton[][] getGameInterface3x3() {
    	return gameInterfaceBottons3x3();
    }
    public JButton[][] getGameInterface4x4() {
    	return gameInterfaceBottons4x4();
    }
    
    public JButton[][] getGameInterface5x5() {
    	return gameInterfaceBottons5x5();
    }
    
    
    
    public JButton getBottonsStart() {
    	return bottonStart;
    }
    public JButton getBottonsDificulty() {
    	return bottonDificulty;
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
