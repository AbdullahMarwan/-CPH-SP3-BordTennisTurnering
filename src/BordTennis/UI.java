package BordTennis;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {

    String userInput;
    Scanner sc = new Scanner(System.in);

    public String getUserInput(String msg) {
        return userInput;
    }

    public void teamList(ArrayList<Team> arrayList){
        String input = sc.nextLine();
        System.out.println("What's your team name?\n");
        Team team = new Team(input);
        arrayList.add(team);
    }

    private void Options(int choice) {
        switch (choice){
            case 1: // Show all teams signed up

        }

    }

    public void inputFromUser() {
        sc.next();

    }
}