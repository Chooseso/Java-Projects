public class relationalOperatorsJRC{

    public static void main(String [] args){
        // declared and initialized integer variable
        int x = 10; /* declared and initialized int x with a value of 10 */
        int y = 15; /* declared and initialized int x with a value of 15 */

        System.out.println(x == y); /* Compare the 2 variable if they are equal, the result should be false */
        System.out.println(x != y); /* Compare the 2 variable if they are not equal, the result should be true */
        System.out.println(x > y);  /* Compare the 2 variable if x is greaterthan to y, the result should be false */
        System.out.println(x < y);  /* Compare the 2 variable if x is lessthan to y, the result should be true */
        System.out.println(x >= y); /* Compare the 2 variable if x is greaterthan or equal to y, the result should be false */
        System.out.println(x <= y); /* Compare the 2 variable if x is lessthan or equal to y, the result should be true */
        
        // Bonus Task
        if(x >= 10 && x <= 50){ /* Create a conditional statement to show if x is within the range of 10 upto 50 */
            System.out.println("Value of X: " + x + " " + "is Within the range of 10 upto 50"); /* if the condition is true this should be printed. */
        }



    }


}