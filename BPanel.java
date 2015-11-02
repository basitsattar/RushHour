
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class BPanel extends JPanel {
	// BufferedIamge object to store dim background image
	BufferedImage Background;
	{

		try {
			// Reading image from storage
			Background = ImageIO.read(new File("resources\\Game.jpg"));

		}
		// Catching exception
		catch (IOException e) {
			e.printStackTrace();
			System.out.print("Image not found");
		}
		// Setting layout null
		setLayout(null); 
	}
	// Paint Component method
	public void paintComponent(Graphics g) { 
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		// Drawing image to panel in full height and width
		g2d.drawImage(Background, 0, 0, getWidth(), getHeight(), null);
	
	}//Paint Component ends
	

}//Class Ends
