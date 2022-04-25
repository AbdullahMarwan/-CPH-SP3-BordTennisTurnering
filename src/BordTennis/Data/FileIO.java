package BordTennis.Data;

import BordTennis.Player;
import BordTennis.Tournament;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO implements IO {
    File gameData = new File("src/BordTennis/Data/GameData");

    public boolean isDataAvailable() throws FileNotFoundException {
        ArrayList<Boolean> data = new ArrayList<>();
        Scanner scan = new Scanner(gameData);
        while (scan.hasNextLine()) {
            data.add(Boolean.parseBoolean(scan.nextLine()));
        }

        if (data.get(0) == true) {
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<String> readGameData() {
        File file = new File("src/BordTennis/Data/TeamData");
        ArrayList<String> data = new ArrayList<>();

        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                data.add(scan.nextLine());
            }
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
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
    public void saveGameData() {
    }

    @Override
    public void saveTeamData(ArrayList<String> data) {
        try {
            FileWriter myWriter = new FileWriter("src/BordTennis/Data/TeamData");
            boolean header = true;
            for(String s : data)
            {
                if (s.contains("Team") && header == false) {
                    header = true;
                    myWriter.write("\n");
                }
                else
                {
                    header = false;
                }
                myWriter.write(s);
            }
            // myWriter.write(String.valueOf(data));
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occurred.");
        }
    }

    @Override
    public void saveTournamentData(String path) {

    }
}
