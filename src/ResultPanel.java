import java.awt.Image;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

@SuppressWarnings("FieldMayBeFinal")
public class ResultPanel extends JPanel {
    private JPanel[] infoPanels = new JPanel[3];

    public ResultPanel(SurveyResult result) {
        super();
        setLayout(null);
        // Calculate score for each Laptop and Sort from Highest to Lowest
        ResultEntry[] scoreArray = new ResultEntry[Database.laptops.size()];
        for (int i = 0; i < scoreArray.length; i++) {
            scoreArray[i] = new ResultEntry(result, Database.laptops.get(i));
        }
        Arrays.sort(scoreArray, Comparator.comparing(ResultEntry::getMatchScore));
        Collections.reverse(Arrays.asList(scoreArray));

        for (int i = 0; i < 3; i++) {
            int computerImageIndex = Database.laptops.indexOf(scoreArray[i].getLaptop()) + 1;
            Image computerImage = new ImageIcon(String.format(Database.laptopImageFormatString, computerImageIndex)).getImage();
            infoPanels[i] = new ResultComputerInfoPanel(scoreArray[i], computerImage);
            infoPanels[i].setBounds(20 + i*220, 20, 200, 420);
            add(infoPanels[i]);
        }
    }

    public static void main(String[] args) {
        JFrame testFrame = new JFrame();
        testFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        testFrame.setLayout(null);
        testFrame.setVisible(true);
        testFrame.setSize(1200, 610);

        FileToArray.readFileToDatabase("data/laptop-info.csv", 20);
        SurveyResult result = new SurveyResult(new String[] {"Under $1000", "Student", "14.1 in - 15 in", "Don't Care"});
        JPanel resultPanel = new ResultPanel(result);
        resultPanel.setBounds(0, 60, 1200, 550);
        testFrame.add(resultPanel);
    }
}
