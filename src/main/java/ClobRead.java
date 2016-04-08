import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Hernan Y.Ke on 2016/4/8.
 */
public class ClobRead {
    public static void main(String[] args) throws SQLException,FileNotFoundException,IOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection(DBType.MYSQL);
            String sql = "SELECT FROM world.resume WHERE id=1";
            stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            if(rs.next()){
                java.sql.Clob resume = rs.getClob("resume");
                Reader data = resume.getCharacterStream();
                int i;
                String resumedetails = "";
                while((i=data.read())!=-1){  //Here throws IOException
                    resumedetails+=((char)i);
                }
                System.out.println(resumedetails);
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
