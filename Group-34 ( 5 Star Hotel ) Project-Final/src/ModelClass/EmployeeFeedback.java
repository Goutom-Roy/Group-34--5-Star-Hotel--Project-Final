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
public class EmployeeFeedback {
    private LocalDate feedbackDate;
    private String department,jobtitle,rating,feedbackBox;

    public EmployeeFeedback(LocalDate feedbackDate, String department, String jobtitle, String rating, String feedbackBox) {
        this.feedbackDate = feedbackDate;
        this.department = department;
        this.jobtitle = jobtitle;
        this.rating = rating;
        this.feedbackBox = feedbackBox;
    }

    public LocalDate getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(LocalDate feedbackDate) {
        this.feedbackDate = feedbackDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getFeedbackBox() {
        return feedbackBox;
    }

    public void setFeedbackBox(String feedbackBox) {
        this.feedbackBox = feedbackBox;
    }

    @Override
    public String toString() {
        return "EmployeeFeedback{" + "feedbackDate=" + feedbackDate + ", department=" + department + ", jobtitle=" + jobtitle + ", rating=" + rating + ", feedbackBox=" + feedbackBox + '}';
    }
    
    
}
