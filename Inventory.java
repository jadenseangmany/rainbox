package rainbox;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the inventory, holding a collection of products.
 */
public class Inventory {
    // List to store the collection of products
    private List<Product> products;

    /**
     * Constructs a new Inventory instance.
     */
    public Inventory() {
        products = new ArrayList<>();
    }

    /**
     * Adds a product to the inventory.
     *
     * @param product The product to be added.
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * Removes a product from the inventory by its ID.
     *
     * @param productId The ID of the product to be removed.
     */
    public void removeProduct(String productId) {
        products.removeIf(product -> product.getProductId().equals(productId));
    }

    /**
     * Retrieves a product from the inventory by its ID.
     *
     * @param productId The ID of the product to retrieve.
     * @return The product if found, or null otherwise.
     */
    public Product getProduct(String productId) {
        return products.stream()
                .filter(product -> product.getProductId().equals(productId))
                .findFirst()
                .orElse(null);
    }

    // Additional methods like listAllProducts can be added for display purposes
}
