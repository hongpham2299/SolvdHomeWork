package hotelProject;

import java.util.regex.Pattern;

public class Guest {

    protected static final String EMAIL_REGEX_PATTERN = "^(.+)@(.+).(.+)$";
    protected String firstName;
    protected String lastName;
    protected String email;

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

    public Guest(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.checkValidEmail(email);
    }

    public String getEmail() {
        return email;
    }

    public void checkValidEmail(String email){
        try {
            Pattern pattern = Pattern.compile(EMAIL_REGEX_PATTERN);
            if(!pattern.matcher(email).matches()){
                throw new InvalidEmailException(firstName + ": Your email - " + email + ": Invalid email");
            }
        }catch (InvalidEmailException e){
            System.out.println(e.getMessage());
        }
    }

    public void splitBilling(double inputTotalAmounts, int inputNumberPeople){
        try {
            if(inputTotalAmounts > 0 && inputNumberPeople > 0){
                System.out.println("Your splited billing: $" + inputTotalAmounts/inputNumberPeople);
            }
            else {
                throw new InputNegativeNumberOfSplitBilling("Must be greater than zero");
            }
        }catch (InputNegativeNumberOfSplitBilling e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Guest {" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}


