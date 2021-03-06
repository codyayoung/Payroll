import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Payroll Lab
 * Uses linked lists and interfaces to perform payroll calculations.
 *@author Cody Young
 *@version 4/28/17
 */
public class Driver {

    public static void main(String[] args) throws IOException {
        Payroll pay = new Payroll();
        pay.scanPayroll();
        pay.payrollFormatted();
        pay.employeeCount();
        pay.allWomen();
        pay.tenuredEmployees();
        pay.giveRaise();
        pay.sort();
        pay.hireNew();
        pay.terminate();
    }
}
