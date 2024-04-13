
package ModelClass;


    
    public class SpecialOffer {
        
        
    private String offerName;
    private double discount;
    private boolean availability;

  
    public SpecialOffer(String offerName, double discount, boolean availability) {
        this.offerName = offerName;
        this.discount = discount;
        this.availability = availability;
    }

  
    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    
} 
 
    


    

    
    
    
    