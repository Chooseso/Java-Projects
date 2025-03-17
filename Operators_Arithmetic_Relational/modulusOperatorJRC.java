public class modulusOperatorJRC{
    public static void main(String [] args){

        int num1 = 3; /* Declared and Initialized int num1 variable */
        int num2 = 10;  /* Declared and Initialized int num2 variable */


        if(num2 % num1 == 0){ /* create a conditional statement wherein it checks if num2 and num1 are divisible to each other using modulus*/
            System.out.println("Divisible by each other");  /*  if the value of the modulus result is 0 print this statement */
        }

        else{
            System.out.println("Not Divisible by each other"); /* else if the result of modulus has a remainder, print this statement */
        }

    }
}