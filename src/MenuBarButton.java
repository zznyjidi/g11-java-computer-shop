
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Callable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

@SuppressWarnings("FieldMayBeFinal")
public class MenuBarButton extends JButton implements ActionListener {
    private Callable<Void> buttonAction;

    public MenuBarButton(Image icon, String text, Callable<Void> action) {
        this.setLayout(new FlowLayout());
        this.add(new JLabel(new ImageIcon(
            icon.getScaledInstance(35, 35, Image.SCALE_SMOOTH)
        )));

        this.add(new JLabel(text));

        buttonAction = action;
        
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this))
            try {
                this.buttonAction.call();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
    }

    public static void main(String[] args) {
        JFrame testFrame = new JFrame();
        testFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        testFrame.setLayout(null);
        testFrame.setVisible(true);
        testFrame.setSize(1200, 610);

        JButton testButton = new MenuBarButton(
            new ImageIcon("assets/computers/20.png").getImage(), 
            "TEST_BUTTON", 
            () -> {
                System.out.println("Button Pressed");
                return null;
            }
        );

        // bugfix: Force Rerender Window to Make Panel shows up
        testFrame.revalidate();
        testFrame.repaint();

        testButton.setBounds(0, 0, 200, 50);
        testFrame.add(testButton);
    }
}
