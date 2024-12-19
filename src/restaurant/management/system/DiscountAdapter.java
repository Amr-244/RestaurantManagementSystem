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
public class DiscountAdapter {
 private final LegacyDiscountSystem legacySystem;

    public DiscountAdapter() {
        this.legacySystem = new LegacyDiscountSystem();
    }

    public double getDiscount(String customerType) {
        return legacySystem.calculateDiscount(customerType);
    }
}
