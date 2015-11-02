import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;

import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.KeyStroke;

//Class Paint extends Methods class which extends MyPanel class
public class Paints extends Methods {

	Values val;  //object of Values class
	int k = 0;
	Boolean collision;
	int generateTime = 500;
	// Non static block
	{
		//anger level labels
		angerLevelLeft = new JLabel();
		angerLevelRight = new JLabel();
		angerLevelTop = new JLabel();
		angerLevelBottom = new JLabel();

		//image icons
		try {
			anger1 = new ImageIcon("resources\\angerlevel1.png");
			anger2 = new ImageIcon("resources\\angerlevel2.png");
			anger3 = new ImageIcon("resources\\angerlevel3.png");
			anger4 = new ImageIcon("resources\\angerlevel4.png");
			anger5 = new ImageIcon("resources\\angerlevel5.png");
			anger1side = new ImageIcon("resources\\angerlevel11.png");
			anger2side = new ImageIcon("resources\\angerlevel22.png");
			anger3side = new ImageIcon("resources\\angerlevel33.png");
			anger4side = new ImageIcon("resources\\angerlevel44.png");
			anger5side = new ImageIcon("resources\\angerlevel55.png");
		} catch (Exception e) {
			e.printStackTrace();
		}

		//setting icons and position of Jlabels
		angerLevelLeft.setIcon(anger1side);
		angerLevelRight.setIcon(anger1side);
		angerLevelTop.setIcon(anger1);
		angerLevelBottom.setIcon(anger1);

		angerLevelBottom.setBounds(600, 560, 150, 15);
		add(angerLevelBottom);

		angerLevelTop.setBounds(600, 220, 150, 15);
		add(angerLevelTop);

		angerLevelLeft.setBounds(490, 320, 15, 150);
		add(angerLevelLeft);

		angerLevelRight.setBounds(860, 320, 15, 150);
		add(angerLevelRight);
		//Font for showing score
		Font myFont = new Font("Serif", Font.BOLD, 48);
		// Setting layout to null
		setLayout(null);
		// Adding mouse listener to panel
		addMouseListener(this);
		// JLabels for traffic signals declaration of which is given in MyPanel
		// class
		// Setting Icons for JLAbel
		Left.setIcon(Red2);
		Right.setIcon(Red3);
		Top.setIcon(Red1);
		Bottom.setIcon(Red1);
		// Adding JLabels i.e traffic signals and Exit button
		add(Left);
		add(Right);
		add(Top);
		add(Bottom);
		add(leftButton);
		add(rightButton);
		add(topButton);
		add(bottomButton);

		//Key Bindings
		InputMap mp = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		mp.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false),
				"keyEscape");
		mp.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "keyLeft");
		mp.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "keyUp");
		mp.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "keyDown");
		mp.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "keyRight");
		mp.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false), "spaceStop");
		ActionMap act = this.getActionMap();
		act.put("keyEscape", escape);
		act.put("keyLeft", left);
		act.put("keyUp", up);
		act.put("keyDown", down);
		act.put("keyRight", right);
		act.put("spaceStop", Stop);
		// setting bounds of Buttons and Labels and adding Mouse Listener

		/*-----------------------------------------*/
		Score.setText("" + score);
		Score.setBounds(1250, 0, 300, 100);
		Score.setFont(myFont);
		Score.setForeground(Color.white);
		add(Score);
		/*-----------------------------------------*/
		Left.setBounds(495, 267, 80, 25);
		leftButton.setBounds(0, 290, 570, 220);
		leftButton.setOpaque(false);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		/*------------------------------------------*/
		Right.setBounds(785, 500, 80, 25);
		rightButton.setBounds(800, 290, 570, 220);
		rightButton.setOpaque(false);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		/*-------------------------------------------*/
		Top.setBounds(547, 185, 25, 80);
		topButton.setBounds(570, 0, 215, 285);
		topButton.setOpaque(false);
		topButton.setBorderPainted(false);
		topButton.setContentAreaFilled(false);
		/*-------------------------------------------*/
		Bottom.setBounds(785, 525, 25, 80);
		bottomButton.setBounds(570, 510, 235, 800);
		bottomButton.setOpaque(false);
		bottomButton.setBorderPainted(false);
		bottomButton.setContentAreaFilled(false);
		/*-------------------------------------------*/

		leftButton.addMouseListener(this);
		rightButton.addMouseListener(this);
		topButton.addMouseListener(this);
		bottomButton.addMouseListener(this);
		// Initializing positions and number of cars of Left Side
		initializationLeft(1);
		// Initializing positions and number of cars of Right Side
		initializationRight();
		// Initializing positions and number of cars of Top Side
		initializationTop();
		// Initializing positions and number of cars of Bottom Side
		initializationBottom(1);

	}

	// Paint Component method
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		//showing score
		Score.setText("" + score * 10);

		// Adding background image
		g2d.drawImage(img, 0, 0, getWidth(), getHeight(), null);
		
		//rectangles around cars for collision detection
		Shape[] recLeft = new Shape[side1.size()];
		for (int i = 0; i < recLeft.length; i++) {
			recLeft[i] = new Rectangle(3, 3, 65, 25);
		}
		Shape[] recRight = new Shape[side2.size()];
		for (int i = 0; i < recRight.length; i++) {
			recRight[i] = new Rectangle(3, 3, 65, 25);
		}
		Shape[] recTop = new Shape[side3.size()];
		for (int i = 0; i < recTop.length; i++) {
			recTop[i] = new Rectangle(3, 3, 65, 25);
		}
		Shape[] recBottom = new Shape[side4.size()];
		for (int i = 0; i < recBottom.length; i++) {
			recBottom[i] = new Rectangle(3, 3, 65, 25);
		}

		// Left Side
		// Side1.length is the number of cars to be generated
		for (int i = 0; i < side1.size(); i++) {
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

			val = trans(1, i, side1.get(i) + 1, green, side1x.get(i),
					side1y.get(i), side1Angle.get(i));
			// Saving xpos to pass it to method next time
			side1x.set(i, val.xpos);
			// Saving ypos to pass it to method next time
			side1y.set(i, val.ypos);
			// Saving angle to pass it to method next time
			side1Angle.set(i, val.angle);

			if (side1x.get(i) > 425 && side1x.get(i) < 430) {
				// score
				score++;
				passedLeft++;
			}
			recLeft[i] = val.at1.createTransformedShape(recLeft[i]);

			// Drawing image of car
			g2d.drawImage(carLeft.get(i).image, val.at1, this);

			if (side1y.get(i) <= -100 && side1y.get(i) >= -103
					|| side1x.get(i) >= 1400 && side1x.get(i) <= 1403
					|| side1y.get(i) >= 800 && side1y.get(i) <= 803) {
				//removing car when it has gone
				recLeft[i]=null;
				side1.remove(i);
				side1x.remove(i);
				side1y.remove(i);
				side1Angle.remove(i);
				carLeft.remove(i);
				passedLeft--;
			}

		}

		// Right side
		// Side1.length is the number of cars to be generated
		for (int i = 0; i < side2.size(); i++) {
			// Provding arguments to method and making it equal to an object of
			// Value class because it reurns object of value class
			val = trans(2, i, side2.get(i) + 1, green, side2x.get(i),
					side2y.get(i), side2Angle.get(i));
			// Saving xpos to pass it to method next time
			side2x.set(i, val.xpos);
			// Saving Ypos to pass it to method next time
			side2y.set(i, val.ypos);
			// Saving angle to pass it to method next time
			side2Angle.set(i, val.angle);
			if (side2x.get(i) < 935 && side2x.get(i) > 930) {
				score++;
				passedRight++;
			}
			recRight[i] = val.at1.createTransformedShape(recRight[i]);
			// Drawing image of car
			g2d.drawImage(carRight.get(i).image, val.at1, this);

			if (side2y.get(i) <= -100 && side2y.get(i) >= -104
					|| side2x.get(i) <= 0 && side2x.get(i) >= -3
					|| side2y.get(i) >= 800 && side2y.get(i) <= 803) {
				//removing car when it has gone
				recRight[i]=null;
				side2.remove(i);
				side2x.remove(i);
				side2y.remove(i);
				side2Angle.remove(i);
				carRight.remove(i);
				passedRight--;
			}

		}

		// Top side

		for (int i = 0; i < side3.size(); i++) {
			// Provding arguments to method and making it equal to an object of
			// Value class because it reurns object of value class
			val = trans(3, i, side3.get(i) + 1, green, side3x.get(i),
					side3y.get(i), side3Angle.get(i));
			// Saving xpos to pass it to method next time
			side3x.set(i, val.xpos);
			// Saving Ypos to pass it to method next time
			side3y.set(i, val.ypos);
			// Saving angle to pass it to method next time
			side3Angle.set(i, val.angle);
			if (side3y.get(i) > 165 && side3y.get(i) < 170) {
				score++;
				passedTop++;
			}
			recTop[i] = val.at1.createTransformedShape(recTop[i]);
			// Drawing image of car
			g2d.drawImage(carTop.get(i).image, val.at1, this);
			if (side3y.get(i) >= 800 && side3y.get(i) <= 803
					|| side3x.get(i) <= 0 && side3x.get(i) >= -3
					|| side3x.get(i) >= 1400 && side3x.get(i) <= 1403) {
				//removing car when it has gone
				recTop[i]=null;
				side3.remove(i);
				side3x.remove(i);
				side3y.remove(i);
				side3Angle.remove(i);
				carTop.remove(i);
				passedTop--;

			}
		}
		// Bottom side
		for (int i = 0; i < side4.size(); i++) {
			// Provding arguments to method and making it equal to an object of
			// Value class because it reurns object of value class
			val = trans(4, i, side4.get(i) + 1, green, side4x.get(i),
					side4y.get(i), side4Angle.get(i));
			// Saving xpos to pass it to method next time
			side4x.set(i, val.xpos);
			// Saving ypos to pass it to method next time
			side4y.set(i, val.ypos);
			// Saving angle to pass it to method next time
			side4Angle.set(i, val.angle);
			if (side4y.get(i) < 625 && side4y.get(i) > 621) {
				score++;
				passedBottom++;

			}
			recBottom[i] = val.at1.createTransformedShape(recBottom[i]);
			// Drawing image of car
			g2d.drawImage(carBottom.get(i).image, val.at1, this);

			if (side4y.get(i) <= 0 && side4y.get(i) >= -3 || side4x.get(i) <= 0
					&& side4x.get(i) >= -3 || side4x.get(i) >= 1400
					&& side4x.get(i) <= 1403) {
				//removing car when it has gone
				recBottom[i]=null;
				side4.remove(i);
				side4x.remove(i);
				side4y.remove(i);
				side4Angle.remove(i);
				carBottom.remove(i);
				passedBottom--;
			}
		}

		angerLevelset();
		collisionAll(recLeft, recRight, recTop, recBottom);
		if (side1.size() > 18 || side2.size() > 18 || side3.size() > 18
				|| side4.size() > 18) {
			//Game Over Frame
			frame = new JFrame();
			GameOver gm = new GameOver(score);
			frame.requestFocusInWindow();
			frame.add(gm);
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			frame.setUndecorated(true);
			frame.setVisible(true);
			//stoping music
			GameMode.gamePanel.clip.stop();
			GameMode.gamePanel=null;
			TrafficMania.frame.setVisible(false);

		}
		//Regenerating cars
		if (k == generateTime) {
			initializationLeft(1);
			initializationRight();
			initializationTop();
			initializationBottom(1);
			if (generateTime > 20) {
				generateTime -= 15;
			}
		}

		angerLevelset();  //Showing anger level
		if (k > generateTime) {
			k = 0;
		}
		k++;
		// Repainting
		repaint();
	}


}
