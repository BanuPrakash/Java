public class SecondExample {
    public static void main(String[] args) {
        doTask();
    }
// StackOverflowError
    private static void doTask() {
        System.out.println("Hello");
        doTask(); // recursive without exit condition
    }
}
