import java.sql.*;

/**
 * Created by Hernan Y.Ke on 2016/4/8.
 */
public class RSMetadata {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection(DBType.MYSQL);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("select * from world.yd");
            ResultSetMetaData rsmd = rs.getMetaData();
            int columncount = rsmd.getColumnCount();        //api memorize
            String format = "%-4d%-25s\n";
            System.out.format(format,"Columnname","Columntype","isnullable","isautoincrement");
            for(int i=1;i<=columncount;i++){
                System.out.format(format,rsmd.getColumnName(i),rsmd.getColumnType(i),rsmd.isNullable(i),rsmd.isAutoIncrement(i));
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
