package hotelProject;

import java.time.LocalDate;
import java.util.Scanner;

public class GroupEvent extends Hotel {

    private final String groupEventName = "SOFIC 2023";
    private final String groupAddress = "2101 Wilson Boulevard, Suite 700, Arlington, VA 22201";
    private final String phoneNumber = "(800) 536-0238";
    private final String meetingPlannerName = "Kate Nguyen";
    private final String emailAddress = "info@sofic.com";
    private final LocalDate eventStartDate = LocalDate.of(2023, 9, 8);
    private final LocalDate eventEndDate = LocalDate.of(2023, 9, 10);

    public void displayGroupInformation(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your group/event name");
        String eventName = scanner.nextLine().toLowerCase();
        if(eventName.contains("sofic")){
            System.out.println("-------SOFIC GROUP INFORMATION---------" + "\n" +
                    "1. Event Name: " + groupEventName + "\n" +
                    "2. Address: " + groupAddress + "\n" +
                    "3. Phone Number: "  + phoneNumber + "\n" +
                    "4. Email: " + emailAddress + "\n" +
                    "5. Event Planner: " + meetingPlannerName + "\n" +
                    "6. Event Location: " + hotelName + " , " + hotelAddress + "\n" +
                    "7. Event Dates: " + eventStartDate + " to " + eventEndDate + "\n" +
                    "For booking group reservation: Please contact the hotel directly at " + hotelPhoneNumber + "\n" +
                    "----------------------------------------------------------------------------------------");
        }
        else {
            System.out.println("We are not able to locate your event at " + hotelName);
        }
    }
}


