package hotelProject;

public enum RoomStatus {

    VACANT_READY("VR", "Room is Vacant and Ready for Check In"),
    VACANT_CLEAN("VC", "Room is Vacant and Cleaned by Housekeeping"),
    VACANT_DIRTY("VD", "Room is Vacant and Dirty"),
    OCCUPIED_CLEAN("OC", "Room is Occupied and Clean by Housekeeping"),
    OCCUPIED_DIRTY("OD", "Room is Occupied and yet to be cleaned by Housekeeping"),
    DO_NOT_DISTURB("DND", "The guest has requested not be be disturbed"),
    OUT_OF_ORDER("OOO", "Room is not available for selling");

    private final String roomTerminology;
    private final String description;

    RoomStatus(String roomTerminology, String description) {
        this.roomTerminology = roomTerminology;
        this.description = description;
    }

    public String getRoomTerminology() {
        return roomTerminology;
    }

    public String getDescription() {
        return description;
    }
}
