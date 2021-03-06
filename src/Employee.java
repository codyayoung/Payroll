/**
 * Creates objects of the Employee class.
 *@author Cody Young
 *@version 4/28/17
 */
public class Employee implements Comparable {
    //Instance variables
    private String firstName;
    private String lastName;
    private String gender;
    private int tenure;          //Years with company
    private String rate;         //Designates if employee is hourly or weekly pay
    private double salary;       //Hourly pay if hourly, weekly pay if weekly employee

    /**
     * Constructor method for Employee objects. Initializes instance variables.
     */
    public Employee(String firstName, String lastName, String gender, int tenure, String rate, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.tenure = tenure;
        this.rate = rate;
        this.salary = salary;
    }

    /**
     * Overloaded constructor for Employee objects that takes only first and last name.
     */
    public Employee (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
     * @param firstName First name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Compares first names of Employee objects.
     @return 1 if letter is lexigraphically higher, 0 if names are same
     */
    public int compareTo (Object j) {
        Employee i = (Employee) j;
        return lastName.compareTo(i.getLastName());
    }

    /**
     * Gets last name of Employee.
     * @return Last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name of Employee.
     * @param lastName Returns last name of Employee.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Compares last names of Employee objects.
     */
    public int compareToLast (Object j) {
        Employee i = (Employee) j;
        return lastName.compareTo(i.getLastName());
    }

    /**
     * Gets gender of Employee.
     * @return Gender: male/female
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets gender of Employee
     * @param gender Gender: male/female
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Compares genders of Employee objects.
     * @param j Employee object to compare
     * @return 1 if genders match, 0 if not
     */
    public int compareGender(Object j) {
        Employee i = (Employee) j;
        return gender.compareTo(i.getGender());
    }

    /**
     * Gets tenure of Employee object.
     * @return Tenure in years
     */
    public int getTenure() {
        return tenure;
    }

    /**
     * Sets tenure of Employee object.
     * @param tenure Tenure in years
     */
    public void setTenure(int tenure) {
        this.tenure = tenure;
    }

    /**
     * Gets rate of employee.
     * @return Rate: hourly/weekly
     */
    public String getRate() {
        return rate;
    }

    /**
     * Sets rate of employee.
     * @param rate Rate: hourly/weekly
     */
    public void setRate(String rate) {
        this.rate = rate;
    }

    /**
     * Compares rates of Employee objects.
     * @param j
     * @return 1 if rates match, 0 if not
     */
    public int compareRate(Object j) {
        Employee i = (Employee) j;
        return rate.compareTo(i.getRate());
    }

    /**
     * Gets salary of Employee objects.
     * @return Salary in dollars
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Sets salary of Employee objects.
     * @param salary Salary in dollars
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    /**
     * toString method for Employee objects.
     * @return String representation of Employee object.
     */
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", tenure=" + tenure +
                ", rate='" + rate + '\'' +
                ", salary=" + salary +
                '}';
    }
}
