package Interface;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;


public class RoundImage{

	
	public static BufferedImage RoundMyImage(BufferedImage bufferedImage){
		int width = bufferedImage.getWidth();
		BufferedImage circleBuffer = new BufferedImage(width, width, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = circleBuffer.createGraphics();
		g2.setClip(new Ellipse2D.Float(0, 0, width, width));
		g2.drawImage(bufferedImage, 0, 0, width, width, null);
		return circleBuffer;
	}
	
}
