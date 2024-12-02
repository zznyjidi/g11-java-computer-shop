
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings({ "FieldMayBeFinal", "serial" })
public class ResultComputerInfoPanel extends JPanel {
    private ImageIcon computerImageIcon;
    private JLabel computerImageLabel;
    private JLabel computerModelLabel;
    private JLabel computerInfoLabel;
    private JLabel computerPriceLabel;
    private JButton moreInfoButton;


    public ResultComputerInfoPanel(String computerName, Image computerImage, String computerInfo) {
        super();
        setLayout(null);
        // Computer Image
        // Resize Image 
        // (From https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon)
        Image scaledImage = computerImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        computerImageIcon = new ImageIcon(scaledImage);
        computerImageLabel = new JLabel(computerImageIcon);
        computerImageLabel.setBounds(0, 0, 200, 200);
        this.add(computerImageLabel);

        // Computer Name
        computerModelLabel = new JLabel(computerName);
        computerModelLabel.setFont(Database.fontComputerModel);
        computerModelLabel.setHorizontalAlignment(SwingConstants.CENTER);
        computerModelLabel.setBounds(0, 200, 200, 24);
        this.add(computerModelLabel);
        
        // Computer Info
        computerInfoLabel = new JLabel(computerInfo);
        computerInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        computerInfoLabel.setVerticalAlignment(SwingConstants.TOP);
        computerInfoLabel.setBounds(0, 225, 200, 20);
        this.add(computerInfoLabel);
    }

    public static void main(String[] args) {
        JFrame testFrame = new JFrame();
        testFrame.setLayout(null);
        testFrame.setVisible(true);
        testFrame.setSize(1200, 610);
        Image computerImage = new ImageIcon("assets/computers/5.png").getImage();

        JPanel infoPanel = new ResultComputerInfoPanel(
            "Test Computer", 
            computerImage, 
            "Something");
        infoPanel.setBounds(0, 0, 200, 400);
        testFrame.add(infoPanel);
    }
}
