package BordTennis;

import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static boolean saveToDatabase;
    public static boolean gameInProgress = true;

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("\nWELCOME TO THE YEARLY TABLETOP TENNIS TOURNAMENT!!\n");

        Tournament tournament = new Tournament();
        gameController gC = new gameController();
        Scanner sc = new Scanner(System.in);
        UI ui = new UI();

        System.out.println("Would you like to use the Database 'D' or the Written File 'F' ?\n");

        String input = sc.nextLine().toLowerCase(Locale.ROOT);

        if (input.equals("d")) {
            gC.dataBaseSetup(tournament, sc);
        } else if (input.equals("f")) {
            gC.fileIOSetup(tournament);
        } else {
            System.out.println("Error loading either");
        }

        while (gameInProgress) {
            System.out.println("Enter OPTIONS by pressing 'O'\n");
            if (sc.nextLine().equalsIgnoreCase("O")) {
                tournament.Options(ui.getUserInput());
            }
        }
    }

    public static boolean isGameInProgress() {
        return gameInProgress;
    }

    public static void setGameInProgress(boolean gameInProgress) {
        Main.gameInProgress = gameInProgress;
    }

    public static boolean isSaveToDatabase() {
        return saveToDatabase;
    }

    public static void setSaveToDatabase(boolean saveToDatabase) {
        Main.saveToDatabase = saveToDatabase;
    }
}
