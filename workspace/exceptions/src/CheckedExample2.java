import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CheckedExample2 {
    public static void main(String[] args) {
        try {
            doTask();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private  static void doTask() throws FileNotFoundException {
        // trying to open "a.txt" to read
        // file can exists or doesn't exist
        FileInputStream fis = new FileInputStream("a.txt");
    }
}
