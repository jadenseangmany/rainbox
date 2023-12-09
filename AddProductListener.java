package rainbox;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProductListener implements ActionListener {

    private final JFrame frame;
    private ProductDAO productDao;
    private DefaultTableModel tableModel;

    public AddProductListener(JFrame frame, ProductDAO productDao, DefaultTableModel tableModel) {
        this.frame = frame;
        this.productDao = productDao;
        this.tableModel = tableModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Code to display a form for adding a new product
        // This could involve opening a new dialog window where the user can enter product details
        AddProductForm addProductForm = new AddProductForm(frame);
        addProductForm.setVisible(true);
    }
}

