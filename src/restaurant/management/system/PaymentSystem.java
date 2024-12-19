/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.management.system;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amr AlEskndrany
 */
     //Singleton Pattern
public class PaymentSystem {
     private static PaymentSystem instance;
    private final List<String> payments;

    private PaymentSystem() {
        payments = new ArrayList<>();
    }

    public static synchronized PaymentSystem getInstance() {
        if (instance == null) {
            instance = new PaymentSystem();
        }
        return instance;
    }

    public void processPayment(String paymentDetails) {
        payments.add(paymentDetails);
        System.out.println("Processing payment: " + paymentDetails);
    }

    public List<String> getPayments() {
        return payments;
    }
}
