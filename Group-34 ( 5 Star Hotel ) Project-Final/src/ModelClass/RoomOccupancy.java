package ModelClass;

public class RoomOccupancy {
    private int roomNumber;
    private boolean occupied;

    public RoomOccupancy(int roomNumber, boolean occupied) {
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

    @Override
    public String toString() {
        return "RoomOccupancy{" +
                "roomNumber=" + roomNumber +
                ", occupied=" + occupied +
                '}';
    }
}
