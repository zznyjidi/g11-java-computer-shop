/*PORJECT HEADER
 * *Group 4; Trisan Ramjohn
 * -----------------------
 * Sunday, December 1, 2024
 * -----------------------
 * ICS3U1-01 Mrs. Biswas
 * -----------------------
 * Laptop Central
 * -----------------------
 * This is the SurveFrame program which is a GUI orienated program
 * that involves gives the user 4 questions with different options
 * they can select using radio buttons
 * that information will then be sent to the results frame
 * -----------------------
 * Skills used in this program were Arrays, 2D arrays, Swing compoents
 * AWT components, ActionEvent and ActionListener
 * -----------------------
 * An added feature I added was thee random button
 * which would randomly select the options for the user  
 * -----------------------
 * None
 * -----------------------
 * 
 */

 




//Import java swing, java awt, ActionEvent, ActionListener
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//SurveryFrame class that implements the ActionListener interface
public class SurveyFrame implements ActionListener {

	//Declare private instances
	private JPanel mainPanel;
	private JRadioButton[][] options;
	private Question[] questions;
	private ButtonGroup[] groups;
	private JButton submitButton;
	private JButton randomButton;

	//Survey Frame's constructor class
	public SurveyFrame() {

		//Call upon the question class
		//Initalize the questions
		questions = new Question[] {
				new Question("What is your budget?",
						new String[] { "Under $1000", "$1000 - $2000", "$2000 - $2500", "$Over $2500" }),
				new Question("What type of computer are you looking for?",
						new String[] { "Student", "Gaming", "Professional" }),
				new Question("What screen size do you want?",
						new String[] { "13 in - 14 in", "14.1 in - 15 in", "15.1 in - 16 in" }),
				new Question("What brand do you want?",
						new String[] { "HP", "Dell", "Apple", "Framework", "Don't Care" }) };

		//Initialize arrays for groups and options
		options = new JRadioButton[questions.length][];
		groups = new ButtonGroup[questions.length];

		//Call SurveyFrameGUI method
		SurveyFrameGUI();

	}
	
	//This method will return the mainPanel
	public JPanel getPanel() {
		return mainPanel;
	}

	//Purpose of this program is to create the GUI portion of the survey
	private void SurveyFrameGUI() {

	
		//Create main panel for the survey frame
		mainPanel = new JPanel(null);
		mainPanel.setBounds(0, 0, 800, 600);

		

		//Create JLabel that holds the image for the mainPanel
		JLabel mainBackground = new JLabel(new ImageIcon("assets/mainBackground.png"));
		mainBackground.setBounds(0, 0, 800, 600);

		
		
		//Create JLabel that holds the image for the surveyLabel
		JLabel surveyPanelBackground = new JLabel(new ImageIcon("assets/otherBackground.png"));
		surveyPanelBackground.setBounds(0, 0, 800, 60);
		
		//Add image to mainPanel
		mainPanel.add(surveyPanelBackground);

		//Create and style Survey Label
		//Add survey label to mainPanel
		JLabel surveyLabel = new JLabel("Survey");
		surveyLabel.setLayout(new FlowLayout(FlowLayout.CENTER));
		surveyLabel.setBounds(325, 0, 460, 60);
		surveyLabel.setForeground(new Color(0xffffff));
		surveyLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		mainPanel.add(surveyLabel);

		//Component to set surveyLabel to the front of panel1
		//stackoverflow informed me about the ComponentZOrder function
		//Link:
		//https://stackoverflow.com/questions/18155687/jframe-setcomponentzorder-changes-size-of-the-objects
		mainPanel.setComponentZOrder(surveyLabel, 0);

		//For loop to loop through every question in questions
		for (int i = 0; i < questions.length; i++) {
			Question question = questions[i];

			//Create and style the radioPanel
			//Add radioPanel to the mainPanel
			JPanel radioPanel = new JPanel();
			radioPanel.setLayout(new GridLayout(2, 2));
			radioPanel.setBounds(0, 125 + i * 100, 800, 60);
			radioPanel.setBackground(new Color(0x3482ba));
			mainPanel.add(radioPanel);

			
			//Create and style question label
			//Add questionLabel to radioPanel
			JLabel questionLabel = new JLabel(question.getQuestionPrompt());
			questionLabel.setBounds(0, 95 + i * 100, 800, 50);
			questionLabel.setForeground(new Color(0xfffff));
			questionLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			questionLabel.setLayout(new FlowLayout());
			radioPanel.add(questionLabel);

			//Initialize groups array
			//Initialize options array
			groups[i] = new ButtonGroup();
			options[i] = new JRadioButton[question.getOptions().length];
			
			

			//Iterate through each option to get the questions
			for (int j = 0; j < question.getOptions().length; j++) {

				//Create and style radiobuttons
				options[i][j] = new JRadioButton(question.getOptions()[j]);
				options[i][j].setOpaque(false);
				options[i][j].setForeground(new Color(0xffffff));
				options[i][j].setBackground(new Color(0x3428ba));
				options[i][j].setFont(new Font("New Times Roman", Font.PLAIN, 15));

				//Add button group to the group
				//Add radio buttons to panel2
				groups[i].add(options[i][j]);
				radioPanel.add(options[i][j]);

			}

		}

		
		//Create and style submitButton
		//Add submitButton to mainPanel
		submitButton = new JButton("SUBMIT");
		submitButton.setBounds(400, 500, 150, 50);
		submitButton.setForeground(new Color(0x3428ba));
		submitButton.setFont(new Font("New Times Roman", Font.PLAIN, 20));
		submitButton.addActionListener(this);
		mainPanel.add(submitButton);
		
		//Create and style randomButton
		//Add randomButton to mainPanel
		randomButton = new JButton("RANDOM");
		randomButton.setBounds(200, 500, 150, 50);
		randomButton.setForeground(new Color(0x3428ba));
		randomButton.setFont(new Font("New Times Roman", Font.PLAIN, 20));
		randomButton.addActionListener(this);
		mainPanel.add(randomButton);

		
		//Add back image to the mainPanel
		//done at end so that it doesn't over lap the buttons
		mainPanel.add(mainBackground);
	}
	
	//Method that deals with the action events of 
	//the submitButton and radioButton
	public void actionPerformed(ActionEvent e) {
		  if (e.getSource() == submitButton) {
		        submitAction(); 
		    } else if (e.getSource() == randomButton) {
		        randomAction();  
		    }
		}
	//Method that deals with the action of the randomButton 
	private void randomAction() {
		
		for (int i = 0; i < questions.length; i++) {
			
			//Vyas helped me with this funciton
	        // Get the number of options for the current question
	        int randomIndex = (int) (Math.random() * options[i].length);  
	        
	 
	        // Selects the random option
	        options[i][randomIndex].setSelected(true);
	    }
	}
	

	// Method that deals with the action of the submitButton
	public void submitAction() {
		
		//Array to store answers a string
		//Later used in the results frame
		String[] answers = new String[questions.length];
	        
			//Iterates through each question
			for (int i = 0; i < questions.length; i++) {
	            
				//Deals with the radoButtons
				for (int j = 0; j < options[i].length; j++) {
	                
					//Tracks which options is selected
					if (options[i][j].isSelected()) {
	                    
						//Stores the selection as an asnwer
						answers[i] = options[i][j].getText();
					}
	           
			}
	      
		}
			
			//display results of the selections
	        displayResults(answers);
		                 				
	}

		    
	

	//Method that will display the results of the survey
	private void displayResults(String[] answers) {

		//Displaying results in results frame
		//Zixuan helped me with this peice of code 
		for (String answer : answers) {
			System.out.println(answer);
		}
	}

	//Purpose of this method is to test the program 
	public static void main(String[] args) {

		//Create main panel for the survey frame
		JFrame frame = new JFrame("Survey");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);

		//Add background to the frame

		//Set size of the frame
		frame.setSize(800, 600);

		//Set resizable to false
		frame.setResizable(false);


		SurveyFrame panel = new SurveyFrame();
		frame.add(panel.getPanel());
		
		//Set visible to true
		frame.setVisible(true);
	}

	
	

	

}  