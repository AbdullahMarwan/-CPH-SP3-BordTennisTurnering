package BordTennis;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBConnector {
    static Connection connection = null;
    public int methodChoiceDB = 1;
    UI ui = new UI();

    public void createConnection(ArrayList<Team> teamList) {
        String JdbcUrl = "jdbc:mysql://localhost/BordfodboldHold?" + "autoReconnect=true&useSSL=false";
        String username = "root";
        String password = "NY9hcW7DAZ!+-qg1:]G6";

        System.out.println("Entered Create Connection");

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
                    System.out.println("Inside of SaveTeamList");
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

    public void printOutDBData() {
        /*

        String selectQuery = "SELECT * FROM TEAM ORDER FROM ID";
        try {
            Statement statement = connection.createStatement();
            statement.execute(selectQuery);

            ResultSet result = statement.getResultSet();

            while (result.next()) {
                System.out.println("Name: " + result.getString("name"));
                System.out.println("ID: " + result.getLong("id") + "\n");
            }
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }


         */

    }

    public ArrayList<Team> loadPreviousDBData() {
        ArrayList<Team> teamList = new ArrayList<>();

        String selectQueryTeam = "SELECT * FROM team ORDER BY id";
        String selectQueryPlayer = "SELECT * FROM playerName ORDER BY id";

        try {
            Statement statement = connection.createStatement();


            for (int k = 0; k < 2; k++) {
                statement.execute(selectQueryTeam);
                ResultSet result1 = statement.getResultSet();

                result1.next();
                String teamName = result1.getString("name");
                Team team = new Team(teamName);
                teamList.add(team);

                team.setTotalTournamentPoints(result1.getInt("score"));
                team.setGoalPoints(result1.getInt("goals"));
                team.setKnockOut(Boolean.parseBoolean(result1.getString("isknockedout")));

                statement.execute(selectQueryPlayer);
                ResultSet result2 = statement.getResultSet();

                String playerName = null;

                result2.next();
                for (int i = 1; i < 6; i++) {

                    if (result2.getString("playerName" + i) != null) {
                        playerName = result2.getString("playerName" + i);
                        Player player = new Player(playerName);
                        team.addPlayersToTeam(player);
                    }
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ui.teamList(teamList);
        return teamList;
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

