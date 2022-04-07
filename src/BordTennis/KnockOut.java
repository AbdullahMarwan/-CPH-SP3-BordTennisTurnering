package BordTennis;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;

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
            switch (roundNr) {
                case 1 -> {
                    if (!t.isKnockOut) {
                        roundOne.add(t);
                    }
                }
                case 2 -> {
                    if (!t.isKnockOut) {
                        quarterFinal.add(t);
                    }
                }
                case 3 -> {
                    if (!t.isKnockOut) {
                        semiFinal.add(t);
                    }
                }
                case 4 -> {
                    if (!t.isKnockOut) {
                        finalGame.add(t);
                    }
                }
            }

        }
    }

    public void gamePlan() {

    }

}