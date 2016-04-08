/**
 * Created by Hernan Y.Ke on 2016/4/8.
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 * Created by Hernan Y.Ke on 2016/4/8.
 */
public class PrepareStatement {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection(DBType.MYSQL);
            String sql = "SELECT * FROM world.yd WHERE name=?";
            stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //Memorize this syntax
            stmt.setString(1,"x");
            rs = stmt.executeQuery();
            String format = "%-4d%-25s\n";
            while (rs.next()){
                System.out.format(format,rs.getInt("id"),rs.getString("name"));
            }
            rs.last();
            System.out.println(rs.getRow());

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

