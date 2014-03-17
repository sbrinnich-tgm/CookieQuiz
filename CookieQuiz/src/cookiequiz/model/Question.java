package cookiequiz.model;

public class Question {

	private String question;
	private String[] answers = new String[4];
	private int trueAnswerIndex;
	
	public Question(String question, String[] answers, int trueAnswerIndex){
		this.question = question;
		this.answers = answers;
		this.trueAnswerIndex = trueAnswerIndex;
	}

	public String getQuestion() {
		return question;
	}

	public String[] getAnswers() {
		return answers;
	}

	public int getTrueAnswerIndex() {
		return trueAnswerIndex;
	}
	
}
