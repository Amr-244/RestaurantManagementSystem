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
public class OrderManager {
   private static OrderManager instance;
    private final List<String> orders;

    private OrderManager() {
        orders = new ArrayList<>();
    }

    public static synchronized OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }

    public void addOrder(String order) {
        orders.add(order);
    }

    public List<String> getOrders() {
        return orders;
    }
}
