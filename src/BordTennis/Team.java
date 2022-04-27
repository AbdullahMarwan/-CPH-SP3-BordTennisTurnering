package BordTennis;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Team {
    Scanner sc = new Scanner(System.in);
    String teamName;
    ArrayList<Player> players = new ArrayList<>();
    int goalPoints = 0;
    int totalTournamentPoints = 0;
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
        int teamSize;
        try {
            var input = sc.nextLine();
            teamSize = Integer.parseInt(input);
            if (teamSize <= 5 && teamSize >= 2) {
                for (int i = 0; i < teamSize; i++) {
                    Player player = new Player();
                    players.add(player);
                }
            } else {
                System.out.println("\nInvalid team size - must be between 2-5.");
                createTeam();
            }
        } catch (NumberFormatException e) {
            System.out.println("\nInvalid team size - must be between 2-5.");
            createTeam();
        }
    }

    public void addPlayersToTeam(Player player) {
        players.add(player);
    }

    public int getGoalPoints() {
        return goalPoints;
    }

    public void setGoalPoints(int goalPoints) {
        this.goalPoints = goalPoints;
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

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int getTotalTournamentPoints() {
        return totalTournamentPoints;
    }

    public void setTotalTournamentPoints(int totalTournamentPoints) {
        this.totalTournamentPoints = totalTournamentPoints;
    }

    public String toString() {
        String string = "\nTeam name: " + this.teamName + "\n";
        for (Player p : players) {
            string += "Player name: " + p.playerName + "\n";
        }
        string += "Team points: " + goalPoints;
        string += "\nIs team Knockout? " + isKnockOut;

        return string;
    }

    public int comparePoints(Team team) {
        int res = 0;
        if (this.goalPoints > team.goalPoints) {
            res = -1;
        }
        if (this.goalPoints < team.goalPoints) {
            res = 1;
        }
        return res;
    }
}
