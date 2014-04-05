package cookiequiz.control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import cookiequiz.model.Model;
import cookiequiz.model.Question;
import cookiequiz.view.Images;
import cookiequiz.view.View;

public class Controller {
	
	private Model model;
	private View view;
	
	private Images images;
	
	private MouseListen mouseL;
	
	public static final int antwortzeit = 20;
	public static final int waitTime = 3600;
	
	public static final int mode_MainMenu = 0;
	public static final int mode_Game = 1;
	public static final int mode_WaitScreen = 2;
	
	public int actualmode = 0;
	
	private String respath = "/res/";

	public Controller(){
		images = new Images("/res/images/");
		mouseL = new MouseListen(this);
		
		model = new Model(this);
		einlesen();
		
		view = new View(this);
		
		view.showMainMenuPanel();
	}
	
	public void startGame(){
		nextQuestion();
	}
	
	public void beenden(){
		save();
		System.exit(0);
	}
	
	public void save(){
		try {
			FileOutputStream saveFile = new FileOutputStream(getClass().getResource(respath + "stats.sav").getPath());
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
			save.writeObject(model.getaCookies());
			save.writeObject(model.getaLvl());
			save.writeObject(model.getLifeCookie());
			save.writeObject(model.getSchachteln());
			save.close();
			
			if(model.getLifeCookie() <= 0){
				saveWaitingTime();
			}
		} catch (Exception e) {
			File f = new File(respath);
			if(!f.exists()){
				f.mkdir();
			}
			save();
		}
	}
	
	public void einlesen(){
		try {
			FileInputStream saveFile = new FileInputStream(getClass().getResource(respath + "stats.sav").getPath());
			ObjectInputStream restore = new ObjectInputStream(saveFile);
			model.setaCookies((Integer) restore.readObject());
			model.setaLvl((Integer) restore.readObject());
			model.setLifeCookie((Integer) restore.readObject());
			model.setSchachteln((Integer) restore.readObject());
			restore.close();
			
			readQuestions();
			
			if(model.getLifeCookie() <= 0){
				readWaitingTime();
			}
		} catch (Exception e) {
			resetStats();
		}
	}
	
	public void saveWaitingTime(){
		try{
			FileOutputStream saveFile = new FileOutputStream(getClass().getResource(respath + "wait.sav").getPath());
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
			save.writeObject(model.getWaitingPointEnd());
			save.close();
		}catch(Exception e){
		}
	}
	
	public void readWaitingTime(){
		FileInputStream saveFile;
		try {
			saveFile = new FileInputStream(getClass().getResource(respath + "wait.sav").getPath());
			ObjectInputStream restore = new ObjectInputStream(saveFile);
			model.setWaitingPointEnd((Long) restore.readObject());
			restore.close();
		} catch (Exception e) {
		}
	}
	
	public void readQuestions(){		
		try {
			BufferedReader in = new BufferedReader(new FileReader(getClass().getResource(respath + "questions.txt").getPath()));
			int count = 0;
		    while ( in.readLine() != null ) {
		    	count++;
		    }
			in.close();
		    
			Question[] questions = new Question[count];
			
			in = new BufferedReader(new FileReader(getClass().getResource(respath + "questions.txt").getPath()));
			
			String zeile = null;
			String[] splittedS = null;
			String[] answers = new String[4];
			
			for (int i = 0;(zeile = in.readLine()) != null;i++) {
				try{
					splittedS = zeile.split("\t");
					answers[0] = splittedS[1];
					answers[1] = splittedS[2];
					answers[2] = splittedS[3];
					answers[3] = splittedS[4];
					questions[i] = new Question(splittedS[0], answers, Integer.parseInt(splittedS[5]));
					answers = new String[4];
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Beim Einlesen der Fragen ist ein Fehler aufgetreten!\nFrage Nr. "+(i+1));
					//Just for Debugging
//					JOptionPane.showMessageDialog(null, splittedS[0]);
//					JOptionPane.showMessageDialog(null, splittedS[1]);
//					JOptionPane.showMessageDialog(null, splittedS[2]);
//					JOptionPane.showMessageDialog(null, splittedS[3]);
//					JOptionPane.showMessageDialog(null, splittedS[4]);
//					JOptionPane.showMessageDialog(null, splittedS[5]);
				}
			}
			in.close();
			
			model.setQuestions(questions);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Beim Einlesen der Fragen ist ein Fehler aufgetreten!\nSpiel wird beendet!");
			System.exit(0);
		}
	}
	
	public void nextQuestion(){
		if(model.getLifeCookie() <= 0){
			model.loseLvl();
		}else{
			actualmode = Controller.mode_Game;
			model.newQuestion();
			model.setWartezeit(antwortzeit);
			view.showGamePanel();
			model.startQuestion();
		}
	}
	
	public void nextLvl(){
		nextQuestion();
	}
	
	public void answer(int answerIndex){
		model.answer(answerIndex);
	}
	
	public void showWaitingScreen(){
		view.showWaitingPanel();
	}
	
	public void resetStats(){
		if(JOptionPane.showConfirmDialog(null, "Möchtest du wirklich deinen aktuellen Spielstand löschen?") == JOptionPane.OK_OPTION){
			model.setaCookies(0);
			model.setaLvl(1);
			model.setLifeCookie(3);
			model.setSchachteln(0);
			model.setWaitingPointEnd(0);
			readQuestions();
			save();
			JOptionPane.showMessageDialog(null, "Spielstand wurde gelöscht!");
		}else{
			JOptionPane.showMessageDialog(null, "Reset abgebrochen!");
		}
	}
	
	public MouseListen getMouseListener(){
		return mouseL;
	}
	
	public View getView(){
		return view;
	}
	
	public Model getModel(){
		return model;
	}

	public Images getImages() {
		return images;
	}
	
}
