package hotelProject;

import java.util.*;

public class FrontDeskManager extends Employee implements Department {

    private int salary;
    private List<FrontDeskAgent> frontDeskAgentList = new ArrayList<>();
    private Queue<Guest> customerServiceLine = new LinkedList<>();

    public FrontDeskManager(){}

    public FrontDeskManager (String name, int salary){
        this.name = name;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

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

    public void addGuestToCustomerServiceLine (Guest guest){
        customerServiceLine.offer(guest);
    }

    public void assistCustomers(){
        customerServiceLine.poll();
    }

    public void displayCustomerServiceLine(){
        customerServiceLine.forEach(System.out::println);
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

