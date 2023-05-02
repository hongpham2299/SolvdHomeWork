package hotelProject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Accounting {
    private Map<String, GroupBooking> groupGuestAccount = new HashMap<>();

    public void addGuestToGroupAccountsList(String inputNumberID, GroupBooking inputGroupGuest){
        groupGuestAccount.put(inputNumberID, inputGroupGuest);
    }

    public void displayGroupGuestAccountList(){
        groupGuestAccount.forEach((key, value) -> System.out.println("Billing Account Number: " + key +
                " | Account Details: " + value));
    }

    public void searchGroupGuestAccount (String inputGuestAccountNumber){
        Iterator<Map.Entry<String, GroupBooking>> it = groupGuestAccount.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,GroupBooking> entry = it.next();
            if(inputGuestAccountNumber.equalsIgnoreCase(entry.getKey())){
                System.out.println(inputGuestAccountNumber + ": We found your account");
                return;
            }
        }
        System.out.println(inputGuestAccountNumber + ": Not Found");

    }
}
