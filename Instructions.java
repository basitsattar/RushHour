import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;

public class Instructions extends JPanel implements MouseListener {
	//declaration and initialization
	BufferedImage mode1, mode2;
	JLabel back = new JLabel();
	JLabel next = new JLabel();
	JLabel backhover = new JLabel();
	JLabel nexthover = new JLabel();
	ImageIcon backButton, nextButton, nextButtonhover, backButtonhover,backButtonSmall,backButtonhoverSmall;
	//for animation
	int x = 1366;
	int y = 0;
	int screen = 1;

	{
		try {
			// Reading images from storage
			mode1 = ImageIO.read(new File("resources\\instruction1Background.jpg"));
			mode2 = ImageIO.read(new File("resources\\instruction2Background.jpg"));
			backButton = new ImageIcon("resources\\backLarge.png");
			backButtonSmall = new ImageIcon("resources\\back.png");
			nextButton = new ImageIcon("resources\\next.png");
			backButtonhover = new ImageIcon("resources\\backhLarge.png");
			backButtonhoverSmall = new ImageIcon("resources\\backh.png");
			nextButtonhover = new ImageIcon("resources\\nexth.png");
		}
		// Catching exception
		catch (IOException e) {
			e.printStackTrace();
			System.out.print("Image not found");
		}
		
		
		//Setting button properties
		back.setIcon(backButton);
		add(back);
		back.setBounds(0, 660, 100, 100);
		back.addMouseListener(this);
		next.setIcon(nextButton);
		add(next);
		next.setBounds(900, 600, 70, 70);
		next.addMouseListener(this);

		// Setting layout null
		setLayout(null);
	}

	// Paint Component method
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Color color=new Color(255,255,255,0);
		setBackground(color);
		// Drawing image to panel in full height and width
		if (screen == 1)
			//mode 1 instructions
			g2d.drawImage(mode1, x, y, getWidth(), getHeight(), null);
		if (screen == 2)
			//moede2
			g2d.drawImage(mode2, x, y, getWidth(), getHeight(), null);
		
		//animation
		if (x > 0) {
			x -= 100;
		}
		if (x <= 0) {
			x = 0;
		}
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		repaint();

	}// Paint Component ends

	@Override
	public void mouseClicked(MouseEvent e) {
		//Back button to end instructions
		if (e.getSource() == back) {
			Menu.fm.dispose();
		}
		
		//mode 2 instruction
		if (e.getSource() == next) {
			if (screen == 1) {
				screen = 2;
				next.setIcon(backButtonSmall);
				
				next.setBounds(400, 600, 70, 70);
			} else
				//mode1 instructions
			if (screen == 2) {
				screen = 1;
				next.setIcon(nextButton);
				next.setBounds(900, 600, 70, 70);
			}
		}
	}

	
	//adding hover effect
	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == back) {
			back.setIcon(backButtonhover);
		}

		if (e.getSource() == next) {
			if(screen==1)
			next.setIcon(nextButtonhover);
			if(screen==2)
				next.setIcon(backButtonhoverSmall);
		}

	}

	//restoring images to make hover effect
	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == back) {
			back.setIcon(backButton);
		}

		if (e.getSource() == next) {
			if(screen==1)
			next.setIcon(nextButton);
			if(screen==2)
				next.setIcon(backButtonSmall);
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	//Adding Escape key action to go back to menu
	Action Escape = new AbstractAction() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	
	    	Menu.fm.dispose();
	    }
	};
	
	//Adding Left key action to go to mode1
	Action Left = new AbstractAction() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	screen = 1;
			next.setIcon(nextButton);
			next.setBounds(900, 600, 70, 70);
	    	
	    }
	};
	//Adding Right key action to go to mode1
	Action Right = new AbstractAction() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	
			screen = 2;
			next.setIcon(backButtonSmall);
			next.setBounds(400, 600, 70, 70);
			
			
	    }
	};
	
	
	//Adding Keyactions through Key Bindings 
	{
		InputMap mp=this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		mp.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0,false), "keyEscape");
		mp.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT,0,false), "keyRight");
		mp.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT,0,false), "keyLeft");
		ActionMap act=this.getActionMap();
		act.put("keyEscape", Escape);
		act.put("keyRight", Right);
		act.put("keyLeft", Left);
		
	}
	
}// Class Ends
