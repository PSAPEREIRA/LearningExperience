package Entities;

public class RoomRent {

    private String nameStudent,email;
    private int roomNumber;

    public RoomRent(String nameStudent, String email, int roomNumber) {
        this.nameStudent = nameStudent;
        this.email = email;
        this.roomNumber = roomNumber;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return roomNumber+": "+nameStudent+", "+email;
    }
}
