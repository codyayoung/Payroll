import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;
/**
 *Performs operations on a payroll database.
 *@author Cody Young
 *@version 4/11/17
 */
public class Payroll {
    //Instance variables
        private Employee employee;  //Employee object
        private ObjectList InputList;    //ObjectList of Employee objects
        private ObjectList EmployeeList;

    /**
     * Constructor method for Payroll objects. Initializes instance variables.
     */
    public Payroll() {
         InputList = new ObjectList();
         EmployeeList = new ObjectList();
    }

    /**
     * Reads from payfile.txt, wraps into Employee objects,
     * and places into InputList for further processing.
     */
    public void scanPayroll() throws IOException {
        Scanner sc = new Scanner(new File("payfile.txt"));
        //PrintWriter foutput = new PrintWriter(new FileWriter("csis.txt"));
        while(sc.hasNext()) {
            String input_string = sc.nextLine();     //Split input string up into tokens delimited by spaces
            String delims = "[ ]+";
            String[] tokens =input_string.split(delims);  //Read tokens into appropriate variables
            String first = tokens[0];   //Read first name
            String last = tokens[1];    //Read last name
            String sex = tokens[2];               //Read gender
            int in_tenure = Integer.parseInt(tokens[3]);             //Tenure
            String in_rate = tokens[4];           //Rate
            double in_salary = Double.parseDouble(tokens[5]);       //Salary
            employee = new Employee(first, last, sex, in_tenure, in_rate, in_salary);// Create employee object, set info fields
            InputList.insert(employee);           //Insert node into input list
        }
    }

    /**
     *Outputs and formats payroll data file.
     */
    public void payrollFormatted() {
        System.out.print("Super Inefficient Enterprise Software Systems Inc. - Payroll 1996\n");
        for(int i = 0; i <= 65; i++){
            System.out.print("-");
        }
        System.out.print('\n');
        System.out.printf("%-25s%10s%10s%10s%10s%20s\n", "First Name", "Last Name", "Gender", "Tenure", "Rate", "Salary");
        ObjectListNode p = InputList.getFirstNode();
            while (p != null) {
            p = p.getNext();
            Employee format = (Employee)InputList.removeFirst();      //Takes from input, places into formatted EmployeeList
            EmployeeList.insert(format);
            //Prints out payroll
            System.out.printf("%-25s%10s%10s%10s%10s%20s\n", format.getFirstName(),format.getLastName(), format.getGender(), format.getTenure(), format.getRate(), format.getSalary());
        }
        System.out.print('\n');
    }

    /**
     * Outputs number of employees.
     */
    public void employeeCount() {
        ObjectListNode p = EmployeeList.getFirstNode();
        int count = 0;
        while(p != null) {
            p = p.getNext();
            count++;
        }
        System.out.println("Number of employees:"+ count);
        System.out.print('\n');
    }

    /**
     *Outputs first and last name of all women on payroll.
     */
    public void allWomen() {
        System.out.printf("Women:\n");
        ObjectListNode p = EmployeeList.getFirstNode();
        while (p!= null) {
            Employee temp = (Employee)p.getInfo();
            if (temp.getGender().equals("F")) {
                System.out.printf("%s %s\n", temp.getFirstName(), temp.getLastName());
            }
            p = p.getNext();
        }
    }

    /**
     * Outputs all tenured employees.
     * Tenure: Weekly rate, at least 5 years with company, yearly income > $35K
     */
    public void tenuredEmployees() {
        System.out.print('\n');
        System.out.printf("Tenured Employees:\n");
        ObjectListNode p = EmployeeList.getFirstNode();
        while (p!= null) {
            Employee temp = (Employee)p.getInfo();
            if (temp.getRate().equals("W") && temp.getTenure() >= 5) {
                double yearly_salary = temp.getSalary() * 52; //Converts weekly into yearly salary, assuming year is 52 weeks long
                if(yearly_salary > 35000) {
                    System.out.printf("%s %s\n", temp.getFirstName(), temp.getLastName());
                }
            }
            p = p.getNext();
        }
    }

    /**
     * Gives a weekly/hourly salary raise to certain employees.
     * $0.75/hr for hourly, $50/week for weekly
     * Prints out employee names and their new salaries.
     */
    public void giveRaise() {
        System.out.print('\n');
        System.out.printf("Employees getting Raises:\n");
        ObjectListNode p = EmployeeList.getFirstNode();
        while (p != null) {
            Employee temp = (Employee)p.getInfo();
            if (temp.getRate().equals("H") && temp.getSalary() < 10) {
               double new_hourly = temp.getSalary() + 0.75;
               System.out.printf("%s %-10s New Hourly Rate: %.2f/hr\n", temp.getFirstName(), temp.getLastName(), new_hourly);
            }
            else if(temp.getRate().equals("W") && temp.getSalary() < 350) {
                double new_weekly = temp.getSalary() + 350;
                System.out.printf("%s %-10s  New Salary: %.2f/week\n", temp.getFirstName(), temp.getLastName(), new_weekly);
            }
            p = p.getNext();
        }
    }

    /**
     * Sorts EmployeeList by first and last name. Prints sorted list.
     */
    public void sort() {
        System.out.print('\n');
        System.out.printf("Employees - Last Name, Alphabetical\n");
        ObjectListNode p = EmployeeList.getFirstNode();     //Lead pointer
        ObjectListNode q = EmployeeList.getFirstNode();
        while (p.getNext() != null) {
            Employee temp = (Employee)p.getInfo();
            Employee previous = (Employee)q.getInfo();
            if (temp.getLastName().compareTo(previous.getLastName()) > 0) {
                EmployeeList.insert(temp);
                System.out.printf("%s %-10s\n", temp.getLastName(), temp.getFirstName());
            }
            q = p;
            p = p.getNext();
        }
    }

    /**
     * Hires new employees. Prints out new payroll roster.
     */
    public void hireNew() {

    }

    /**
     * Marks certain employees for termination and outputs their names.
     * What happens after that is classified.
     */
    public void terminate() {

    }
}
