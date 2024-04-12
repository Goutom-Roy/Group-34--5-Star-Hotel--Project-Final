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
public class Salary {
    private String month;
     private LocalDate salaryDate;
    private String employeeId,employeeName,emailAddress,gender,dateOfBirth,departMent,jobTitle,BasicSalary,regularHours,overTimeHours,totalHours;
    private String taxDeductions,socialSecurity,healthInsurance,uniformFees,otherDeductions,ratePerHour,overTimeEarning,totalDeduction,paymentMethod,netsalary;
   



    public Salary(String month, LocalDate salaryDate, String employeeId, String employeeName, String emailAddress, String gender, String dateOfBirth, String departMent, String jobTitle, String BasicSalary, String regularHours, String overTimeHours, String totalHours, String taxDeductions, String socialSecurity, String healthInsurance, String uniformFees, String otherDeductions, String ratePerHour, String overTimeEarning, String totalDeduction, String paymentMethod, String netsalary) {
        this.month = month;
        this.salaryDate = salaryDate;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.emailAddress = emailAddress;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.departMent = departMent;
        this.jobTitle = jobTitle;
        this.BasicSalary = BasicSalary;
        this.regularHours = regularHours;
        this.overTimeHours = overTimeHours;
        this.totalHours = totalHours;
        this.taxDeductions = taxDeductions;
        this.socialSecurity = socialSecurity;
        this.healthInsurance = healthInsurance;
        this.uniformFees = uniformFees;
        this.otherDeductions = otherDeductions;
        this.ratePerHour = ratePerHour;
        this.overTimeEarning = overTimeEarning;
        this.totalDeduction = totalDeduction;
        this.paymentMethod = paymentMethod;
        this.netsalary = netsalary;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public LocalDate getSalaryDate() {
        return salaryDate;
    }

    public void setSalaryDate(LocalDate salaryDate) {
        this.salaryDate = salaryDate;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDepartMent() {
        return departMent;
    }

    public void setDepartMent(String departMent) {
        this.departMent = departMent;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getBasicSalary() {
        return BasicSalary;
    }

    public void setBasicSalary(String BasicSalary) {
        this.BasicSalary = BasicSalary;
    }

    public String getRegularHours() {
        return regularHours;
    }

    public void setRegularHours(String regularHours) {
        this.regularHours = regularHours;
    }

    public String getOverTimeHours() {
        return overTimeHours;
    }

    public void setOverTimeHours(String overTimeHours) {
        this.overTimeHours = overTimeHours;
    }

    public String getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(String totalHours) {
        this.totalHours = totalHours;
    }

    public String getTaxDeductions() {
        return taxDeductions;
    }

    public void setTaxDeductions(String taxDeductions) {
        this.taxDeductions = taxDeductions;
    }

    public String getSocialSecurity() {
        return socialSecurity;
    }

    public void setSocialSecurity(String socialSecurity) {
        this.socialSecurity = socialSecurity;
    }

    public String getHealthInsurance() {
        return healthInsurance;
    }

    public void setHealthInsurance(String healthInsurance) {
        this.healthInsurance = healthInsurance;
    }

    public String getUniformFees() {
        return uniformFees;
    }

    public void setUniformFees(String uniformFees) {
        this.uniformFees = uniformFees;
    }

    public String getOtherDeductions() {
        return otherDeductions;
    }

    public void setOtherDeductions(String otherDeductions) {
        this.otherDeductions = otherDeductions;
    }

    public String getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(String ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    public String getOverTimeEarning() {
        return overTimeEarning;
    }

    public void setOverTimeEarning(String overTimeEarning) {
        this.overTimeEarning = overTimeEarning;
    }

    public String getTotalDeduction() {
        return totalDeduction;
    }

    public void setTotalDeduction(String totalDeduction) {
        this.totalDeduction = totalDeduction;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getNetsalary() {
        return netsalary;
    }

    public void setNetsalary(String netsalary) {
        this.netsalary = netsalary;
    }

    @Override
    public String toString() {
        return "Salary{" + "month=" + month + ", salaryDate=" + salaryDate + ", employeeId=" + employeeId + ", employeeName=" + employeeName + ", emailAddress=" + emailAddress + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", departMent=" + departMent + ", jobTitle=" + jobTitle + ", BasicSalary=" + BasicSalary + ", regularHours=" + regularHours + ", overTimeHours=" + overTimeHours + ", totalHours=" + totalHours + ", taxDeductions=" + taxDeductions + ", socialSecurity=" + socialSecurity + ", healthInsurance=" + healthInsurance + ", uniformFees=" + uniformFees + ", otherDeductions=" + otherDeductions + ", ratePerHour=" + ratePerHour + ", overTimeEarning=" + overTimeEarning + ", totalDeduction=" + totalDeduction + ", paymentMethod=" + paymentMethod + ", netsalary=" + netsalary + '}';
    }
    

  
    

  
    

   
   

   
   

  

   
    
    
}
