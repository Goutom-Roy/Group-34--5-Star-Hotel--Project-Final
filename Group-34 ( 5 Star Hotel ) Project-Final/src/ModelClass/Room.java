
package ModelClass;


public class Room {
    
    
    
    public class RoomAvailability {
    private int totalRoom;
    private String roomType;
    private double pricePerNight;
    private boolean available;

    public RoomAvailability(int totalRoom, String roomType, double pricePerNight, boolean available) {
        this.totalRoom = totalRoom;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.available = available;
    }

  
    public int getTotalRoom() {
        return totalRoom;
    }

    public void setTotalRoom(int totalRoom) {
        this.totalRoom = totalRoom;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    
 
    
    
    }
    
    
    
    
    
    public class RoomOccupancyData {
    private int roomNumber;
    private boolean occupied;


    public RoomOccupancyData(int roomNumber, boolean occupied) {
        this.roomNumber = roomNumber;
        this.occupied = occupied;
    }

  
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
    
 
 }
    
    
    
    
    
    
    
}
