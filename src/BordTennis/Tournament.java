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


}
