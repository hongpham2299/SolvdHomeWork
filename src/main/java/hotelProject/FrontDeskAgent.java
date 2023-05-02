package hotelProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FrontDeskAgent extends Employee implements CalculateEmployeeWage {
    private final double basedWagePerHour = 17.25;
    private final double twoYearsWageExp = basedWagePerHour + 2.35;
    private final double threeYearsUpWageExp = basedWagePerHour + 4.55;
    //private List<GroupBooking> bookingList = new ArrayList<>();
    private final Logger logger = LogManager.getLogger(FrontDeskAgent.class.getName());

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
                Double.compare(that.threeYearsUpWageExp, threeYearsUpWageExp) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(basedWagePerHour, twoYearsWageExp, threeYearsUpWageExp);
    }

    @Override
    public void calculatedWagesPerWeek(int inputHours) {
        try{
            if(getYearsOfExperience() == 1 && inputHours >= 0){
                System.out.println(this.name + ": $" + basedWagePerHour * inputHours);
                //throw new Exception("Can't be negative number");
            }
            if(getYearsOfExperience() == 2 && inputHours >=0){
                System.out.println(this.name + ": $" + twoYearsWageExp * inputHours);
            }
            if(getYearsOfExperience() >= 3 && inputHours >=0){
                System.out.println(this.name + ": $" + threeYearsUpWageExp * inputHours);
            }
            if(inputHours < 0){
                throw new InputNegativeWorkedHoursException(this.name + ": The input hours can't be negative number");
            }
        }catch (InputNegativeWorkedHoursException e){
            logger.error(e.getMessage());
        }
    }
}


