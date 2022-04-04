package BordTennis.Data;

import java.util.ArrayList;

public interface IO {

    ArrayList<String> readGameData(String path);

    ArrayList<String> readTeamData(String path);

    ArrayList<String> readTournamentData(String path);

    void saveGameData(String path);

    void saveTeamData(String path);

    void saveTournamentData(String path);

}
