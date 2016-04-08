import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Hernan Y.Ke on 2016/4/8.
 */
public class Clob {
    public static void main(String[] args) throws SQLException,FileNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection(DBType.MYSQL);
            String sql = "INSERT INTO world.resume(resume) VALUES(?) ";
            stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String path = "c:/test.txt";
            File file = new File(path);
            FileReader reader = new FileReader(file);       //Here throws FileNotFoundException
            stmt.setCharacterStream(1,reader,(int)file.length());      //syntax
            stmt.executeUpdate();



        } catch (SQLException e) {
            DBUtil.showErrorMessage(e);
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
    }
}
