/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.management.system;

/**
 *
 * @author Amr AlEskndrany
 */
       //Adapter Pattern
public class LegacyDiscountSystem {
    public double calculateDiscount(String customerType) {
        switch (customerType) {
            case "Regular":
                return 5.0;
            case "VIP":
                return 10.0;
            default:
                return 0.0;
        }
    }
}
