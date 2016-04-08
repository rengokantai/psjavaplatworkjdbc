import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Hernan Y.Ke on 2016/4/8.
 */
public class ScrollableResultset {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection(DBType.MYSQL);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("select * from world.yd");
            ///rs.last();
            String format = "%-4d%-25s\n";
            rs.beforeFirst();
            while (rs.next()) {
                System.out.format(format, rs.getInt(1), rs.getString(2));
            }
            rs.afterLast();
            while (rs.previous()) {
                System.out.format(format, rs.getInt(1), rs.getString(2));
            }
            rs.absolute(1);
            System.out.format(format, rs.getInt(1), rs.getString(2));
            rs.relative(2);
            System.out.format(format, rs.getInt(1), rs.getString(2));

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
