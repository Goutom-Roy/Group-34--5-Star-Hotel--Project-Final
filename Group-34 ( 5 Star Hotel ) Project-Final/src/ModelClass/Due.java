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
public class Due {
    private String supplier,inVoiceNumber;
    private LocalDate inVoiceDate,dueDate;
    private String amount,satus,paymentMethod;

    public Due(String supplier, String inVoiceNumber, LocalDate inVoiceDate, LocalDate dueDate, String amount, String satus, String paymentMethod) {
        this.supplier = supplier;
        this.inVoiceNumber = inVoiceNumber;
        this.inVoiceDate = inVoiceDate;
        this.dueDate = dueDate;
        this.amount = amount;
        this.satus = satus;
        this.paymentMethod = paymentMethod;
    }
    

  
    

   

   

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getInVoiceNumber() {
        return inVoiceNumber;
    }

    public void setInVoiceNumber(String inVoiceNumber) {
        this.inVoiceNumber = inVoiceNumber;
    }

    public LocalDate getInVoiceDate() {
        return inVoiceDate;
    }

    public void setInVoiceDate(LocalDate inVoiceDate) {
        this.inVoiceDate = inVoiceDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSatus() {
        return satus;
    }

    public void setSatus(String satus) {
        this.satus = satus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Due{" + "supplier=" + supplier + ", inVoiceNumber=" + inVoiceNumber + ", inVoiceDate=" + inVoiceDate + ", dueDate=" + dueDate + ", amount=" + amount + ", satus=" + satus + ", paymentMethod=" + paymentMethod + '}';
    }

  

    
    
}
