package Classes;

import java.sql.SQLException;
import java.util.List;

public class EmployeeMain {
    public static void main(String[] args) {
        EmployeeDAO empDAO = new EmployeeDAO();

        try {
            // عرض كل الموظفين
            System.out.println("Existing Employees:");
            List<Employee> employees = empDAO.getAllEmployees();
            for (Employee e : employees) {
                System.out.println(e);
            }

            // إضافة موظف جديد
            Employee newEmp = new Employee(4, "Laila", "Samir", "laila.sam@hotel.com", "01011112222", "Receptionist");
            if (!empDAO.isEmployeeExist(newEmp.getEmployeeID())) {
                empDAO.addEmployee(newEmp);
                System.out.println("New employee added successfully!");
            } else {
                System.out.println("Employee ID " + newEmp.getEmployeeID() + " already exists. Skipping insertion.");
            }

            // عرض الموظفين بعد الإضافة
            System.out.println("\nEmployees after insertion:");
            employees = empDAO.getAllEmployees();
            for (Employee e : employees) {
                System.out.println(e);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}