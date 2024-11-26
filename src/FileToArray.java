import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Group 4: Project Manager
 * 2024-11-26
 * ICS3U1-01 Mrs. Biswas
 * 
 * Project: Laptop Central
 * 
 * Read laptops from csv file
 * and Save them to the Database
 * 
 * Added Feature: 
 *  - ArrayList
 * 
 * Areas of Concern:
 *  - Remove ALL Extra Commas when editing the csv file
 */
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
            Database.laptops = new ArrayList<>();
        }

        try (Scanner fileInput = new Scanner(new File(fileName));) {
            fileInput.useDelimiter(",|\n|\r\n");
            for (int i = 0; i < csvLength; i++) {
                String brand = fileInput.next();
                String model = fileInput.next();
                String type = fileInput.next();
                double price = fileInput.nextDouble();
                String os = fileInput.next();
                String cpu = fileInput.next();
                String gpu = fileInput.next();
                int ssdSize = fileInput.nextInt();
                int ramSize = fileInput.nextInt();
                double weight = fileInput.nextDouble();
                int usbPorts = fileInput.nextInt();
                double displaySize = fileInput.nextDouble();
                String link = fileInput.next();
                Database.laptops.add(new Laptops(
                    brand, model, type, price, os, cpu, gpu, ssdSize,
                    ramSize, weight, usbPorts, displaySize, link
                ));
            }
            fileInput.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
