package hotelProject;

import java.io.IOException;

public class InvalidValueOfRoomTypeException extends RuntimeException {
    public InvalidValueOfRoomTypeException(String message){
        super(message);
    }
}
