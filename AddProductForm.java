package rainbox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProductForm extends JDialog {
    private JTextField productNameField;
    private JTextField productIdField;
    private JTextField quantityField;
    private JTextField priceField;
    private JButton saveButton;
    private JButton cancelButton;

    public AddProductForm(Frame owner) {
        super(owner, "Add New Product", true);
        initializeForm();
    }

    private void initializeForm() {
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Product Name:"));
        productNameField = new JTextField();
        add(productNameField);

        add(new JLabel("Product ID:"));
        productIdField = new JTextField();
        add(productIdField);

        add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        add(quantityField);

        add(new JLabel("Price:"));
        priceField = new JTextField();
        add(priceField);

        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");
        
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to save product
                dispose(); // Close the dialog
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the dialog
            }
        });

        add(saveButton);
        add(cancelButton);

        setSize(300, 200);
    }
}
