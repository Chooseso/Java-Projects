public class Car {
    // Instance variables to hold the brand and year of the car
    String brand;
    int year;

    // Method to display car information
    public void displayInfo(String brand, int year) {
        // Print the brand of the car
        System.out.println("Brand: " + brand);
        // Print the year of the car
        System.out.println("Year: " + year);
    }

    public static void main(String[] args) {
        // Create a new Car object
        Car car = new Car();
        // Call the displayInfo method to show the car's brand and year
        car.displayInfo("Toyota", 2020);
    }
}