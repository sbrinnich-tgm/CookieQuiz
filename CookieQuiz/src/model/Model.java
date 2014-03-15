package model;

import java.io.File;

import control.Controller;

public class Model {

	private Controller c;
	
	private int aCookies;
	private int lifeCookie;
	private int schachteln;
	private int aLvl;
	
	private Question aQuestion;
	private Question[] questions;
	
	private int wartezeit;
	private long waitingPointEnd;
	
	private TimeLoop timeLoop;
	
	public Model(Controller c){
		this.c = c;
	}
	
	public void loseLvl(){
		c.actualmode = Controller.mode_WaitScreen;
		aCookies = 0;
		
		if(!new File("res/wait.sav").exists()){
			waitingPointEnd = calculateWaitTime();
		}else{
			new File("res/wait.sav").delete();
		}
		
		c.showWaitingScreen();
		
		timeLoop = new TimeLoop(this, c, TimeLoop.mode_WaitTime);
		timeLoop.start();
	}
	
	public long calculateWaitTime(){
		long time = System.currentTimeMillis();
		time += (Controller.waitTime*1000);
		return time;
	}
	
	public void answer(int answerIndex){
		timeLoop.stopLoop();
		
		if(aQuestion.getTrueAnswerIndex() == answerIndex){
			//Richtig
			aCookies++;
		}else if(answerIndex == 0){
			//Time Out
			lifeCookie--;
		}else{
			//Falsch
			lifeCookie--;
		}
		
		if(aCookies >= 8){
			aCookies = 0;
			schachteln++;
			aLvl++;
			c.nextLvl();
		}else{
			c.nextQuestion();
		}
	}
	
	public void newQuestion(){
		int i = (int)(Math.random()*questions.length);
		
		aQuestion = questions[i];
	}
	
	public void startQuestion(){
		timeLoop = new TimeLoop(this, c, TimeLoop.mode_Game);
		timeLoop.start();
	}
	
	public void resetLifeCookie(){
		timeLoop.stopLoop();
		lifeCookie = 3;
		c.nextQuestion();
	}

	public int getaCookies() {
		return aCookies;
	}

	public void setaCookies(int aCookies) {
		this.aCookies = aCookies;
	}

	public int getLifeCookie() {
		return lifeCookie;
	}

	public void setLifeCookie(int lifeCookie) {
		this.lifeCookie = lifeCookie;
	}

	public int getSchachteln() {
		return schachteln;
	}

	public void setSchachteln(int schachteln) {
		this.schachteln = schachteln;
	}

	public int getaLvl() {
		return aLvl;
	}

	public void setaLvl(int aLvl) {
		this.aLvl = aLvl;
	}

	public Question getaQuestion() {
		return aQuestion;
	}

	public int getWartezeit() {
		return wartezeit;
	}
	
	public void setWartezeit(int wartezeit){
		this.wartezeit = wartezeit;
	}
	
	public void decreaseWartezeit(){
		wartezeit--;
	}

	public void setQuestions(Question[] questions) {
		this.questions = questions;
	}
	
	public Question[] getQuestions(){
		return questions;
	}

	public long getWaitingPointEnd() {
		return waitingPointEnd;
	}

	public void setWaitingPointEnd(long waitingPointEnd) {
		this.waitingPointEnd = waitingPointEnd;
	}
	
}
