package BordTennis;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBConnector {
    Connection connection = null;
    public int methodChoiceDB = 1;

    public void createConnection(ArrayList<Team> teamList) {
        String JdbcUrl = "jdbc:mysql://localhost/BordfodboldHold?" + "autoReconnect=true&useSSL=false";
        String username = "root";
        String password = "NY9hcW7DAZ!+-qg1:]G6";

        try {
            connection = DriverManager.getConnection(JdbcUrl, username, password);

            switch (methodChoiceDB) {

                case 1 -> { //PrintOut DBData on Screen
                    printOutDBData();
                }
                case 2 -> { //Load the Previous DB Data
                    loadPreviousDBData();
                }

                case 3 -> { //Save Team data to DB
                    insertTeamToDB(teamList);
                }

                case 4 -> { //Clean DB Data
                    cleanDBData();
                }

            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Database Connected");
    }

    public void cleanDBData() {

    }

    public void printOutDBData() {

    }

    public void loadPreviousDBData() {

    }

    public void saveDataToDB(ArrayList<Team> teamList) {
        methodChoiceDB = 4;
        createConnection(teamList);
    }

    public void insertTeamToDB(ArrayList<Team> teamList) {
        String name;
        int score;
        int goals;
        boolean isKnockedOut;

        for (Team t : teamList) {
            name = t.teamName;
            score = t.totalTournamentPoints;
            goals = t.goalPoints;
            isKnockedOut = t.isKnockOut;

            String insertTeam = "INSERT INTO team (name, score, goals, isknockedout) VALUES (?,?,?,?)";
            try {
                PreparedStatement query1 = connection.prepareStatement(insertTeam);
                query1.setString(1, name);
                query1.setString(2, String.valueOf(score));
                query1.setString(3, String.valueOf(goals));
                query1.setString(4, String.valueOf(isKnockedOut));

                var query1Result = query1.executeUpdate();
                //System.out.println("Query1Result: " + query1Result);
            } catch (SQLException a) {
                a.printStackTrace();
            }
        }
    }

    public int getMethodChoiceDB() {
        return methodChoiceDB;
    }

    public void setMethodChoiceDB(int methodChoiceDB) {
        this.methodChoiceDB = methodChoiceDB;
    }
}

