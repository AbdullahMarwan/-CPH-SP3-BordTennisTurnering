package BordTennis;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    String userInput;
    //KnockOut knockOut = new KnockOut();
    //Tournament tournament = new Tournament();

    /*
    public void Options(int choice) {
        switch (choice) {
            case 1 -> { // Show all teams signed up
                System.out.println("All teams signed up: ");
                teamList(tournament.teamList);
            }
            case 2 -> { // Show all team's positions in the tournament
                System.out.println("Positions of following teams: ");
                tournament.teamPointPositions(tournament.teamList);
            }
            case 3 -> { //Show game program where all teams are shown and when they have to play
                System.out.println("Overview of entire game program: ");
                knockOut.gamePlan();
            }
            case 4 -> //Show when next game is played
                    System.out.println("Next game: ");
            case 5 -> //Change team name
                    System.out.println("Change team name from: " + " to: " + " ");
            //team1.changeTeamName();
        }

    }
     */

    public String getUserInput() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println("\nIn OPTIONS you have 4 choices: \n" +
                "1: Show all teams signed up\n" +
                "2: Show all team's positions in the tournament\n" +
                "3: Show game program\n" +
                "4: Show when next game is played\n");
        return input;
    }

    public void teamList(ArrayList<Team> arrayList) {
        for (Team a : arrayList) {
            System.out.println(a);
        }
    }
}