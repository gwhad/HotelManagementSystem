import java.sql.Connection;
import java.sql.DriverManager;

public class Main1 {
    public static void main(String[] args) throws Exception {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        String url =
                "jdbc:sqlserver://localhost:1433;" +
                        "databaseName=HotelDB;" +
                        "encrypt=true;trustServerCertificate=true;" +
                        "integratedSecurity=true";
        Connection conn = DriverManager.getConnection(url);


        System.out.println("Connected!");
    }
}

