package cookiequiz.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;
import javax.swing.JProgressBar;

import cookiequiz.control.Controller;

@SuppressWarnings("serial")
public class GamePanel extends JPanel{
	
	private Controller c;
	
	public Rectangle2D rectAnswer1;
	public Rectangle2D rectAnswer2;
	public Rectangle2D rectAnswer3;
	public Rectangle2D rectAnswer4;
	public Rectangle2D rectBack;
	
	public Rectangle2D actualRect = null;
	
	private JProgressBar progbar;
	
	public GamePanel(Controller c){
		this.c = c;
		
		rectAnswer1 = new Rectangle2D.Double(25, 275, 250, 125);
		rectAnswer2 = new Rectangle2D.Double(300, 275, 250, 125);
		rectAnswer3 = new Rectangle2D.Double(25, 425, 250, 125);
		rectAnswer4 = new Rectangle2D.Double(300, 425, 250, 125);
		rectBack = new Rectangle2D.Double(25, 25, 35, 25);
		
		progbar = new JProgressBar();
		progbar.setMaximum(Controller.antwortzeit*10-10);
		progbar.setBackground(Color.GRAY);
		progbar.setBorderPainted(false);
		progbar.setForeground(Color.GREEN);
		
		this.addMouseListener(c.getMouseListener());
		this.addMouseMotionListener(c.getMouseListener());
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Font1", Font.BOLD, 15));

		g2d.drawImage(c.getImages().getBackgroundGame(), 0, 0, this);		

		//Frage
		g2d.setColor(new Color(0, 0, 0, 90));
		g2d.fillRoundRect(30, 90, 515, 160, 10, 10);
		
		String[] q = c.getModel().getaQuestion().getQuestion().split("/n");
		if(q.length > 1){
			for(int i = 0; i < q.length; i++){
				g2d.setColor(Color.BLACK);
				g2d.drawString(q[i], 52, 125+i*25);
				g2d.drawString(q[i], 48, 125+i*25);
				g2d.drawString(q[i], 50, 123+i*25);
				g2d.drawString(q[i], 50, 127+i*25);
				g2d.setColor(Color.WHITE);
				g2d.drawString(q[i], 50, 125+i*25);
			}
		}else{
			g2d.setColor(Color.BLACK);
			g2d.drawString(c.getModel().getaQuestion().getQuestion(), 52, 125);
			g2d.drawString(c.getModel().getaQuestion().getQuestion(), 48, 125);
			g2d.drawString(c.getModel().getaQuestion().getQuestion(), 50, 123);
			g2d.drawString(c.getModel().getaQuestion().getQuestion(), 50, 127);
			g2d.setColor(Color.WHITE);
			g2d.drawString(c.getModel().getaQuestion().getQuestion(), 50, 125);
		}
		
		//Antworten
		g2d.setColor(Color.BLACK);
		g2d.fillRoundRect((int)rectAnswer1.getX(), (int)rectAnswer1.getY(), (int)rectAnswer1.getWidth(), (int)rectAnswer1.getHeight(), 15, 15);
		g2d.fillRoundRect((int)rectAnswer2.getX(), (int)rectAnswer2.getY(), (int)rectAnswer2.getWidth(), (int)rectAnswer2.getHeight(), 15, 15);
		g2d.fillRoundRect((int)rectAnswer3.getX(), (int)rectAnswer3.getY(), (int)rectAnswer3.getWidth(), (int)rectAnswer3.getHeight(), 15, 15);
		g2d.fillRoundRect((int)rectAnswer4.getX(), (int)rectAnswer4.getY(), (int)rectAnswer4.getWidth(), (int)rectAnswer4.getHeight(), 15, 15);

		g2d.setColor(Color.WHITE);
		g2d.drawString(c.getModel().getaQuestion().getAnswers()[0], (int)rectAnswer1.getX()+25, (int)rectAnswer1.getY()+25);
		g2d.drawString(c.getModel().getaQuestion().getAnswers()[1], (int)rectAnswer2.getX()+25, (int)rectAnswer2.getY()+25);
		g2d.drawString(c.getModel().getaQuestion().getAnswers()[2], (int)rectAnswer3.getX()+25, (int)rectAnswer3.getY()+25);
		g2d.drawString(c.getModel().getaQuestion().getAnswers()[3], (int)rectAnswer4.getX()+25, (int)rectAnswer4.getY()+25);
		
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
		
		//Zurück-Pfeil
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
	
	public void setProgBarValue(int value){
		this.progbar.setValue(value);
	}
	
	public JProgressBar getProgBar(){
		return progbar;
	}
	
	public void setProgBarColor(Color color){
		progbar.setForeground(color);
	}
	
}
