import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class GameMode extends JPanel implements MouseListener, Action {
	// declaration and iniialization
	BufferedImage background;
	JLabel mode1 = new JLabel("");
	JLabel mode2 = new JLabel("");
	static int mode = 0;
	ImageIcon mode1simple, mode1hover, mode2simple, mode2hover;
	static MyPanel gamePanel;
	{
		// setting layout to null
		setLayout(null);
		// reading images
		try {
			background = ImageIO
					.read(new File("resources\\modesBackground.png"));
			mode1simple = new ImageIcon("resources\\mode1.png");
			mode1hover = new ImageIcon("resources\\mode1hover.png");
			mode2simple = new ImageIcon("resources\\mode2.png");
			mode2hover = new ImageIcon("resources\\mode2hover.png");
		} catch (Exception e) {
			System.out.println("Image not found");
		}

		// setting Icons and properties of JLabels
		mode1.setIcon(mode1simple);
		mode2.setIcon(mode2simple);
		setBackground(Color.orange);
		mode2.setBounds(450, 350, 410, 300);
		mode1.setBounds(450, 50, 410, 300);
		mode1.addMouseListener(this);
		mode2.addMouseListener(this);
		add(mode1);
		add(mode2);

		// adding key binding to add Escape key listener
		InputMap mp = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		mp.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false),
				"keyEscape");
		ActionMap act = this.getActionMap();
		act.put("keyEscape", this);

	}

	// paintComponent method
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		// drawing image
		g2d.drawImage(background, 0, 0, getWidth(), getHeight(), null);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// adding Paints panel if mode1 clicked
		if (e.getSource() == mode1) {
			mode = 1;
			// Make Paints Object
			gamePanel = new Paints();
			// making menu invisible
			this.setVisible(false);
			// Adding paints object i.e main game
			TrafficMania.frame.add(gamePanel);
		}

		// adding Paints2 panel if mode12 clicked
		if (e.getSource() == mode2) {
			mode = 2;
			// Make Paints Object
			gamePanel = new Paints2();
			// making menu invisible
			this.setVisible(false);
			// Adding paints object i.e main game
			TrafficMania.frame.add(gamePanel);
		}

	}

	//change images to add  hover effect
	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == mode1) {
			mode1.setIcon(mode1hover);
		}

		if (e.getSource() == mode2) {
			mode2.setIcon(mode2hover);
		}

	}

	// restore images to add hover effect
	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == mode1) {
			mode1.setIcon(mode1simple);
		}

		if (e.getSource() == mode2) {
			mode2.setIcon(mode2simple);
		}

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

	// Escape key to return back to menu
	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
		TrafficMania.frame.add(new Menu());

	}
	@Override
	public Object getValue(String arg0) {
		return null;
	}

	@Override
	public void putValue(String arg0, Object arg1) {
	}

}
