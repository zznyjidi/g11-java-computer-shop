import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Application {

	public static void main(String[] args) {
		FileToArray.readFileToDatabase("data/laptop-info.csv", 20);

        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
        mainFrame.setSize(1200, 610);

        Database.mainFrame = mainFrame;

        MenuBar menuBar = new MenuBar();
        menuBar.setBounds(0, 0, 1200, 60);
        mainFrame.add(menuBar);

		menuBar.changePanel(new MainMenuFrame());

        // bugfix: Force Rerender Window to Make Panel shows up
        mainFrame.revalidate();
        mainFrame.repaint();
}
}
