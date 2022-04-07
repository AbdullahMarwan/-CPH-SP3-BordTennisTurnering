package BordTennis;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    String userInput;
    Scanner sc = new Scanner(System.in);
    UI ui = new UI();
    KnockOut knockOut = new KnockOut();
    Tournament tournament = new Tournament();

    public void Options(int choice) {
        switch (choice) {
            case 1 -> { // Show all teams signed up
                System.out.println("All teams signed up: ");
                ui.teamList(tournament.teamList);
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

    public String getUserInput(String msg) {

        return userInput;
    }

    public void teamList(ArrayList<Team> arrayList) {
        for (Team a : arrayList) {
            System.out.println(a);
        }
    }

    public void inputFromUser() {
        sc.next();
    }
}