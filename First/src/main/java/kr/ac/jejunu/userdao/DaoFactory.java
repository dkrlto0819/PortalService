package kr.ac.jejunu.userdao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
//import java.sql.Connection;
import java.sql.Driver;
//import java.sql.DriverManager;
//import java.sql.SQLException;

@Configuration
public class DaoFactory {
    @Value("${db.classname}")
    private String classname;
    @Value("${db.url}")
    private String url; // jdbc:mysql://192.168.0.54/jeju?serverTimezone=UTC
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    @Bean
    public UserDao userDao() {
        return new UserDao(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        try {
            dataSource.setDriverClass((Class<? extends Driver>) Class.forName(classname));
        } catch (ClassNotFoundException e) {
            throw  new RuntimeException(e);
        }
        dataSource.setUrl(url);
        dataSource.setPassword(password);
        dataSource.setUsername(username);
        return dataSource;
    }
    @Bean
    public UserDao getUserDao() {
        return new UserDao(dataSource());
    }

    @Bean
    public ConnectionMaker getConnectionMaker() {
        return new jejuConnectionMaker();
    }
}
