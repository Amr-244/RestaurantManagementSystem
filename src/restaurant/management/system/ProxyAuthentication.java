/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.management.system;

import java.awt.GridLayout;
import javax.swing.*;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
/**
 *
 * @author Amr AlEskndrany
 */
public class ProxyAuthentication implements Authentication {
   private RealAuthentication realAuthentication;

    @Override
    public void authenticate(String password) throws Exception {
        if (realAuthentication == null) {
            realAuthentication = new RealAuthentication();
        }
        realAuthentication.authenticate(password);
    }

    public void showLoginScreen() {
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setSize(400, 200);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        panel.add(userLabel);
        panel.add(userField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(loginButton);

        loginFrame.add(panel);
        loginFrame.setVisible(true);

        loginButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            if (authenticate(username, password)) {
                playSuccessSound(); // تشغيل الصوت عند النجاح
                JOptionPane.showMessageDialog(loginFrame, "Login Successfully   !", "Success", JOptionPane.INFORMATION_MESSAGE);
                loginFrame.dispose(); // غلق نافذة تسجيل الدخول
            } else {
                JOptionPane.showMessageDialog(loginFrame, "Invalid credentials. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private boolean authenticate(String username, String password) {
        // استبدل هذه الدالة بتحقق فعلي من قاعدة بيانات أو أي منطق آخر
        return "amr".equals(username) && "123".equals(password);
    }

    private void playSuccessSound() {
        try {
            File soundFile = new File("C:\\Users\\Amr AlEskndrany\\Downloads\\resources\\success2.wav"); // ضع ملف الصوت الخاص بك هنا
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.err.println("Error playing sound: " + ex.getMessage());
        }
    
    }
}
