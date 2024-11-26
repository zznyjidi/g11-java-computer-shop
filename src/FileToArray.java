import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FileToArray {

    /**
     * Read n laptops form specified file and Add to the Database
     * If List is not init in the Database, init as ArrayList
     * @param fileName
     * @param csvLength
     */
    public static void readFileToDatabase(String fileName, int csvLength) {
        // Init Database as ArrayList if not already
        if (Database.laptops == null) {
            Database.laptops = new ArrayList<Laptops>();
        }

        try {
            Scanner fileInput = new Scanner(new File(fileName));
            fileInput.useDelimiter(",|\n|\r\n");
            for (int i = 0; i < csvLength; i++) {
                Database.laptops.add(new Laptops(
                    fileInput.next(), 
                    fileInput.next(), 
                    fileInput.next(), 
                    fileInput.nextInt(), 
                    fileInput.next(), 
                    fileInput.next(), 
                    fileInput.next(), 
                    fileInput.nextInt(), 
                    fileInput.nextInt(), 
                    fileInput.nextInt(), 
                    fileInput.nextInt(), 
                    fileInput.nextDouble(), 
                    fileInput.next())
                );
            }
            fileInput.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            new JOptionPane("File Not Found! ");
        }
    }
}
