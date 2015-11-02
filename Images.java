import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

//Images class to provide images of vehicles
public class Images {
	//Array of images
	BufferedImage[] vehicles = new BufferedImage[10];
	BufferedImage image;
	//non styatic block
	 {

		try {
			//Reading images from emory in a loop
			for (int i = 0; i < vehicles.length; i++) {
				vehicles[i] = ImageIO.read(new File("resources\\cars\\car"
						+ (i + 1) + ".png"));
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Assiging a random image to each object
		int n=(int) (Math.random()*(vehicles.length-0));
		image=vehicles[n];
		
	}//nonStatic block ends

}//Class ends
