package rainbox;

/**
 * Represents a category for products in the inventory.
 */
public class ProductCategory {
    // Attributes for the category
    private String categoryId;
    private String name;

    /**
     * Constructs a new ProductCategory instance.
     *
     * @param categoryId The unique identifier for the category.
     * @param name       The name of the category.
     */
    public ProductCategory(String categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    // Getter and setter methods

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // You can override the toString method for easy display of category information
}
