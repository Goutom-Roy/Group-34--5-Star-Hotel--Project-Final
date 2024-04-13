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
public class Resignation {
    private LocalDate date;
    private String department,jobTitle,reasonForResignation,resignationletter;

    public Resignation(LocalDate date, String department, String jobTitle, String reasonForResignation, String resignationletter) {
        this.date = date;
        this.department = department;
        this.jobTitle = jobTitle;
        this.reasonForResignation = reasonForResignation;
        this.resignationletter = resignationletter;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getReasonForResignation() {
        return reasonForResignation;
    }

    public void setReasonForResignation(String reasonForResignation) {
        this.reasonForResignation = reasonForResignation;
    }

    public String getResignationletter() {
        return resignationletter;
    }

    public void setResignationletter(String resignationletter) {
        this.resignationletter = resignationletter;
    }

    @Override
    public String toString() {
        return "Resignation{" + "date=" + date + ", department=" + department + ", jobTitle=" + jobTitle + ", reasonForResignation=" + reasonForResignation + ", resignationletter=" + resignationletter + '}';
    }
    
    
    
}
