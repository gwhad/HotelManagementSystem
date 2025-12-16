package Classes;

public class Guest {
    private int guestId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int idNumber;
    private String address;

    public Guest() {
    }

    public Guest(int guestId, String firstName, String lastName, String email, String phone, int idNumber, String address) {
        this.guestId = guestId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.idNumber = idNumber;
        this.address = address;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
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

    public void setEmail(String email) throws InvalidDataException {
        if (!email.contains("@")) throw new InvalidDataException("Invalid email format.");
        this.email = email;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "Guest { " +
                "id=" + guestId +
                ", name='" + firstName + " " + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                " }";
    }


}
