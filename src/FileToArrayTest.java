
public class FileToArrayTest {
    public static void main(String[] args){
        FileToArray.readFileToDatabase("data/laptop-info.csv", 20);

       /*  try (Scanner fileInput = new Scanner(new File("data/laptop-info.csv"))) {
            fileInput.useDelimiter(",|\n|\r\n");
            while (true) { 
                System.out.println(fileInput.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } */

        for (Laptops laptop : Database.laptops) {
            System.out.println(laptop);
        }
    }
}
