import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import javax.imageio.*;
import javax.swing.*;

public class HighScorePanel extends JPanel implements MouseListener {
	// Declaration and initialization
	BufferedImage Background;
	JLabel back = new JLabel();
	ImageIcon backButton, backButtonhover;
	JTextArea scoreBoard;
	//setting x value of image to provode animation
	int x = 1366;
	int y = 0;
	
	//Array list to store High scores from file
	ArrayList<Score> data = new ArrayList<Score>();
	{
		// Setting layout null
		setLayout(null);
		

		try {
			// Reading image from storage
			Background = ImageIO.read(new File("resources\\HighScore.png"));
			backButton = new ImageIcon("resources\\backLarge.png");
			backButtonhover = new ImageIcon("resources\\backhLarge.png");

			// input streams for Reading Score from file
			FileInputStream input = new FileInputStream("score.txt");
			ObjectInputStream player = new ObjectInputStream(input);
			data = (ArrayList<Score>) player.readObject();
		}
		// Catching exception
		catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.print("Image not found");
		} catch (IOException e) {
			System.out.println("Creating new file");
		} catch (ClassNotFoundException e) {
			System.out.println("There is a litle error . Please report so that we can fix it");
		}
		
		//Writing score to TextArea
		scoreBoard = new JTextArea("");
		
		
		//Setting bounds,color anf font of scoreBoard
		scoreBoard.setBounds(400, 150, 550, 500);
		scoreBoard.setBackground(new Color(0, 0, 0, 0));
		Font myFont = new Font("Serif", Font.BOLD, 36);
		scoreBoard.setForeground(Color.red);
		scoreBoard.setFont(myFont);
		add(scoreBoard);

		//adding back button
		back.setIcon(backButton);
		add(back);
		back.setBounds(0, 660, 100, 100);
		back.addMouseListener(this);
	}

	// Paint Component method
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Color color = new Color(255, 255, 255, 0);
		setBackground(color);
		// Drawing image to panel in full height and width
		g2d.drawImage(Background, x, y, getWidth(), getHeight(), null);
		//animation
		if (x > 0) {
			x -= 100;
		}
		if (x <= 0) {
			x = 0;

			//Showing scores on scoreBoard
			if (data != null) {
				scoreBoard.setText("");
				for (int i = 0; i < data.size(); i++) {
					String name=data.get(i).getName();
					
					//setting default name if name is null
					scoreBoard.append((i + 1) + "   " + name
							+ "\t\t" + data.get(i).getScore() + "\n");
				}
			}
		}
		//sleeping
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		repaint();

	}// Paint Component ends

	
	@Override
	public void mouseClicked(MouseEvent e) {
		//exiting menu
		if (e.getSource() == back) {
			Menu.fm.dispose();
		}
	}

	//hover effect
	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == back) {
			back.setIcon(backButtonhover);
		}
	}

	//hover effect
	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == back) {
			back.setIcon(backButton);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	//Escape button to go back to menu
	Action Escape = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent e) {
			Menu.fm.dispose();
		}
	};

	//Adding key binding of Escape button
	{
		InputMap mp = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		mp.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false),
				"keyEscape");
		ActionMap act = this.getActionMap();
		act.put("keyEscape", Escape);
	}

}// Class Ends
