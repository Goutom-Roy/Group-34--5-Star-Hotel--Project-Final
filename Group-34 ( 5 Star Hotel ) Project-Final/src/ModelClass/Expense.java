/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelClass;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author ASUS
 */
public class Expense implements Serializable{
    private LocalDate date;
    private String expenseCatagory,expenseDescription,amount,paymentMethod,supplier;

    public Expense(LocalDate date, String expenseCatagory, String expenseDescription, String amount, String paymentMethod, String supplier) {
        this.date = date;
        this.expenseCatagory = expenseCatagory;
        this.expenseDescription = expenseDescription;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.supplier = supplier;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getExpenseCatagory() {
        return expenseCatagory;
    }

    public void setExpenseCatagory(String expenseCatagory) {
        this.expenseCatagory = expenseCatagory;
    }

    public String getExpenseDescription() {
        return expenseDescription;
    }

    public void setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Expense{" + "date=" + date + ", expenseCatagory=" + expenseCatagory + ", expenseDescription=" + expenseDescription + ", amount=" + amount + ", paymentMethod=" + paymentMethod + ", supplier=" + supplier + '}';
    }

   
    
     
    
}
