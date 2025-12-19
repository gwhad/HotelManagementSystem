package Classes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAO {
    private final String url = "jdbc:sqlserver://localhost:1433;" +
            "databaseName=HotelDB;" +
            "encrypt=true;trustServerCertificate=true;" +
            "integratedSecurity=true";
    private final String  user ="sa";
    private final String password ="Your Pass";
    private Connection getConnection() throws SQLException {
        return
                DriverManager.getConnection(url, user, password);
    }
    public List<Service> getAllServices()throws SQLException , InvalidDataException{
        List<Service> services = new ArrayList<>();
        String sql = "SELECT * FROM Service";
        try (Connection conn=getConnection();
             PreparedStatement stmt= conn.prepareStatement(sql);
             ResultSet rs= stmt.executeQuery()){
            while (rs.next()){
                Service service=new Service(
                        rs.getInt("serviceID"),
                        rs.getString("name"),
                        rs.getDouble("price")

                ) ;
                services.add(service);
            }

        }
        return services;
        /*catch (SQLException | InvalidDataException e) {
            e.printStackTrace();
        }*/


    }

    public void addService(Service service) throws SQLException{
        String sql="INSERT INTO Service " +
                "(serviceID,name,price) "+ "VALUES" +
                "(?,?,?)";
        try(Connection conn=getConnection();
            PreparedStatement stmt= conn.prepareStatement(sql) ){
            stmt.setInt(1, service.getServiceID());
            stmt.setString(2, service.getName());
            stmt.setDouble(3, service.getPrice());

            stmt.executeUpdate();
        }
        /*catch (SQLException e) {
            e.printStackTrace();
        }*/


    }
}


