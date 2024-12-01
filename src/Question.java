//The purpose of the Question class is to store 
//questionPrompt and options so I can use it 
//in the SurveyFrame program


public class Question {
	
	//private instanes for questionPrompt and options
	private String questionPrompt;
	private String [] options;
	
	//Constructor method
	public Question(String questionPrompt, String[] options) {
		
		this.questionPrompt = questionPrompt;
		this.options = options;
	}
	
	//return questionPrompt
	public String getQuestionPrompt() {
		return questionPrompt;
	}

	//returns optons
	public String[] getOptions() {
		return options;
	}
	
	

}
