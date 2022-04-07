package BordTennis;

import java.util.ArrayList;

public class Tournament {
    UI ui = new UI();
    KnockOut knockOut = new KnockOut();
    ArrayList<Team> teamList = new ArrayList<>();

    public void initializeTeams(){
        Team team1 = new Team("Team1", 5);
        Team team2 = new Team("Team2", 8);
        Team team3 = new Team("Team3", 6);
        Team team4 = new Team("Team4",1);
        Team team5 = new Team("Team5",9);
        Team team6 = new Team("Team6",12);
        Team team7 = new Team("Team7",25);
        Team team8 = new Team("Team8",4);

        team1.teamMaker();
        teamList.add(team1);

        ui.teamList(teamList); //Quick debug

        team2.teamMaker();
        teamList.add(team2);

        ui.teamList(teamList); //Quick debug

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

    public void playMatches (){
         knockOut.addPointsToWinner(teamList);
    }

    public void Options(int choice) {
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

                //team1.changeTeamName();
                break;
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
        for(Team t: teamList)
        {
            System.out.println("Team "+t.teamName+" got "+t.points+" points.");
        }
    }
}
