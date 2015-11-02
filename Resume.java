import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class Resume extends Menu implements Action {
	ImageIcon Resume, Resumeh, Restart, Restarth;

	{
		//reading images
		try {
			Resume = new ImageIcon("resources\\resume.png");
			Resumeh = new ImageIcon("resources\\resumeh.png");
			Restart = new ImageIcon("resources\\restart.png");
			Restarth = new ImageIcon("resources\\restarth.png");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "image not found");
		}

		//assigning images to first two buttons
		jb[0].setIcon(Resume);
		jb[1].setIcon(Restart);
	}

	//adding key listener through key bindings
	{
		InputMap mp = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		mp.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false), "key");

		ActionMap act = this.getActionMap();
		act.put("key", this);

	}

	public void mouseClicked(MouseEvent e) {
		// When mouse clciked
		// If button is first button ResumeGame button then resume game
		if (e.getComponent() == jb[0]) {
			Methods.fm.setVisible(false);
			Methods.fm.removeAll();
			Methods.fm.dispose();
			GameMode.gamePanel.pause = false;
			this.clip.stop();
			GameMode.gamePanel.clip.start();

		}
		// If button is Second button Restart Game button then restart game
		if (e.getComponent() == jb[1]) {
			GameMode.gamePanel.setVisible(false);
			GameMode.gamePanel = null;
			if(GameMode.mode==1)
			GameMode.gamePanel = new Paints();
			if(GameMode.mode==2)
			GameMode.gamePanel = new Paints2();
			GameMode.gamePanel.pause = false;
			GameMode.gamePanel.setVisible(true);
			Methods.fm.dispose();
			this.clip.stop();
			this.setVisible(false);
			TrafficMania.frame.add(GameMode.gamePanel);
			TrafficMania.frame.revalidate();
		}
		if (e.getComponent() == jb[2]) {
			jb[2].setIcon(instructionsh);
			fm = new JFrame();
			fm.add(new Instructions());
			fm.setUndecorated(true);
			fm.setExtendedState(JFrame.MAXIMIZED_BOTH);
			fm.setVisible(true);
		}
		if (e.getComponent() == jb[3]) {
			// Setting visibility and focus
			Methods.fm.removeAll();
			Methods.fm.dispose();
			GameMode.gamePanel.setVisible(false);
			GameMode.gamePanel.pause = false;
			this.clip.stop();
			TrafficMania.frame.remove(GameMode.gamePanel);
			TrafficMania.frame.add(new Menu());

		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Changing images of buttons when mouse entered to make hover effect

		if (e.getComponent() == jb[0]) {
			jb[0].setIcon(Resumeh);
			repaint();
		}
		if (e.getComponent() == jb[1]) {
			jb[1].setIcon(Restarth);
		}
		if (e.getComponent() == jb[2]) {
			jb[2].setIcon(instructionsh);
		}
		if (e.getComponent() == jb[3]) {
			jb[3].setIcon(Exith);

		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Restoring images of JLabes when mouse removed

		if (e.getComponent() == jb[0]) {
			jb[0].setIcon(Resume);
			repaint();
		}
		if (e.getComponent() == jb[1]) {
			jb[1].setIcon(Restart);
		}
		if (e.getComponent() == jb[2]) {
			jb[2].setIcon(instructions);
		}
		if (e.getComponent() == jb[3]) {
			jb[3].setIcon(Exit);

		}
	}

	
	// adding action of escape button 
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Methods.fm.setVisible(false);
		Methods.fm.removeAll();
		Methods.fm.dispose();
		GameMode.gamePanel.pause = false;
		this.clip.stop();  //stopping music
		GameMode.gamePanel.clip.start();
	}

	@Override
	public Object getValue(String arg0) {

		return null;
	}

	@Override
	public void putValue(String arg0, Object arg1) {

	}

}
