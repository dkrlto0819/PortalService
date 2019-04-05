package kr.ac.jejunu.userdao;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Data
public class jejuConnectionMaker implements ConnectionMaker {

    private String classname;
    private String url; // jdbc:mysql://192.168.0.54/jeju?serverTimezone=UTC
    private String username;
    private String password;

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(classname);
        return DriverManager.getConnection(url, username, password);
    }
}
