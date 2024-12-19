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
public class TableFactory {
     public static Table createTable(String type) {
        switch (type) {
            case "Regular":
                return new RegularTable();
            case "VIP":
                return new VIPTable();
            case "Outdoor":
                return new OutdoorTable();
            default:
                return null;
        }
    }
}
