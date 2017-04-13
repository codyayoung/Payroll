import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/**
 *Performs operations on a payroll database.
 *@author Cody Young
 *@version 4/11/17
 */
public class Payroll {
    //Instance variables
        private Employee employee;  //Employee object
        private ObjectList EmployeeList;    //ObjectList of Employee objects
        private ObjectListNode empnode;     //ObjectListNode to hold Employee object
    Scanner sc = new Scanner("payfile.txt");
    /**
     * Constructor method for Payroll objects. Initializes instance variables.
     */
    public Payroll() {
         EmployeeList = new ObjectList();
    }

    /**
     * Reads from payfile.txt, places into Employee objects,
     * places Employee objects into nodes, then inserts nodes into EmployeeList.
     */
    public void scanPayroll() throws IOException {
        Scanner sc = new Scanner(new File("payfile.txt"));
        while(sc.hasNext()) {
            String input_string = sc.nextLine();     //Split input string up into tokens delimited by spaces
            String delims = "[ ]+";
            String [] tokens = input_string.split(delims);  //Read tokens into appropriate variables

            String first = sc.nextLine();   //Read first name
            String last = sc.nextLine();    //Read last name
            String sex = sc.nextLine();               //Read gender
            int in_tenure = sc.nextInt();             //Tenure
            String in_rate = sc.nextLine();           //Rate
            double in_salary = sc.nextDouble();       //Salary
            employee = new Employee(first, last, sex, in_tenure, in_rate, in_salary);// Create employee object, set info fields
        }
    }

    /**
     *Outputs and formats payroll data file.
     */
    public void payrollFormatted() {

    }

    /**
     * Outputs number of employees.
     */
    public void employeeCount() {
        
    }

    /**
     *Outputs first and last name of all women on payroll.
     */
    public void allWomen() {
        
    }
}
