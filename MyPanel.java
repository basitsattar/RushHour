import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Class MyPanel
class MyPanel extends JPanel {
	// Declaration and initialization
	static Boolean pause = false;
	Clip clip,clipCrash;
	BufferedImage img; // For backround image

	// image icons for use in paints and paints2 classes
	ImageIcon Red1, Red2, Red3, Green1, Green2, Green3, Yellow1, Yellow2,
			Resume1, Resumeh, anger1, anger2, anger3, anger4, anger5,
			anger1side, anger2side, anger3side, anger4side, anger5side;// Image
																		// icons
																		// for
																		// JLaBel
																		// l of
																		// traffic
																		// signals
																		// and
																		// anger
																		// level
	int k1 = 0, k2 = 0, k3 = 0, k4 = 0,k1b=0,k4b=0, score = 0, passedLeft = 0,
			passedRight = 0, passedTop = 0, passedBottom = 0, n1 = 0, n2 = 0,
			n3 = 0, n4 = 0;

	//JLabels
	JLabel angerLevelLeft, angerLevelRight, angerLevelTop, angerLevelBottom;

	//Array lists for leftSide
	ArrayList<Integer> side1 = new ArrayList<Integer>();
	ArrayList<Integer> side1x = new ArrayList<Integer>();
	ArrayList<Integer> side1y = new ArrayList<Integer>();
	ArrayList<Double> side1Angle = new ArrayList<Double>();
	ArrayList<Images> carLeft = new ArrayList<Images>();
	
	//Arraylists for  leftside mode2
	ArrayList<Integer> side1b = new ArrayList<Integer>();
	ArrayList<Integer> side1bx = new ArrayList<Integer>();
	ArrayList<Integer> side1by = new ArrayList<Integer>();
	ArrayList<Double> side1bAngle = new ArrayList<Double>();
	ArrayList<Images> carLeftb = new ArrayList<Images>();
	
	//Array lists for rightSide
	ArrayList<Integer> side2 = new ArrayList<Integer>();
	ArrayList<Integer> side2x = new ArrayList<Integer>();
	ArrayList<Integer> side2y = new ArrayList<Integer>();
	ArrayList<Double> side2Angle = new ArrayList<Double>();
	ArrayList<Images> carRight = new ArrayList<Images>();
	//Array lists for topSide
	ArrayList<Integer> side3 = new ArrayList<Integer>();
	ArrayList<Integer> side3x = new ArrayList<Integer>();
	ArrayList<Integer> side3y = new ArrayList<Integer>();
	ArrayList<Double> side3Angle = new ArrayList<Double>();
	ArrayList<Images> carTop = new ArrayList<Images>();
	//Array lists for bottomSide
	ArrayList<Integer> side4 = new ArrayList<Integer>();
	ArrayList<Integer> side4x = new ArrayList<Integer>();
	ArrayList<Integer> side4y = new ArrayList<Integer>();
	ArrayList<Double> side4Angle = new ArrayList<Double>();
	ArrayList<Images> carBottom = new ArrayList<Images>();
	
	//Array lists for bottomSide
	ArrayList<Integer> side4b = new ArrayList<Integer>();
	ArrayList<Integer> side4bx = new ArrayList<Integer>();
	ArrayList<Integer> side4by = new ArrayList<Integer>();
	ArrayList<Double> side4bAngle = new ArrayList<Double>();
	ArrayList<Images> carBottomb = new ArrayList<Images>();
	// Initial positions of front cars from each side
	int[][] xpos = { { -100 }, { 1450 }, { 775, 730, 730 }, { 580, 620, 620 } };
	int[][] ypos = { { 295, 340 }, { 485, 440 }, { -100 }, { 900 } };

	int[][] xpos1 = { { -100 }, { 1450 }, { 775, 730, 730 }, { 630, 690, 690 } };
	int[][] ypos1 = { { 340, 400 }, { 485, 440 }, { -100 }, { 900 } };

	// Traffic signal level
	int green = 0;
	// JLAbels for traffic signals buttonz
	JLabel Left = new JLabel("");
	JLabel Right = new JLabel("");
	JLabel Top = new JLabel("");
	JLabel Bottom = new JLabel("");
	JLabel Score = new JLabel("");
	JButton leftButton = new JButton("");
	JButton rightButton = new JButton("");
	JButton topButton = new JButton("");
	JButton bottomButton = new JButton("");

	{
		//music
		try {
			
			
			AudioInputStream stream = AudioSystem.getAudioInputStream(new File(
					"resources\\gamesound.wav"));
			AudioInputStream streamCrash = AudioSystem.getAudioInputStream(new File(
					"resources\\crash.wav"));
			AudioFormat format = stream.getFormat();
			AudioFormat format1 = streamCrash.getFormat();
			DataLine.Info info= new DataLine.Info(Clip.class, format);
			DataLine.Info info1= new DataLine.Info(Clip.class, format1);
			clip = (Clip) AudioSystem.getLine(info);
			clipCrash = (Clip) AudioSystem.getLine(info1);
			clip.open(stream);
			clipCrash.open(streamCrash);
			clip.getControls();
			clipCrash.getControls();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			clip.start();
		} catch (Exception e) {

		}
	}

	// Constructor
	public MyPanel() {

		// Reading images from storage

		try {
			img = ImageIO.read(new File("resources\\Road.jpg"));
			Red1 = new ImageIcon("resources\\Red.png");
			Green1 = new ImageIcon("resources\\Green.png");
			Yellow1 = new ImageIcon("resources\\Yellow.png");
			Red2 = new ImageIcon("resources\\Red2.png");
			Green2 = new ImageIcon("resources\\Green2.png");
			Yellow2 = new ImageIcon("resources\\Yellow2.png");
			Red3 = new ImageIcon("resources\\Red3.png");
			Green3 = new ImageIcon("resources\\Green3.png");

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	// Values class
	// We have used this class because we want to return more than one values
	// from trans() method
	class Values {
		int xinc = 0, yinc = 0, xpos = 0, ypos = 0;
		double angle = 0;
		AffineTransform at1 = new AffineTransform();
	}

}
