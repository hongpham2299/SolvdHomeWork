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
    private RoomType(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    public static RoomType valueOfEachRoomType(int numOfRooms){
        for (RoomType roomType : values()){
            if(roomType.numOfRooms == numOfRooms)
                return roomType;
        }
        return null;
    }

}

