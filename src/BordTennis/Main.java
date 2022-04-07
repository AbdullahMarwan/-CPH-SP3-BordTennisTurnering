package BordTennis;


public class Main {


    public static void main(String[] args)
    {
        Tournament tournament = new Tournament();

        tournament.initializeTeams();

        tournament.teamPointPositions(tournament.teamList);
        //tournament.Options();
    }
}
