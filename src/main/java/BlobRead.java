import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Hernan Y.Ke on 2016/4/8.
 */
public class BlobRead {
    public static void main(String[] args) throws SQLException,FileNotFoundException,IOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection(DBType.MYSQL);
            String sql = "SELECT FROM world.photo WHERE id=1";
            stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            if(rs.next()){
                java.sql.Blob photo = rs.getBlob("photo");
                FileOutputStream fos = new FileOutputStream("C:/target.jpg");
                fos.write(photo.getBytes(1,(int)photo.length()));
                fos.flush();
                fos.close();
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
