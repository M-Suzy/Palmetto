import java.util.ArrayList;

public class Pizza {
    public static final int MAX_NUMBER = 10;
    private String name;
    private PIZZA_TYPE type;
    private ArrayList<PizzaIngredients> ingredients;
    private int quantity = 1;
    Pizza(String name, PIZZA_TYPE type, int quantity) {
        this.name = name;
        this.type = type;
        if (isQuantityAcceptable(quantity)) this.quantity = quantity;
        ingredients = new ArrayList<PizzaIngredients>(7);
    }

    Pizza(String name, PIZZA_TYPE type) {
        this.name = name;
        this.type = type;
        ingredients = new ArrayList<PizzaIngredients>(7);
    }

    Pizza(String name, int quantity) {
        this.name = name;
        if(isQuantityAcceptable(quantity)) this.quantity = quantity;
        this.type = PIZZA_TYPE.REGULAR;
    }

    public void setQuantity(int quantity) {
        if(isQuantityAcceptable(quantity)) {
            this.quantity = quantity;
        }
    }

    public int getQuantity() {
        return quantity;
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

    public ArrayList<PizzaIngredients> getIngredients() {
        return ingredients;
    }

    public double getCost() {
        double price = type.getPrice();
        for (PizzaIngredients ingredient : ingredients) {
            price += ingredient.getPrice();
        }
        return price;
    }

    void addIngredient(PizzaIngredients pizzaIngredient) {
        if (ingredients.size() > 7)
            System.out.println("You can't add more ingredients");
        else if (ingredients.contains(pizzaIngredient))
            System.out.println("You've already added this ingredient");
        else ingredients.add(pizzaIngredient);
    }

    public void printPizzaInfo() {
        System.out.println("Name: " + name);
        System.out.println("--------------------------------");
        System.out.println("Pizza Base (" + type.toString() + ") " + type.getPrice() + " €");
        for (PizzaIngredients ingredient : ingredients) {
            System.out.println(ingredient.toString() + " " + ingredient.getPrice() + " €");
        }
        System.out.println("-------------------------------");
        System.out.println("Amount: " + getCost() + " €");
        System.out.println("Quantity: " + getQuantity());
    }

    public boolean isQuantityAcceptable(int quantity){
        if(quantity>10){
            this.quantity =10;
            System.out.println("\n");
            System.out.println("Attention: You can't order more than 10 pizzas with the same name. The quantity is set to 10.");
            return false;
        }
        if(quantity<1){
            System.out.println("Wrong input number. Can't be less than 1. Setting quantity to 1!");
            return false;
        }
        return true;
    }

    public enum PIZZA_TYPE {
        REGULAR(1, "Regular"),
        CALZONE(1.5, "Calzone");
        private double price;
        private String name;

        PIZZA_TYPE(double price, String name) {
            this.price = price;
            this.name = name;
        }

        public double getPrice() {
            return price;
        }
        @Override
        public String toString(){
            return name;
        }
    }

}
