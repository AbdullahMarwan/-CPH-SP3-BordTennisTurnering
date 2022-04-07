package BordTennis;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;

public class KnockOut {

    public void addPointsToWinner(ArrayList<Team> teamList) {
        for (Team t : teamList) {
            if (t.win) {
                t.points += 2;
                t.win = false;
            }
        }
    }
}