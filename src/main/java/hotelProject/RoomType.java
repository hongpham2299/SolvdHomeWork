package hotelProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.EnumSet;
import java.util.Iterator;

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

    private static EnumSet<RoomType> roomTypeEnumSet;
    private static final Logger logger = LogManager.getLogger(RoomType.class.getName());

    public static void displayAllRoomTypes(){
        roomTypeEnumSet = EnumSet.allOf(RoomType.class);
        Iterator<RoomType> it = roomTypeEnumSet.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    public static void displayRoomTypesWithoutSuites(){
        roomTypeEnumSet = EnumSet.range(RoomType.KING, RoomType.QUEENQUEEN_WATERVIEW_BALCONY);
        System.out.println("Room Types without Suites: " + roomTypeEnumSet);
    }

    public static void valueOfEachRoomType(int numOfRooms) {
        try {
            for (RoomType roomType : values()) {
                if (roomType.numOfRooms != numOfRooms) {
                    throw new InvalidValueOfRoomTypeException(numOfRooms + " :The number is invalid");
                }
            }
        } catch (InvalidValueOfRoomTypeException e) {
            logger.error(e.getMessage());
        }
    }

}

