package BordTennis;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBConnector {
    Tournament tournament = new Tournament();
    Connection connection = null;

    public void createConnection(ArrayList<Team> teamList) {
        String JdbcUrl = "jdbc:mysql://localhost/BordfodboldHold?" + "autoReconnect=true&useSSL=false";
        String username = "root";
        String password = "NY9hcW7DAZ!+-qg1:]G6";

        System.out.println("Start of create");

        try {

            connection = DriverManager.getConnection(JdbcUrl, username, password);
            System.out.println("Try");
            insertTeamToDB(teamList);
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQLexception");
        }

        System.out.println("Database Connected");
    }

    public void insertTeamToDB(ArrayList<Team> teamList) {
        String teamName = "Teamswd";
        int score;
        int goals;

        System.out.println("teamName" + teamName);

        System.out.println("T Teamlist: (DBC) " + teamList.size());
        System.out.println("T Teamlist: (DBC) " + teamList);

        for (Team t : teamList) {
            teamName = t.teamName;
            score = t.totalTournamentPoints;
            goals = t.goalPoints;

            System.out.println(teamName);
            System.out.println(score);
            System.out.println(goals);

            String insertTeam = "INSERT INTO team (name, score, goals) VALUES (teamName,score,goals)";
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

