package rainbox;

import java.util.List;
import java.util.ArrayList;

/**
 * Data Access Object for managing product categories.
 */
public class CategoryDAO {
    private List<ProductCategory> categories;
    private FileHandler fileHandler;

    public CategoryDAO(String categoryFilePath) {
        fileHandler = new FileHandler(categoryFilePath);
        categories = fileHandler.readCategories();
    }

    public List<ProductCategory> getAllCategories() {
        return categories;
    }

    public void addCategory(ProductCategory category) {
        categories.add(category);
        fileHandler.writeCategories(categories);
    }

    public void updateCategory(ProductCategory category) {
        int index = findCategoryIndex(category.getCategoryId());
        if (index >= 0) {
            categories.set(index, category);
            fileHandler.writeCategories(categories);
        }
    }

    public void deleteCategory(String categoryId) {
        categories.removeIf(c -> c.getCategoryId().equals(categoryId));
        fileHandler.writeCategories(categories);
    }

    private int findCategoryIndex(String categoryId) {
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getCategoryId().equals(categoryId)) {
                return i;
            }
        }
        return -1;
    }
}
