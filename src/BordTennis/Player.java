package BordTennis;

import java.util.Scanner;

public class Player {

    Scanner sc = new Scanner(System.in);
    String playerName;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public Player() {
        System.out.println("\nWhat's your name?");
        String name = sc.nextLine();
        this.playerName = name;
    }

    @Override
    public String toString() {
        return "Name: " + playerName;
    }
}
