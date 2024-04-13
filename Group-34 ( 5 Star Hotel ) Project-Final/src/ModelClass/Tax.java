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
public class Tax {
    private String taxId,taxType;
    private LocalDate dueDate;
    private String amount,status;

    public Tax(String taxId, String taxType, LocalDate dueDate, String amount, String status) {
        this.taxId = taxId;
        this.taxType = taxType;
        this.dueDate = dueDate;
        this.amount = amount;
        this.status = status;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tax{" + "taxId=" + taxId + ", taxType=" + taxType + ", dueDate=" + dueDate + ", amount=" + amount + ", status=" + status + '}';
    }
    
}
