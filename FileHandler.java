package rainbox;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

	private String filename;

    public FileHandler(String filename) {
        this.filename = filename;
        ensureFileExists();
    }

    private void ensureFileExists() {
        File file = new File(filename);
        if (!file.exists()) {
            try {
                // Create the file along with its directory structure if necessary
                File parentDir = file.getParentFile();
                if (parentDir != null && !parentDir.exists()) {
                    parentDir.mkdirs(); // Create the directory structure if it doesn't exist
                }
                file.createNewFile(); // Create the file if it doesn't exist
            } catch (IOException e) {
                e.printStackTrace();
                // Handle the exception appropriately (e.g., logging or user notification)
            }
        }
    }

    @SuppressWarnings("unchecked")
    public List<Product> readProducts() {
        return (List<Product>) readFile(productFilename);
    }

    public void writeProducts(List<Product> products) {
        writeFile(productFilename, products);
    }

    @SuppressWarnings("unchecked")
    public List<ProductCategory> readCategories() {
        return (List<ProductCategory>) readFile(categoryFilename);
    }

    public void writeCategories(List<ProductCategory> categories) {
        writeFile(categoryFilename, categories);
    }

    private List<?> readFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<?>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename + ", will be created on first save.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private void writeFile(String filename, Object data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
