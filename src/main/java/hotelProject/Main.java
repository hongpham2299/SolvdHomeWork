package hotelProject;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        FrontDeskAgent alexDiaz = new FrontDeskAgent("Alex Diaz", "Full-time", 97, 3);
        alexDiaz.displayPerformance();
        alexDiaz.displaySalaryOrWage();
        alexDiaz.calculatedWages(32);

        FrontDeskAgent jennyWilliams = new FrontDeskAgent("Jenny William", "Full-time", "Female");
        FrontDeskAgent jodiNguyen = new FrontDeskAgent("Jodi Nguyen", "Part-time", "Female");
        FrontDeskAgent scottPeavey = new FrontDeskAgent("Scott Peavey", "Part time", "Male");


        FrontDeskManager employeeList = new FrontDeskManager();
        employeeList.addNewEmployee(jennyWilliams);
        employeeList.addNewEmployee(jodiNguyen);
        employeeList.addNewEmployee(scottPeavey);
        employeeList.addCurrentEmployee(alexDiaz);

        employeeList.displayEmployeeList();

        GroupBooking hongPham = new GroupBooking("Hong", "Pham", LocalDate.of(2023, 9, 8), LocalDate.of(2023, 9, 10), 2, 3, "hong@gmail.com");
        GroupBooking stevenChang = new GroupBooking("Steven", "Chang", LocalDate.of(2023, 9, 8), LocalDate.of(2023, 9, 10), 3, 2, "chang@yahoo.com");
        GroupBooking kimTran = new GroupBooking("Kim", "Tran", LocalDate.of(2023, 9, 8), LocalDate.of(2023, 9, 10), 4, 1, "kim@outlook.com");
        GroupBooking alexJenkins = new GroupBooking("Alex", "Jenkins", LocalDate.of(2023, 9, 8), LocalDate.of(2023, 9, 10), 5, 4, "alex.com");
        GroupBooking brittanyMatthews = new GroupBooking("Brittany", "Matthews", LocalDate.of(2023, 9, 8), LocalDate.of(2023, 9, 9), 1, 2, "matthew@google.com");

        hongPham.bookGroupReservation();
        stevenChang.bookGroupReservation();
        kimTran.bookGroupReservation();
        alexJenkins.bookGroupReservation();
        brittanyMatthews.bookGroupReservation();//This booking is not successful due to the departure date.

        alexJenkins.displayBilling();

        GroupReservation groupGuestList = new GroupReservation();
        groupGuestList.addGroupGuestToList(hongPham);
        groupGuestList.addGroupGuestToList(stevenChang);
        groupGuestList.addGroupGuestToList(kimTran);
        groupGuestList.addGroupGuestToList(alexJenkins);

        groupGuestList.displayGroupGuestList();

        groupGuestList.searchGroupRes("TRAN", "SOFICKimTran4");

        Hotel jwHotel = new Hotel();
        jwHotel.displayHotelCategory();

        System.out.println(RoomType.valueOfEachRoomType(50));

        GroupEvent soficEvent = new GroupEvent();
        soficEvent.displayGroupInformation();

    }


}

