package hotelProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FrontDeskAgent extends Employee implements CalculateEmployeeWage {
    private final double basedWagePerHour = 17.25;
    private final double twoYearsWageExp = basedWagePerHour + 2.35;
    private final double threeYearsUpWageExp = basedWagePerHour + 4.55;
    private List<GroupBooking> bookingList = new ArrayList<>();

    public FrontDeskAgent(String name, String employmentStatus,int performanceScore, int yearsOfExperience) {
        this.name = name;
        this.employmentStatus = employmentStatus;
        this.performanceScore = performanceScore;
        this.yearsOfExperience = yearsOfExperience;
        this.gender = "Do Not List";
    }

    public FrontDeskAgent (String name, String employmentStatus, String gender){
        this.name = name;
        this.employmentStatus = employmentStatus;
        this.gender = gender;
    }


    public void displaySalaryOrWage(){
        switch (yearsOfExperience){
            case 1:
                System.out.println(name + ": " + yearsOfExperience + " year experience ---> $"
                        + basedWagePerHour + "/hour");
                break;
            case 2:
                System.out.println(name + ": " + yearsOfExperience + " years experience ---> $"
                        + twoYearsWageExp + "/hour");
                break;
            case 3:
                System.out.println(name + ": " + yearsOfExperience + " years experience ---> $"
                        + threeYearsUpWageExp + "/hour");
                break;
            default:
                System.out.println(name + ": with more than " + yearsOfExperience + " years experience ---> $"
                        + threeYearsUpWageExp + "/hour");
        }
    }

    @Override
    public String toString() {
        return "FrontDeskAgent{" +
                "name='" + name + '\'' +
                ", employmentStatus='" + employmentStatus + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FrontDeskAgent that = (FrontDeskAgent) o;
        return Double.compare(that.basedWagePerHour, basedWagePerHour) == 0 &&
                Double.compare(that.twoYearsWageExp, twoYearsWageExp) == 0 &&
                Double.compare(that.threeYearsUpWageExp, threeYearsUpWageExp) == 0 &&
                Objects.equals(bookingList, that.bookingList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(basedWagePerHour, twoYearsWageExp, threeYearsUpWageExp, bookingList);
    }

    @Override
    public void calculatedWages(int workedHours) {
        if(getYearsOfExperience() == 1){
            System.out.println(this.getName() + ": $" + basedWagePerHour * workedHours);
        }
        else if(getYearsOfExperience() == 2){
            System.out.println(this.getName() + ": $" + twoYearsWageExp * workedHours);
        }
        else {
            System.out.println(this.getName() + ": $" + threeYearsUpWageExp * workedHours);
        }
    }
}


