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
    //Builder Pattern
public class Order {
     private String menuItem;
    private String tableType;
    private String customerType;

    private Order(Builder builder) {
        this.menuItem = builder.menuItem;
        this.tableType = builder.tableType;
        this.customerType = builder.customerType;
    }

    public static class Builder {
        private String menuItem;
        private String tableType;
        private String customerType;

        public Builder setMenuItem(String menuItem) {
            this.menuItem = menuItem;
            return this;
        }

        public Builder setTableType(String tableType) {
            this.tableType = tableType;
            return this;
        }

        public Builder setCustomerType(String customerType) {
            this.customerType = customerType;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }

    @Override
    public String toString() {
        return "Order: MenuItem=" + menuItem + ", TableType=" + tableType + ", CustomerType=" + customerType;
    }
}
