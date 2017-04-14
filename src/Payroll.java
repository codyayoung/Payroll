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
        public ObjectList EmployeeList;    //ObjectList of Employee objects
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
        ObjectListNode p = EmployeeList.getFirstNode();
            while (p != null) {
            p = p.getNext();
            Employee format = (Employee)EmployeeList.removeFirst();      //Need to perform this non destructively
            System.out.printf("%-25s%10s%10s%10s%10s%20s\n", format.getFirstName(),format.getLastName(), format.getGender(), format.getTenure(), format.getRate(), format.getSalary());
        }
        System.out.print('\n');
    }

    /**
     * Outputs number of employees.
     */
    public void employeeCount() {
        ObjectListNode p = EmployeeList.getFirstNode();     //Points to head of list, but returns null
        int count = 0;
        while(p != null) {
            p = p.getNext();
            count++;
        }
        System.out.println("Number of employees:"+ count); //Says 0 because it points to null, don't know why
    }

    /**
     *Outputs first and last name of all women on payroll.
     */
    public void allWomen() {
        
    }
}
