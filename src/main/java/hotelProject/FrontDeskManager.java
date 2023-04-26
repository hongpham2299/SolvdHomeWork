package hotelProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FrontDeskManager extends Employee implements Department {

    private double salary;
    private List<FrontDeskAgent> frontDeskAgentList = new ArrayList<>();
    public void addNewEmployee(FrontDeskAgent newEmployee){
        this.frontDeskAgentList.add(newEmployee);
    }
    public void addCurrentEmployee(FrontDeskAgent currentEmployee){
        this.frontDeskAgentList.add(currentEmployee);
    }

    public void displayEmployeeList(){
        for(FrontDeskAgent fdlist: frontDeskAgentList){
            System.out.println(fdlist);
        }
        System.out.println("Front Desk - Number of Employees: " + frontDeskAgentList.size());
    }

    @Override
    public void displaySalaryOrWage() {
        System.out.println("We will update the list of front desk manager salary later");
    }

    @Override
    public String toString() {
        return "FrontDeskManager{" +
                "salary=" + salary +
                ", name='" + name + '\'' +
                ", employmentStatus='" + employmentStatus + '\'' +
                ", performanceScore=" + performanceScore +
                ", yearsOfExperience=" + yearsOfExperience +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FrontDeskManager that = (FrontDeskManager) o;
        return Double.compare(that.salary, salary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary);
    }
}

