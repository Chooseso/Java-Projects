import java.util.*;
import java.io.*;

// Interface for tracking
interface Trackable {
    String getStatus();
}

// Interface for refunding
interface Refundable {
    void refund();
}

// Customer class
class Customer {
    private String name;
    private String customerId;

    public Customer(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return customerId;
    }
}

// OrderItem class
class OrderItem {
    private String productName;
    private int quantity;
    private double price;

    public OrderItem(String productName, int quantity, double price) {
        if (quantity <= 0 || price <= 0) {
            throw new IllegalArgumentException("Quantity and price must be positive.");
        }
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}

// Order class
class Order implements Trackable, Refundable {
    private Customer customer;
    private List<OrderItem> items;
    private String status; // e.g., "Completed", "Cancelled"

    public Order(Customer customer) {
        this.customer = customer;
        this.items = new ArrayList<>();
        this.status = "Completed"; // default status
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void refund() {
        this.status = "Cancelled";
    }

    public double getTotalAmount() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
}

// OrderManager class
class OrderManager {
    private List<Order> orders = new ArrayList<>();
    private Map<String, Integer> productOrderCount = new HashMap<>();

    public void addOrder(Order order) {
        orders.add(order);
        for (OrderItem item : order.getItems()) {
            productOrderCount.put(item.getProductName(),
                    productOrderCount.getOrDefault(item.getProductName(), 0) + item.getQuantity());
        }
    }

    public void cancelOrder(Order order) {
        order.refund();
    }

    public List<Order> viewOrdersByCustomer(String customerName) {
        List<Order> result = new ArrayList<>();
        for (Order order : orders) {
            if (order.getCustomer().getName().equalsIgnoreCase(customerName)) {
                result.add(order);
            }
        }
        return result;
    }

    public List<Order> filterOrdersByStatus(String status) {
        List<Order> result = new ArrayList<>();
        for (Order order : orders) {
            if (order.getStatus().equalsIgnoreCase(status)) {
                result.add(order);
            }
        }
        return result;
    }

    public String getMostOrderedProduct() {
        String mostOrdered = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : productOrderCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostOrdered = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return mostOrdered;
    }

    public void saveLogs(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Order order : orders) {
                StringBuilder line = new StringBuilder(); // Build the full line first

                line.append("Customer: ").append(order.getCustomer().getName())
                        .append(", ID: ").append(order.getCustomer().getCustomerId())
                        .append(", Status: ").append(order.getStatus())
                        .append(", Total: ₱").append(order.getTotalAmount())
                        .append(", Products: ");

                List<OrderItem> items = order.getItems();
                for (int i = 0; i < items.size(); i++) {
                    OrderItem item = items.get(i);
                    line.append(item.getProductName()).append(" (Qty: ").append(item.getQuantity()).append(")");
                    if (i < items.size() - 1) {
                        line.append(", "); // Add comma between products
                    }
                }

                writer.write(line.toString()); // Single write call
                writer.newLine(); // Move to next order
            }
            System.out.println("Order logs saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

// Main program
public class CustomerOrderTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderManager orderManager = new OrderManager();

        while (true) {
            System.out.println("\n===== Customer Order Tracker =====");
            System.out.println("1. Add Order");
            System.out.println("2. Cancel and Refund Order");
            System.out.println("3. View customer order log");
            System.out.println("4. Filter Orders");
            System.out.println("5. View Most Ordered Product");
            System.out.println("6. Save Order Logs");
            System.out.println("7. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter customer ID (3 numerical value): ");
                    String id = scanner.nextLine();
                    Customer customer = new Customer(name, id);
                    Order order = new Order(customer);

                    while (true) {
                        System.out.print("Enter product name: ");
                        String productName = scanner.nextLine();
                        System.out.print("Enter quantity: ");
                        int quantity = scanner.nextInt();
                        System.out.print("Enter price: ");
                        double price = scanner.nextDouble();
                        scanner.nextLine(); // consume newline

                        try {
                            OrderItem item = new OrderItem(productName, quantity, price);
                            order.addItem(item);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }

                        System.out.print("Add another item? (yes/no): ");
                        String another = scanner.nextLine();
                        if (!another.equalsIgnoreCase("yes")) {
                            break;
                        }
                    }

                    orderManager.addOrder(order);
                    System.out.println("Order added successfully!");
                    break;

                case 2:
                    System.out.print("Enter customer name to cancel order: ");
                    String cancelName = scanner.nextLine();
                    List<Order> cancelOrders = orderManager.viewOrdersByCustomer(cancelName);
                    if (!cancelOrders.isEmpty()) {
                        orderManager.cancelOrder(cancelOrders.get(0)); // cancel first order found
                        System.out.println("Order cancelled and refunded!");
                    } else {
                        System.out.println("No order found for customer.");
                    }
                    break;

                case 3:
                    System.out.print("Enter customer name to view orders: ");
                    String customerName = scanner.nextLine();
                    List<Order> customerOrders = orderManager.viewOrdersByCustomer(customerName);
                    for (Order o : customerOrders) {
                        System.out.println("Status: " + o.getStatus() + ", Total: $" + o.getTotalAmount());
                    }
                    if (customerOrders.isEmpty()) {
                        System.out.println("No orders found for this customer.");
                    }
                    break;

                case 4:
                    System.out.print("Enter status to filter (Completed/Cancelled): ");
                    String status = scanner.nextLine();
                    List<Order> statusOrders = orderManager.filterOrdersByStatus(status);
                    for (Order o : statusOrders) {
                        System.out.println("Customer: " + o.getCustomer().getName() +
                                ", Total: $" + o.getTotalAmount());
                    }
                    if (statusOrders.isEmpty()) {
                        System.out.println("No orders found with this status.");
                    }
                    break;

                case 5:
                    String mostOrdered = orderManager.getMostOrderedProduct();
                    if (mostOrdered != null) {
                        System.out.println("Most ordered product: " + mostOrdered);
                    } else {
                        System.out.println("No products ordered yet.");
                    }
                    break;

                case 6:
                    orderManager.saveLogs("order_logs.txt");
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
