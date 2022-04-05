package BordTennis;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    Scanner sc = new Scanner(System.in);
    String playerName;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public void createPlayer(ArrayList<Player> arrayList) {
        System.out.println("What's your name?\n");
        String name = sc.nextLine();
        Player player = new Player(name);
        arrayList.add(player);
    }


    @Override
    public String toString() {
        return "Name: " + playerName;
    }
}
