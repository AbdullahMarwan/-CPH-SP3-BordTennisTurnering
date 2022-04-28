package BordTennis;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBConnector {
    static Connection connection = null;
    public int methodChoiceDB = 1;

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

    public void loadPreviousDBData() {

        String selectQuery = "SELECT * FROM team ORDER BY id LIMIT 10";

        try {
            Statement statement = connection.createStatement();
            statement.execute(selectQuery);

            ResultSet result = statement.getResultSet();

            while (result.next()) {
                String teamName = result.getString("name");
                Team team = new Team(teamName);

                String playerName = result.getString("playerName1");
                Player player = new Player(playerName);

                team.setTotalTournamentPoints(result.getInt("score"));

                team.setGoalPoints(result.getInt("goals"));

                team.setKnockOut(Boolean.parseBoolean(result.getString("isknockedout")));

                System.out.println("name: " + result.getString("name"));
                System.out.println("Population: " + result.getLong("population") + "\n");
            }
            System.out.println(result);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public void saveDataToDB(ArrayList<Team> teamList) {
        methodChoiceDB = 3;
        System.out.println("Choice: " + methodChoiceDB);
        System.out.println("Teamlist (savedata)" + teamList);
        createConnection(teamList);
    }

    public void insertTeamToDB(ArrayList<Team> teamList) {
        String name;
        int score;
        int goals;
        boolean isKnockedOut;
        String playerName;

        System.out.println("Teamlist (insertDB)" + teamList);

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

                query1.executeUpdate();
                //System.out.println("Query1Result: " + query1Result);


            } catch (SQLException a) {
                a.printStackTrace();
            }


            String insertPlayers = "INSERT INTO playerName (playerName1, playerName2, playerName3, playerName4, playerName5) VALUES (?,?,?,?,?)";
            try {

                //String playerNameInc = "playerName";
                int counter = 1;

                PreparedStatement query2 = connection.prepareStatement(insertPlayers);
                for (Player p : t.players) {
                    //playerNameInc += counter;
                    playerName = p.playerName;


                    query2.setString(counter, playerName);

                    System.out.println("Current Counter: " + counter);


                    counter++;
                    System.out.println("New Counter: " + counter);
                }
                System.out.println("Counter outside loop: " + counter);
                counter = 1;

                query2.executeUpdate();


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

