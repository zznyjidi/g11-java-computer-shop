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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// SurveryFrame class that implements the ActionListener interface
public class SurveyFrame implements ActionListener {

	// Declare private instances
	private JPanel mainPanel;
	private JRadioButton[][] options;
	private Question[] questions;
	private ButtonGroup[] groups;
	private JButton submitButton;
	private JButton randomButton;

	// Survey Frame's constructor class
	public SurveyFrame() {

		// Call upon the question class
		// Initalize the questions
		questions = new Question[] {
				new Question("What is your budget?",
						new String[] { "Under $1000", "$1000 - $2000", "$2000 - $2500", "Over $2500" }),
				new Question("What type of computer are you looking for?",
						new String[] { "Student", "Gaming", "Professional" }),
				new Question("What screen size do you want?",
						new String[] { "13 in - 14 in", "14.1 in - 15 in", "15.1 in - 16 in" }),
				new Question("What brand do you want?",
						new String[] { "HP", "Dell", "Apple", "Framework", "Don't Care" }) };

		// Initialize arrays for groups and options
		options = new JRadioButton[questions.length][];
		groups = new ButtonGroup[questions.length];

		// Call SurveyFrameGUI method
		SurveyFrameGUI();
	}

	// This method will return the mainPanel
	public JPanel getPanel() {
		return mainPanel;
	}

	// Purpose of this program is to create the GUI portion of the survey
	private void SurveyFrameGUI() {

		// Create main panel for the survey frame
		mainPanel = new JPanel(null);
		mainPanel.setBounds(0, 0, 1200, 550);

		// Create JLabel that holds the image for the mainPanel
		JLabel mainBackground = new JLabel(new ImageIcon("assets/mainBackground.png"));
		mainBackground.setBounds(0, 0, 1200, 550);

		// Create JLabel that holds the image for the surveyLabel
		JLabel surveyPanelBackground = new JLabel(new ImageIcon("assets/otherBackground.png"));
		surveyPanelBackground.setBounds(0, 0, 1200, 60);

		// Add image to mainPanel
		mainPanel.add(surveyPanelBackground);

		// Create and style Survey Label
		// Add survey label to mainPanel
		JLabel surveyLabel = new JLabel("Survey");
		surveyLabel.setLayout(new FlowLayout(FlowLayout.CENTER));
		surveyLabel.setBounds(530, 0, 800, 60);
		surveyLabel.setForeground(Database.colorForeground);
		surveyLabel.setFont(Database.fontTitle);
		mainPanel.add(surveyLabel);

		// Component to set surveyLabel to the front of panel1
		// stackoverflow informed me about the ComponentZOrder function
		// Link:
		// https://stackoverflow.com/questions/18155687/jframe-setcomponentzorder-changes-size-of-the-objects
		mainPanel.setComponentZOrder(surveyLabel, 0);

		// For loop to loop through every question in questions
		for (int i = 0; i < questions.length; i++) {
			Question question = questions[i];

			// Create and style the radioPanel
			// Add radioPanel to the mainPanel
			JPanel radioPanel = new JPanel();
			radioPanel.setLayout(new GridLayout(2, 2));
			radioPanel.setBounds(0, 100 + i * 90, 1200, 60);
			radioPanel.setBackground(Database.colorBackgroundPanel);
			mainPanel.add(radioPanel);

			// Create and style question label
			// Add questionLabel to radioPanel
			JLabel questionLabel = new JLabel(question.getQuestionPrompt());
			questionLabel.setBounds(0, 95 + i * 100, 800, 50);
			questionLabel.setForeground(Database.colorForegroundQuestion);
			questionLabel.setFont(Database.fontTextDefault);
			questionLabel.setLayout(new FlowLayout());
			radioPanel.add(questionLabel);

			// Initialize groups array
			// Initialize options array
			groups[i] = new ButtonGroup();
			options[i] = new JRadioButton[question.getOptions().length];

			// Iterate through each option to get the questions
			for (int j = 0; j < question.getOptions().length; j++) {
				// Create and style radiobuttons
				options[i][j] = new JRadioButton(question.getOptions()[j]);
				options[i][j].setOpaque(false);
				options[i][j].setForeground(Database.colorForeground);
				options[i][j].setBackground(Database.colorBackgroundTitle);
				options[i][j].setFont(Database.fontTextSmall);

				// Add button group to the group
				// Add radio buttons to panel2
				groups[i].add(options[i][j]);
				radioPanel.add(options[i][j]);
			}
		}

		// Create and style submitButton
		// Add submitButton to mainPanel
		submitButton = new JButton("SUBMIT");
		submitButton.setBounds(600, 450, 150, 50);
		submitButton.setForeground(Database.colorBackgroundTitle);
		submitButton.setFont(Database.fontTextDefault);
		submitButton.addActionListener(this);
		mainPanel.add(submitButton);

		// Create and style randomButton
		// Add randomButton to mainPanel
		randomButton = new JButton("RANDOM");
		randomButton.setBounds(400, 450, 200, 50);
		randomButton.setForeground(Database.colorBackgroundTitle);
		randomButton.setFont(Database.fontTextDefault);
		randomButton.addActionListener(this);
		mainPanel.add(randomButton);

		// Add back image to the mainPanel
		// done at end so that it doesn't over lap the buttons
		mainPanel.add(mainBackground);
	}

	// Method that deals with the action events of
	// the submitButton and radioButton
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submitButton) {
			submitAction();
		} else if (e.getSource() == randomButton) {
			randomAction();
		}
	}

	// Method that deals with the action of the randomButton
	private void randomAction() {
		for (int i = 0; i < questions.length; i++) {
			// Vyas helped me with this funciton
			// Get the number of options for the current question
			int randomIndex = (int) (Math.random() * options[i].length);

			// Selects the random option
			options[i][randomIndex].setSelected(true);
		}
	}

	// Method that deals with the action of the submitButton
	public void submitAction() {
		// Array to store answers a string
		// Later used in the results frame
		String[] answers = new String[questions.length];
		// Iterates through each question
		for (int i = 0; i < questions.length; i++) {
			// Deals with the radoButtons
			for (int j = 0; j < options[i].length; j++) {
				// Tracks which options is selected
				if (options[i][j].isSelected()) {
					// Stores the selection as an asnwer
					answers[i] = options[i][j].getText();
				}
			}
		}
		// display results of the selections
		displayResults(answers);
	}

	// Method that will display the results of the survey
	private void displayResults(String[] answers) {
		// Displaying results in results frame
		// Zixuan helped me with this peice of code
		SurveyResult result = new SurveyResult(answers);
		JPanel resultPanel = new ResultPanel(result);
		resultPanel.setBounds(0, 60, 1200, 550);
		
		Database.menuBar.changePanel(resultPanel);
		// bugfix: Force Rerender Window to Make Panel shows up
        Database.mainFrame.revalidate();
        Database.mainFrame.repaint();
	}

	// Purpose of this method is to test the program
	public static void main(String[] args) {
		// Create main panel for the survey frame
		Database.mainFrame = new JFrame("Survey");
		JFrame frame = Database.mainFrame;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);

		FileToArray.readFileToDatabase("data/laptop-info.csv", 20);
		
		// Add background to the frame
		// Set size of the frame
		frame.setSize(Database.windowWidth, Database.windowHeight);
		// Set resizable to false
		frame.setResizable(false);
		SurveyFrame panel = new SurveyFrame();
		frame.add(panel.getPanel());
		// Set visible to true
		frame.setVisible(true);
	}
}
