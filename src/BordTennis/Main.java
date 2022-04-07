package BordTennis;


public class Main {


    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        //tournament.Options();

        tournament.addPlayersFromData();
        tournament.initializeTeams();
        tournament.playMatches();

    }
}
