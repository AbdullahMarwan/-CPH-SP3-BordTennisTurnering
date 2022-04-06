package BordTennis;

import java.util.ArrayList;
import java.util.Scanner;

public class Team {
    Scanner sc = new Scanner(System.in);
    String teamName;
    ArrayList<Player> team = new ArrayList<>();

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public void createTeam() {
        System.out.println("Current team name is: " + teamName + ", do you want to change your team name?");

        if (sc.nextLine().equalsIgnoreCase("y")) {
            System.out.println("What's your new team name?\n");
            teamName = sc.nextLine();
            System.out.println("What's the team size?\n");
            int teamSize = sc.nextInt();
            if (teamSize <= 5 && teamSize >= 2) {
                for (int i = 0; i<teamSize; i++) {
                    //Player player = new Player().createPlayer(team);
                    Player player = new Player();
                    System.out.println(player);
                }
            } else {
                System.out.println("Invalid team size - must be between 2-5.\n");
                createTeam();
            }
        } else {
            System.out.println("What's the team size?\n");
            int teamSize = sc.nextInt();
            if (teamSize <= 5 && teamSize >= 2) {
                for (int i = 0; i<teamSize; i++) {
                    Player player = new Player();
                    System.out.println(player);
                }
            } else {
                System.out.println("Invalid team size - must be between 2-5.\n");
                createTeam();
            }
        }


        //Team team = new Team(teamName);
            /*
        } catch (NullPointerException e) {
            System.out.println("Invalid team size - must be between 2-5.");
        }
             */
    }

    public String getTeamName() {
        return teamName;
    }

    public ArrayList<Player> getTeam() {
        return team;
    }

    public String toString() {
        String string = "Team name: " + this.teamName+"\n";
        for (Player p:team)
        {
            string+="Player name: "+p.playerName+"\n";
        }
        return string;
    }
}
