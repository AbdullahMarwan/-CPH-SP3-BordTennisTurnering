package BordTennis;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static boolean saveToDatabase;
    public static int methodChoiceDB = 1;

    public static void main(String[] args) throws FileNotFoundException {
        boolean gameInProgress = true;
        System.out.println("\nWELCOME TO THE YEARLY TABLETOP TENNIS TOURNAMENT!!\n");

        Tournament tournament = new Tournament();
        Scanner sc = new Scanner(System.in);
        UI ui = new UI();

        System.out.println("Would you like to use the Database 'D' or the Written File 'F' ?\n");
        try {
            String input = sc.nextLine().toLowerCase(Locale.ROOT);

            if (input.equals("d")) {
                DBConnector dbConnector = new DBConnector();
                saveToDatabase = true;

                System.out.println("This is the current data in the Database");

                methodChoiceDB = 1;
                dbConnector.createConnection(tournament.teamList);

                System.out.println("To load it press 'L' or start a new 'N'\n");
                String input2 = sc.nextLine().toLowerCase(Locale.ROOT);

                if (input2.equals("l")) { //Load previous DB data
                    methodChoiceDB = 2;
                    dbConnector.createConnection(tournament.teamList);
                } else if (input2.equals("n")) { //Clean DB table and start initiliazing new teams
                    methodChoiceDB = 4;
                    dbConnector.createConnection(tournament.teamList);
                    tournament.initializeTeams();
                }

            } else if (input.equals("f")) {
                if (tournament.fileIO.isDataAvailable()) {
                    System.out.println("isDataAvailable d");
                    tournament.addPlayersFromData();
                } else {
                    System.out.println("initilize teams");
                    tournament.initializeTeams();
                }
            } else {
                System.out.println("mærkeligt");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        while (gameInProgress) {
            System.out.println("Enter OPTIONS by pressing 'O'\n");
            if (sc.nextLine().equalsIgnoreCase("O")) {
                tournament.Options(ui.getUserInput());
            }
        }

        try {
            FileWriter myWriter = new FileWriter("src/BordTennis/Data/TournamentData");
            myWriter.write(String.valueOf(tournament.teamList));
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public void saveDataToDB() {
        DBConnector dbConnector = new DBConnector();
        methodChoiceDB = 4;
        dbConnector.createConnection(tournament.teamList);
    }
}
