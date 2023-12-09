package rainbox;

public class ProductCategory {
    private String categoryId;
    private String name;

    public ProductCategory(String categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    // Getter and Setter for categoryId
    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // You can override the toString method for easy display of category information
    @Override
    public String toString() {
        return "ProductCategory{" +
                "categoryId='" + categoryId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    // Additional functionalities can be added as per your requirements
}
