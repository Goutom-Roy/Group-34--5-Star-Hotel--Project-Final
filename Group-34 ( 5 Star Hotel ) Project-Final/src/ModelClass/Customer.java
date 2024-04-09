/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelClass;

/**
 *
 * @author Dell
 */
public class Customer  {
    
    String Name;
    String Email;
    String Address;
    String ContactNumber;
    String CheckIn;
    String CheckOut;
    String NumberofGuests; 
    String RoomType;

    public Customer(String Name, String Email) {
        this.Name = Name;
        this.Email = Email;
        this.Address = Address;
        this.ContactNumber = ContactNumber;
        this.CheckIn = CheckIn;
        this.CheckOut = CheckOut;
        this.NumberofGuests = NumberofGuests;
        this.RoomType = RoomType;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String ContactNumber) {
        this.ContactNumber = ContactNumber;
    }

    public String getCheckIn() {
        return CheckIn;
    }

    public void setCheckIn(String CheckIn) {
        this.CheckIn = CheckIn;
    }

    public String getCheckOut() {
        return CheckOut;
    }

    public void setCheckOut(String CheckOut) {
        this.CheckOut = CheckOut;
    }

    public String getNumberofGuests() {
        return NumberofGuests;
    }

    public void setNumberofGuests(String NumberofGuests) {
        this.NumberofGuests = NumberofGuests;
    }

    public String getRoomType() {
        return RoomType;
    }

    public void setRoomType(String RoomType) {
        this.RoomType = RoomType;
    }

    @Override
    public String toString() {
        return "Customer{" + "Name=" + Name + ", Email=" + Email + ", Address=" + Address + ", ContactNumber=" + ContactNumber + ", CheckIn=" + CheckIn + ", CheckOut=" + CheckOut + ", NumberofGuests=" + NumberofGuests + ", RoomType=" + RoomType + '}';
    }

    
    
}
