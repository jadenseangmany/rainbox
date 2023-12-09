package rainbox;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Data Access Object for product data.
 * Handles CRUD operations for products.
 */
public class ProductDAO {
    private List<Product> products;
    private FileHandler fileHandler;

    public ProductDAO(String productFilePath) {
        fileHandler = new FileHandler(productFilePath);
        products = fileHandler.readProducts();
    }
 
    public ProductDAO() {
	 // Relative path to the data file
	    String relativePath = "data/products.dat";
	    fileHandler = new FileHandler(relativePath);
	    products = fileHandler.readProducts();
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
        fileHandler.writeProducts(products);
    }

    public void updateProduct(Product product) {
        int index = findProductIndex(product.getProductId());
        if (index >= 0) {
            products.set(index, product);
            fileHandler.writeProducts(products);
        }
    }

    public void deleteProduct(String productId) {
        products.removeIf(p -> p.getProductId().equals(productId));
        fileHandler.writeProducts(products);
    }

    private int findProductIndex(String productId) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId().equals(productId)) {
                return i;
            }
        }
        return -1;
    }
    /**
     * Retrieves a product by its ID.
     *
     * @param productId The ID of the product to retrieve.
     * @return The product with the specified ID, or null if not found.
     */
    public Product getProduct(String productId) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null; // Return null if product is not found
    }
}
