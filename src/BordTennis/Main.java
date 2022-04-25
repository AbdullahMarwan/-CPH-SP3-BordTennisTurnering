package BordTennis;

import BordTennis.Data.FileIO;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        boolean gameInProgress = true;
        System.out.println("\nWELCOME TO THE YEARLY TABLETOP TENNIS TOURNAMENT!!\n");

        Tournament tournament = new Tournament();
        Scanner sc = new Scanner(System.in);
        FileIO fileIO = new FileIO();
        UI ui = new UI();



        System.out.println("Would you like load the Database 'D' or the File 'F'\n");
        try {
            if (sc.nextLine().equalsIgnoreCase("D")) {
                tournament.Options(ui.getUserInput());
            } else if (sc.nextLine().equalsIgnoreCase("F")) {
                tournament.Options(ui.getUserInput());
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        if (fileIO.isDataAvailable()) {
            tournament.addPlayersFromData();
        } else {
            tournament.initializeTeams();
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
}
