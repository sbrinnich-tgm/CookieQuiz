package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseListen implements MouseListener, MouseMotionListener{

	private Controller c;
	
	public MouseListen(Controller c){
		this.c = c;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if(c.actualmode == Controller.mode_MainMenu){
			if(c.getView().getMainMenuPanel().rectSpielen.contains(e.getPoint())){
				c.getView().getMainMenuPanel().setActualRect(c.getView().getMainMenuPanel().rectSpielen);
				c.getView().getMainMenuPanel().repaint();
			}else if(c.getView().getMainMenuPanel().rectReset.contains(e.getPoint())){
				c.getView().getMainMenuPanel().setActualRect(c.getView().getMainMenuPanel().rectReset);
				c.getView().getMainMenuPanel().repaint();
			}else if(c.getView().getMainMenuPanel().rectBeenden.contains(e.getPoint())){
				c.getView().getMainMenuPanel().setActualRect(c.getView().getMainMenuPanel().rectBeenden);
				c.getView().getMainMenuPanel().repaint();
			}else{
				c.getView().getMainMenuPanel().setActualRect(null);
				c.getView().getMainMenuPanel().repaint();
			}
		}else if(c.actualmode == Controller.mode_Game){
			if(c.getView().getGamePanel().rectBack.contains(e.getPoint())){
				c.getView().getGamePanel().setActualRect(c.getView().getGamePanel().rectBack);
				c.getView().getGamePanel().repaint();
			}else{
				c.getView().getGamePanel().setActualRect(null);
				c.getView().getGamePanel().repaint();
			}
		}else if(c.actualmode == Controller.mode_WaitScreen){
			if(c.getView().getWaitingPanel().rectBack.contains(e.getPoint())){
				c.getView().getWaitingPanel().setActualRect(c.getView().getWaitingPanel().rectBack);
				c.getView().getWaitingPanel().repaint();
			}else{
				c.getView().getWaitingPanel().setActualRect(null);
				c.getView().getWaitingPanel().repaint();
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		try{
			if(c.actualmode == Controller.mode_MainMenu){
				if(c.getView().getMainMenuPanel().rectSpielen.contains(e.getPoint())){
					c.startGame();
				}else if(c.getView().getMainMenuPanel().rectReset.contains(e.getPoint())){
					c.resetStats();
				}else if(c.getView().getMainMenuPanel().rectBeenden.contains(e.getPoint())){
					c.beenden();
				}
			}else if(c.actualmode == Controller.mode_Game){
				if(c.getView().getGamePanel().rectAnswer1.contains(e.getPoint())){
					c.answer(1);
				}else if(c.getView().getGamePanel().rectAnswer2.contains(e.getPoint())){
					c.answer(2);
				}else if(c.getView().getGamePanel().rectAnswer3.contains(e.getPoint())){
					c.answer(3);
				}else if(c.getView().getGamePanel().rectAnswer4.contains(e.getPoint())){
					c.answer(4);
				}else if(c.getView().getGamePanel().rectBack.contains(e.getPoint())){
					//-> Main Menu
				}
			}else if(c.actualmode == Controller.mode_WaitScreen){
				if(c.getView().getWaitingPanel().rectBack.contains(e.getPoint())){
					//-> Main Menu
				}
			}
		}catch(Exception ex){
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	
	
}
