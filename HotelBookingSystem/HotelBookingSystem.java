import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

class InvalidDateException extends Exception {
    public InvalidDateException(String message) {
        super(message);

    }

}

abstract class Room {
    private String roomType;
    private double price;
    private boolean isAvailable = true;

    public Room(String roomType, double price) {
        this.roomType = roomType;
        this.price = price;
    }

    public String getroomType() {
        return roomType;
    }

    public double getprice() {
        return price;

    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void bookRoom() {
        isAvailable = false;
    }

    public void ReleaseRoom() {
        isAvailable = true;
    }

    abstract void getDescription();

}

class SingleRoom extends Room {

    public SingleRoom() {
        super("Single Room", 2500);

    }

    @Override
    void getDescription() {
        System.out.println("Single Room: Have a single bed good for 1 to 2 persons.");
    }

}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 5500);

    }

    @Override
    void getDescription() {
        System.out.println("Double Room: Have a double bed good for 2 to 4 persons.");
    }
}

class Suite extends Room {
    public Suite() {
        super("Suite Room", 10000);

    }

    @Override
    void getDescription() {
        System.out.println("Suite Room: a luxury room.");
    }

}

class Customer {
    String name;
    String email;
    String membershipStatus;

    public Customer(String name, String email, String membershipStatus) {
        this.name = name;
        this.email = email;
        this.membershipStatus = membershipStatus;
    }

    public String getName() {

        return name;
    }

    public String getEmail() {
        return email;

    }

    public String getMembershipStatus() {
        return membershipStatus;
    }
}

class Reservation {
    Room room;
    Customer customer;
    String checkInDate;
    String checkOutDate;
    double totalPrice;

    public Reservation(Room room, Customer customer, String checkInDate, String checkOutDate) {
        this.room = room;
        this.customer = customer;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;

    }

    void applyDiscount() {
        String membership = customer.getMembershipStatus();
        if (membership.equalsIgnoreCase("Gold")) {
            totalPrice *= 0.8;

        } else if (membership.equalsIgnoreCase("Silver")) {
            totalPrice *= 0.9;

        }
    }

    void calcuateTotalPrice() {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate checkIn = LocalDate.parse(checkInDate, formatter);
            LocalDate checkOut = LocalDate.parse(checkOutDate, formatter);

            if (checkOut.isBefore(checkIn)) {
                throw new InvalidDateException("Check-out date cannot be before check-in data!");

            }
            long days = Duration.between(checkIn.atStartOfDay(), checkOut.atStartOfDay()).toDays();
            totalPrice = room.getprice() * days;

            applyDiscount();

        } catch (DateTimeParseException e) {
            System.out.println("Invalid Date format, Use YYYY-MM-DD as standard format!");

        } catch (InvalidDateException e) {
            System.out.println(e.getMessage());

        }

    }

    public double getTotalPrice() {
        return totalPrice;

    }

    void displayReservationDetails() {
        System.out.println("===== Reservation Details =====");
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Customer Email: " + customer.getEmail());
        System.out.println("Customer Membership: " + customer.getMembershipStatus());
        System.out.println("Customer Room: " + room.getroomType());
        System.out.println("Customer Check-In Date: " + checkInDate);
        System.out.println("Customer Check-Out Date: " + checkOutDate);
        System.out.println("Customer Total Price: ₱" + totalPrice);
    }

}

class Payment {
    double amount;
    String PaymentMethod;
    String creditcardNumber;

    Payment(double amount, String PaymentMethod, String creditcardNumber) {
        this.amount = amount;
        this.PaymentMethod = PaymentMethod;
        this.creditcardNumber = creditcardNumber;

    }

    void processPayment() {
        if (PaymentMethod.equalsIgnoreCase("Credit Card")) {
            System.out.println("Processing Payment......");
            System.out.println("Credit Card Number: " + MaskCredit());

        } else {
            System.out.println("Processing cash payment....");

        }
        System.out.println("Payment Successfull Amount Paid: ₱" + amount);
    }

    public String MaskCredit() {
        if (creditcardNumber.length() < 4) {
            return "****";

        }
        String last4Digits = creditcardNumber.substring(creditcardNumber.length() - 4);
        return "**** **** ****" + last4Digits;
    }

}

public class HotelBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new SingleRoom());
        rooms.add(new DoubleRoom());
        rooms.add(new Suite());

        System.out.println("===== Hotel Booking System =====");

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Membership (Gold | Silver | Regular): ");
        String membershiptype = sc.nextLine();

        Customer customer = new Customer(name, email, membershiptype);

        System.out.println("Available Rooms");

        int index = 1;
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.print(index + ". ");
                room.getDescription();
                ;
                System.out.println("    Price: ₱" + room.getprice());
            }

            index++;
        }

        System.out.print("Select a room: ");
        int optionSelect = sc.nextInt();

        if (optionSelect < 1 || optionSelect > rooms.size()) {
            System.out.println("Invalid Option!");
            return;
        }
        Room selectedRoom = rooms.get(optionSelect - 1);

        sc.nextLine();
        System.out.print("Enter Check-in Date (YYYY-MM-DD): ");
        String checkinDatae = sc.nextLine();

        System.out.print("Enter Check-out Date: (YYYY-MM_DD): ");
        String checkOutDate = sc.nextLine();

        Reservation reservation = new Reservation(selectedRoom, customer, checkinDatae, checkOutDate);
        reservation.calcuateTotalPrice();
        selectedRoom.bookRoom();
        String creditcard = "";

        System.out.print("Enter Payment Method (Cash/Credit Card): ");
        String paymentmethod = sc.nextLine();

        if (paymentmethod.equalsIgnoreCase("Credit Card")) {
            System.out.print("Enter Credit Card Number: ");
            creditcard = sc.nextLine();

        }

        Payment payment = new Payment(reservation.getTotalPrice(), paymentmethod, creditcard);
        payment.processPayment();

        reservation.displayReservationDetails();
    }
}
