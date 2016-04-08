import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Hernan Y.Ke on 2016/4/7.
 */
public class DBUtil {
    static String username="root";
    static String password="root";
    static String url="jdbc:mysql://localhost:3306/world";
    public static Connection getConnection(DBType dt) throws SQLException{
        try {
            return DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void showErrorMessage(SQLException e){
        System.err.println(e.getMessage());
        System.err.println(e.getErrorCode());
    }
}
