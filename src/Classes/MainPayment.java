package Classes;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class MainPayment {
    public static void main(String[] args) {

        PaymentDAO paymentDAO = new PaymentDAO();

        try {

            System.out.println("Existing Payments:");
            List<Payment> payments = paymentDAO.getAllPayments();
            for (Payment p : payments) {
                System.out.println(p);
            }


            Payment newPayment = new Payment(
                    3, // paymentID
                    102, // reservationID
                    2500, // amount
                    LocalDateTime.now(), // paymentDate
                    "Debit Card", // paymentMethod
                    "Pending" // status
            );

            if (!paymentDAO.isPaymentExist(newPayment.getPaymentID())) {
                paymentDAO.addPayment(newPayment);
                System.out.println("\nNew payment added successfully!");
            } else {
                System.out.println("\nPayment ID " + newPayment.getPaymentID() + " already exists. Skipping insertion.");
            }


            System.out.println("\nPayments after insertion:");
            payments = paymentDAO.getAllPayments();
            for (Payment p : payments) {
                System.out.println(p);
            }

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }

    }
}