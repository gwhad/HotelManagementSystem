package Classes;

public class Employee {
    private int employeeID;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String role;

    public Employee(int i, String saraMohamed, String receptionist, int i1) {
    }

    public Employee(int employeeID, String firstName, String lastName, String email, String role, String phone) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.phone = phone;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public String toString() {
        return "Employee { " +
                "id=" + employeeID +
                ", name='" + firstName + " " + lastName + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", phone='" + phone + '\'' +
                " }";
    }


    //createReservation()
    //handleServiceRequest()

}
