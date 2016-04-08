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
            conn=DBUtil.getConnection(DBType.MYSQL);
            DatabaseMetaData dbmd = conn.getMetaData();
            System.out.println(dbmd.getDriverName());
            System.out.println(dbmd.getDriverVersion());
            System.out.println(dbmd.getUserName());
            System.out.println(dbmd.getDatabaseProductName());
            System.out.println(dbmd.getDatabaseProductVersion());

            String catalog = null;
            String schemaPattern = null;
            String tableNamePattern = null;
            String schemaTypes[]= {"TABLE"};
            rs = dbmd.getTables(catalog,schemaPattern,tableNamePattern,schemaTypes);
            while (rs.next()){
                System.out.println(rs.getString("TABLE_NAME"));
            }

            String columnName = null;
            rs = dbmd.getColumns(catalog,schemaPattern,"yd",columnName);
            while (rs.next()){
                System.out.println(rs.getString("COLUMN_NAME"));
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
