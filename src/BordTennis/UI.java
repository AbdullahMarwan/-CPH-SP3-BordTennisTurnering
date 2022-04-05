package BordTennis;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {

    String userInput;
    Scanner sc = new Scanner(System.in);

    public String getUserInput(String msg) {
        return userInput;
    }

    public void teamList(ArrayList<Team> arrayList) {
        String input = sc.nextLine();
        System.out.println("What's your team name?\n");
        Team team = new Team(input);
        arrayList.add(team);
    }

    private void Options(int choice) {
        switch (choice) {
            case 1: // Show all teams signed up
                System.out.println("All teams signed up: ");
                break;
            case 2: // Show all team's positions in the tournament
                System.out.println("Positions of following teams: ");
                break;

            case 3: //Show game program where all teams are shown and when they have to play
                System.out.println("Overview of entire game program: ");
                break;

            case 4: //Show when next game is played
                System.out.println("Next game: ");
                break;

            case 5: //Change team name
                System.out.println("Change team name from: " + " to: " + " ");
                break;
        }

    }

    public void inputFromUser() {
        sc.next();

    }
}