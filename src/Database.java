import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JFrame;

public class Database {
    static String laptopImageFormatString = "assets/computers/%d.jpg";
    static int windowWidth = 1200;
    static int windowHeight = 610;

    static JFrame mainFrame;
    static List<Laptops> laptops;

    static Font fontTitle = new Font("Times New Roman", Font.BOLD, 40);
    static Font fontTextDefault = new Font("Times New Roman", Font.PLAIN, 20);
    static Font fontTextSmall = new Font("New Times Roman", Font.PLAIN, 15);
    static Font fontComputerModel = new Font("New Times Roman", Font.BOLD, 16);
    static Font fontComputerPrice = new Font("New Times Roman", Font.BOLD, 14);
    static Font fontHighlight = new Font("New Times Roman", Font.BOLD, 22);

    static Color colorForeground = new Color(0xffffff);
    static Color colorForegroundQuestion = new Color(0x1cffff);
    static Color colorForegroundHighlight = new Color(0xff0000);
    static Color colorBackgroundTitle = new Color(0x3428ba);
    static Color colorBackgroundPanel = new Color(0x3482ba);
}
