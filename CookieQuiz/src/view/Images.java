package view;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Images{
	
	String path;
	
	private BufferedImage[] backgrounds = new BufferedImage[2];
	private BufferedImage[] backArrows = new BufferedImage[2];
	private BufferedImage[] lifeCookies = new BufferedImage[3];
	private BufferedImage[] cookies = new BufferedImage[9];
	private BufferedImage[] waitcookies = new BufferedImage[50];
	private BufferedImage schachteln;

	public Images(String path){
		this.path = path;
		readImages();
	}
	
	public void readImages(){
		try{
			for(int i = 0; i < backgrounds.length; i++){
				backgrounds[i] = ImageIO.read(getClass().getResource(path + "background_" + (i+1) + ".png"));
			}
		}catch(Exception e){
		}
		try{
			backArrows[0] = ImageIO.read(getClass().getResource(path + "backArrow.png"));
			backArrows[1] = ImageIO.read(getClass().getResource(path + "backArrowOver.png"));
		}catch(Exception e){ 
		}
		try{
			for(int i = 0; i < lifeCookies.length; i++){
				lifeCookies[i] = ImageIO.read(getClass().getResource(path + "lifecookie_" + (i+1) + ".png"));
			}
		}catch(Exception e){
		}
		try{
			for(int i = 0; i < cookies.length; i++){
				cookies[i] = ImageIO.read(getClass().getResource(path + "cookies_" + i + ".png"));
			}
		}catch(Exception e){
		}
		try{
			for(int i = 0; i < waitcookies.length; i++){
				waitcookies[i] = ImageIO.read(getClass().getResource(path + "waitcookie_" + ((i*2)+2) + ".png"));
			}
		}catch(Exception e){
		}
		try{
			schachteln = ImageIO.read(getClass().getResource(path + "schachteln.png"));
		}catch(Exception e){ 
		}
	}

	public BufferedImage getBackgroundMainMenu() {
		return backgrounds[0];
	}
	
	public BufferedImage getBackgroundGame() {
		return backgrounds[1];
	}

	public BufferedImage[] getBackArrows() {
		return backArrows;
	}
	
	public BufferedImage[] getLifeCookies(){
		return lifeCookies;
	}
	
	public BufferedImage[] getCookies(){
		return cookies;
	}
	
	public BufferedImage getSchachteln(){
		return schachteln;
	}
	
	public BufferedImage[] getWaitcookies(){
		return waitcookies;
	}
	
}
