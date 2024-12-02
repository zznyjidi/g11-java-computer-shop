import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainMenuFrame extends JFrame implements ActionListener {

	// Method for the main menu frame
	public MainMenuFrame() {

		// Create conponent
		// mainframe
		JFrame frame = new JFrame("Laptop Central");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Set frame size
		frame.setSize(800, 600);
		// layout for precise positioning
		frame.setLayout(null);

		// Create the "LAPTOP" label
		JLabel laptopLabel = new JLabel("LAPTOP");
		laptopLabel.setFont(new Font("Arial", Font.BOLD, 70));
		laptopLabel.setForeground(Color.WHITE);
		laptopLabel.setBounds(100, 150, 600, 80); // Increased width and adjusted position

		// Create the "CENTRAL" label
		JLabel centralLabel = new JLabel("CENTRAL");
		// set front
		centralLabel.setFont(new Font("Arial", Font.BOLD, 70));
		// set corlor
		centralLabel.setForeground(Color.WHITE);
		// set position and size
		centralLabel.setBounds(100, 250, 600, 80);

		// Set background color for the frame
		frame.getContentPane().setBackground(new Color(60, 100, 160));

		// Add the labels to the frame
		frame.add(laptopLabel);
		frame.add(centralLabel);

		// Set frame visibility
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new MainMenuFrame();
	}

	@Override
	public void actionPerformed(ActionEvent event) {

	}
}