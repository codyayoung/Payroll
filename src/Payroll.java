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

    /**
     * Constructor method for Payroll objects. Initializes instance variables.
     */
    public Payroll() {
         employee = new Employee();
         EmployeeList = new ObjectList();
         empnode = new ObjectListNode();
    }

    /**
     * Reads from payfile.txt, places into Employee objects,
     * places Employee objects into nodes, then inserts nodes into EmployeeList.
     */
    public void scanPayroll() {
        Scanner sc = new Scanner("payfile.txt");
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
