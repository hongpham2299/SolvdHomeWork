package hotelProject;

public class Hotel implements MarriottCorporation {
    protected final String hotelName = "JW Marriott Water Street";
    protected final String hotelAddress = "700 S Florida Ave, Tampa, Florida 336002";
    protected final String hotelPhoneNumber = "(813) 238-0856";
    protected String accountPayable;

    public Hotel(){}

    public Hotel (String accountPayable) {
        this.accountPayable = accountPayable;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public String getHotelPhoneNumber() {
        return hotelPhoneNumber;
    }

    public void displayHotelCategory(){
        System.out.println("Category: " + hotelName + " - " + jwBrand) ;
    }

    @Override
    public String toString() {
        return "Hotel {" +
                "BillNeedToPay='" + accountPayable + '\'' +
                ", hotelName=" + hotelName + '\'' +
                ", hotelAddress='" + hotelAddress + '\'' +
                ", hotelPhoneNumber='" + hotelPhoneNumber +
                '}';
    }
}