import Classes.InvalidDataException;
import Classes.Service;
import Classes.ServiceDAO;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class MainService {
    public static void main(String[] args) throws SQLException , ClassNotFoundException, InvalidDataException {
        ServiceDAO serviceDAO = new ServiceDAO();
        try{
            List<Service> services= serviceDAO.getAllServices();
            System.out.println("Existing Services: ");
            for (Service s : services) {
                System.out.println(s);
            }
            Service newService = new Service(30,"Breakfast",50.0);
            boolean exists=services.stream().anyMatch(s-> s.getServiceID()==newService.getServiceID());
            if(exists){
                serviceDAO.addService(newService);
                System.out.println("Service added successfully");
            }
            else {

                System.out.println("ServiceID "+newService.getServiceID()+" already exists, Skipping insertation.");
            }
                for (Service s : services) {
                    System.out.println(s);
                }


            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url =
                    "jdbc:sqlserver://localhost:1433;databaseName=HotelDB;encrypt=true;trustServerCertificate=true;integratedSecurity=true";
            Connection conn = DriverManager.getConnection(url);
            System.out.println("\nConnected to DB.");
            conn.close();

        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
