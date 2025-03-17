public class assignmentOperatorsJRC{
    public static void main(String [] args){


        int x = 10; /* Declare and initialize a variable x with a value of 10 */

        System.out.println("Add: " + (x += 5)); /* Perform addition: Add 5 to x and print the result */
        System.out.println("Subtract: " + (x -= 3)); /* Perform subtraction: Subtract 3 from x and print the result */
        System.out.println("Multiply: " + (x *= 2)); /* Perform multiplication: Multiply x by 2 and print the result*/
        System.out.println("Divide: " + (x /= 4));  /* Perform division: Divide x by 4 and print the result */
        System.out.println("Remainder: " + (x %= 3)); /* Perform modulus operation: Get the remainder of x divided by 3 and print the result */

        // Calculate Final Price

        int initialPrice = 100; /* Initialize the initial price of the product */
        double discount = .20; /* Define the discount rate (20%) */
        double tax = .10; /* Define the tax rate (10%) */
        int finalPrice; /* Declare a variable to hold the final price */

        initialPrice = initialPrice *= (1 - discount); /* Apply the discount to the initial price, Update initialPrice to be its current value multiplied by (1 - discount) or 0.8 */
        initialPrice = initialPrice *= (1 + tax); /* Apply the tax to the new price, Update initialPrice again to be its current value multiplied by (1 + tax) or 1.10 */

        finalPrice = initialPrice; /* Set finalPrice to the updated initialPrice */

        System.out.println("The Final Price is: $" + finalPrice); /* Print the final price to the console with a dollar sign */



    }
}