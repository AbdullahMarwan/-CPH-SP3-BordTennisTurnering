package BordTennis;


public class Main {


    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        //tournament.Options();

        tournament.initializeTeams();
        tournament.playMatches();

    }
}
