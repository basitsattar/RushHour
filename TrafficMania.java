/*Classes Hierarchy:
TrafficMania:
Main class which extends JFrame and all frames all included in it.
BPanel:
Class extending JPanel to show dim background.
Menu:
Class extending JPanel to show background with Menu.
MyPanel: 
MyPanel class extend JPanel and all variables are declared and initialized in it
Methods:
Methods class extend MyPanel class and all methods are defined in it including event listener methods
Paints:
Paints class extends Methods Class and all the work is done in this class. As this class extends Methods class which extends MyPanel class so all variables of MyPanel and all methods of Methods class are available in it.
Values:
In order to return more than one values from a method ,this class is made and the methid return object of this class
Images:
This class is used to read images of vehicles an these images are called in Paints class by an instance of Images class and a random image Is assigned to each instance.
 */

import javax.swing.JFrame;

public class TrafficMania extends JFrame { // Main class of our game
	static TrafficMania frame;
	
	public static void main(String args[]) { // Main method
		frame = new TrafficMania(); // Frame object
		BPanel panel = new BPanel(); // Adding panel having dim background image

		// Setting frame properties
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Making frame fill screen
		frame.setUndecorated(true);
		frame.setExtendedState(MAXIMIZED_BOTH);
		frame.setLocationRelativeTo(null);
		// Setting visibility
		frame.setVisible(true);
		try {
			// Changing background image after short interval
			Thread.sleep(2000);
			// Removing old panel and making it null
			frame.remove(panel);
			panel = null;
			// Adding panel of menu
			Menu m = new Menu();
			frame.add(m);
			frame.revalidate();
			// Catching Exception
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
