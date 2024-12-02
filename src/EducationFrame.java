import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EducationFrame extends JFrame implements ActionListener {
	
	private EducationInfoPanel infoPanel;  // Panel to show information
    
    // Constructor for setting up the frame
    public EducationFrame() {
        // Set up the frame (window)
        setTitle("Education");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 600); // Set the size of the window
        setLocation(280, 120); // Set position of the frame

        // Title Label - Displays "Education" at the top
        JLabel titleLabel = new JLabel("Education", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 50));
        titleLabel.setForeground(Color.BLUE);
        //--------------------

        // Create a JPanel to hold the buttons and organize them in a grid layout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 70, 240)); // Center aligned, with spacing

        // Add buttons with different images
        buttonPanel.add(createButton("assets/computer_parts/cpu.png", "CPU"));
        buttonPanel.add(createButton("assets/computer_parts/gpu.png", "GPU"));
        buttonPanel.add(createButton("assets/computer_parts/ram.png", "RAM"));
        buttonPanel.add(createButton("assets/computer_parts/ssd.png", "SSD"));
        
        
        // Initialize the EducationInfoPanel
        infoPanel = new EducationInfoPanel();
        
        // Layout for the frame's content
        setLayout(new BorderLayout()); // Use BorderLayout for better organization
        add(titleLabel, BorderLayout.NORTH); // Title at the top
        add(buttonPanel, BorderLayout.WEST); // Buttons on the left side
        add(infoPanel, BorderLayout.CENTER); // Information panel in the center
    }

    // Method to create and return a button with an icon and action listener
    private JButton createButton(String imagePath, String buttonText) {
        // Load and resize the image
        ImageIcon icon = new ImageIcon(imagePath);
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(90, 90, Image.SCALE_SMOOTH); // Resize width and height
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        // Create the button with the resized image
        JButton button = new JButton(resizedIcon);
        button.setPreferredSize(new Dimension(120, 120));  // Set size of buttons (X-axis 120, Y-axis 120)

        // Add action listener to the button
        button.setActionCommand(buttonText); // Set the action command to button text
        button.addActionListener(this); // Register the current class as the ActionListener

        return button;
    }

 
    // ActionListener's method for handling button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonText = e.getActionCommand(); // Get the action command (button text)
        infoPanel.updateInformation(buttonText); // Update the info panel based on the button clicked
      
    }

    public static void main(String[] args) {
        // Create and display the EducationFrame
        EducationFrame frame = new EducationFrame();
        frame.setVisible(true);
    }
}


