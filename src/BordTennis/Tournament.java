package BordTennis;

import BordTennis.Data.FileIO;

import java.util.ArrayList;

public class Tournament {
    UI ui = new UI();
    KnockOut knockOut = new KnockOut();
    ArrayList<Team> teamList = new ArrayList<>();
    FileIO fileIO = new FileIO();

    public void initializeTeams() {
        Team team1 = new Team("Team1");
        Team team2 = new Team("Team2");
        Team team3 = new Team("Team3");
        Team team4 = new Team("Team4");
        Team team5 = new Team("Team5");
        Team team6 = new Team("Team6");
        Team team7 = new Team("Team7");
        Team team8 = new Team("Team8");

        team1.teamMaker();
        teamList.add(team1);
        team2.teamMaker();
        teamList.add(team2);
        team3.teamMaker();
        teamList.add(team3);
        team4.teamMaker();
        teamList.add(team4);
        team5.teamMaker();
        teamList.add(team5);
        team6.teamMaker();
        teamList.add(team6);
        team7.teamMaker();
        teamList.add(team7);
        team8.teamMaker();
        teamList.add(team8);

        ui.teamList(teamList);
    }

    public void playMatches() {
        knockOut.playMatch();
        knockOut.addPointsToWinner(teamList);
        knockOut.addTeamsToRounds(teamList);
    }

    public void addPlayersFromData() {
        ArrayList<String> data;
        data = fileIO.readGameData();
        int amountOfPlayersInTeam = 0;

        for (String s : data) {
            System.out.println(s);
            String[] values = s.split(", ");

            String teamName = values[0];
            Team team = new Team(teamName);
            teamList.add(team);

            //Checks amount of players on a line in TeamData
            switch (values.length - 3) {
                case 2 -> amountOfPlayersInTeam = 2;
                case 3 -> amountOfPlayersInTeam = 3;
                case 4 -> amountOfPlayersInTeam = 4;
                case 5 -> amountOfPlayersInTeam = 5;
            }

            for (int i = 0; i < amountOfPlayersInTeam; i++) {
                Player player = new Player(values[i + 1]);
                team.addPlayersToTeam(player);
            }

            int teamPoints = Integer.parseInt(values[amountOfPlayersInTeam + 1]);
            team.setPoints(teamPoints);

            boolean isKnockOut = Boolean.parseBoolean(values[values.length - 1]);
            team.setKnockOut(isKnockOut);
        }

    }


    public void Options(String choice) {
        switch (choice) {
            case "1" -> { // Show all teams signed up
                System.out.println("All teams signed up: ");
                ui.teamList(teamList);
            }
            case "2" -> { // Show all team's positions in the tournament
                System.out.println("Positions of following teams: ");
                teamPointPositions(teamList);
            }
            case "3" -> { //Show game program where all teams are shown and when they have to play
                System.out.println("Overview of entire game program: ");
                knockOut.gamePlan();
            }
            case "4" -> //Show when next game is played
                    System.out.println("Next game: is played shortly");
            case "5" -> //Play match
                    playMatches();
        }
    }



    public void teamPointPositions(ArrayList<Team> teamList) {
        Team temp;
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < teamList.size() - 1; i++) {
                if (teamList.get(i).comparePoints(teamList.get(i + 1)) > 0) {
                    temp = teamList.get(i);
                    teamList.set(i, teamList.get(i + 1));
                    teamList.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
        for (Team t : teamList) {
            System.out.println("Team " + t.teamName + " got " + t.points + " points.");
        }
    }
}
