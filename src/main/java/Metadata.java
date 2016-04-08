/**
 * Created by Hernan Y.Ke on 2016/4/7.
 */
import java.sql.*;


public class Metadata {


    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection(DBType.MYSQL);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("select * from world.yd");
            String format = "%-4d%-25s\n";



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
