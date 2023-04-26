package hotelProject;

import java.time.LocalDate;
import java.util.Objects;

public class GroupBooking extends Guest implements GuestBilling {
    private final LocalDate contractedGroupArrDate = LocalDate.of(2023, 9, 8);
    private final LocalDate contractedGroupDepDate = LocalDate.of(2023, 9, 10);
    private final double groupRate = 350;
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

    public LocalDate getContractedGroupArrDate() {
        return contractedGroupArrDate;
    }

    public LocalDate getContractedGroupDepDate() {
        return contractedGroupDepDate;
    }

    public double getGroupRate() {
        return groupRate;
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
        int totalBilling = contractedNumOfNights * 350;
        System.out.println(getFirstName() + " " + getLastName() + ": Total charge for your reservation is $" + totalBilling);
    }

    @Override
    public String toString() {
        return "GroupReservation {" +
                "groupRate= $" + groupRate +
                ", confirmationNumber='" + confirmationNumber + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", arrDate=" + arrDate +
                ", depDate=" + depDate +
                ", numOfRooms=" + numOfRooms +
                ", numOfGuests=" + numOfGuests +
                '}';
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

