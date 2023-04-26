package hotelProject;

public class HouseKeeping extends GroupReservation {

    private int roomNumber;
    private enum RoomStatus {
        CLEAN,
        VACANT,
        OCCUPIED,
        DIRTY,
        READY,
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

}
