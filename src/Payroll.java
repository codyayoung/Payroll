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
            String[] tokens =input_string.split(delims);  //Read tokens into appropriate variables
            String first = tokens[0];   //Read first name
            String last = tokens[1];    //Read last name
            String sex = tokens[2];               //Read gender
            int in_tenure = Integer.parseInt(tokens[3]);             //Tenure
            String in_rate = tokens[4];           //Rate
            double in_salary = Double.parseDouble(tokens[5]);       //Salary
            employee = new Employee(first, last, sex, in_tenure, in_rate, in_salary);// Create employee object, set info fields
            EmployeeList.insert(employee);           //Insert node into list
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
        while (!EmployeeList.isEmpty()) {
            Employee formattedEmployee = (Employee)EmployeeList.removeFirst();
            System.out.printf("%-25s%10s%10s%10s%10s%20s\n", formattedEmployee.getFirstName(), formattedEmployee.getLastName(), formattedEmployee.getGender(), formattedEmployee.getTenure(), formattedEmployee.getRate(), formattedEmployee.getSalary());
        }
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
