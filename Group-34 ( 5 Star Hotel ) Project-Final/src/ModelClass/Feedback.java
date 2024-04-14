/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelClass;

/**
 *
 * @author gouto
 */
public class Feedback {
   public String Costomer_name;
   public int rating;
   public String details;

    public Feedback(String Costomer_name, int rating, String details) {
        this.Costomer_name = Costomer_name;
        this.rating = rating;
        this.details = details;
    }

    public String getCostomer_name() {
        return Costomer_name;
    }

    public void setCostomer_name(String Costomer_name) {
        this.Costomer_name = Costomer_name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
    
    
}
