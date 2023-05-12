package hotelProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.Objects;
import java.util.function.BinaryOperator;

public class GroupBooking extends Guest implements GuestBilling {

    private final Logger logger = LogManager.getLogger(GroupBooking.class.getName());
    private final LocalDate contractedGroupArrDate = LocalDate.of(2023, 9, 8);
    private final LocalDate contractedGroupDepDate = LocalDate.of(2023, 9, 10);
    private final double groupRate = 350.00;
    private final int contractedNumOfNights = 2;
    private String confirmationNumber;
    private LocalDate arrDate;
    private LocalDate depDate;
    private int numOfRooms;
    private int numOfGuests;
    private enum roomType{
        KING,
        QUEENQUEEN,
    }

    public GroupBooking(String firstName, String lastName, LocalDate arrDate, LocalDate depDate, int numOfRooms, int numOfGuests, String email) {
        super(firstName, lastName, email );
        this.arrDate = arrDate;
        this.depDate = depDate;
        this.numOfRooms = numOfRooms;
        this.numOfGuests = numOfGuests;
        this.confirmationNumber = "SOFIC" + firstName + lastName + numOfRooms;
        this.email = email;
    }

    public double getGroupRate() {
        return groupRate;
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }

    public int getContractedNumOfNights() {
        return contractedNumOfNights;
    }

    public void setArrDate(LocalDate arrDate) {
        try{
            if(arrDate.equals(contractedGroupArrDate)) {
                this.arrDate = arrDate;
            }
            throw new IncorrectArrDepDateException(this.firstName + " " + this.lastName +
                    ": " + arrDate + ": doesn't quality the SOFIC group contract, the arrival date must be "
                + contractedGroupArrDate);
        }
        catch (IncorrectArrDepDateException e){
            logger.error(e.getMessage());

        }
    }

    public void setDepDate(LocalDate depDate) {
        try{
            if(depDate.equals(contractedGroupDepDate)) {
                this.depDate = depDate;
            }
            throw new IncorrectArrDepDateException(this.firstName + " " + this.lastName +
                ": " + depDate + ": doesn't quality the SOFIC group contract, the departure date must be "
                + contractedGroupDepDate);
        }
        catch (IncorrectArrDepDateException e){
            logger.error(e.getMessage());
        }
    }

    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    public void bookGroupReservation(){
        if(arrDate.equals(contractedGroupArrDate) && depDate.equals(contractedGroupDepDate)  && numOfGuests <=2){
            System.out.println("Hi " + firstName + ", Your reservation booked successfully. CONF# " + confirmationNumber
                    + ". Room Type: " + roomType.KING);
        }
        else if (arrDate.equals(contractedGroupArrDate) && depDate.equals(contractedGroupDepDate)  && numOfGuests >=3){
            System.out.println("Hi " + firstName + ", Your reservation booked successfully. CONF# " + confirmationNumber
                    + ". Room Type: " + roomType.QUEENQUEEN);
        }
        else {
            System.out.println("Hi " + firstName + ", Room is not available. Per SOFIC, each reservation must book 2 night stays. "
                    + "Arrival Date: " + contractedGroupArrDate + " , Departure Date: " + contractedGroupDepDate);
        }
    }

    @Override
    public void displayBilling() {
        double totalBilling = contractedNumOfNights * groupRate;
        System.out.println(getFirstName() + " " + getLastName() + ": Total charge for your reservation is $" + totalBilling);
    }

    public String toString() {
        return "Group Reservation:\n" +
                "First Name: " + firstName + "\n" +
                "Last Name: " + lastName + "\n" +
                "Arrival Date: " + arrDate + "\n" +
                "Departure Date: " + depDate + "\n" +
                "Number of Room(s): " + numOfRooms + "\n" +
                "Number of Guest(s): " + numOfGuests + "\n" +
                "Contract Group Rate: $" + groupRate + "\n" +
                "Confirmation Number: " + confirmationNumber + "\n" +
                "Email: " + email + "\n" +
                "---------------------";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupBooking that = (GroupBooking) o;
        return Double.compare(that.groupRate, groupRate) == 0 &&
                Objects.equals(contractedGroupArrDate, that.contractedGroupArrDate) &&
                Objects.equals(contractedGroupDepDate, that.contractedGroupDepDate) &&
                Objects.equals(confirmationNumber, that.confirmationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractedGroupArrDate, contractedGroupDepDate, groupRate, confirmationNumber);
    }
}

