import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/*
 * This class is to make the info page for
 * specific laptop
 * which shows the image, price name and 
 * some hardware info of laptop
 */

public class specificLaptopFrame extends JFrame implements ActionListener {

	// create components
	// name, image, price, info and background
	JLabel nameLabel;
	ImageIcon computer;
	JLabel price;
	JTextArea text;
	JButton backButton;
	JPanel background;

	// create constructor to create and initialize the frame for displaying
	public specificLaptopFrame(Image computerImage, String computerName, double computerPrice, String computerInfo) {
		// Initialize the components
		// labels, text area, and button
		nameLabel = new JLabel(computerName);
		computer = new ImageIcon(computerImage);
		price = new JLabel("$" + computerPrice);
		text = new JTextArea(computerInfo);
		backButton = new JButton("Back");
		background = new JPanel();

		// Set up frame
		setLayout(null);
		setTitle(computerName);
		setSize(600, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		// Set up and add title label
		// set position, size and front
		nameLabel.setBounds(210, 8, 400, 50);
		nameLabel.setFont(new Font("Arial", Font.BOLD, 17));
		add(nameLabel);

		// Create label for computer image
		JLabel imageLabel = new JLabel(computer);

		// Scale image size
		// .getScaledInstance()
		ImageIcon image = (ImageIcon) imageLabel.getIcon();
		Image scaledImage = image.getImage();
		Image newImage = scaledImage.getScaledInstance(294, 200, 0);
		computer = new ImageIcon(computerImage);

		// Set and add computer label
		// set position and size
		imageLabel.setBounds(150, 60, 294, 200);
		add(imageLabel);

		// Set up and add price label
		// set position, size and color
		price.setBounds(270, 25, 600, 500);
		price.setForeground(Color.WHITE);
		add(price);

		// Set up and add the text area for displaying
		// Set the font,Position,color and background color
		text.setEditable(false);// .setEditable(false)
								// Make the text area non-editable

		text.setFont(new Font("Arial", Font.PLAIN, 11));
		text.setBounds(20, 290, 590, 300);
		text.setForeground(Color.WHITE);
		text.setBackground(new Color(60, 100, 160));
		add(text);

		// Set and add back button
		backButton.setBounds(260, 610, 90, 30);
		// Add action listener for button click
		backButton.addActionListener(this);
		add(backButton);

		// Set and add background panel
		// position and size
		background.setBounds(0, 0, 600, 700);
		// set color
		background.setBackground(new Color(60, 100, 160));
		add(background);
		// Set frame to visible
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == backButton) {
			// Close the current frame
			this.dispose();
		}
	}

}
