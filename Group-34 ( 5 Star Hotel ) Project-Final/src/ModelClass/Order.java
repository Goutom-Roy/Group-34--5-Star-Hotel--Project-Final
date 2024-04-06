/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelClass;

import java.time.LocalDate;

/**
 *
 * @author ASUS
 */
public class Order {
    private LocalDate date;
    private String orderId;
    private String customerName,orderItem,quantity;
    private String perUnitPrice,totalPrice,orderStatus;

    public Order(LocalDate date, String orderId, String customerName, String orderItem, String quantity, String perUnitPrice, String totalPrice, String orderStatus) {
        this.date = date;
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderItem = orderItem;
        this.quantity = quantity;
        this.perUnitPrice = perUnitPrice;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(String orderItem) {
        this.orderItem = orderItem;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPerUnitPrice() {
        return perUnitPrice;
    }

    public void setPerUnitPrice(String perUnitPrice) {
        this.perUnitPrice = perUnitPrice;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" + "date=" + date + ", orderId=" + orderId + ", customerName=" + customerName + ", orderItem=" + orderItem + ", quantity=" + quantity + ", perUnitPrice=" + perUnitPrice + ", totalPrice=" + totalPrice + ", orderStatus=" + orderStatus + '}';
    }
    
    
}
