package homeWorkDatabase.conector;/*
 * Created by Alexsandr        15.05.2018
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private String url;
    private String logon;
    private String password;

    public ConnectionFactory(String url, String logon, String password) {
        this.url = url;
        this.logon = logon;
        this.password = password;
    }

    public Connection getconnection() {
        try {
            return DriverManager.getConnection(url, logon, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
