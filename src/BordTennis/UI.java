package BordTennis;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {

    public String getUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nIn OPTIONS you have 4 choices: \n" +
                "1: Show all teams signed up\n" +
                "2: Show all team's positions in the tournament\n" +
                "3: Show game program\n" +
                "4: Show when next game is played\n" +
                "5: Play the next games\n" +
                "6: Saves team info to DB/File\n" +
                "7: Quit and save Tournament Data\n");
        return sc.nextLine();
    }

    public void teamList(ArrayList<Team> arrayList) {
        for (Team a : arrayList) {
            System.out.println(a);
        }
    }
}