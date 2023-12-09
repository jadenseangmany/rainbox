package rainbox;

public class Main {
    public static void main(String[] args) {
        // Create an instance of Inventory
        Inventory inventory = new Inventory();

        // Add some products
        inventory.addProduct(new Product("P100", "Widget", 10, 2.99));
        inventory.addProduct(new Product("P101", "Gadget", 5, 5.99));

        // Display all products
        // This functionality needs to be implemented in the Inventory class
        // Additional functionalities like updating a product, saving/loading from a file can be implemented later
    }
}