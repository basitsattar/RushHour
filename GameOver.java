import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;


public class GameOver extends JPanel {
	
	//declaration and initialization
	BufferedImage gameOver1, gameOver2, scoreBoard, background1, background2;
	
	JLabel carsPassed = new JLabel("");
	JLabel totalScore = new JLabel("");
	JLabel message = new JLabel("press ESC to go to Menu ");
	ImageIcon restartOver, menuOver, restartOverh, menuOverh;
	//for animation
	int scoreBoardY = 2000;
	int gameOverX = 2000;
	int score;
	{
		//setting  layout null
		setLayout(null);

		//reading images
		try {
			gameOver1 = ImageIO.read(new File("./resources/over1.png"));
			background1 = ImageIO.read(new File("./resources/Road.jpg"));
			background2 = ImageIO.read(new File("./resources/Game2.jpg"));
			gameOver2 = ImageIO.read(new File("./resources/over2.png"));
			scoreBoard = ImageIO.read(new File("./resources/scoreBoard.png"));
		} catch (IOException e) {
		}
		//Showing statistics of game
		carsPassed.setBounds(800, 260, 100, 100);
		totalScore.setBounds(800, 360, 100, 100);
		message.setBounds(480, 600, 1000, 200);
		//Font for score
		Font myFont = new Font("Serif", Font.BOLD, 36);
		carsPassed.setFont(myFont);
		totalScore.setFont(myFont);
		message.setForeground(Color.GREEN);
		carsPassed.setForeground(Color.WHITE);
		totalScore.setForeground(Color.WHITE);
		//Showing mesage
		message.setFont(myFont);

	}

	//constructor which takes score as argument
	public GameOver(int gameScore) {
		score = gameScore;
	}

	//paint component method
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		//setting background image according to mode of game
		if (GameMode.mode == 1) {
			g2d.drawImage(background1, 0, 0, getWidth(), getHeight(), null);
		}
		if (GameMode.mode == 2) {
			g2d.drawImage(background2, 0, 0, getWidth(), getHeight(), null);
		}
		//Drawing images with animation
		g2d.drawImage(gameOver1, 0, 0, getWidth(), getHeight(), null);
		g2d.drawImage(gameOver2, gameOverX, 0, getWidth(), getHeight(), null);
		//scoreboard
		g2d.drawImage(scoreBoard, 0, scoreBoardY, getWidth(), getHeight(), null);
		//Showing scores
		carsPassed.setText("" + score);
		totalScore.setText(""+(score * 10));
		//animation of images
		if (scoreBoardY > 0)
			scoreBoardY -= 25;
		if (gameOverX > 0) {
			gameOverX -= 30;
		}

		if (scoreBoardY <= 0) {
			add(carsPassed);
			add(totalScore);
			add(message);
		}
		repaint();

	}

	
	//Adding action of escape button to go to menu
	Action Escape = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent e) {
			new ScoreIO(score);      //passing score to save in file
			if (GameMode.mode == 1) {
				TrafficMania.frame = new TrafficMania();
				TrafficMania.frame.add(new Menu());
				TrafficMania.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				TrafficMania.frame.setUndecorated(true);
				TrafficMania.frame.setVisible(true);
				Methods.frame.dispose();			//disposing game over frame
			}
			if (GameMode.mode == 2) {
				TrafficMania.frame = new TrafficMania();	
				TrafficMania.frame.add(new Menu());
				TrafficMania.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				TrafficMania.frame.setUndecorated(true);
				TrafficMania.frame.setVisible(true);
				Methods.frame.dispose();  	//disposing game over frame
			}
		}
	};
	{
		//Key Bindings
		InputMap mp = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		mp.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false),
				"keyEscape");
		ActionMap act = this.getActionMap();
		act.put("keyEscape", Escape);
	}

}