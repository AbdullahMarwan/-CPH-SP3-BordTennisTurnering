package BordTennis.Data;

import BordTennis.Tournament;

import java.util.ArrayList;

public interface IO {

    ArrayList<String> readGameData();

    ArrayList<String> readTeamData(String path);

    ArrayList<String> readTournamentData(String path);

    void saveGameData();

    void saveTeamData(ArrayList<String> data);

    void saveTournamentData(String path);

}
