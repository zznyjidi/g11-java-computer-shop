/*
 *  this program is for the main manu
 *  frame, this frame is the first page 
 *  of our laptop central, there will have some 
 *  buttons can be used to go to other pages
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainMenuFrame extends JFrame implements ActionListener {
	
	// Method for the main menu frame
	void MainTitleFrame(){
		//Create a JLabel for the text "LAPTOP"
		JLabel label1 = new JLabel();
		label1.setText("LAPTOP");
		
		// Change text color to blue
        label1.setForeground(Color.BLUE.darker()); 
        // Change font to Atton with size 115
        label1.setFont(new Font("Atton", Font.PLAIN, 115)); 
        label1.setBounds(115, 230, 460, 138);
        
        // Create a JLabel for the text "CENTRAL"
        JLabel label2 = new JLabel();
		label2.setText("CENTRAL");
		
		// Change text color to blue
        label2.setForeground(Color.WHITE); 
        // Change font to Atton with size 115
        label2.setFont(new Font("Atton", Font.PLAIN, 115)); 
        label2.setBounds(115, 414, 460, 138);
        
        // Set the title of the frame
        this.setTitle("Software Development Practise Title Goes Here"); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Prevent the window from being resized
		this.setResizable(false);
		
		//Set the size of the window
		this.setSize(800, 600);
		
		// Make the window visible
		this.setVisible(true);
		
		// Add the labels to the frame
		this.add(label1);
		this.add(label2);
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		
		
	}

}
