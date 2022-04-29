package BordTennis;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBConnector {
    static Connection connection = null;
    public int methodChoiceDB = 1;
    UI ui = new UI();
    String JdbcUrl = "jdbc:mysql://localhost/BordfodboldHold?" + "autoReconnect=true&useSSL=false";
    String username = "root";
    String password = "NY9hcW7DAZ!+-qg1:]G6";

    public void createConnection(ArrayList<Team> teamList) {
        System.out.println("Entered Create Connection");

        try {
            connection = DriverManager.getConnection(JdbcUrl, username, password);

            switch (methodChoiceDB) {

                case 1 -> { //PrintOut DBData on Screen
                    printOutDBData(teamList);
                    connection.close();
                }

                case 2 -> { //Load the Previous DB Data
                    loadPreviousDBData();
                    connection.close();
                }

                case 3 -> { //Save Team data to DB
                    System.out.println("Inside of SaveTeamList");
                    insertTeamToDB(teamList);
                    connection.close();
                }

                case 4 -> { //Clean DB Data
                    cleanDBData();
                    connection.close();
                }

            }

            //connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Finished DBConnect");
    }

    public void cleanDBData() {

        String query1 = "TRUNCATE TABLE team";
        try {
            PreparedStatement statement1 = connection.prepareStatement(query1);

            statement1.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query2 = "TRUNCATE TABLE playerName";
        try {
            PreparedStatement statement2 = connection.prepareStatement(query2);

            statement2.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void printOutDBData(ArrayList<Team> teamList) {
        ui.teamList(teamList);
    }

    public ArrayList<Team> loadPreviousDBData() throws SQLException {
        connection = DriverManager.getConnection(JdbcUrl, username, password);
        ArrayList<Team> teamList = new ArrayList<>();

        String selectQueryTeam = "SELECT * FROM team ORDER BY id";
        String selectQueryPlayer = "SELECT * FROM playerName ORDER BY id";

        try {
            Statement statement = connection.createStatement();

            for (int k = 0; k < 1; k++) {
                statement.execute(selectQueryTeam);
                ResultSet result1 = statement.getResultSet();

                result1.next();
                String teamName1 = result1.getString("name");
                Team team1 = new Team(teamName1);
                loadTeamDB(teamList, result1, team1);

                result1.next();
                String teamName2 = result1.getString("name");
                Team team2 = new Team(teamName2);
                loadTeamDB(teamList, result1, team2);

                result1.next();
                String teamName3 = result1.getString("name");
                Team team3 = new Team(teamName3);
                loadTeamDB(teamList, result1, team3);

                result1.next();
                String teamName4 = result1.getString("name");
                Team team4 = new Team(teamName4);
                loadTeamDB(teamList, result1, team4);

                result1.next();
                String teamName5 = result1.getString("name");
                Team team5 = new Team(teamName5);
                loadTeamDB(teamList, result1, team5);

                result1.next();
                String teamName6 = result1.getString("name");
                Team team6 = new Team(teamName6);
                loadTeamDB(teamList, result1, team6);

                result1.next();
                String teamName7 = result1.getString("name");
                Team team7 = new Team(teamName7);
                loadTeamDB(teamList, result1, team7);

                result1.next();
                String teamName8 = result1.getString("name");
                Team team8 = new Team(teamName8);
                loadTeamDB(teamList, result1, team8);


                statement.execute(selectQueryPlayer);
                ResultSet result2 = statement.getResultSet();

                result2.next();
                loadPlayerDB(teamList, result2, team1);

                result2.next();
                loadPlayerDB(teamList, result2, team2);

                result2.next();
                loadPlayerDB(teamList, result2, team3);

                result2.next();
                loadPlayerDB(teamList, result2, team4);

                result2.next();
                loadPlayerDB(teamList, result2, team5);

                result2.next();
                loadPlayerDB(teamList, result2, team6);

                result2.next();
                loadPlayerDB(teamList, result2, team7);

                result2.next();
                loadPlayerDB(teamList, result2, team8);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ui.teamList(teamList);
        return teamList;
    }

    public void loadTeamDB(ArrayList<Team> teamList, ResultSet result1, Team team) throws SQLException {
        teamList.add(team);
        team.setTotalTournamentPoints(result1.getInt("score"));
        team.setGoalPoints(result1.getInt("goals"));
        team.setKnockOut(Boolean.parseBoolean(result1.getString("isknockedout")));
    }

    public void loadPlayerDB(ArrayList<Team> teamList, ResultSet result2, Team team) throws SQLException {
        for (int i = 1; i < 6; i++) {
            if (result2.getString("playerName" + i) != null) {
                String playerName = result2.getString("playerName" + i);
                Player player = new Player(playerName);
                team.addPlayersToTeam(player);
            }
        }

    }


    public void saveDataToDB(ArrayList<Team> teamList) {
        methodChoiceDB = 3;
        System.out.println("Choice: " + methodChoiceDB);
        System.out.println("Teamlist (savedata)" + teamList);
        createConnection(teamList);
    }

    public void insertTeamToDB(ArrayList<Team> teamList) throws SQLException {
        String name;
        int score;
        int goals;
        boolean isKnockedOut;

        for (Team t : teamList) {
            name = t.teamName;
            score = t.totalTournamentPoints;
            goals = t.goalPoints;
            isKnockedOut = t.isKnockOut;

            String insertTeam = "INSERT INTO team (name, score, goals, isknockedout) VALUES ('" + name + "','" + score + "','" + goals + "','" + isKnockedOut + "')";
            try {
                PreparedStatement query1 = connection.prepareStatement(insertTeam);
                var query1Result = query1.executeUpdate();
            } catch (SQLException a) {
                a.printStackTrace();
            }

            String insertPlayers;

            switch (t.players.size()) {
                case 2 -> {
                    insertPlayers = "INSERT INTO playerName (playerName1, playerName2) VALUES ('" + t.players.get(0).playerName + "','" + t.players.get(1).playerName + "')";
                    PreparedStatement query2 = connection.prepareStatement(insertPlayers);
                    var query2Result = query2.executeUpdate();
                }
                case 3 -> {
                    insertPlayers = "INSERT INTO playerName (playerName1, playerName2, playerName3) VALUES ('" + t.players.get(0).playerName + "','" + t.players.get(1).playerName + "','" + t.players.get(2).playerName + "')";
                    PreparedStatement query2 = connection.prepareStatement(insertPlayers);
                    var query2Result = query2.executeUpdate();
                }
                case 4 -> {
                    insertPlayers = "INSERT INTO playerName (playerName1, playerName2, playerName3, playerName4) VALUES ('" + t.players.get(0).playerName + "','" + t.players.get(1).playerName + "','" + t.players.get(2).playerName + "','" + t.players.get(3).playerName + "')";
                    PreparedStatement query2 = connection.prepareStatement(insertPlayers);
                    var query2Result = query2.executeUpdate();
                }
                case 5 -> {
                    insertPlayers = "INSERT INTO playerName (playerName1, playerName2, playerName3, playerName4, playerName5) VALUES ('" + t.players.get(0).playerName + "','" + t.players.get(1).playerName + "','" + t.players.get(2).playerName + "','" + t.players.get(3).playerName + "','" + t.players.get(4).playerName + "')";
                    PreparedStatement query2 = connection.prepareStatement(insertPlayers);
                    var query2Result = query2.executeUpdate();
                }
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

