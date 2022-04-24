package BordTennis;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class KnockOut {
    ArrayList<Team> roundOne = new ArrayList<>();
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
                    case 1 -> roundOne.add(t);
                    case 2 -> quarterFinal.add(t);
                    case 3 -> semiFinal.add(t);
                    case 4 -> finalGame.add(t);
                }
            }
        }
    }

    public void selectMatch() {
        switch (roundNr) {
            case 1 -> playMatch(roundOne);
            case 2 -> playMatch(quarterFinal);
            case 3 -> playMatch(semiFinal);
            case 4 -> playMatch(finalGame);
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
        String teamName;

        if (team1.getGoalPoints() < team2.getGoalPoints()) {
            team1.win = true;
            team2.isKnockOut = true;
            teamName = team1.getTeamName();
        } else {
            team2.win = true;
            team1.isKnockOut = true;
            teamName = team2.getTeamName();
        }

        System.out.println("Match Results: ");
        System.out.println(team1.getTeamName() + "goals scored: " + team1.getGoalPoints());
        System.out.println(team2.getTeamName() + "goals scored: " + team2.getGoalPoints());
        System.out.println(teamName + " is the Winner!");
    }

    public void assignPoints(Team team) {
        team.setGoalPoints((int) (Math.random() * 10));
    }

    public void gamePlan() {
        ArrayList<Team> tempArrayList = new ArrayList<>();

        switch (roundNr) {
            case 1 -> tempArrayList = roundOne;
            case 2 -> tempArrayList = quarterFinal;
            case 3 -> tempArrayList = semiFinal;
            case 4 -> tempArrayList = finalGame;
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