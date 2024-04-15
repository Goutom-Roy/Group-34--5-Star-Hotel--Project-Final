package ModelClass;

import java.time.LocalDate;

public class Booking {

    public class NewBooking {
        private String guestName;
        private int numberOfGuests;
        private String phoneNumber;
        private String roomType;
        private int totalRoom;
        private LocalDate bookingDate;

        public NewBooking(String guestName, int numberOfGuests, String phoneNumber, String roomType, int totalRoom, LocalDate bookingDate) {
            this.guestName = guestName;
            this.numberOfGuests = numberOfGuests;
            this.phoneNumber = phoneNumber;
            this.roomType = roomType;
            this.totalRoom = totalRoom;
            this.bookingDate = bookingDate;
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

        public LocalDate getBookingDate() {
            return bookingDate;
        }

        public void setBookingDate(LocalDate bookingDate) {
            this.bookingDate = bookingDate;
        }

        @Override
        public String toString() {
            return "NewBooking{" +
                    "guestName='" + guestName + '\'' +
                    ", numberOfGuests=" + numberOfGuests +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    ", roomType='" + roomType + '\'' +
                    ", totalRoom=" + totalRoom +
                    ", bookingDate=" + bookingDate +
                    '}';
        }
    }

    public class CancelBooking {
        private String guestName;
        private String roomType;
        private LocalDate checkinDate;
        private LocalDate checkoutDate;
        private String bookingID;

        public CancelBooking(String guestName, String roomType, LocalDate checkinDate, LocalDate checkoutDate, String bookingID) {
            this.guestName = guestName;
            this.roomType = roomType;
            this.checkinDate = checkinDate;
            this.checkoutDate = checkoutDate;
            this.bookingID = bookingID;
        }

        public String getGuestName() {
            return guestName;
        }

        public void setGuestName(String guestName) {
            this.guestName = guestName;
        }

        public String getRoomType() {
            return roomType;
        }

        public void setRoomType(String roomType) {
            this.roomType = roomType;
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

        public String getBookingID() {
            return bookingID;
        }

        public void setBookingID(String bookingID) {
            this.bookingID = bookingID;
        }

        @Override
        public String toString() {
            return "CancelBooking{" +
                    "guestName='" + guestName + '\'' +
                    ", roomType='" + roomType + '\'' +
                    ", checkinDate=" + checkinDate +
                    ", checkoutDate=" + checkoutDate +
                    ", bookingID='" + bookingID + '\'' +
                    '}';
        }
    }
}


