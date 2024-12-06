package As3_League;

import java.util.ArrayList;

public class As3_Team {

    //2023-2024 season

    private String name;

    private String nickName;

    private String city;

    private String division;

    private int wins;

    private int loses;

    private int overTimeLoses;


    public As3_Team(String n, String nn, String c, String d, int w, int l, int o) {
        name = n;
        nickName = nn;
        city = c;
        division = d;
        wins = w;
        loses = l;
        overTimeLoses = o;

    }//crop

    public String toString(){
        return name + ", " + nickName + ", " + city + ", " + division + ", " + wins + ", " + loses + ", " + overTimeLoses;
    }//toString


    public void printMe(){
        System.out.println(name + " Nick Named " + nickName + " Play In " + city + " In The " + division + " Division With " + wins + " Wins And " + loses + " Loses And " + overTimeLoses + " Over Time Loses ");
    }

    public String getName() {
        return name;
    }

    public String getNickName() {
        return nickName;
    }

    public String getCity() {
        return city;
    }

    public String getDivision() {
        return division;
    }

    public int getWins() {
        return wins;
    }

    public int getLoses() {
        return loses;
    }

    public int getOverTimeLoses() {
        return overTimeLoses;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public void setWins(int wins) {
        this.wins += wins;
    }

    public void setLoses(int loses) {
        this.loses += loses;
    }

    public void setOverTimeLoses(int overTimeLoses) {
        this.overTimeLoses += overTimeLoses;
    }
}//class
