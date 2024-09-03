import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CheckedException {
    public static void main(String[] args) {
        doTask();
    }

    private  static void doTask() {
        // trying to open "a.txt" to read
        // file can exists or doesn't exist
        try {
            FileInputStream fis = new FileInputStream("a.txt");
        }catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
