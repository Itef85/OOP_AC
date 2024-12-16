package As3_League;

import java.util.ArrayList;
public class As3_Players {

    private String nameP;

    private int playerID;

    private int goalsScored;

    private String position;

    public As3_Players(String n, int id, int g, String p) {

        nameP = n;
        playerID = id;
        goalsScored = g;
        position = p;


    };

    @Override
    public String toString() {
        return "As3_Players{" +
                "nameP='" + nameP + '\'' +
                ", playerID='" + playerID + '\'' +
                ", goalsScored=" + goalsScored +
                ", position='" + position + '\'' +
                '}';
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored += goalsScored;
    }

    public String getNameP() {
        return nameP;
    }

    public int getPlayerID() {
        return playerID;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public String getPosition() {
        return position;
    }
}//calss
