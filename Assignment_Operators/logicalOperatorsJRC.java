public class logicalOperatorsJRC{

    public static void main(String [] args){

        /* Initialize two integer variables */
        int a = 10;
        int b = 20;


        if(a < b && b > a){ /* Check if a is less than b AND b is greater than a */
            System.out.println(true); /* Print true if both conditions are met */
        }
        if(a > b || b > a){ /* Check if a is greater than b OR b is greater than a */
            System.out.println(true); /* Print true if at least one condition is met */
        }
        
        if(!(a > b)){ /* Check if a is NOT greater than b */
            System.out.println(true); /* Print true if a is less than to b */
        }
        if(!(b < a)){ /* Check if b is NOT less than a */
            System.out.println(true); /* Print true if b is greater than to a */
        }
        
        
        
        
        /* Loan Eligibility Program */

        /* Initialize variables for credit score and annual income */
        int creditScore = 1000;
        int annualIncome = 100000;

        if(creditScore >= 700 && annualIncome >= 50000){ /* Check eligibility for a loan */

            System.out.println("You are eligible to loan"); /* Eligible if both conditions are met */
        }
        else if(creditScore < 700 && annualIncome >= 50000){ /* Not eligible due to low credit score */
            System.out.println("Your credit score should above 700 you are not eligible to loan");
        }
        else if(creditScore >= 700 && annualIncome < 50000){ /* Not eligible due to low income */
            System.out.println("Your annual income should above 50000 you are not eligible to loan");
        }
        else{
            System.out.println("You are not eligible to loan"); /* Not eligible for any other reason */
        }



    }

}