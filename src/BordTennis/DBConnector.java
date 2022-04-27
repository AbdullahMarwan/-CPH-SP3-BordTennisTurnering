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
        String name;
        int score;
        int goals;

        //System.out.println("name" + name);

        System.out.println("T Teamlist: (DBC) " + teamList.size());
        System.out.println("T Teamlist: (DBC) " + teamList);

        for (Team t : teamList) {
            name = t.teamName;
            score = t.totalTournamentPoints;
            goals = t.goalPoints;

            System.out.println("/////////////");

            System.out.println(name);
            System.out.println(score);
            System.out.println(goals);

            String insertTeam = "INSERT INTO team (name, score, goals) VALUES (name,score,goals)";
            try {
                PreparedStatement query1 = connection.prepareStatement(insertTeam);
                var query1Result = query1.executeUpdate();
                System.out.println("Query1Result: " + query1Result);
            } catch (SQLException a) {
                a.printStackTrace();
            }
        }
    }


}

