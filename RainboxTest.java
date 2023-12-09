package rainbox;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RainboxTest {

    // Test cases for Product
    @Test
    public void testProductCreation() {
        Product product = new Product("P100", "Widget", 10, 2.99);
        assertNotNull(product, "Product should not be null");
    }

    @Test
    public void testProductGettersAndSetters() {
        Product product = new Product("P100", "Widget", 10, 2.99);
        // Assertions for getters and setters
    }

    // Test cases for Inventory
    @Test
    public void testAddProductToInventory() {
        Inventory inventory = new Inventory();
        Product product = new Product("P100", "Widget", 10, 2.99);
        inventory.addProduct(product);
        // Assertions for adding product
    }

    @Test
    public void testRemoveProductFromInventory() {
        Inventory inventory = new Inventory();
        Product product = new Product("P100", "Widget", 10, 2.99);
        inventory.addProduct(product);
        inventory.removeProduct("P100");
        // Assertions for removing product
    }

    @Test
    public void testGetProductFromInventory() {
        Inventory inventory = new Inventory();
        Product product = new Product("P100", "Widget", 10, 2.99);
        inventory.addProduct(product);
        // Assertions for getting product
    }

    // Test cases for ProductCategory
    @Test
    public void testCategoryGettersAndSetters() {
        ProductCategory category = new ProductCategory("C100", "Electronics");
        // Assertions for getters and setters
    }
}

