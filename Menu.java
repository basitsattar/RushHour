import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.*;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.*;

public class Menu extends JPanel implements MouseListener {
	BufferedImage Background; // Declaration and initialization
	JLabel[] jb = new JLabel[5]; // For Menu buttons
	ImageIcon Start, Exit, Scores, instructions, Starth, Exith, Scoresh, instructionsh; // Images for Menu
	static JFrame fm;
	int xp;
	static Clip clip;
	// Non static Block
	{
		
			//Adding music
			try{  
						DataLine.Info info;
						AudioInputStream stream= AudioSystem.getAudioInputStream(new File("resources/menu.wav"));
						AudioFormat format = stream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						clip = (Clip) AudioSystem.getLine(info);
						clip.open(stream);
						clip.loop(Clip.LOOP_CONTINUOUSLY);
						clip.start();
					}catch (Exception e){}
		
		
		
		
		// Getting screen size and width
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		//Giving error message if screen resolution is not our required resolution
		if(width!=1366 || height!=768){
			JOptionPane.showMessageDialog(null, "Your screen resolution is not 1366*768 which is required for optimal performance");
			//System.exit(0);//exiting 
		}
		
		// Getting center of screen to add menu relatively so that it appears on
		// center in all devices
		xp = (int) (width / 2);

		// Reading Images from storage
		try {
			Background = ImageIO.read(new File("resources\\Gamef.jpg"));
			Start = new ImageIcon("resources\\start.png");
			Exit = new ImageIcon("resources\\exit.png");
			Scores = new ImageIcon("resources\\score.png");
			instructions = new ImageIcon("resources\\instructions.png");
			Starth = new ImageIcon("resources\\starth.png");
			Exith = new ImageIcon("resources\\exith.png");
			Scoresh = new ImageIcon("resources\\scoreh.png");
			instructionsh = new ImageIcon("resources\\instructionsh.png");
	

		}// Catching Exception if found
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("Image not found");
		}
		// Setting Layout to null
		setLayout(null);
		// Adding JLAbels via for loop
		int yb = 250;
		for (int i = 0; i < 4; i++) {
			jb[i] = new JLabel(); // Making JLabel
			jb[i].addMouseListener(this); // Adding Mouse Listener
			add(jb[i]); // Adding JLabel
			jb[i].setBounds(xp - 100, yb, 200, 50);// Setting bounds
			yb += 55;
		}
		// ASssigining image icons to labels
		jb[0].setIcon(Start);
		jb[1].setIcon(Scores);
		jb[2].setIcon(instructions);
		jb[3].setIcon(Exit);
	}// Non-static block ends

	// Paint Component method
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		// Drawing background image
		g2d.drawImage(Background, 0, 0, getWidth(), getHeight(), null);
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// When mouse clciked
		// If button is first button i-e start Game button
		if (e.getComponent() == jb[0]) {
			// Make GameModes Object
			GameMode modeScreen=new GameMode();
			//Stopping music
			clip.stop();
			// making menu invisible
			this.setVisible(false);
			// Adding GamoMode object
			TrafficMania.frame.add(modeScreen);
		}

		//if button is High Scores button then showing high scores
		if (e.getComponent() == jb[1]) {
			fm=new JFrame();
			fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			fm.add(new HighScorePanel());
			fm.setUndecorated(true);
			fm.setExtendedState(JFrame.MAXIMIZED_BOTH);
			fm.setVisible(true);
		}
		//if button is Instructions button then showing instructions
		if (e.getComponent() == jb[2]) {
			jb[2].setIcon(instructionsh);
			fm=new JFrame();
			fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			fm.add(new Instructions());
			fm.setUndecorated(true);
			fm.setExtendedState(JFrame.MAXIMIZED_BOTH);
			fm.setVisible(true);
		}
		// Exit button
		if (e.getComponent() == jb[3]) {
			jb[3].setIcon(Exith);
			System.exit(0);

		}

	}

	
	//changing images when mouse entered to provide hover effect
	@Override
	public void mouseEntered(MouseEvent e) {
		// Changing images of buttons when mouse entered to make hover effect

		if (e.getComponent() == jb[0]) {
			jb[0].setIcon(Starth);
			repaint();
		}
		if (e.getComponent() == jb[1]) {
			jb[1].setIcon(Scoresh);
		}
		if (e.getComponent() == jb[2]) {
			jb[2].setIcon(instructionsh);
		}
		if (e.getComponent() == jb[3]) {
			jb[3].setIcon(Exith);

		}

	}
	//restoring images when mouse exited to provide hover effect
	@Override
	public void mouseExited(MouseEvent e) {
		// Restoring images of JLabels when mouse removed

		if (e.getComponent() == jb[0]) {
			jb[0].setIcon(Start);
			repaint();
		}
		if (e.getComponent() == jb[1]) {
			jb[1].setIcon(Scores);
		}
		if (e.getComponent() == jb[2]) {
			jb[2].setIcon(instructions);
		}
		if (e.getComponent() == jb[3]) {
			jb[3].setIcon(Exit);

		}
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

}
