
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class MenuBar extends JPanel {
    JButton[] buttons = new MenuBarButton[4];

    JPanel currentPanel;

    public MenuBar() {
        setLayout(new FlowLayout());
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new MenuBarButton(
                new ImageIcon("assets/icons/" + i + ".png").getImage(), 
                switch (i+1) {
                    case 1 -> "Home";
                    case 2 -> "Inventory";
                    case 3 -> "Education";
                    case 4 -> "Survey";
                    default -> "UNDEFINED_BUTTON";
                }, 
                switch (i+1) {
                    case 1 -> () -> {
                        changePanel(new MainMenuFrame());
                        return null;
                    };
                    case 2 -> () -> {
                        JFrame frame = new InventoryFrame();
                        return null;
                    };
                    case 3 -> () -> {
                        JFrame eduFrame = new EducationFrame();
                        eduFrame.setVisible(true);
                        System.out.println("EducationFrame");
                        return null;
                    };
                    case 4 -> () -> {
                        SurveyFrame survey = new SurveyFrame();
                        changePanel(survey.getPanel());
                        return null;
                    };
                    default -> () -> {
                        return null;
                    };
                }
            );
            this.add(buttons[i]);
        }
    }

    public void changePanel(JPanel newPanel) {
        try {
            Database.mainFrame.remove(currentPanel);
        } catch (NullPointerException e) {}
        currentPanel = newPanel;
        currentPanel.setBounds(0, 60, 1200, 550);
        Database.mainFrame.add(currentPanel);

        // bugfix: Force Rerender Window to Make Panel shows up
        Database.mainFrame.revalidate();
        Database.mainFrame.repaint();
    }

    public static void main(String[] args) {
        FileToArray.readFileToDatabase("data/laptop-info.csv", 20);

        JFrame testFrame = new JFrame();
        testFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        testFrame.setLayout(null);
        testFrame.setVisible(true);
        testFrame.setSize(1200, 610);

        Database.mainFrame = testFrame;

        JPanel menuBar = new MenuBar();
        menuBar.setBounds(0, 0, 1200, 60);
        testFrame.add(menuBar);

        // bugfix: Force Rerender Window to Make Panel shows up
        testFrame.revalidate();
        testFrame.repaint();
    }
}
