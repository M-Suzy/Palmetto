public enum PizzaIngredients {
    TOMATO_PASTE(1, "Tomato paste"), CHEESE(1, "Cheese"), SALAMI(1.5, "Salami"),
    BACON(1.2, "Bacon"), GARLIC(0.3, "Garlic"), CORN(0.7, "Corn"),
    PEPPER(0.6, "Pepper"), OLIVES(0.5, "Olives");
    private double price;
    private String name;
    PizzaIngredients(double price, String name){
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
