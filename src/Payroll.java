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
     */
    public void tenuredEmployees() {
        System.out.print('\n');
        System.out.printf("Tenured Employees:\n");
        ObjectListNode p = EmployeeList.getFirstNode();
        while (p!= null) {
            Employee temp = (Employee)p.getInfo();
            if (temp.getRate().equals("W") && temp.getTenure() >= 5) {
                double yearly_salary = temp.getSalary() * 52; //Converts weekly into yearly salary
                if(yearly_salary > 35000) {
                    System.out.printf("%s %s\n", temp.getFirstName(), temp.getLastName());
                }
            }
            p = p.getNext();
        }
    }
}
