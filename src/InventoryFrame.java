import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 * Group 4: inventory
 * 
 * 2024-11-26 ICS3U1-01 Mrs. Biswas
 * 
 * Project: main page, inventory frame, laptop Info frames
 * 
 * create panels: -InventoryComputerInfoPanel -specificLaptopFrame -ScrollPane
 * 
 * Added Feature: - ArrayList
 * 
 * Areas of Concern: - to make sure the panel size and position are appropriate
 * that panels will not cover each other
 */
public class InventoryFrame extends JFrame implements ActionListener {
	// Title label for the inventory frame
	JLabel titlelabel = new JLabel("Laptop Inventory");

	// Create ArrayList to hold the laptop information panels
	List<InventoryComputerInfoPanel> computerInfoPanelList = new ArrayList<>();

	// Create a constructor to set up the Inventory frame
	public InventoryFrame() {
		// Set the size of the frame window
		setSize(800, 600);

		// Exit the application when the frame is closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create a main panel to hold the computer panels
		JPanel mainPanel = new JPanel();
		// Set layout to null for absolute positioning of components
		mainPanel.setLayout(null);

		// Adding the title label at the top
		// Set the position and size of the title label
		titlelabel.setBounds(10, 10, 200, 30);
		// Add the label to the main panel
		mainPanel.add(titlelabel);

		// Set the dimensions for each laptop information panel
		int panelWidth = 250;
		int panelHeight = 250;
		// Horizontal gap between panels
		int gapX = 30;
		// Vertical gap between panels
		int gapY = 30;

		// Loop to create and add 20 laptop panels to the frame
		for (int i = 0; i < 20; i++) {
			// Retrieve the laptop object from the database
			Laptops laptopObject = Database.laptops.get(i);

			// Load the laptop image from the assets folder
			Image computerImage = new ImageIcon("assets/computers/" + (i + 1) + ".png").getImage();

			// Create a new panel to display the laptop's image, model, and price
			InventoryComputerInfoPanel panel = new InventoryComputerInfoPanel(computerImage, laptopObject.getModel(),
					laptopObject.getPrice());
			// Add the panel to the list of panels
			computerInfoPanelList.add(panel);

			// Calculate the position of the panel
			// 3 panels per row
			int xPos = (i % 3) * (panelWidth + gapX) + 10;
			int yPos = (i / 3) * (panelHeight + gapY) + 50;

			// Set the panel's position and size
			panel.setBounds(xPos, yPos, panelWidth, panelHeight);

			// Create a button to view the details of the specific laptop
			JButton viewButton = new JButton("MORE INFO");

			// Set button position and size
			viewButton.setBounds(60, 200, 120, 30);

			// Add an ActionListener to handle button click events
			// Capture the current index for use in the lambda expression
			int index = i;

			// group manager told me that I can use this way to make the button connect
			// other frame
			// e ->:The arrow operator separates the list of parameters
			// from the body of the lambda expression.
			// openSpecificLaptopFrame(laptopObject, computerImage):
			// The method call that opens the new window
			viewButton.addActionListener(e -> openSpecificLaptopFrame(laptopObject, computerImage));

			// Add the button to the panel
			panel.add(viewButton);

			// Add the panel to the main panel
			mainPanel.add(panel);
		}

		// Set size for the main panel to hold laptop panels
		// mainPanel.setPreferredSize():
		// set Preferred Size of the panel
		// new Dimension(width, height):
		// creates a new Dimension object set the size of the panel.
		mainPanel.setPreferredSize(new Dimension(800, (20 / 3 + 1) * 220));

		// Add the mainPanel to a scroll pane
		JScrollPane scrollPane = new JScrollPane(mainPanel);

		// set size and position of Scroll box
		scrollPane.setBounds(0, 10, 900, 600);

		// .setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED):
		// The scroll bar will appear only if needed(horizontal)
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// .setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED):
		// the scroll bar will appear only if needed(vertical)
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		// Add the scroll pane to the frame
		setLayout(null);
		add(scrollPane);

		// Make the frame visible
		setVisible(true);
	}

	// Method to open specific laptop frame
	private void openSpecificLaptopFrame(Laptops laptopObject, Image computerImage) {

		// create laptopInfo which contain:
		// CPU, GPU, OS, RAM, SSD
		String laptopInfo = (laptopObject.getCPU() + "/n" + laptopObject.getGPU() + "/n" + laptopObject.getOS() + "/n"
				+ laptopObject.getRAM() + "/n" + laptopObject.getSSD());

		// add detail for specificLaptopFrame
		new specificLaptopFrame(computerImage, laptopObject.getModel(), laptopObject.getPrice(), laptopInfo);
	}

	@Override
	public void actionPerformed(ActionEvent event) {

	}

	public static void main(String[] args) {
		// Load laptop data from a CSV file into the database
		FileToArray.readFileToDatabase("data/laptop-info.csv", 20);
		// create and display the InventoryFrame
		new InventoryFrame();
	}
}
