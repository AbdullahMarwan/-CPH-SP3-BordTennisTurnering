package BordTennis;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    String userInput;
    Scanner sc = new Scanner(System.in);

    public String getUserInput(String msg) {
        return userInput;
    }

    public void teamList(ArrayList<Team> arrayList) {
        for (Team a : arrayList) {
            System.out.println(a);
        }
    }

    public void inputFromUser() {
        sc.next();
    }
}