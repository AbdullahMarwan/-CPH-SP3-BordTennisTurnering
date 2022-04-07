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

    public void gamePlan() {

    }

}