/**
 * Creates objects of the Employee class.
 *@author Cody Young
 *@version 4/11/17
 */
public class Employee implements Comparable {
    //Instance variables
    public String firstName;
    public String lastName;
    public String gender;
    public int tenure;          //Years with company
    public String rate;         //Designates if employee is hourly or weekly pay
    public double salary;       //Hourly pay if hourly, weekly pay if weekly employee

    /**
     * Constructor method for Employee objects. Initializes instance variables.
     */
    public Employee() {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.tenure = tenure;
        this.rate = rate;
        this.salary = salary;
    }

    /**
     * Gets first name of Employee.
     * @return First name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name of Employee.
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getTenure() {
        return tenure;
    }

    public void setTenure(int tenure) {
        this.tenure = tenure;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
