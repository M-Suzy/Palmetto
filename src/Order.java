import java.time.LocalTime;
import java.util.HashMap;
import java.util.Random;


public class Order {
    private final int orderNumber;
    private LocalTime orderTime;
    private int customerNumber;
    private HashMap<String, Pizza> pizzaItems;

    Order(int customerNumber, HashMap<String, Pizza> pizzaItems) {
        this.customerNumber = customerNumber;
        this.orderNumber = generateOrderId();
        this.pizzaItems = pizzaItems;
        checkPizzaNames();
        this.orderTime = LocalTime.now();
    }

    private int generateOrderId() {
        return new Random(5).nextInt(99999);
    }

    private void checkPizzaNames() {
        int index = 0;
        for (String name : pizzaItems.keySet()) {
            if (name.length() < 4 || name.length() > 20 || !name.matches("[a-zA-Z]+")) {
                pizzaItems.get(name).setName(customerNumber + "_" + index);
            }
            index++;
        }
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void addIngredient(PizzaIngredients ingredient, String pizzaName) {
        if (pizzaItems.containsKey(pizzaName)) {
            pizzaItems.get(pizzaName).addIngredient(ingredient);
        }
    }

    public void printCheck() {
        double total_cost = 0;
        System.out.println("********************************");
        System.out.println("Order: " + orderNumber);
        System.out.println("Client: " + customerNumber);
        for (Pizza p : pizzaItems.values()) {
            p.printPizzaInfo();
            total_cost += (p.getCost()*p.getQuantity());
        }
        System.out.println("--------------------------------");
        System.out.println("Total amount: " + total_cost + " €");
        System.out.println("Time: "+orderTime);
        System.out.println("********************************\n");
    }


}
