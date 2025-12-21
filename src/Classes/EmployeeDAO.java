package Classes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    private final String url = "jdbc:sqlserver://localhost:1433;" +
            "databaseName=HotelDB;" +
            "encrypt=true;trustServerCertificate=true;" +
            "integratedSecurity=true";


    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM Employee";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Employee emp = new Employee(
                        rs.getInt("employeeId"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("role")
                );
                employees.add(emp);
            }
        }

        return employees;
    }


    public void addEmployee(Employee emp) throws SQLException {
        String query = "INSERT INTO Employee (employeeId, firstName, lastName, email, phone, role) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, emp.getEmployeeID());
            ps.setString(2, emp.getFirstName());
            ps.setString(3, emp.getLastName());
            ps.setString(4, emp.getEmail());
            ps.setString(5, emp.getPhone());
            ps.setString(6, emp.getRole());

            ps.executeUpdate();
        }
    }


    public boolean isEmployeeExist(int employeeID) throws SQLException {
        String query = "SELECT COUNT(*) FROM Employee WHERE employeeId = ?";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, employeeID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }
}