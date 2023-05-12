package hotelProject;

import java.time.LocalDateTime;
import java.util.function.Supplier;

public abstract class Employee {
    protected String name;
    protected String employmentStatus;
    protected int performanceScore;
    protected int yearsOfExperience;
    protected String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public int getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(int performanceScore) {
        this.performanceScore = performanceScore;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public abstract void displaySalaryOrWage();

    public void displayPerformance(){
        if(performanceScore > 95 && performanceScore < 100){
            System.out.println(name + ": The best employees of the month with the score " + performanceScore + "/100");
        }else {
            System.out.println(name + ": not the best employees of the month");
        }
    }

    //Using Supplier, Pre-defined Functional Interfaces
    public Supplier<LocalDateTime> employeePunchInTime () {
        System.out.println(getName() + " - Punch In Time below: ");
        return () -> LocalDateTime.now();
    }
}

