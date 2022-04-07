package BordTennis.Data;

import BordTennis.Player;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO implements IO {
    ArrayList<Player> players = new ArrayList<>();
    File gameData = new File("src/Data/GameData.txt");

    public boolean isDataAvailable() {
        if (gameData != null) {
            return true;
        }

        return false;
    }

    @Override
    public ArrayList<String> readGameData() {
        if (isDataAvailable()) {
            File file = new File("src/Data/TeamData.txt");
            ArrayList<String> data = new ArrayList<>();

            try {
                Scanner scan = new Scanner(file);
                while (scan.hasNextLine()) {
                    data.add(scan.nextLine()); //“Egon: 30000”
                }
            } catch (
                    FileNotFoundException e) {
                e.printStackTrace();
            }
            return data;
        }
        return null;
    }

    @Override
    public ArrayList<String> readTeamData(String path) {
        return null;
    }

    @Override
    public ArrayList<String> readTournamentData(String path) {
        return null;
    }

    @Override
    public void saveGameData(String path) {

    }

    @Override
    public void saveTeamData(String path) {

    }

    @Override
    public void saveTournamentData(String path) {

    }
}
