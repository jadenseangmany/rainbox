package rainbox;

/**
 * Represents a product in the inventory.
 */
public class Product {
    // Attributes of the product
    private String productId;
    private String name;
    private int quantity;
    private double price;

    /**
     * Constructs a new Product instance.
     *
     * @param productId The unique identifier for the product.
     * @param name      The name of the product.
     * @param quantity  The quantity of the product in stock.
     * @param price     The price of the product.
     */
    public Product(String productId, String name, int quantity, double price) {
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // Getter and setter methods

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Additional methods like toString() can be added for easy display
}
