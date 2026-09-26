import java.util.*;

class Customer {

    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Product {

    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class OrderItem {

    Product product;
    int quantity;

    OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    double getTotal() {
        return product.price * quantity;
    }
}

interface PaymentMethod {

    boolean processPayment(double amount);
    
    String getMethodName();
}

class CreditCardPayment implements PaymentMethod {

    public boolean processPayment(double amount) {
        return true;
    }

    public String getMethodName() {
        return "Credit Card";
    }
}

class PayPalPayment implements PaymentMethod {

    public boolean processPayment(double amount) {
        return false;
    }

    public String getMethodName() {
        return "PayPal";
    }
}

class BankTransferPayment implements PaymentMethod {

    public boolean processPayment(double amount) {
        return true;
    }

    public String getMethodName() {
        return "Bank Transfer";
    }
}

class Order {

    enum Status {
        PENDING,
        PAID
    }

    Customer customer;
    ArrayList<OrderItem> items = new ArrayList<>();
    Status status = Status.PENDING;

    Order(Customer customer) {
        this.customer = customer;
    }

    void addItem(Product product, int quantity) {

        items.add(
            new OrderItem(product, quantity)
        );
    }

    double calculateTotal() {

        double total = 0;

        for (OrderItem item : items) {
            total += item.getTotal();
        }

        return total;
    }

    void processPayment(PaymentMethod paymentMethod) {

        if (items.isEmpty()) {
            System.out.println(
                "Cannot process payment for an empty order."
            );
            return;
        }

        System.out.println(
            "Payment initiated via " +
            paymentMethod.getMethodName() +
            " for Order " +
            customer.name + "."
        );

        boolean success =
            paymentMethod.processPayment(
                calculateTotal()
            );

        if (success) {

            status = Status.PAID;

            System.out.println(
                "Payment for Order " +
                customer.name +
                " successful."
            );

        } else {

            System.out.println(
                "Payment for Order " +
                customer.name +
                " failed."
            );
        }

        System.out.println(
            "Order status: " + status
        );
    }
}

public class M5 {

    public static void main(String[] args) {

        Product productA =
            new Product("Product A", 100);

        Product productB =
            new Product("Product B", 200);

        Product productC =
            new Product("Product C", 150);

        Customer customerX =
            new Customer("X");

        Customer customerY =
            new Customer("Y");

        Customer customerZ =
            new Customer("Z");

        Order orderX = new Order(customerX);

        System.out.println(
            "Order created for Customer X."
        );

        orderX.addItem(productA, 2);
        orderX.addItem(productB, 1);

        orderX.processPayment(
            new CreditCardPayment()
        );

        Order orderY = new Order(customerY);

        orderY.processPayment(
            new CreditCardPayment()
        );

        Order orderZ = new Order(customerZ);

        System.out.println(
            "Order created for Customer Z."
        );

        orderZ.addItem(productC, 1);

        orderZ.processPayment(
            new PayPalPayment()
        );
    }
}