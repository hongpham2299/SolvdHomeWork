package hotelProject;

public class InvalidEmailException extends IllegalArgumentException {
    public InvalidEmailException(String message){
        super(message);
    }
}
