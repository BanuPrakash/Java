public class FirstExample {
    public static void main(String[] args) {
        doTask();
    }

    private static void doTask() {
        int[] elems = {4,21};
        System.out.println(elems[5]); //Unchecked
    }
}
