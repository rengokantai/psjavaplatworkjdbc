

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import javax.sql.PooledConnection;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Hernan Y.Ke on 2016/4/8.
 */
public class Pooling {
    public static void main(String[] args) throws SQLException{
        MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();
        ds.setServerName("localhost");
        ds.setPortNumber(3306);
        ds.setUser("root");
        ds.setPassword("root");
        PooledConnection pconn = ds.getPooledConnection();
        Connection conn= pconn.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from world.yd");
    }
}
