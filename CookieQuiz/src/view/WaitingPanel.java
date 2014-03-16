package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import control.Controller;

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

		g2d.setFont(new Font("Font1", Font.BOLD, 15));
		g2d.setColor(Color.BLACK);
		//Cookies
		g2d.drawString(c.getModel().getaCookies()+"", 250, 50);
		
		//Life Cookie
		//g2d.drawString(c.getModel().getLifeCookie()+"", 500, 50);
		
		//Lvl
		g2d.drawString(c.getModel().getaLvl()+"", 100, 50);
		
		//Wartezeit
		long wartezeit = c.getModel().getWaitingPointEnd();
		wartezeit -= System.currentTimeMillis();
		wartezeit /= 1000;
		g2d.drawString(wartezeit+"", 250, 250);
		
		//Zurück-Pfeil
		if(actualRect == rectBack){
			g2d.drawImage(c.getImages().getBackArrows()[1], (int)rectBack.getX(), (int)rectBack.getY(), this);
		}else{
			g2d.drawImage(c.getImages().getBackArrows()[0], (int)rectBack.getX(), (int)rectBack.getY(), this);
		}
		
	}

	public Rectangle2D getActualRect() {
		return actualRect;
	}

	public void setActualRect(Rectangle2D rect) {
		this.actualRect = rect;
	}
	
}
