package rainbox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class EditProductListener implements ActionListener {

    private final JTable productTable;
    private final ProductDAO productDao;
    private final JFrame parentFrame;
    private DefaultTableModel tableModel;

    public EditProductListener(JTable productTable, ProductDAO productDao, JFrame frame, DefaultTableModel tableModel) {
        this.productTable = productTable;
        this.productDao = productDao;
        this.parentFrame = frame;
        this.tableModel = tableModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow >= 0) {
            // Assuming the first column of the table contains the product ID
            String productId = productTable.getModel().getValueAt(selectedRow, 0).toString();

            // Retrieve the Product object from the DAO or the table model
            Product productToEdit = productDao.getProduct(productId);

            if (productToEdit != null) {
                // Open the edit product form with the selected product's details
                EditProductForm editForm = new EditProductForm(parentFrame, productToEdit, productDao);
                editForm.setVisible(true);

                // Optionally, refresh the product table after editing
                refreshProductTable();
            }
        }
    }

    private void refreshProductTable() {
        List<Product> products = productDao.getAllProducts();
        DefaultTableModel tableModel = (DefaultTableModel) productTable.getModel();
        
        // Clear the existing table data
        tableModel.setRowCount(0);

        // Add updated data to the table model
        for (Product product : products) {
            tableModel.addRow(new Object[] {
                product.getProductId(),
                product.getName(),
                product.getQuantity(),
                product.getPrice()
            });
        }

        // Notify the table model that data has changed, to refresh the table UI
        tableModel.fireTableDataChanged();
    }

}
