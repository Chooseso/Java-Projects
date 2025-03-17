public class combineOperatorsJRC{

    public static void main(String [] args){

        /* Initialize two integer variables */
        int a = 5;
        int b = 10;

        if(a > 0 && b > 0){ /* Check if both a and b are greater than 0 */
            a = a += b; /* Add b to a and update a with the new value, result for a should be 15 */
            b = a *= 2; /* Multiply the new value of a by 2 and update b with the result, the result for b should be 30, and for the a should be 30 also because both variables are being updated using assignment operators */
            System.out.println("Final value of a: " + a); /* Print the final value of a */
            System.out.println("Final value of b: " + b);  /* Print the final value of b */
        }

    }
}