package Interface;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ProfImage extends JPanel{
	
	private String photoName = "current";
	
	@Override
	  protected void paintComponent(Graphics g){	
		File sourceimage = new File("./src/Account_Data/" + photoName + ".png");
		File backupimage = new File("./src/Account_Data/backup.png");
		Image bg = null;
		
		try {
			bg = ImageIO.read(backupimage);
			bg = ImageIO.read(sourceimage);
		} catch (IOException e ) {
			UsageLog.add("Error recovering user profile photo. Reverting to template.");
		}
		bg = RoundImage.RoundMyImage((BufferedImage) bg);
	    super.paintComponent(g);
	    g.drawImage(bg.getScaledInstance(45, -1, Image. SCALE_SMOOTH), 10, 10, this);
	}
	
	
	public ProfImage(String photoName){		

		setOpaque(false);
		setBackground(null);
		
		this.photoName = photoName;
		repaint();
	}
}
