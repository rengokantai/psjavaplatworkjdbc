import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Hernan Y.Ke on 2016/4/8.
 */
public class ExecuteUpdate {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection(DBType.MYSQL);
            String sql = "INSERT INTO world.yd(name) VALUES (?)";
            //String sql = "UPDATE world.yd SET name = ? WHERE name="update";
            //String sql = "DELETE FROM world.yd WHERE name=?;
            stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //Memorize this syntax
            stmt.setString(1,"update");
            int result = stmt.executeUpdate();
            String format = "%-4d%-25s\n";
            if(result==1){
                System.out.println("successful");
            }

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
