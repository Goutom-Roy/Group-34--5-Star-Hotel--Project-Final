
package ModelClass;

import java.time.LocalDate;


public class RoomRates {
    
    
    
public class UpdateBooking {
    private String guestName;
    private int numberOfGuests;
    private String phoneNumber;
    private String roomType;
    private int totalRoom;
    private LocalDate checkinDate;
    private LocalDate checkoutDate;
    private double roomRate;

    
    public UpdateBooking(String guestName, int numberOfGuests, String phoneNumber, String roomType,
                          int totalRoom, LocalDate checkinDate, LocalDate checkoutDate, double roomRate) {
        this.guestName = guestName;
        this.numberOfGuests = numberOfGuests;
        this.phoneNumber = phoneNumber;
        this.roomType = roomType;
        this.totalRoom = totalRoom;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.roomRate = roomRate;
    }

    
    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getTotalRoom() {
        return totalRoom;
    }

    public void setTotalRoom(int totalRoom) {
        this.totalRoom = totalRoom;
    }

    public LocalDate getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(LocalDate checkinDate) {
        this.checkinDate = checkinDate;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public double getRoomRate() {
        return roomRate;
    }

    public void setRoomRate(double roomRate) {
        this.roomRate = roomRate;
    }
    
    
    
    
    
    
    
    public class SetRoomPrice {
    private double singleRoomPrice;
    private double doubleRoomPrice;
    private double familyRoomPrice;


    public SetRoomPrice(double singleRoomPrice, double doubleRoomPrice, double familyRoomPrice) {
        this.singleRoomPrice = singleRoomPrice;
        this.doubleRoomPrice = doubleRoomPrice;
        this.familyRoomPrice = familyRoomPrice;
    }

  
    public double getSingleRoomPrice() {
        return singleRoomPrice;
    }

    public void setSingleRoomPrice(double singleRoomPrice) {
        this.singleRoomPrice = singleRoomPrice;
    }

    public double getDoubleRoomPrice() {
        return doubleRoomPrice;
    }

    public void setDoubleRoomPrice(double doubleRoomPrice) {
        this.doubleRoomPrice = doubleRoomPrice;
    }

    public double getFamilyRoomPrice() {
        return familyRoomPrice;
    }

    public void setFamilyRoomPrice(double familyRoomPrice) {
        this.familyRoomPrice = familyRoomPrice;
    }
    
    
    
    
    
    }
    
    
    
    
    
    
    
    
    
}
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
