package com.inventario.gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.inventario.model.*;

public class ProductRegistrationFrame extends JFrame {
    private JTextField txtId, txtName, txtPrice, txtQuantity;
    private JButton btnSave;
    private JTable table;
    private ProductTableModel tableModel;

    public ProductRegistrationFrame() {
        setTitle("Registro de Productos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tableModel = new ProductTableModel();
        table = new JTable(tableModel);

        initComponents();
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(5, 2));

        panel.add(new JLabel("ID:"));
        txtId = new JTextField();
        panel.add(txtId);

        panel.add(new JLabel("Nombre:"));
        txtName = new JTextField();
        panel.add(txtName);

        panel.add(new JLabel("Precio:"));
        txtPrice = new JTextField();
        panel.add(txtPrice);

        panel.add(new JLabel("Cantidad:"));
        txtQuantity = new JTextField();
        panel.add(txtQuantity);

        btnSave = new JButton("Guardar");
        panel.add(btnSave);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveProduct();
            }
        });

        add(panel, BorderLayout.NORTH);
    }

    private void saveProduct() {
        try {
            int id = Integer.parseInt(txtId.getText());
            String name = txtName.getText();
            double price = Double.parseDouble(txtPrice.getText());
            int quantity = Integer.parseInt(txtQuantity.getText());

            Product product = new Product(id, name, price, quantity);
            tableModel.addProduct(product);

            // Limpia los campos
            txtId.setText("");
            txtName.setText("");
            txtPrice.setText("");
            txtQuantity.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, Ingresa datos Validos.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
        }
    }
}