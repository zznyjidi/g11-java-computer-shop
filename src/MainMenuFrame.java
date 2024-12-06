import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenuFrame extends JPanel {

	// Method for the main menu panel
	public MainMenuFrame() {

		// Create conponent

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

		// Set background color for the panel
		this.setBackground(new Color(60, 100, 160));

		// Add the labels to the panel
		this.add(laptopLabel);
		this.add(centralLabel);
	}

	public static void main(String[] args) {
		new MainMenuFrame();
	}
}