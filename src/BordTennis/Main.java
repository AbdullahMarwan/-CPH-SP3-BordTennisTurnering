package BordTennis;


import BordTennis.Data.FileIO;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        Scanner sc = new Scanner(System.in);
        FileIO fileIO = new FileIO();
        UI ui = new UI();

        if (fileIO.isDataAvailable()) {
            tournament.addPlayersFromData();
        } else {
            tournament.initializeTeams();
        }

        System.out.println("Enter OPTIONS by pressing 'O'\n");
        if (sc.nextLine().equalsIgnoreCase("O")) {
            tournament.Options(ui.getUserInput());
        }

        tournament.playMatches();
    }
}
