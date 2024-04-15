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
public class CustomerIssue {
    private String customerId,customerName,customerContactInfo,issueType,description,status;
    private LocalDate submittedDate;

   

    public CustomerIssue(String customerId, String customerName, String customerContactInfo, String issueType, String description, String status, LocalDate submittedDate) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerContactInfo = customerContactInfo;
        this.issueType = issueType;
        this.description = description;
        this.status = status;
        this.submittedDate = submittedDate;
    }
    

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerContactInfo() {
        return customerContactInfo;
    }

    public void setCustomerContactInfo(String customerContactInfo) {
        this.customerContactInfo = customerContactInfo;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(LocalDate submittedDate) {
        this.submittedDate = submittedDate;
    }

    @Override
    public String toString() {
        return "CustomerIssue{" + "customerId=" + customerId + ", customerName=" + customerName + ", customerContactInfo=" + customerContactInfo + ", issueType=" + issueType + ", description=" + description + ", status=" + status + ", submittedDate=" + submittedDate + '}';
    }

    
}
