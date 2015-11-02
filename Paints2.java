import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

//Class Paint extends Methods class which extends MyPanel clas which extends JPanel
public class Paints2 extends Methods {
	// Font for score
	Font myFont = new Font("Serif", Font.BOLD, 48);
	// declaration and initialization
	Values val;
	JLabel angerLevel = new JLabel();
	ImageIcon anger1, anger2, anger3, anger4, anger5;
	int k = 0, z = 0, generateTime = 50;
	int multiplier = 300;
	{
		// reading images
		try {
			img = ImageIO.read(new File("resources\\Game2.jpg"));
			anger1 = new ImageIcon("resources\\angerlevel1.png");
			anger2 = new ImageIcon("resources\\angerlevel2.png");
			anger3 = new ImageIcon("resources\\angerlevel3.png");
			anger4 = new ImageIcon("resources\\angerlevel4.png");
			anger5 = new ImageIcon("resources\\angerlevel5.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Setting layout to null
		setLayout(null);
		// Adding mouse listener to panel
		addMouseListener(this);
		// JLabels for traffic signals and anger level
		angerLevel.setIcon(anger1);
		angerLevel.setBounds(600, 560, 150, 15);
		add(angerLevel);
		// Setting Icons for JLAbel
		Bottom.setIcon(Red1);
		// Adding JLabels i.e traffic signals and Exit button
		add(Bottom);
		add(bottomButton);

		InputMap mp = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		mp.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false),
				"keyEscape");
		mp.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false), "keySpace");
		ActionMap act = this.getActionMap();
		act.put("keyEscape", escape);
		act.put("keySpace", space);
		/*-----------------------------------------*/
		Score.setText("" + score);
		Score.setBounds(1250, 0, 300, 100);
		Score.setFont(myFont);
		Score.setForeground(Color.white);
		add(Score);
		// setting bounds of Buttons and Labels and adding Mouse Listener
		/*-------------------------------------------*/
		Bottom.setBounds(785, 525, 25, 80);
		bottomButton.setBounds(0, 0, 1366, 800);
		bottomButton.setOpaque(false);
		bottomButton.setBorderPainted(false);
		bottomButton.setContentAreaFilled(false);
		/*-------------------------------------------*/
		bottomButton.addMouseListener(this);
		// Initializing positions and number of cars of Left Side
		initializationLeft(2);
		// Initializing positions and number of cars of Bottom Side
		initializationBottom(2);

	}

	// Paint Component method
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Score.setText("" + score * 10);
		// Adding background image
		g2d.drawImage(img, 0, 0, getWidth(), getHeight(), null);

		// rectangles around car to detect colllision
		Shape[] rectangleLeft = new Shape[side1b.size()];
		for (int i = 0; i < rectangleLeft.length; i++) {
			rectangleLeft[i] = new Rectangle(3, 3, 70, 30);
		}
		Shape[] rectangleBottom = new Shape[side4b.size()];
		for (int i = 0; i < rectangleBottom.length; i++) {
			rectangleBottom[i] = new Rectangle(3, 3, 70, 30);
		}

		// setting images of anger level
		if (side4b.size() > 0) {
			angerLevel.setIcon(anger1);
		}
		if (side4b.size() > 3) {
			angerLevel.setIcon(anger2);
		}
		if (side4b.size() > 6) {
			angerLevel.setIcon(anger3);
		}
		if (side4b.size() > 9) {
			angerLevel.setIcon(anger4);
		}
		if (side4b.size() > 12) {
			angerLevel.setIcon(anger5);
		}

		// Left Side
		// Side1b.length is the number of cars to be generated
		for (int i = 0; i < side1b.size(); i++) {
			// Provding arguments to method and making it equal to an object of
			// Value class because it reurns object of value class
			// First argument is used to tell method that it is left side
			// 2nd argument is used to tell the method number of this car in the
			// lane
			// 3rd arument is used to tell methid that car wants to move left
			// ,right or straight
			// Green is used to tell compiler that which signal is open
			// 5th and 6th argumenty is to tell the x and y position of car
			// 7th argument is tell the method current angle of rotation

			val = trans(1, i, 2, 1, side1bx.get(i), side1by.get(i),
					side1bAngle.get(i));
			// Saving xpos to pass it to method next time
			side1bx.set(i, val.xpos);
			// Saving ypos to pass it to method next time
			side1by.set(i, val.ypos);
			// Saving angle to pass it to method next time
			side1bAngle.set(i, val.angle);

			if (side1bx.get(i) > 425 && side1bx.get(i) < 430) {
				passedLeft++;
			}

			// Drawing image of car
			g2d.drawImage(carLeftb.get(i).image, val.at1, this);

			rectangleLeft[i] = val.at1.createTransformedShape(rectangleLeft[i]);

			if (side1by.get(i) <= -100 && side1by.get(i) >= -103
					|| side1bx.get(i) >= 1400 && side1bx.get(i) <= 1403
					|| side1by.get(i) >= 800 && side1by.get(i) <= 803) {
				// removing car when it has gone
				side1b.remove(i);

				side1bx.remove(i);
				side1by.remove(i);
				side1bAngle.remove(i);
				carLeftb.remove(i);
				passedLeft--;
			}

		}

		// Bottom side
		for (int i = 0; i < side4b.size(); i++) {
			// Provding arguments to method and making it equal to an object of
			// Value class because it reurns object of value class
			val = trans(4, i, 2, green, side4bx.get(i), side4by.get(i),
					side4bAngle.get(i));
			// Saving xpos to pass it to method next time
			side4bx.set(i, val.xpos);
			// Saving ypos to pass it to method next time
			side4by.set(i, val.ypos);
			// Saving angle to pass it to method next time
			side4bAngle.set(i, val.angle);
			if (side4by.get(i) < 625 && side4by.get(i) > 621) {
				score++; // score
				passedBottom++;

			}

			// Drawing image of car
			g2d.drawImage(carBottomb.get(i).image, val.at1, this);

			rectangleBottom[i] = val.at1
					.createTransformedShape(rectangleBottom[i]);
			if (side4by.get(i) <= 0 && side4by.get(i) >= -3
					|| side4bx.get(i) <= 0 && side4bx.get(i) >= -3
					|| side4bx.get(i) >= 1400 && side4bx.get(i) <= 1403) {
				// removing car when it has gone
				side4b.remove(i);
				side4bx.remove(i);
				side4by.remove(i);
				side4bAngle.remove(i);
				carBottomb.remove(i);
				passedBottom--;
			}
		}

		collisionCheck(rectangleLeft, rectangleBottom);

		if (side4b.size() > 16) {
			// Game Over
			// Game over frame and panel
			frame = new JFrame();
			frame.add(new GameOver(score));
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			frame.setUndecorated(true);
			frame.setVisible(true);
			GameMode.gamePanel.clip.stop();
			GameMode.gamePanel = null;
			TrafficMania.frame.setVisible(false);

		}
		// regenerate cars
		if (k == generateTime) {
			initializationLeft(2);
			generateTime = (int) ((Math.random() * multiplier)) + 100;
			if (multiplier > 100)
				multiplier -= 5;
		}
		if (k > generateTime) {
			k = 0;
		}
		if (z == 150) {
			initializationBottom(2);
		}
		if (z > 150) {
			z = 0;
		}
		k++;
		z++;
		// Repainting
		repaint();
	}

	// Method to detect collision between cars
	public void collisionCheck(Shape[] r, Shape[] r2) {
		Rectangle temp=new Rectangle(3,3,70,30);
		for (int i = 0; i < r.length; i++) {
			for (int j = 0; j < r2.length; j++) {
				if (r[i] != null && r2[j] != null) {
					if (r[i].intersects(r2[j].getBounds2D())) {
						if(r[i].getBounds().equals(temp)){
							continue;
						}
						clipCrash.start();
						frame = new JFrame();
						frame.add(new GameOver(score));
						frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setUndecorated(true);
						frame.setVisible(true);
						GameMode.gamePanel.clip.stop();
						GameMode.gamePanel=null;
						TrafficMania.frame.setVisible(false);
					}
				}
			}
		}

	}

}
