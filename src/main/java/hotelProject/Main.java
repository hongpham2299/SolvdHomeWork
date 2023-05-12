package hotelProject;

import java.io.File;
import java.time.LocalDate;

import static hotelProject.FrontDeskAgent.displayWorkingShiftForFrontDeskTeam;
import static hotelProject.GuestRegisterValidation.isAnAdult;
import static hotelProject.GuestRegisterValidation.isPhoneNumberValid;
import static hotelProject.RoomType.*;
import static hotelProject.GuestRegisterValidation.*;

public class Main {
    public static void main(String[] args) {

        FrontDeskAgent alexDiaz = new FrontDeskAgent("Alex Diaz", "Full-time", 97, 3);
        alexDiaz.displayPerformance();
        alexDiaz.displaySalaryOrWage();
        alexDiaz.calculatedWagesPerWeek(35);

        FrontDeskAgent jennyWilliams = new FrontDeskAgent("Jenny William", "Full-time", "Female");
        FrontDeskAgent jodiNguyen = new FrontDeskAgent("Jodi Nguyen", "Part-time", "Female");
        FrontDeskAgent scottPeavey = new FrontDeskAgent("Scott Peavey", "Part time", "Male");

        FrontDeskManager frontDeskManager = new FrontDeskManager();
        frontDeskManager.addNewEmployee(jennyWilliams);
        frontDeskManager.addNewEmployee(jodiNguyen);
        frontDeskManager.addNewEmployee(scottPeavey);
        frontDeskManager.addCurrentEmployee(alexDiaz);

        frontDeskManager.displayEmployeeList();

        jennyWilliams.setYearsOfExperience(1);
        jennyWilliams.calculatedWagesPerWeek(-15);

        Guest josephLeGuest = new Guest("Joseph", "Le");
        Guest sabrinaTorresGuest = new Guest("Sabrina", "Torres");
        Guest henryNguyenGuest = new Guest("Henry", "Nguyen");
        Guest hollyHowellGuest = new Guest("Holly", "Howell");

        frontDeskManager.addGuestToCustomerServiceLine(henryNguyenGuest);
        frontDeskManager.addGuestToCustomerServiceLine(sabrinaTorresGuest);
        frontDeskManager.addGuestToCustomerServiceLine(josephLeGuest);
        frontDeskManager.addGuestToCustomerServiceLine(hollyHowellGuest);

        frontDeskManager.assistCustomers();

        frontDeskManager.displayCustomerServiceLine();

        GroupBooking hongPham = new GroupBooking("Hong", "Pham", LocalDate.of(2023, 9, 8), LocalDate.of(2023, 9, 10), 2, 3, "hong@gmail.com");
        GroupBooking stevenChang = new GroupBooking("Steven", "Chang", LocalDate.of(2023, 9, 8), LocalDate.of(2023, 9, 10), 3, 2, "chang@yahoo.com");
        GroupBooking kimTran = new GroupBooking("Kim", "Tran", LocalDate.of(2023, 9, 8), LocalDate.of(2023, 9, 10), 4, 1, "kim@outlook.com");
        GroupBooking alexJenkins = new GroupBooking("Greg", "Jenkins", LocalDate.of(2023, 9, 8), LocalDate.of(2023, 9, 10), 5, 4, "greg.com");
        GroupBooking brittanyMatthews = new GroupBooking("Brittany", "Matthews", LocalDate.of(2023, 9, 8), LocalDate.of(2023, 9, 9), 1, 2, "matthew@google.com");
        GroupBooking maiTran = new GroupBooking("Mai", "Tran", LocalDate.of(2023, 9, 8), LocalDate.of(2023, 9, 10), 1, 2, "mai@yahoo.com");

        hongPham.bookGroupReservation();
        stevenChang.bookGroupReservation();
        kimTran.bookGroupReservation();
        alexJenkins.bookGroupReservation();
        brittanyMatthews.bookGroupReservation();//This booking is not successful due to the departure date.

        GroupReservation groupGuestList = new GroupReservation();
        groupGuestList.addGroupGuestToList(hongPham);
        groupGuestList.addGroupGuestToList(stevenChang);
        groupGuestList.addGroupGuestToList(kimTran);
        groupGuestList.addGroupGuestToList(alexJenkins);
        groupGuestList.addGroupGuestToList(maiTran);

        //Guest hongPham already booked reservation. However, she called back to change the arrival & departure date.
        //The result: She won't be able to change due to the Group Contract
        hongPham.setArrDate(LocalDate.of(2023, 9, 7));
        hongPham.setDepDate(LocalDate.of(2023, 9, 12));

        groupGuestList.displayGroupGuestList();

        //Using the regular method to search Group Guest
        groupGuestList.searchGroupRes("TRAN", "SOFICKimTran4");

        Hotel jwHotel = new Hotel();
        jwHotel.displayHotelCategory();

        alexJenkins.displayBilling();
        alexJenkins.splitBilling(768.90, -2);

        valueOfEachRoomType(51);
        displayAllRoomTypes();
        displayRoomTypesWithoutSuites();

        Accounting accounting = new Accounting();
        accounting.addGuestToGroupAccountsList("JW3567", hongPham);
        accounting.addGuestToGroupAccountsList("JW1289", stevenChang);
        accounting.addGuestToGroupAccountsList("JW5897", kimTran);
        accounting.addGuestToGroupAccountsList("JW8956", alexJenkins);
        accounting.addGuestToGroupAccountsList("JW5612", maiTran);

        accounting.searchGroupGuestAccount("JW123456");

        accounting.displayGroupGuestAccountList();

        Hotel waterBill = new Hotel("Water Bill");
        Hotel electricBill = new Hotel("Electric Bill");
        Hotel restaurantSupplyBill = new Hotel("Restaurant Supply Bill");
        Hotel spaSupplyBill = new Hotel("Spa Supply Bill");

        accounting.addBillToHotelAccountPayableAtFirstPosition(waterBill);
        accounting.addBillToHotelAccountPayableAtLastPosition(electricBill);
        accounting.addBillToHotelAccountPayableAtLastPosition(spaSupplyBill);
        accounting.addBillToHotelAccountPayableAtGivenPosition(3, restaurantSupplyBill);

        accounting.displayHotelAccountPayable();

        HouseKeeping houseKeeping = new HouseKeeping();
        File file = houseKeeping.createRoomStatusDataFile();
        houseKeeping.addRoomStatusToFile(file, true);
        houseKeeping.displayRoomStatusData();

        GroupEvent soficEvent = new GroupEvent();
        soficEvent.displayGroupInformation();

        //Using Supplier to record the employee Punch In Time
        System.out.println(jennyWilliams.employeePunchInTime().get());

        //Using the Predicate to search Group Guest
        groupGuestList.searchGroupResByPredicate(inputLastName->inputLastName.getLastName().equalsIgnoreCase("Chang"));
        groupGuestList.searchGroupResByPredicate(inputEmail->inputEmail.getEmail().equals("kim@outlook.com"));

        Accounting frontDeskManagerList = new Accounting();
        frontDeskManagerList.addFrontDeskManagersToList(new FrontDeskManager("Mo Arce", 75000));
        frontDeskManagerList.addFrontDeskManagersToList(new FrontDeskManager("Alice Diaz", 69000));
        frontDeskManagerList.addFrontDeskManagersToList(new FrontDeskManager("Josh Bowen", 55000));
        frontDeskManagerList.addFrontDeskManagersToList(new FrontDeskManager("Courtney Shuckra", 47000));

        //Using Function to apply 5% bonus to all the front desk managers.
        frontDeskManagerList.addBonusToAllFrontDeskManager(f->(f.getSalary()*5)/100);

        Guest joeMadieo = new Guest("Joe", "Madieo", "8132380232", LocalDate.of(2010, 1, 1));

        //Using Combinator Pattern to validate guest information before register for Gym membership
        ValidationResult result = isPhoneNumberValid().and(isAnAdult()).apply(joeMadieo);
        System.out.println(result);

        System.out.println(RoomStatus.OCCUPIED_CLEAN.getDescription());
        System.out.println(RoomStatus.VACANT_DIRTY.getRoomTerminology());

        displayWorkingShiftForFrontDeskTeam();







    }

}

