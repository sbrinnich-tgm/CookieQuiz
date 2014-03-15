package model;

import control.Controller;

public class TimeLoop extends Thread{
	
	private Model m;
	private Controller c;
	
	private boolean stop;
	
	private int mode;
	
	public static final int mode_WaitTime = 0;
	public static final int mode_Game = 1;
	
	public TimeLoop(Model m, Controller c, int mode){
		super();
		this.m = m;
		this.c = c;
		
		this.mode = mode;
	}

	public void run(){
		while(!stop){
			
			if(mode == mode_WaitTime){
				c.getView().getWaitingPanel().repaint();
			}else{
				m.decreaseWartezeit();
			}
			
			if(m.getWartezeit() <= 0){
				if(mode == mode_Game){
					m.answer(0);
				}
			}
			
			if(m.getWaitingPointEnd() <= System.currentTimeMillis()){
				if(mode == mode_WaitTime){
					m.resetLifeCookie();
				}
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
		this.stop = false;
	}
	
	public void stopLoop(){
		this.stop = true;
	}
	
}
