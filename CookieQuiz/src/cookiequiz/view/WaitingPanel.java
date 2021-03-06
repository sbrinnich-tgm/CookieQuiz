package cookiequiz.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import cookiequiz.control.Controller;

@SuppressWarnings("serial")
public class WaitingPanel extends JPanel{
	
	private Controller c;
	
	public Rectangle2D rectBack;
	
	private Rectangle2D actualRect = null;
	
	public WaitingPanel(Controller c){
		this.c = c;
		
		rectBack = new Rectangle2D.Double(25, 25, 40, 25);
		
		this.addMouseListener(c.getMouseListener());
		this.addMouseMotionListener(c.getMouseListener());
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(c.getImages().getBackgroundGame(), 0, 0, this);

		g2d.setFont(new Font("Font1", Font.BOLD, 15));
		g2d.setColor(Color.BLACK);

		//Cookies
		try{
			g2d.drawImage(c.getImages().getCookies()[c.getModel().getaCookies()], 190, 5, this);
		}catch(Exception e){
		}
		
		//Life Cookie
		try{
			g2d.drawImage(c.getImages().getLifeCookies()[c.getModel().getLifeCookie()-1], 500, 10, this);
		}catch(Exception e){
		}
		
		//Lvl
		try{
			g2d.drawImage(c.getImages().getSchachteln(), 10, 10, this);
		}catch(Exception e){
		}
		g2d.setFont(new Font("Font2", Font.BOLD, 22));
		g2d.setColor(Color.BLACK);
		if(c.getModel().getaLvl() < 10){
			g2d.drawString(c.getModel().getaLvl()+"", 53, 40);
			g2d.drawString(c.getModel().getaLvl()+"", 57, 40);
			g2d.drawString(c.getModel().getaLvl()+"", 55, 38);
			g2d.drawString(c.getModel().getaLvl()+"", 55, 42);
			g2d.setColor(Color.WHITE);
			g2d.drawString(c.getModel().getaLvl()+"", 55, 40);
		}else{
			g2d.drawString(c.getModel().getaLvl()+"", 43, 40);
			g2d.drawString(c.getModel().getaLvl()+"", 47, 40);
			g2d.drawString(c.getModel().getaLvl()+"", 45, 38);
			g2d.drawString(c.getModel().getaLvl()+"", 45, 42);
			g2d.setColor(Color.WHITE);
			g2d.drawString(c.getModel().getaLvl()+"", 45, 40);
		}
		

		//Hintergrund
		g2d.setColor(new Color(0, 0, 0, 100));
		g2d.fillRect(0, 0, c.getView().getFrame().getWidth(), c.getView().getFrame().getHeight());
		
		//Wartezeit
		long wartezeit = c.getModel().getWaitingPointEnd();
		wartezeit -= System.currentTimeMillis();
		wartezeit /= 1000;
		
		double percent = (double)(Controller.waitTime-wartezeit)/((double)Controller.waitTime/100);
		percent = (int)(percent*100);
		percent = percent/100;
		
		try{
			g2d.drawImage(c.getImages().getWaitcookies()[((int)percent)/2-1], 100, 125, this);
		}catch(Exception e){
			g2d.drawImage(c.getImages().getWaitcookies()[0], 100, 125, this);
		}


		g2d.setColor(Color.BLACK);
		g2d.drawString(percent+" %", 258, 320);
		g2d.drawString(percent+" %", 262, 320);
		g2d.drawString(percent+" %", 260, 318);
		g2d.drawString(percent+" %", 260, 322);
		g2d.setColor(Color.WHITE);
		g2d.drawString(percent+" %", 260, 320);
		
		
		if(wartezeit/3600 > 0){
			g2d.setColor(Color.BLACK);
			g2d.drawString("Noch " + (wartezeit/3600+1) + " Stunden!", 198, 520);
			g2d.drawString("Noch " + (wartezeit/3600+1) + " Stunden!", 202, 520);
			g2d.drawString("Noch " + (wartezeit/3600+1) + " Stunden!", 200, 518);
			g2d.drawString("Noch " + (wartezeit/3600+1) + " Stunden!", 200, 522);
			g2d.setColor(Color.WHITE);
			g2d.drawString("Noch " + (wartezeit/3600+1) + " Stunden!", 200, 520);
		}else if(wartezeit/60 > 0){
			g2d.setColor(Color.BLACK);
			g2d.drawString("Noch " + (wartezeit/60+1) + " Minuten!", 198, 520);
			g2d.drawString("Noch " + (wartezeit/60+1) + " Minuten!", 202, 520);
			g2d.drawString("Noch " + (wartezeit/60+1) + " Minuten!", 200, 518);
			g2d.drawString("Noch " + (wartezeit/60+1) + " Minuten!", 200, 522);
			g2d.setColor(Color.WHITE);
			g2d.drawString("Noch " + (wartezeit/60+1) + " Minuten!", 200, 520);
		}else{
			g2d.setColor(Color.BLACK);
			g2d.drawString("Noch " + wartezeit + " Sekunden!", 198, 520);
			g2d.drawString("Noch " + wartezeit + " Sekunden!", 202, 520);
			g2d.drawString("Noch " + wartezeit + " Sekunden!", 200, 518);
			g2d.drawString("Noch " + wartezeit + " Sekunden!", 200, 522);
			g2d.setColor(Color.WHITE);
			g2d.drawString("Noch " + wartezeit + " Sekunden!", 200, 520);
		}
		
		
		//Zur�ck-Pfeil
//		if(actualRect == rectBack){
//			g2d.drawImage(c.getImages().getBackArrows()[1], (int)rectBack.getX(), (int)rectBack.getY(), this);
//		}else{
//			g2d.drawImage(c.getImages().getBackArrows()[0], (int)rectBack.getX(), (int)rectBack.getY(), this);
//		}
		
	}

	public Rectangle2D getActualRect() {
		return actualRect;
	}

	public void setActualRect(Rectangle2D rect) {
		this.actualRect = rect;
	}
	
}
