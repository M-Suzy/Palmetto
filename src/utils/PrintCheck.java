package utils;

import order.Order;
import product.Pizza;

public class PrintCheck {

  public static void print(Order order) {
    double total_cost = 0;
    System.out.println("********************************");
    System.out.println("order.Order: " + order.getOrderNumber());
    System.out.println("Client: " + order.getCustomerNumber());
    for (Pizza p : order.getPizzaItems().values()) {
      p.printPizzaInfo();
      total_cost += (p.getCost() * p.getQuantity());
    }
    System.out.println("--------------------------------");
    System.out.println("Total amount: " + total_cost + " €");
    System.out.println("Time: " + order.getOrderTime());
    System.out.println("********************************\n");
  }
}
