package BordTennis;


import BordTennis.Data.FileIO;

public class Main {


    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        FileIO fileIO = new FileIO();

        //tournament.Options();

        if (fileIO.isDataAvailable()) {
            tournament.addPlayersFromData();
        } else {
            tournament.initializeTeams();
        }
        tournament.playMatches();

    }
}
