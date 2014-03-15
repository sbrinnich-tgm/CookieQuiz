package view;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Images{
	
	String path;
	
	private BufferedImage backgroundMainMenu;
	private BufferedImage[] backArrows = new BufferedImage[2];

	public Images(String path){
		this.path = path;
		readImages();
	}
	
	public void readImages(){
		try{
			backgroundMainMenu = ImageIO.read(getClass().getResource(path + "background_mainMenu.png"));
		}catch(Exception e){ 
			System.out.println(path + "background_mainMenu.png");
		}
		try{
			backArrows[0] = ImageIO.read(getClass().getResource(path + "backArrow.png"));
			backArrows[1] = ImageIO.read(getClass().getResource(path + "backArrowOver.png"));
		}catch(Exception e){ 
			System.out.println(path + "background_mainMenu.png");
		}
	}

	public BufferedImage getBackgroundMainMenu() {
		return backgroundMainMenu;
	}

	public BufferedImage[] getBackArrows() {
		return backArrows;
	}
	
}
