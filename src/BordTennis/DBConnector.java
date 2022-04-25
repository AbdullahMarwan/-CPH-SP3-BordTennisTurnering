package BordTennis;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    Connection connection = null;

    public void createConnection() {
        String JdbcUrl = "jdbc:mysql://localhost/BordfodboldHold?"+ "autoReconnect=true&useSSL=false";
        String username = "root";
        String password = "NY9hcW7DAZ!+-qg1:]G6";

        try {

            connection = DriverManager.getConnection(JdbcUrl, username, password);
            insertTeamToDB();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertTeamToDB() {
        String insertTeam = "INSERT INTO team (name,score,goals) VALUES ('TEST',3,2)";
        try {
            PreparedStatement query1 = connection.prepareStatement(insertTeam);
            var query1Result = query1.executeUpdate();
            System.out.println(query1Result);
        } catch (SQLException a) {
            a.printStackTrace();
        }
    }





}

