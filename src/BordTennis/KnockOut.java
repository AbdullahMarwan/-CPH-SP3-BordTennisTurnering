package BordTennis;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class KnockOut {
    ArrayList<Team> quarterFinal = new ArrayList<>();
    ArrayList<Team> semiFinal = new ArrayList<>();
    ArrayList<Team> finalGame = new ArrayList<>();
    private int roundNr = 1;

    public void addPointsToWinner(ArrayList<Team> teamList) {
        for (Team t : teamList) {
            if (t.win) {
                t.totalTournamentPoints += 2;
                t.win = false;
            }
        }
    }

    //Method to add each NON-knockouted team to the next rounds
    public void addTeamsToRounds(ArrayList<Team> teamList) {
        for (Team t : teamList) {
            if (!t.isKnockOut) {
                switch (roundNr) {
                    case 1 -> quarterFinal.add(t);
                    case 2 -> semiFinal.add(t);
                    case 3 -> finalGame.add(t);
                }
            }
        }
    }

    public void selectMatch() {
        switch (roundNr) {
            case 1 -> {
                System.out.println("Current round: Quarter Finals");
                playMatch(quarterFinal);
            }
            case 2 -> {
                System.out.println("Current round: Semi Finals");
                playMatch(semiFinal);
            }
            case 3 -> {
                System.out.println("Current round: The Finale");
                playMatch(finalGame);
            }
        }
    }

    public void playMatch(ArrayList<Team> teams) {
        if (teams.size() == 2) {
            teamFight(teams.get(0), teams.get(1));
        } else {
            for (int i = 0; i < teams.size(); i = i + 2) {
                teamFight(teams.get(i), teams.get(i + 1));
            }
        }

        if (roundNr < 4) {
            roundNr++;
        }
    }

    public void teamFight(Team team1, Team team2) {
        assignPoints(team1);
        assignPoints(team2);
        String teamName = null;

        if (team1.getGoalPoints() == team2.getGoalPoints()) {
            System.out.println("Both teams ended in a draw, sudden death commences");

            int winningTeam = (int) (Math.random() * 1);

            if (winningTeam == 0) {
                team1Win(team1, team2);
                System.out.println(team1.teamName + " has won the sudden death");
            } else {
                team2Win(team1, team2);
                System.out.println(team2.teamName + " has won the sudden death");
            }
        } else if (team1.getGoalPoints() > team2.getGoalPoints()) {
            team1Win(team1, team2);
            teamName = team1.getTeamName();
        } else {
            team2Win(team1, team2);
            teamName = team2.getTeamName();
        }

        System.out.println("Match Results: ");
        System.out.println(team1.getTeamName() + " goals scored: " + team1.getGoalPoints());
        System.out.println(team2.getTeamName() + " goals scored: " + team2.getGoalPoints());
        System.out.println(teamName + " is the Winner!\n");
    }

    public void team1Win(Team team1, Team team2) {
        team1.win = true;
        team2.isKnockOut = true;
    }

    public void team2Win(Team team1, Team team2) {
        team2.win = true;
        team1.isKnockOut = true;
    }

    public void assignPoints(Team team) {
        team.setGoalPoints((int) (Math.random() * 10));
    }

    public void gamePlan() {
        ArrayList<Team> tempArrayList = new ArrayList<>();

        switch (roundNr) {
            case 1 -> tempArrayList = quarterFinal;
            case 2 -> tempArrayList = semiFinal;
            case 3 -> tempArrayList = finalGame;
        }

        System.out.println("Round Number: " + roundNr);

        if (tempArrayList != finalGame) {
            for (int i = 0; i < tempArrayList.size(); i += 2) {
                System.out.println("( " + tempArrayList.get(i).teamName + " VS " + tempArrayList.get(i + 1).teamName + " )");
                System.out.println(tempArrayList.get(i) + "\tVS\t" + tempArrayList.get(i + 1));
            }
        } else {
            System.out.println("( " + tempArrayList.get(0).teamName + " VS " + tempArrayList.get(1).teamName + " )");
            System.out.println(tempArrayList.get(0) + "\tVS\t" + tempArrayList.get(1));
        }
    }

}