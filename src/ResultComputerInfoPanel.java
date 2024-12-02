
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings({ "FieldMayBeFinal", "serial" })
public class ResultComputerInfoPanel extends JPanel {
    private ImageIcon computerImageIcon;
    private JLabel computerImageLabel;
    private JLabel computerModelLabel;
    private JLabel computerInfoLabel;
    private JLabel computerPriceLabel;
    private JButton moreInfoButton;

    public ResultComputerInfoPanel(String computerName, Image computerImage, String computerInfo) {
        // Computer Image
        computerImageIcon = new ImageIcon(
            // Resize Image 
            // (From https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon)
            computerImage.getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH)
        );
        computerImageLabel = new JLabel(computerImageIcon);
        //computerImageLabel.setBounds(0, 0, 300, 300);
        this.add(computerImageLabel);

        // Computer Name
        computerModelLabel = new JLabel(computerName);
        //computerModelLabel.setBounds(320, 0, 300, 20);
        this.add(computerModelLabel);

        // Computer Info
        computerInfoLabel = new JLabel(computerInfo);
        //computerInfoLabel.setBounds(340, 0, 300, 300);
        this.add(computerInfoLabel);
    }

    public static void main(String[] args) {
        JFrame testFrame = new JFrame();
        testFrame.setVisible(true);
        testFrame.setSize(1000, 1000);
        Image computer = new ImageIcon("assets/computers/5.png").getImage();
        JPanel infoPanel = new ResultComputerInfoPanel("Test Computer", computer, "");
        testFrame.add(infoPanel);
    }
}
