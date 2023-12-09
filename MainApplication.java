package rainbox;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainApplication extends JFrame {

    private JTable productTable;
    private DefaultTableModel tableModel;
    private ProductDAO productDao;

    public MainApplication() {
        // Initialize the DAO
    	productDao = new ProductDAO("path/to/products.dat");
 // Adjust file paths as needed

        // Setup the UI components
        initializeFrame();
        setupProductTable();
        setupButtons();
    }

    private void initializeFrame() {
        setTitle("Rainbox Inventory Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());
    }

    private void setupProductTable() {
        String[] columnNames = {"Product ID", "Name", "Quantity", "Price"};
        tableModel = new DefaultTableModel(columnNames, 0);
        productTable = new JTable(tableModel);
        add(new JScrollPane(productTable), BorderLayout.CENTER);

        // Load initial product data into the table
        loadProductData();
    }

    private void setupButtons() {
        JButton addButton = new JButton("Add Product");
        JButton editButton = new JButton("Edit Product");
        JButton deleteButton = new JButton("Delete Product");

        addButton.addActionListener(new AddProductListener(this, productDao, tableModel));
        editButton.addActionListener(new EditProductListener(productTable, productDao, this, tableModel));
        deleteButton.addActionListener(e -> deleteProduct());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void deleteProduct() {
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow >= 0) {
            String productId = tableModel.getValueAt(selectedRow, 0).toString();
            productDao.deleteProduct(productId);
            tableModel.removeRow(selectedRow);
        }
    }

    private void loadProductData() {
        for (Product product : productDao.getAllProducts()) {
            tableModel.addRow(new Object[]{
                product.getProductId(),
                product.getName(),
                product.getQuantity(),
                product.getPrice()
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainApplication().setVisible(true));
    }
}
