package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import control.Controller;

@SuppressWarnings("serial")
public class MainMenuPanel extends JPanel{
	
	Controller c;
	
	public Rectangle2D rectSpielen;
	public Rectangle2D rectReset;
	public Rectangle2D rectBeenden;
	
	public Rectangle2D actualRect = null;
	
	public MainMenuPanel(Controller c){		
		this.c = c;
		
		rectSpielen = new Rectangle2D.Double(45, 62, 170, 50);
		rectReset = new Rectangle2D.Double(45, 132, 135, 50);
		rectBeenden = new Rectangle2D.Double(45, 202, 200, 50);
		
		this.addMouseListener(c.getMouseListener());
		this.addMouseMotionListener(c.getMouseListener());
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(c.getImages().getBackgroundMainMenu(), 0, 0, this);

		g2d.setFont(new Font("Font2", Font.BOLD, 45));
		g2d.setColor(Color.BLACK);
		
		if(actualRect == rectSpielen){
			g2d.drawString("Spielen", (int)rectSpielen.getX()+7, (int)rectSpielen.getY()+38);
			g2d.drawString("Spielen", (int)rectSpielen.getX()+3, (int)rectSpielen.getY()+38);
			g2d.drawString("Spielen", (int)rectSpielen.getX()+5, (int)rectSpielen.getY()+40);
			g2d.drawString("Spielen", (int)rectSpielen.getX()+5, (int)rectSpielen.getY()+36);
			
			g2d.setColor(Color.getHSBColor(1.4f, 0.47f, 5f));
			g2d.drawString("Spielen", (int)rectSpielen.getX()+5, (int)rectSpielen.getY()+38);
			g2d.setColor(Color.black);
		}else{
			g2d.setColor(Color.white);
			g2d.drawString("Spielen", (int)rectSpielen.getX()+6, (int)rectSpielen.getY()+38);
			g2d.drawString("Spielen", (int)rectSpielen.getX()+4, (int)rectSpielen.getY()+38);
			g2d.drawString("Spielen", (int)rectSpielen.getX()+5, (int)rectSpielen.getY()+39);
			g2d.drawString("Spielen", (int)rectSpielen.getX()+5, (int)rectSpielen.getY()+37);

			g2d.setColor(Color.black);
			g2d.drawString("Spielen", (int)rectSpielen.getX()+5, (int)rectSpielen.getY()+38);
		}
		if(actualRect == rectReset){
			g2d.drawString("Reset", (int)rectReset.getX()+7, (int)rectReset.getY()+38);
			g2d.drawString("Reset", (int)rectReset.getX()+3, (int)rectReset.getY()+38);
			g2d.drawString("Reset", (int)rectReset.getX()+5, (int)rectReset.getY()+40);
			g2d.drawString("Reset", (int)rectReset.getX()+5, (int)rectReset.getY()+36);
			
			g2d.setColor(Color.getHSBColor(1.4f, 0.47f, 5f));
			g2d.drawString("Reset", (int)rectReset.getX()+5, (int)rectReset.getY()+38);
			g2d.setColor(Color.black);
		}else{
			g2d.setColor(Color.white);
			g2d.drawString("Reset", (int)rectReset.getX()+6, (int)rectReset.getY()+38);
			g2d.drawString("Reset", (int)rectReset.getX()+4, (int)rectReset.getY()+38);
			g2d.drawString("Reset", (int)rectReset.getX()+5, (int)rectReset.getY()+39);
			g2d.drawString("Reset", (int)rectReset.getX()+5, (int)rectReset.getY()+37);

			g2d.setColor(Color.black);
			g2d.drawString("Reset", (int)rectReset.getX()+5, (int)rectReset.getY()+38);
		}
		if(actualRect == rectBeenden){
			g2d.drawString("Beenden", (int)rectBeenden.getX()+7, (int)rectBeenden.getY()+38);
			g2d.drawString("Beenden", (int)rectBeenden.getX()+3, (int)rectBeenden.getY()+38);
			g2d.drawString("Beenden", (int)rectBeenden.getX()+5, (int)rectBeenden.getY()+40);
			g2d.drawString("Beenden", (int)rectBeenden.getX()+5, (int)rectBeenden.getY()+36);
			
			g2d.setColor(Color.getHSBColor(1.4f, 0.47f, 5f));
			g2d.drawString("Beenden", (int)rectBeenden.getX()+5, (int)rectBeenden.getY()+38);
			g2d.setColor(Color.black);
		}else{
			g2d.setColor(Color.white);
			g2d.drawString("Beenden", (int)rectBeenden.getX()+6, (int)rectBeenden.getY()+38);
			g2d.drawString("Beenden", (int)rectBeenden.getX()+4, (int)rectBeenden.getY()+38);
			g2d.drawString("Beenden", (int)rectBeenden.getX()+5, (int)rectBeenden.getY()+39);
			g2d.drawString("Beenden", (int)rectBeenden.getX()+5, (int)rectBeenden.getY()+37);

			g2d.setColor(Color.black);
			g2d.drawString("Beenden", (int)rectBeenden.getX()+5, (int)rectBeenden.getY()+38);
		}
		
	}
	
	public Rectangle2D getActualRect(){
		return this.actualRect;
	}
	
	public void setActualRect(Rectangle2D rect){
		this.actualRect = rect;
	}
}
