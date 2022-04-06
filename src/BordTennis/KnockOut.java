package BordTennis;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;

public class KnockOut {

    public void addPointsToWinner(ArrayList<Team> teamList) {
        for (Team t : teamList)
        {
            if (t.win)
            {
                t.points += 2;
                t.win = false;
            }
        }
    }

    public void teamPointPositions(ArrayList<Team> teamList)
    {
        ArrayList<Integer> ints = new ArrayList<>();
        for(Team t:teamList)
        {
            ints.add(t.points);
        }
        Collections.sort(ints);
        System.out.println("");
    }

}
