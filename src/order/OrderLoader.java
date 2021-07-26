package order;

import product.Pizza;
import product.PizzaIngredients;
import utils.PrintCheck;

import java.util.HashMap;

public class OrderLoader {
  public static void main(String[] args) {

    // Initialize pizzas
    Pizza margarita = new Pizza("Margarita", Pizza.PIZZA_TYPE.CALZONE);
    margarita.addIngredient(PizzaIngredients.TOMATO_PASTE);
    margarita.addIngredient(PizzaIngredients.PEPPER);
    margarita.addIngredient(PizzaIngredients.GARLIC);
    margarita.addIngredient(PizzaIngredients.BACON);
    margarita.setQuantity(2);
    Pizza pepperoniOro = new Pizza("PepperoniOro", Pizza.PIZZA_TYPE.REGULAR, 3);
    pepperoniOro.addIngredient(PizzaIngredients.TOMATO_PASTE);
    pepperoniOro.addIngredient(PizzaIngredients.CHEESE);
    pepperoniOro.addIngredient(PizzaIngredients.SALAMI);
    pepperoniOro.addIngredient(PizzaIngredients.OLIVES);
    // Create order for customer 7717
    HashMap<String, Pizza> pizzaItems = new HashMap<>(2);
    pizzaItems.putIfAbsent(margarita.getName(), margarita);
    pizzaItems.putIfAbsent(pepperoniOro.getName(), pepperoniOro);
    Order order1 = new Order(7717, pizzaItems);
    PrintCheck.print(order1);
    // order.Order for customer 4372
    HashMap<String, Pizza> pizzaItems2 = new HashMap<>();
    margarita.setQuantity(12);
    pizzaItems2.putIfAbsent(margarita.getName(), margarita);
    Order order2 = new Order(4372, pizzaItems2);
    PrintCheck.print(order2);
  }
}
