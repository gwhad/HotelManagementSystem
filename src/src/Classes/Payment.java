package Classes;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Payment {
    private int paymentID;
    private int reservationID;
    private double amount;
    private LocalDateTime paymentDate;
    private String paymentMethod;
    private String status;

    public Payment() {
    }

    public Payment(int paymentID, int reservationID, double amount, LocalDateTime paymentDate, String paymentMethod, String status) {
        this.paymentID = paymentID;
        this.reservationID = reservationID;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethodetho() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {return status;}

    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "Payment { " +
                "id=" + paymentID +
//                ", reservationId=" + reservationId +
                ", amount=" + amount +
                ", date=" + paymentDate +
                ", method='" + paymentMethod + '\'' +
                ", status='" + status + '\'' +
                " }";
    }

}
