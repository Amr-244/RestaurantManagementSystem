    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Amr AlEskndrany
 */
public class RestaurantManagementSystem {
    private static String tableType = "";
    private static String discountType = "";
    private static List<String> deliveryOrders = new ArrayList<>();
    private static double deliveryTotal = 0.0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
            showInitialScreen();
            ProxyAuthentication proxyAuth = new ProxyAuthentication();
            proxyAuth.showLoginScreen();
        });
    }
    
    

    static void showInitialScreen() {
    JFrame initialFrame = new JFrame("Choose Order Type");
    initialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    initialFrame.setSize(400, 200);
    initialFrame.setLocationRelativeTo(null);

    JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
    panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    JLabel label = new JLabel("Choose Order Type", JLabel.CENTER);
    label.setFont(new Font("Arial", Font.BOLD, 25));

    JButton inRestaurantButton = new JButton("In-Restaurant");
    JButton deliveryButton = new JButton("Delivery");
    inRestaurantButton.setFont(new Font("Arial", Font.PLAIN, 20));
    deliveryButton.setFont(new Font("Arial", Font.PLAIN, 20));
            
    inRestaurantButton.addActionListener(e -> {
        initialFrame.dispose(); // إغلاق النافذة الحالية
        showInRestaurantGUI(); // فتح نافذة In-Restaurant
    });

    deliveryButton.addActionListener(e -> {
        initialFrame.dispose(); // إغلاق النافذة الحالية
        showDeliveryGUI(); // فتح نافذة Delivery
    });

    panel.add(label);
    panel.add(inRestaurantButton);
    panel.add(deliveryButton);

    initialFrame.add(panel);
    initialFrame.setVisible(true);
    }

    private static void showInRestaurantGUI() {
         JFrame frame = new JFrame("Restaurant Management System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 800);
            frame.setLocationRelativeTo(null);

            JPanel panel = new JPanel(new BorderLayout());

            // Styled Panels
            JPanel topPanel = new JPanel();
            topPanel.setBackground(new Color(60, 179, 113));
            topPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            JLabel titleLabel = new JLabel("Restaurant Management System", JLabel.CENTER);
            titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
            titleLabel.setForeground(Color.WHITE);
            topPanel.add(titleLabel);

            Timer titleAnimationTimer = new Timer(500, e -> {
                Color currentColor = titleLabel.getForeground();
                titleLabel.setForeground(currentColor == Color.WHITE ? Color.YELLOW : Color.WHITE);
            });
            titleAnimationTimer.start();

            JPanel centerPanel = new JPanel(new GridLayout(7, 1, 20, 20));
            centerPanel.setBackground(Color.WHITE);
            centerPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
            
            JButton backButton = createAnimatedButton("← Back");
        backButton.addActionListener(e -> {
            frame.dispose();
            showInitialScreen();
        });
        topPanel.add(backButton);

            // Orders Panel
            JPanel ordersPanel = new JPanel(new FlowLayout());
            ordersPanel.setBackground(new Color(240, 248, 255));
            JLabel orderLabel = new JLabel("Enter Order:");
            orderLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            JTextField orderField = new JTextField(20);
            orderField.setFont(new Font("Arial", Font.PLAIN, 18));
            JButton addOrderButton = createAnimatedButton("Add Order");

            ordersPanel.add(orderLabel);
            ordersPanel.add(orderField);
            ordersPanel.add(addOrderButton);

            addOrderButton.addActionListener(e -> {
                String order = orderField.getText();
                OrderManager.getInstance().addOrder(order);
                orderField.setText("");
            });

            // Payment Panel
            JPanel paymentPanel = new JPanel(new FlowLayout());
            paymentPanel.setBackground(new Color(240, 248, 255));
            JLabel paymentLabel = new JLabel("Enter Payment Details:");
            paymentLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            JTextField paymentField = new JTextField(20);
            paymentField.setFont(new Font("Arial", Font.PLAIN, 18));
            JButton processPaymentButton = createAnimatedButton("Process Payment");

            paymentPanel.add(paymentLabel);
            paymentPanel.add(paymentField);
            paymentPanel.add(processPaymentButton);

            processPaymentButton.addActionListener(e -> {
                String paymentDetails = paymentField.getText();
                PaymentSystem.getInstance().processPayment(paymentDetails);
                paymentField.setText("");
            });

            // Food Type Panel
            JPanel foodTypePanel = new JPanel(new FlowLayout());
            foodTypePanel.setBackground(new Color(240, 248, 255));
            JLabel foodTypeLabel = new JLabel("Select Food Type:");
            foodTypeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            String[] foodTypes = {"Appetizer", "Main Course", "Dessert"};
            JComboBox<String> foodTypeComboBox = new JComboBox<>(foodTypes);
            foodTypeComboBox.setFont(new Font("Arial", Font.PLAIN, 18));

            foodTypePanel.add(foodTypeLabel);
            foodTypePanel.add(foodTypeComboBox);

            // Table Type Panel
            JPanel tableTypePanel = new JPanel(new FlowLayout());
            tableTypePanel.setBackground(new Color(240, 248, 255));
            JLabel tableTypeLabel = new JLabel("Select Table Type:");
            tableTypeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            String[] tableTypes = {"Regular", "VIP", "Outdoor"};
            JComboBox<String> tableTypeComboBox = new JComboBox<>(tableTypes);
            tableTypeComboBox.setFont(new Font("Arial", Font.PLAIN, 18));

            tableTypePanel.add(tableTypeLabel);
            tableTypePanel.add(tableTypeComboBox);

            // Discount Panel
            JPanel discountPanel = new JPanel(new FlowLayout());
            discountPanel.setBackground(new Color(240, 248, 255));
            JLabel discountLabel = new JLabel("Select Customer Type:");
            discountLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            String[] customerTypes = {"Regular", "VIP"};
            JComboBox<String> customerTypeComboBox = new JComboBox<>(customerTypes);
            customerTypeComboBox.setFont(new Font("Arial", Font.PLAIN, 18));

            discountPanel.add(discountLabel);
            discountPanel.add(customerTypeComboBox);

            // Summary Panel
            JPanel summaryPanel = new JPanel(new FlowLayout());
            summaryPanel.setBackground(new Color(240, 248, 255));
            JButton showSummaryButton = createAnimatedButton("Show Summary");
            summaryPanel.add(showSummaryButton);

            showSummaryButton.addActionListener(e -> {
                List<String> orders = OrderManager.getInstance().getOrders();
                List<String> payments = PaymentSystem.getInstance().getPayments();
                String selectedFoodType = (String) foodTypeComboBox.getSelectedItem();
                String selectedTableType = (String) tableTypeComboBox.getSelectedItem();
                String selectedCustomerType = (String) customerTypeComboBox.getSelectedItem();

                DiscountAdapter discountAdapter = new DiscountAdapter();
                double discount = discountAdapter.getDiscount(selectedCustomerType);

                String summary = "Orders:\n" + String.join("\n", orders) +
                        "\n\nPayments:\n" + String.join("\n", payments) +
                        "\n\nFood Type: " + selectedFoodType +
                        "\nTable Type: " + selectedTableType +
                        "\nCustomer Type: " + selectedCustomerType +
                        "\nDiscount: " + discount + "%";

                JOptionPane.showMessageDialog(frame, summary, "Summary", JOptionPane.INFORMATION_MESSAGE);
            });
        

            centerPanel.add(ordersPanel);
            centerPanel.add(paymentPanel);
            centerPanel.add(foodTypePanel);
            centerPanel.add(tableTypePanel);
            centerPanel.add(discountPanel);
            centerPanel.add(summaryPanel);
           


            panel.add(topPanel, BorderLayout.NORTH);
            panel.add(centerPanel, BorderLayout.CENTER);

            frame.add(panel);
            frame.setVisible(true);
    }

    private static void showDeliveryGUI() {
    JFrame frame = new JFrame("Delivery");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1000, 800);  // الحجم المرغوب فيه

    // توسيط النافذة في منتصف الشاشة
    frame.setLocationRelativeTo(null);

    JPanel panel = new JPanel(new GridLayout(8, 1, 20, 20));  // تعديل GridLayout ليتسع للحقل الإضافي
    panel.setBackground(new Color(240, 248, 255));
    panel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

    JLabel titleLabel = new JLabel("Delivery Order Details", JLabel.CENTER);
    titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
    titleLabel.setForeground(new Color(60, 179, 113));

    JButton backButton = createAnimatedButton("← Back");
    backButton.addActionListener(e -> {
        frame.dispose();
        showInitialScreen();
    });

    // Food Item Input
    JPanel foodPanel = createInputPanel("Order:", new JTextField(20));
    JTextField foodField = (JTextField) foodPanel.getComponent(1);  // Get the JTextField from the panel

    // Price Input
    JPanel pricePanel = createInputPanel("Price:", new JTextField(20));
    JTextField priceField = (JTextField) pricePanel.getComponent(1);  // Get the JTextField from the panel

    // Phone Number Input
    JPanel phonePanel = createInputPanel("Phone Number:", new JTextField(15));
    JTextField phoneField = (JTextField) phonePanel.getComponent(1);  // Get the JTextField from the panel

    // Address Input
    JPanel addressPanel = createInputPanel("Address:", new JTextField(20));
    JTextField addressField = (JTextField) addressPanel.getComponent(1); // Get the JTextField from the panel

    JButton addFoodButton = createAnimatedButton("Add Order");
    addFoodButton.addActionListener(e -> {
       String food = foodField.getText();
    String priceText = priceField.getText();
    if (!food.isEmpty() && !priceText.isEmpty() && !phoneField.getText().trim().isEmpty() && !addressField.getText().trim().isEmpty()) {
    try {
        double price = Double.parseDouble(priceText);
        String phoneNumber = phoneField.getText().trim();
        String address = addressField.getText().trim();
        
        // إضافة الطلب مع السعر ورقم الهاتف والعنوان
        deliveryOrders.add("Order: " + food + " - $" + price + 
                           "\nPhone: " + phoneNumber + 
                           "\nAddress: " + address);
        deliveryTotal += price;
        
        foodField.setText("");
        priceField.setText("");
        phoneField.setText("");
        addressField.setText("");
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(frame, "Please enter a valid price.", "Error", JOptionPane.ERROR_MESSAGE);
    }
} else {
    JOptionPane.showMessageDialog(frame, "Order, price, phone number, and address cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
}

    });

    JButton summaryButton = createAnimatedButton("Show Summary");
    summaryButton.addActionListener(e -> {
        
    StringBuilder orderSummary = new StringBuilder();
    for (String order : deliveryOrders) {
        orderSummary.append(order).append("\n");
    }

    // إنشاء النص الكامل للملخص
    String summary = "Orders:\n" + orderSummary + "\n\nTotal Price: $" + deliveryTotal;

    // عرض الملخص
    JOptionPane.showMessageDialog(frame, summary, "Summary", JOptionPane.INFORMATION_MESSAGE);
});

    // إضافة الحقول للنوافذ بالترتيب الجديد
    panel.add(titleLabel);
    panel.add(backButton);
    panel.add(foodPanel);  // Order Field
    panel.add(pricePanel);  // Price Field
    panel.add(phonePanel);  // Phone Number Field
    panel.add(addressPanel); // Address Field
    panel.add(addFoodButton);
    panel.add(summaryButton);
    frame.add(panel);
    frame.setVisible(true);
}

private static JPanel createInputPanel(String label, JTextField textField) {
    JPanel panel = new JPanel(new FlowLayout());
    panel.setBackground(new Color(240, 248, 255));
    JLabel fieldLabel = new JLabel(label);
    fieldLabel.setFont(new Font("Arial", Font.PLAIN, 20));
    panel.add(fieldLabel);
    textField.setFont(new Font("Arial", Font.PLAIN, 18));
    panel.add(textField);
    return panel;
    }

    private static JButton createAnimatedButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setBackground(new Color(50, 205, 50));
        button.setForeground(Color.WHITE);

        Timer animationTimer = new Timer(300, e -> {
            Color currentColor = button.getBackground();
            button.setBackground(currentColor.equals(new Color(50, 205, 50)) ? new Color(34, 139, 34) : new Color(50, 205, 50));
        });
        animationTimer.start();

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(72, 209, 204));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(50, 205, 50));
            }
        });

        return button;
    }

    
}
