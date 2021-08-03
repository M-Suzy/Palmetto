package product;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
  private final PIZZA_TYPE type;
  private String name;
  private ArrayList<PizzaIngredients> ingredients;
  private int quantity = 1;

  public Pizza(String name, PIZZA_TYPE type, int quantity) {
    this.name = name;
    this.type = type;
    if (isQuantityAcceptable(quantity)) this.quantity = quantity;
    ingredients = new ArrayList<>(7);
  }

  public Pizza(String name, PIZZA_TYPE type) {
    this.name = name;
    this.type = type;
    ingredients = new ArrayList<>(7);
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    if (isQuantityAcceptable(quantity)) {
      this.quantity = quantity;
    }
  }

  public PIZZA_TYPE getType() {
    return type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<PizzaIngredients> getIngredients() {
    return ingredients;
  }

  public double getCost() {
    double price = type.getPrice();
    for (PizzaIngredients ingredient : ingredients) {
      price += ingredient.getPrice();
    }
    return price;
  }

  public void addIngredient(PizzaIngredients pizzaIngredient) {
    if (ingredients.size() > 7) System.out.println("You can't add more ingredients");
    else if (ingredients.contains(pizzaIngredient))
      System.out.println("You've already added this ingredient");
    else ingredients.add(pizzaIngredient);
  }

  public void printPizzaInfo() {
    System.out.println("Name: " + name);
    System.out.println("--------------------------------");
    System.out.println("product.Pizza Base (" + type.toString() + ") " + type.getPrice() + " €");
    for (PizzaIngredients ingredient : ingredients) {
      System.out.println(ingredient.toString() + " " + ingredient.getPrice() + " €");
    }
    System.out.println("-------------------------------");
    System.out.println("Amount: " + getCost() + " €");
    System.out.println("Quantity: " + getQuantity());
  }

  public boolean isQuantityAcceptable(int quantity) {
    if (quantity > 10) {
      this.quantity = 10;
      System.out.println("\n");
      System.out.println(
          "Attention: You can't order more than 10 pizzas with the same name. The quantity is set to 10.");
      return false;
    }
    if (quantity < 1) {
      System.out.println("Wrong input number. Can't be less than 1. Setting quantity to 1!");
      return false;
    }
    return true;
  }

  public enum PIZZA_TYPE {
    REGULAR(1, "Regular"),
    CALZONE(1.5, "Calzone");
    private final double price;
    private final String name;

    PIZZA_TYPE(double price, String name) {
      this.price = price;
      this.name = name;
    }

    public double getPrice() {
      return price;
    }

    @Override
    public String toString() {
      return name;
    }
  }
}
