import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;
/**
 *Performs operations on a payroll database.
 *@author Cody Young
 *@version 4/28/17
 */
public class Payroll {
    //Instance variables
    private Employee employee;  //Employee object
    private Employee fired_employee;    //Objects formerly known as Employees
    private ObjectList EmployeeList;
    public PrintWriter foutput;

    /**
     * Constructor method for Payroll objects. Initializes instance variables.
     */
    public Payroll() throws IOException {
        EmployeeList = new ObjectList();
        foutput = new PrintWriter(new FileWriter("csis.txt"));
    }

    /**
     * Reads from payfile.txt, wraps into Employee objects,
     * and places into EmployeeList.
     */
    public void scanPayroll() throws IOException {
        Scanner sc = new Scanner(new File("payfile.txt"));
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
            EmployeeList.insert(employee);           //Insert node into employee list
        }
    }

    /**
     *Outputs and formats payroll data file.
     */
    public void payrollFormatted() {
        System.out.print("Super Inefficient Enterprise Software Systems Inc. - Payroll 1996\n");
        foutput.print("Super Inefficient Enterprise Software Systems Inc. - Payroll 1996\n");
        for(int i = 0; i <= 65; i++){
            System.out.print("-");
            foutput.print("-");
        }
        System.out.print('\n');
        foutput.print('\n');

        System.out.printf("%-25s%10s%10s%10s%10s%20s\n", "First Name", "Last Name", "Gender", "Tenure", "Rate", "Salary");
        foutput.printf("%-25s%10s%10s%10s%10s%20s\n", "First Name", "Last Name", "Gender", "Tenure", "Rate", "Salary");
        ObjectListNode p = EmployeeList.getFirstNode();
        while (p != null) {
            Employee temp = (Employee)p.getInfo();     //Takes from input, places Employee List
            //Prints out payroll
            System.out.printf("%-25s%10s%10s%10s%10s%20s\n", temp.getFirstName(),temp.getLastName(), temp.getGender(), temp.getTenure(), temp.getRate(), temp.getSalary());
            foutput.printf("%-25s%10s%10s%10s%10s%20s\n", temp.getFirstName(),temp.getLastName(), temp.getGender(), temp.getTenure(), temp.getRate(), temp.getSalary());
            p = p.getNext();
        }
        System.out.print('\n');
        foutput.print('\n');
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
        System.out.println("Number of employees: "+ count);
        foutput.println("Number of employees: "+ count);
        System.out.print('\n');
        foutput.print('\n');
    }

    /**
     *Outputs first and last name of all women on payroll.
     */
    public void allWomen() {
        System.out.printf("Women:\n");
        foutput.printf("Women:\n");
        ObjectListNode p = EmployeeList.getFirstNode();
        while (p!= null) {
            Employee temp = (Employee)p.getInfo();
            if (temp.getGender().equals("F")) {
                System.out.printf("%s %s\n", temp.getFirstName(), temp.getLastName());
                foutput.printf("%s %s\n", temp.getFirstName(), temp.getLastName());
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
        foutput.print('\n');
        System.out.printf("Tenured Employees:\n");
        foutput.printf("Tenured Employees:\n");
        ObjectListNode p = EmployeeList.getFirstNode();
        while (p!= null) {
            Employee temp = (Employee)p.getInfo();
            if (temp.getRate().equals("W") && temp.getTenure() >= 5) {
                double yearly_salary = temp.getSalary() * 52; //Converts weekly into yearly salary, assuming year is 52 weeks long
                if(yearly_salary > 35000) {
                    System.out.printf("%s %s\n", temp.getFirstName(), temp.getLastName());
                    foutput.printf("%s %s\n", temp.getFirstName(), temp.getLastName());
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
        foutput.print('\n');
        System.out.printf("Employees getting Raises:\n");
        foutput.printf("Employees getting Raises:\n");
        ObjectListNode p = EmployeeList.getFirstNode();
        while (p != null) {
            Employee temp = (Employee)p.getInfo();
            if (temp.getRate().equals("H") && temp.getSalary() < 10) {
                double new_hourly = temp.getSalary() + 0.75;
                System.out.printf("%s %-10s New Hourly Rate: %.2f/hr\n", temp.getFirstName(), temp.getLastName(), new_hourly);
                foutput.printf("%s %-10s New Hourly Rate: %.2f/hr\n", temp.getFirstName(), temp.getLastName(), new_hourly);
            }
            else if(temp.getRate().equals("W") && temp.getSalary() < 350) {
                double new_weekly = temp.getSalary() + 350;
                System.out.printf("%s %-10s  New Salary: %.2f/week\n", temp.getFirstName(), temp.getLastName(), new_weekly);
                foutput.printf("%s %-10s  New Salary: %.2f/week\n", temp.getFirstName(), temp.getLastName(), new_weekly);
            }
            p = p.getNext();
        }
    }

    /**
     * Sorts EmployeeList by last name - if last names are the same, then first name. Prints sorted list.
     */
    public void sort() {
        System.out.print('\n');
        foutput.print('\n');
        System.out.printf("Employees - Last Name - Alphabetical - Salary\n");
        foutput.printf("Employees - Last Name - Alphabetical - Salary\n");
        ObjectListNode p = EmployeeList.getFirstNode();     //Pointer to head of list
        while (p != null) {
            Employee temp = (Employee)p.getInfo();
            System.out.printf("%s %s %5.2f\n", temp.getFirstName(), temp.getLastName(), temp.getSalary());
            foutput.printf("%s %s %5.2f\n", temp.getFirstName(), temp.getLastName(), temp.getSalary());
            p = p.getNext();
        }
    }

    /**
     * Hires new employees. Prints out new payroll roster.
     */
    public void hireNew() throws IOException {
        System.out.print('\n');
        foutput.print('\n');
        System.out.printf("Payroll 1996 -- New Employees Added!\n");
        foutput.printf("Payroll 1996 -- New Employees Added!\n");
        Scanner hire = new Scanner(new File("hirefile.txt"));

        while (hire.hasNext()) {                    //Same scanning method as before
            String input_string = hire.nextLine();
            String delims = "[ ]+";
            String[] tokens =input_string.split(delims);
            String first = tokens[0];
            String last = tokens[1];
            String sex = tokens[2];
            int in_tenure = Integer.parseInt(tokens[3]);
            String in_rate = tokens[4];
            double in_salary = Double.parseDouble(tokens[5]);
            employee = new Employee(first, last, sex, in_tenure, in_rate, in_salary);
            EmployeeList.insert(employee);
        }
        ObjectListNode p = EmployeeList.getFirstNode();
        while (p != null) {
            Employee temp = (Employee)p.getInfo();
            System.out.printf("%s %s\n", temp.getFirstName(), temp.getLastName());
            foutput.printf("%s %s\n", temp.getFirstName(), temp.getLastName());
            p = p.getNext();
        }
    }

    /**
     * Marks certain employees for termination and outputs their names.
     * What happens after that is classified.
     */
    public void terminate() throws IOException {
        System.out.print('\n');
        foutput.print('\n');
        System.out.printf("Payroll 1996 -- Post \"Restructuring\"\n");
        foutput.printf("Payroll 1996 -- Post \"Restructuring\"\n");
        Scanner fire = new Scanner (new File ("firefile.txt"));
        ObjectListNode p = EmployeeList.getFirstNode();
        while (fire.hasNext()) {                    //Read from file, scan employees for termination into list
            String input_string = fire.nextLine();
            String delims = "[ ]+";
            String[] tokens =input_string.split(delims);
            String first = tokens[0];
            String last = tokens[1];
            fired_employee = new Employee(first,last);
            EmployeeList.remove(fired_employee);
        }
        while (p != null) {
            Employee temp = (Employee)p.getInfo();
            System.out.printf("%s %s\n", temp.getFirstName(), temp.getLastName());
            foutput.printf("%s %s\n", temp.getFirstName(), temp.getLastName());
            p = p.getNext();
        }
        foutput.flush();
        foutput.close();
    }
}
