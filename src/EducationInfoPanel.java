import javax.swing.*;
import java.awt.*;

	public class EducationInfoPanel extends JPanel {
	    
	    private JLabel infoLabel;
	    
	    public EducationInfoPanel() {
	        // Initialize panel layout
	        setLayout(new BorderLayout());
	        
	        // Create and set up a label that will show the information
	        infoLabel = new JLabel("Select a component to view its information.", JLabel.CENTER);
	        infoLabel.setFont(new Font("Arial", Font.PLAIN, 20));
	        add(infoLabel, BorderLayout.CENTER); // Add label to the center of the panel
	    }
	    
	    // Method to update the information based on the component selected
	    public void updateInformation(String component) {
	        String infoText = "";
	        
	        switch (component) {
	            case "CPU":
	                infoText = "<html><b>CPU (Central Processing Unit)</b><br>" +
	                           "A central processing unit, or CPU. The main part of a computer is system processing."
	                           + " Because it carries out commands, performs calculations, and regulates the data flow inside the computer That’s why CPU is also known as the brain of the computer."
	                           + " The CPU interprets and executes instructions from the computer’s memory, including arithmetic and logical operations, instructions for moving data around, and instructions for controlling flow. "
	                           + "By modifying and processing data held in registers, caches, and main memory, it carries out these processes..<br>" +
	                           "It carries out instructions from programs by performing basic arithmetic, logic, control, and input/output operations.</html>";
	                break;
	            case "GPU":
	                infoText = "<html><b>GPU (Graphics Processing Unit)</b><br>" +
	                           "The GPU is responsible for rendering images, video, and animations in computers."
	                           + "The graphics processing unit (GPU) has many smaller, more specialized cores."
	                           + " These cores deliver massive performance by working together and dividing processing tasks across many cores simultaneously (or in parallel)."
	                           + " The GPU excels at highly parallel tasks like rendering visuals during gameplay, manipulating video data during content creation, and computing results in intensive AI workloads..<br>" +
	                           "It accelerates the creation of images in a frame buffer intended for output to a display.</html>";
	                break;
	            case "RAM":
	                infoText = "<html><b>RAM (Random Access Memory)</b><br>" +
	                           "RAM (which stands for Random Access Memory) is the familiar acronym for random access memory, which is the temporary storage in your computer that gives applications a place to store and access data on a short-term basis. "
	                           + "Having more RAM means that more data can be accessed and read almost instantly, as opposed to being written on your hard drive.<br>" +
	                           "It is used to store data that is being actively used or processed by the CPU.</html>";
	                break;
	            case "SSD":
	                infoText = "<html><b>SSD (Solid State Drive)</b><br>" +
	                           "An SSD is a type of storage device that uses flash memory to store data.SSD is a storage device for a computer that keeps hold of all your programs, files, and whatever else you have on your computer, but not all storage is the same. Even the best cheap SSD will give you next-level performance over the best hard drive, while the best SSD overall will provide load times that older PCs could only dream of.\n"
	                           + "\n"
	                           + "<br>" +
	                           "It is faster than traditional hard drives (HDDs) and has no moving parts.</html>";
	                break;
	            default:
	                infoText = "Select a component to view its information.";
	                break;
	        }
	        
	        // Update the label with the new information
	        infoLabel.setText(infoText);
	    }
	}


