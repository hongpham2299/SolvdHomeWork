package hotelProject;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;
import static hotelProject.GuestRegisterValidation.*;
import static hotelProject.GuestRegisterValidation.ValidationResult.*;

//Using enum and Function, Pre-defined Functional Interfaces to implement the Combinator Pattern
public interface GuestRegisterValidation extends Function<Guest, ValidationResult> {

    enum ValidationResult {
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        IS_NOT_AN_ADULT
    }

    static GuestRegisterValidation isPhoneNumberValid(){
        return guest -> guest.getPhoneNumber().startsWith("813") ?
                SUCCESS : PHONE_NUMBER_NOT_VALID;
    }

    static GuestRegisterValidation isAnAdult() {
        return guest -> Period.between(guest.getDateOfBirth(), LocalDate.now()).getYears() > 18 ?
                SUCCESS : IS_NOT_AN_ADULT;
    }
    default GuestRegisterValidation and (GuestRegisterValidation other){
        return guest -> {
            ValidationResult result = this.apply(guest);
            return  result.equals(SUCCESS) ? other.apply(guest) : result;
        };
    }

}
