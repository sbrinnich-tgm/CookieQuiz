package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import control.Controller;

@SuppressWarnings("serial")
public class GamePanel extends JPanel{
	
	private Controller c;
	
	public Rectangle2D rectAnswer1;
	public Rectangle2D rectAnswer2;
	public Rectangle2D rectAnswer3;
	public Rectangle2D rectAnswer4;
	public Rectangle2D rectBack;
	
	public Rectangle2D actualRect = null;
	
	public GamePanel(Controller c){
		this.c = c;
		
		rectAnswer1 = new Rectangle2D.Double(25, 225, 250, 150);
		rectAnswer2 = new Rectangle2D.Double(300, 225, 250, 150);
		rectAnswer3 = new Rectangle2D.Double(25, 400, 250, 150);
		rectAnswer4 = new Rectangle2D.Double(300, 400, 250, 150);
		rectBack = new Rectangle2D.Double(25, 25, 35, 25);
		
		this.addMouseListener(c.getMouseListener());
		this.addMouseMotionListener(c.getMouseListener());
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		
		g2d.fill(rectAnswer1);
		g2d.fill(rectAnswer2);
		g2d.fill(rectAnswer3);
		g2d.fill(rectAnswer4);

		g2d.setFont(new Font("Font1", Font.BOLD, 15));
		
		//Frage
		g2d.drawString(c.getModel().getaQuestion().getQuestion(), 50, 125);
		
		g2d.setColor(Color.WHITE);
		//Antworten
		g2d.drawString(c.getModel().getaQuestion().getAnswers()[0], 50, 250);
		g2d.drawString(c.getModel().getaQuestion().getAnswers()[1], 325, 250);
		g2d.drawString(c.getModel().getaQuestion().getAnswers()[2], 50, 425);
		g2d.drawString(c.getModel().getaQuestion().getAnswers()[3], 325, 425);

		g2d.setColor(Color.BLACK);
		//Cookies
		g2d.drawString(c.getModel().getaCookies()+"", 250, 50);
		
		//Life Cookie
		g2d.drawString(c.getModel().getLifeCookie()+"", 500, 50);
		
		//Lvl
		g2d.drawString(c.getModel().getaLvl()+"", 100, 50);
		
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
