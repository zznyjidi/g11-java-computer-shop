import java.awt.Image;
import javax.swing.*;

/*
 * This class is to make a panel for laptop
 * wich can use to make different info button in the
 * inventory frame page by use arrayList and for loop
 */

public class InventoryComputerInfoPanel extends JPanel {

	// panel for laptops can be change info in the inventoty frame
	public InventoryComputerInfoPanel(Image computerImage, String computerName, double computerPrice) {

		// Create labels to display the
		// price, name, and image of the laptop
		ImageIcon computer = new ImageIcon(computerImage.getScaledInstance(105, 55, Image.SCALE_SMOOTH));
		JLabel price = new JLabel(String.format("$%.2f", computerPrice));
		JLabel name = new JLabel(computerName);
		JLabel computerComputer = new JLabel(computer);

		// Set layout to null for manual positioning of components
		setLayout(null);

		// Set the bounds: position and size
		// for each component within the panel
		computerComputer.setBounds(37, 75, 145, 90);
		name.setBounds(50, 145, 200, 25);
		price.setBounds(80, 170, 200, 25);

		// Add all components (image, name, and price) to the panel
		add(computerComputer);
		add(name);
		add(price);

	}

	public void setBonds(int x, int y, int width, int height) {
		// Set the panel's position and size
		setBounds(x, y, width, height);
	}
	// -----------test the panel--------------
	// public static void main(String[] args) {
	// JFrame testFrame = new JFrame();
	// testFrame.setSize(800, 600);
	// testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure window
	// closes
	// Image computerImage = new ImageIcon("assets/computers/5.png").getImage();
	// testFrame.add(new InventoryComputerInfoPanel(computerImage, "Computer",
	// 5.5));
	// testFrame.setVisible(true);
	// }
}