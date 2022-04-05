package BordTennis;

import java.util.ArrayList;
import java.util.Scanner;

public class Team {
    Scanner sc = new Scanner(System.in);
    String teamName;
    ArrayList<Player> team = new ArrayList<>();
    Player player;


    public Team(String teamName) {
        this.teamName = teamName;
    }

    public void createTeam() {
        System.out.println("Current team name: " + teamName);
        System.out.println("What's your team name?\n");
        teamName = sc.nextLine();
        System.out.println("What's the team size?\n");
        int teamSize = sc.nextInt();
        //try {
            for (int i = Math.abs(teamSize - 5); i <= 5; i++) {
                player.createPlayer(team);
                System.out.println(player);

            }


            //Team team = new Team(teamName);
            /*
        } catch (NullPointerException e) {
            System.out.println("Invalid team size - must be between 2-5.");
        }
             */
    }

    public String getTeamName()
    {
        return teamName;
    }

    public ArrayList<Player> getTeam() {
        return team;
    }
}
