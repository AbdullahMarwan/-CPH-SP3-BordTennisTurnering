package BordTennis;

import java.util.ArrayList;
import java.util.Scanner;

public class Team {
    Scanner sc = new Scanner(System.in);
    String teamName;
    ArrayList<Player> team = new ArrayList<>();
    int points = 0;
    boolean isKnockOut = false;
    boolean win = false;

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public void changeTeamName() {
        System.out.println("\nCurrent team name is: " + teamName + ", do you want to change your team name?\nPress Y for 'Yes', N for 'No':");

        if (sc.nextLine().equalsIgnoreCase("y")) {
            System.out.println("\nWhat's your new team name?");
            teamName = sc.nextLine();
        }
    }

    public void teamMaker() {
        changeTeamName();
        createTeam();
    }

    public void createTeam() {
        System.out.println("\nWhat's the team size?");
        int teamSize = sc.nextInt();
        if (teamSize <= 5 && teamSize >= 2) {
            for (int i = 0; i < teamSize; i++) {
                Player player = new Player();
                team.add(player);
            }
        } else {
            System.out.println("\nInvalid team size - must be between 2-5.");
            createTeam();
        }

    }

    public void addPlayersToTeam(Player player) {
        team.add(player);
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isKnockOut() {
        return isKnockOut;
    }

    public void setKnockOut(boolean knockOut) {
        isKnockOut = knockOut;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public String getTeamName() {
        return teamName;
    }

    public ArrayList<Player> getTeam() {
        return team;
    }

    public String toString() {
        String string = "\nTeam name: " + this.teamName + "\n";
        for (Player p : team) {
            string += "Player name: " + p.playerName + "\n";
        }
        string += "Team points: " + points;
        string += "\nIs team Knockout? " + isKnockOut;

        return string;
    }

    public int comparePoints(Team team) {
        int res = 0;
        if (this.points > team.points) {
            res = -1;
        }
        if (this.points < team.points) {
            res = 1;
        }
        return res;
    }
}
