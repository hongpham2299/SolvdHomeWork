package hotelProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Guest {

    protected final String EMAIL_REGEX_PATTERN = "^(.+)@(.+).(.+)$";
    protected String firstName;
    protected String lastName;
    protected String email;
    protected LocalDate dateOfBirth;
    protected String phoneNumber;
    private final Logger logger = LogManager.getLogger(Guest.class.getName());

    public Guest(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public Guest(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.checkValidEmail(email);
    }

    public Guest (String firstName, String lastName, String phoneNumber, LocalDate dateOfBirth ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void checkValidEmail(String email){
        try {
            Pattern pattern = Pattern.compile(EMAIL_REGEX_PATTERN);
            if(!pattern.matcher(email).matches()){
                throw new InvalidEmailException(firstName + ": Your email - " + email + ": Invalid email");
            }
        }catch (InvalidEmailException e){
            logger.warn(e.getMessage());
            //System.out.println(e.getMessage());
        }
    }

    public void splitBilling(double inputTotalAmounts, int inputNumberPeople){
        try {
            if(inputTotalAmounts > 0 && inputNumberPeople > 0){
                System.out.println("Your splited billing: $" + inputTotalAmounts/inputNumberPeople);
            }
            else {
                throw new InputNegativeNumberOfSplitBilling("Split Billing: Must be greater than zero");
            }
        }catch (InputNegativeNumberOfSplitBilling e){
            logger.error(e.getMessage(), e);
        }
    }

    @Override
    public String toString() {
        return "Guest {" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}


