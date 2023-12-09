package rainbox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditProductForm extends JDialog {
	private Frame owner; // Add a field for the owner
    private JTextField productNameField;
    private JTextField productIdField; // Assuming productId is immutable
    private JTextField quantityField;
    private JTextField priceField;
    private JButton saveButton;
    private JButton cancelButton;

    private Product product;
    private ProductDAO productDao;

    public EditProductForm(Frame owner, Product product, ProductDAO productDao) {
        super(owner, "Edit Product", true);
        this.owner = owner; // Initialize the owner
        this.product = product;
        this.productDao = productDao;

        initializeForm();
        populateFormWithProductData();
    }

    private void initializeForm() {
        setLayout(new GridLayout(6, 2, 10, 10));

        add(new JLabel("Product ID:"));
        productIdField = new JTextField();
        productIdField.setEditable(false); // Product ID is typically not editable
        add(productIdField);

        add(new JLabel("Product Name:"));
        productNameField = new JTextField();
        add(productNameField);

        add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        add(quantityField);

        add(new JLabel("Price:"));
        priceField = new JTextField();
        add(priceField);

        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveProduct();
            }
        });

        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the dialog
            }
        });

        add(saveButton);
        add(cancelButton);

        setSize(400, 250);
        setLocationRelativeTo(owner);
    }

    private void populateFormWithProductData() {
        productIdField.setText(product.getProductId());
        productNameField.setText(product.getName());
        quantityField.setText(String.valueOf(product.getQuantity()));
        priceField.setText(String.format("%.2f", product.getPrice()));
    }

    private void saveProduct() {
        try {
            String name = productNameField.getText();
            int quantity = Integer.parseInt(quantityField.getText());
            double price = Double.parseDouble(priceField.getText());

            // Update product details
            product.setName(name);
            product.setQuantity(quantity);
            product.setPrice(price);

            // Persist changes
            productDao.updateProduct(product);

            JOptionPane.showMessageDialog(this, "Product updated successfully!");
            dispose(); // Close the dialog after saving
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid number format in quantity or price field.",
                                          "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error updating product: " + ex.getMessage(),
                                          "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
