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
        Pattern pattern = Pattern.compile(EMAIL_REGEX_PATTERN);
        if(pattern.matcher(email).matches()){
            System.out.println(email + ": Valid email");
        }
        else{
            System.out.println(email + ": Invalid email");
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


