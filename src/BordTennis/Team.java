package BordTennis;

import java.util.ArrayList;
import java.util.Scanner;

public class Team
{
    Scanner sc = new Scanner(System.in);
    String teamName;
    ArrayList<Player> team;

    public Team(String teamName, ArrayList<Player> team)
    {
        this.teamName = teamName;
        this.team = team;
    }

    public void createTeam(ArrayList<Player> team)
    {
        String nameInput = sc.nextLine();
        System.out.println("What's your team name?\n");

        int intInput = sc.nextInt();
        System.out.println("How many players are on your team?\n");
        for(int i = 5; i<=intInput && i>2; i--)
        {
            Player player = new Player();
            player.createPlayer(team);
        }
    }

}
