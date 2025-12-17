import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) throws Exception {

        String url =
                "jdbc:sqlserver://localhost:1433;" +
                        "databaseName=HotelDB;" +
                        "encrypt=true;trustServerCertificate=true";

        String user = "sa";
        String password = "your_password";

        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("Connected to SQL Server!");
    }
}
