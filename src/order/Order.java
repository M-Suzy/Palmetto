package order;

import product.Pizza;
import product.PizzaIngredients;

import java.time.LocalTime;
import java.util.Map;
import java.util.Random;

/**
 * The implementation of Order class, which 

 **/
public class Order {
  private final int orderNumber;
  private final LocalTime orderTime;
  private int customerNumber;
  private Map<String, Pizza> pizzaItems;

  Order(int customerNumber, Map<String, Pizza> pizzaItems) {
    this.customerNumber = customerNumber;
    this.orderNumber = generateOrderId();
    this.pizzaItems = pizzaItems;
    checkPizzaNames();
    this.orderTime = LocalTime.now();
  }

  private int generateOrderId() {
    return new Random().nextInt(99999);
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

  public Map<String, Pizza> getPizzaItems() {
    return pizzaItems;
  }

  public LocalTime getOrderTime() {
    return orderTime;
  }
}
