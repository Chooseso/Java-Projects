public class MultiplicationTableJRC {
    public static void main(String args[]) {
        int num = 5; // Define the number for which the multiplication table will be generated

        // Loop from 1 to 10 to create the multiplication table
        for (int i = 1; i <= 10; i++) {
            // Print the multiplication statement: "num x i = result"
            System.out.println(num + " x " + i + " = " + (num * i));
        }
    }
}