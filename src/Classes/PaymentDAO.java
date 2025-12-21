package Classes;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {
    private final String url = "jdbc:sqlserver://localhost:1433;" +
            "databaseName=HotelDB;" +
            "encrypt=true;trustServerCertificate=true;" +
            "integratedSecurity=true";


    public List<Payment> getAllPayments() throws SQLException {
        List<Payment> payments = new ArrayList<>();
        String query = "SELECT * FROM Payment";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {

                Date sqlDate = rs.getDate("paymentDate");
                LocalDateTime paymentDateTime = null;
                if (sqlDate != null) {
                    LocalDate ld = sqlDate.toLocalDate();
                    paymentDateTime = LocalDateTime.of(ld, LocalTime.MIDNIGHT);
                }

                Payment pay = new Payment(
                        rs.getInt("paymentId"),
                        rs.getInt("reservationId"),
                        rs.getDouble("amount"),
                        paymentDateTime,
                        rs.getString("paymentMethod"),
                        rs.getString("status")
                );
                payments.add(pay);
            }
        }

        return payments;
    }


    public void addPayment(Payment payment) throws SQLException {
        String query = "INSERT INTO Payment (paymentId, reservationId, amount, paymentDate, paymentMethod, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, payment.getPaymentID());
            ps.setInt(2, payment.getReservationID());
            ps.setDouble(3, payment.getAmount());

            if (payment.getPaymentDate() != null) {
                ps.setDate(4, Date.valueOf(payment.getPaymentDate().toLocalDate()));
            } else {
                ps.setNull(4, Types.DATE);
            }

            ps.setString(5, payment.getPaymentMethodetho());
            ps.setString(6, payment.getStatus());

            ps.executeUpdate();
        }
    }


    public boolean isPaymentExist(int paymentID) throws SQLException {
        String query = "SELECT COUNT(*) FROM Payment WHERE paymentId = ?";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, paymentID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }
}