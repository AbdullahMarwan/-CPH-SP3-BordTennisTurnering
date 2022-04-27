package BordTennis;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    Tournament tournament = new Tournament();
    Connection connection = null;

    public void createConnection() {
        String JdbcUrl = "jdbc:mysql://localhost/BordfodboldHold?" + "autoReconnect=true&useSSL=false";
        String username = "root";
        String password = "NY9hcW7DAZ!+-qg1:]G6";

        try {

            connection = DriverManager.getConnection(JdbcUrl, username, password);
            insertTeamToDB();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Database Connected");
    }

    public void insertTeamToDB() {
        String teamName;
        int score;
        int goals;

        for (Team t : tournament.teamList) {
            teamName = t.teamName;
            score = t.totalTournamentPoints;
            goals = t.goalPoints;

            String insertTeam = "INSERT INTO team (name,score,goals) VALUES (teamName,score,goals)";
            try {
                PreparedStatement query1 = connection.prepareStatement(insertTeam);
                var query1Result = query1.executeUpdate();
                System.out.println(query1Result);
            } catch (SQLException a) {
                a.printStackTrace();
            }
        }
    }


}

