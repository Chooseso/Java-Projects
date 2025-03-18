import java.util.Scanner;


public class BMICalculator{
    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);
        double weight;
        double height;
        double bmi;



        System.out.print("Enter Weight in kilogram: ");
        weight = scanner.nextDouble();
        System.out.print("Enter Height in meters: ");
        height = scanner.nextDouble();

        bmi = weight / (height * height);
        String BMIresult = (bmi < 18.5) ? "Underweight" : 
        (bmi >= 18.5 && bmi < 24.9) ? "Normal" : 
        (bmi >= 25 && bmi < 29.9) ? "Overweight" : 
        (bmi >= 30) ? "Obese": null;


        System.out.println("=== BMI RESULT ===");
        System.out.println("Your Computed BMI is: " + Math.ceil(bmi * 100)/100);
        System.out.println("Your Health Status is: " + BMIresult);



    }



}