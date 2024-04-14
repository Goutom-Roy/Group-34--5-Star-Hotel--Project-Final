/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelClass;

/**
 *
 * @author Dell
 */
public class Feedback {
    private int rating;
    private String comments;

    
    public Feedback(int rating, String comments) {
        this.rating = rating;
        this.comments = comments;
    }

   
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    
    public void submitFeedback() {
        
        System.out.println("Feedback submitted: Rating - " + rating + ", Comments - " + comments);
    }
}
