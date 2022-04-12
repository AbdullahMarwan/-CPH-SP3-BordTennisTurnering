package BordTennis;

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
                t.points += 2;
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

    public void playMatch() {

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