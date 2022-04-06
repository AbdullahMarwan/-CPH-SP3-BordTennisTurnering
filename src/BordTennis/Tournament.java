package BordTennis;

import java.util.ArrayList;

public class Tournament {
    UI ui = new UI();
    ArrayList<Team> teamList = new ArrayList<>();

    public void initializeTeams(){
        Team team1 = new Team("Team1");
        Team team2 = new Team("Team2");
        Team team3 = new Team("Team3");
        Team team4 = new Team("Team4");
        Team team5 = new Team("Team5");
        Team team6 = new Team("Team6");
        Team team7 = new Team("Team7");
        Team team8 = new Team("Team8");

        team1.createTeam();
        teamList.add(team1);

        ui.teamList(teamList); //Quick debug

        team2.createTeam();
        teamList.add(team2);

        ui.teamList(teamList); //Quick debug

        team3.createTeam();
        teamList.add(team3);
        team4.createTeam();
        teamList.add(team4);
        team5.createTeam();
        teamList.add(team5);
        team6.createTeam();
        teamList.add(team6);
        team7.createTeam();
        teamList.add(team7);
        team8.createTeam();
        teamList.add(team8);

        ui.teamList(teamList);

    }

    private void Options(int choice) {
        switch (choice) {
            case 1: // Show all teams signed up
                System.out.println("All teams signed up: ");
                ui.teamList(teamList);
                break;
            case 2: // Show all team's positions in the tournament
                System.out.println("Positions of following teams: ");
                break;

            case 3: //Show game program where all teams are shown and when they have to play
                System.out.println("Overview of entire game program: ");
                break;

            case 4: //Show when next game is played
                System.out.println("Next game: ");
                break;

            case 5: //Change team name
                System.out.println("Change team name from: " + " to: " + " ");

                break;
        }

    }

}
