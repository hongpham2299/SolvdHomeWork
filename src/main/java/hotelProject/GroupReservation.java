package hotelProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class GroupReservation implements SearchReservation {

    private final Logger logger = LogManager.getLogger(GroupReservation.class.getName());
    private static List<GroupBooking> groupGuestList = new ArrayList<>();
    private final int groupRoomContract = 100;

    public List<GroupBooking> getGroupGuestList() {
        return groupGuestList;
    }

    public static void setGroupGuestList(List<GroupBooking> groupGuestList) {
        GroupReservation.groupGuestList = groupGuestList;
    }

    public void addGroupGuestToList(GroupBooking newBookingReservation){
        groupGuestList.add(newBookingReservation);
    }

    public void displayGroupGuestList(){
        for(GroupBooking e: groupGuestList){
            //System.out.println(e);
            logger.info(e);
        }
    }

    public void searchGroupRes(String inputLastName, String inputConfNumber){
        for(GroupBooking e:groupGuestList){
            if(e.getLastName().toLowerCase().contains(inputLastName.toLowerCase()) && e.getConfirmationNumber().equals(inputConfNumber)){
                System.out.println("Hi, " + inputLastName + "! We found your reservation - CONF# " + e.getConfirmationNumber());
                return;
            }
        }
        System.out.println("We are not able to locate your reservation");
    }
}


