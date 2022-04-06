package BordTennis;

import java.util.ArrayList;

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
