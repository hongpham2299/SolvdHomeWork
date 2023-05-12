package hotelProject;

import java.util.*;
import java.util.function.Function;

public class Accounting {
    private Map<String, GroupBooking> groupGuestAccount = new HashMap<>();
    private CustomLinkedList<Hotel> accountPayableForHotel = new CustomLinkedList<>();
    private List<FrontDeskManager> frontDeskManagerList = new ArrayList<>();

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

    public void addBillToHotelAccountPayableAtFirstPosition(Hotel inputHotelBill){
        accountPayableForHotel.addFirst(inputHotelBill);
    }

    public void addBillToHotelAccountPayableAtLastPosition(Hotel inputHotelBill){
        accountPayableForHotel.addLast(inputHotelBill);
    }

    public void addBillToHotelAccountPayableAtGivenPosition(int position, Hotel inputHotelBill){
        accountPayableForHotel.addAtGivenPosition(position, inputHotelBill);
    }

    public void displayHotelAccountPayable(){
        accountPayableForHotel.print();
    }

    public void addFrontDeskManagersToList(FrontDeskManager frontDeskManager){
        frontDeskManagerList.add(frontDeskManager);
    }

    //Using the Function, Pre-defined Functional Interfaces
    public void addBonusToAllFrontDeskManager(Function<FrontDeskManager, Integer> percentage){
        for(FrontDeskManager st: frontDeskManagerList){
            int bonus = percentage.apply(st);
            System.out.println(st.getName() + ", Bonus: " + bonus);
        }
    }
}
