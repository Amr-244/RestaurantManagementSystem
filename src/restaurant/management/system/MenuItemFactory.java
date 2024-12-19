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
     //Factory Pattern
public class MenuItemFactory {
    public static MenuItem createMenuItem(String type) {
        switch (type) {
            case "Appetizer":
                return new Appetizer();
            case "MainCourse":
                return new MainCourse();
            case "Dessert":
                return new Dessert();
            default:
                return null;
        }
    }
}
