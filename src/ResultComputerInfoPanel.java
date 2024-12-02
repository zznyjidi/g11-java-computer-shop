
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

@SuppressWarnings({ "FieldMayBeFinal", "serial" })
public class ResultComputerInfoPanel extends JPanel {
    private ImageIcon computerImageIcon;
    private JLabel computerImageLabel;
    private JLabel computerModelLabel;
    private JLabel computerInfoLabel;
    private JLabel computerPriceLabel;
    private JButton moreInfoButton;
    private JLabel matchPercentageLabel;

    /**
     * JPanel that display the Laptop info
     * @param laptop Laptop object that contains info for the laptop
     * @param computerImage Image for the Laptop
     */
    public ResultComputerInfoPanel(ResultEntry result, Image computerImage) {
        super();
        setLayout(null);
        // Computer Image
        computerImageIcon = new ImageIcon(
            // Resize Image 
            // (From https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon)
            computerImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH)
        );
        computerImageLabel = new JLabel(computerImageIcon);
        computerImageLabel.setBounds(0, 0, 200, 200);
        this.add(computerImageLabel);

        Laptops laptop = result.getLaptop();
        // Computer Name
        computerModelLabel = new JLabel(laptop.getModel());
        computerModelLabel.setFont(Database.fontComputerModel);
        computerModelLabel.setHorizontalAlignment(SwingConstants.CENTER);
        computerModelLabel.setBounds(0, 200, 200, 24);
        this.add(computerModelLabel);

        // Computer Info
        //Format Computer Info String
        String computerInfo = String.format(
            "<html><center>For %s<br>CPU: %s<br>GPU: %s<br>%dG RAM/%dG SSD<br>OS: %s<br>%.2flb/%.1f\" Screen<br>Have %d USB Ports</center></html>", 
            laptop.getType(), laptop.getCPU(), laptop.getGPU(), laptop.getRAM(), laptop.getSSD(), 
            laptop.getOS(), laptop.getWeight(), laptop.getDisplaySize(), laptop.getNumOfUSBPorts()
        );

        computerInfoLabel = new JLabel(computerInfo);
        computerInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        computerInfoLabel.setVerticalAlignment(SwingConstants.TOP);
        computerInfoLabel.setBounds(0, 225, 200, 115);
        this.add(computerInfoLabel);

        // Computer Price
        computerPriceLabel = new JLabel(String.format("$%.2f", laptop.getPrice()));
        computerPriceLabel.setFont(Database.fontComputerPrice);
        computerPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        computerPriceLabel.setBounds(0, 340, 200, 20);
        this.add(computerPriceLabel);

        // More Info Button
        moreInfoButton = new JButton("More Info");
        moreInfoButton.setBounds(55, 365, 90, 25);
        this.add(moreInfoButton);

        // Match Percentage
        matchPercentageLabel = new JLabel(String.format("%.1f%% Match", (result.getMatchScore()/4)*100));
        matchPercentageLabel.setFont(Database.fontHighlight);
        matchPercentageLabel.setForeground(Database.colorForegroundHighlight);
        matchPercentageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        matchPercentageLabel.setBounds(0, 395, 200, 20);
        this.add(matchPercentageLabel);
    }

    public static void main(String[] args) {
        JFrame testFrame = new JFrame();
        testFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        testFrame.setLayout(null);
        testFrame.setVisible(true);
        testFrame.setSize(1200, 610);
        Image computerImage = new ImageIcon("assets/computers/20.png").getImage();

        FileToArray.readFileToDatabase("data/laptop-info.csv", 20);

        JPanel infoPanel = new ResultComputerInfoPanel(
            new ResultEntry(3.5, Database.laptops.get(19)), 
            computerImage
        );
        infoPanel.setBounds(0, 0, 200, 420);
        // bugfix: Force Rerender Window to Make Panel shows up
        testFrame.revalidate();
        testFrame.repaint();

        testFrame.add(infoPanel);
    }
}
