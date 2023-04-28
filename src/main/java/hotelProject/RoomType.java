package hotelProject;

public enum RoomType {

    KING(170),
    QUEENQUEEN (200),
    KING_WATERVIEW(30),
    QUEENQUEEN_WATERVIEW(50),
    KING_WATERVIEW_BALCONY(15),
    QUEENQUEEN_WATERVIEW_BALCONY(25),
    PRESIDENTIAL_SUITE(1),
    KING_SUITE(7);

    public final int numOfRooms;
    RoomType(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    public static void valueOfEachRoomType(int numOfRooms) {
        try {
            for (RoomType roomType : values()) {
                if (roomType.numOfRooms != numOfRooms) {
                    throw new InvalidValueOfRoomTypeException(numOfRooms + " :The number is invalid");
                }
            }
        } catch (InvalidValueOfRoomTypeException e) {
            System.out.println(e.getMessage());
        }
    }

}

