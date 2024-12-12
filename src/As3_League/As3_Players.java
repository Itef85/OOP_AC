package As3_League;

import java.util.ArrayList;
public class As3_Players {

    private String nameP;

    private String playerID;

    private int goalsScored;

    public As3_Players(String n, String id, int g) {

        nameP = n;
        playerID = id;
        goalsScored = g;


    };

    @Override
    public String toString() {
        return "As3_Players{" +
                "nameP='" + nameP + '\'' +
                ", playerID='" + playerID + '\'' +
                ", goalsScored=" + goalsScored +
                '}';
    }//to string

    public void setGoalsScored(int goalsScored) {
        this.goalsScored += goalsScored;
    }

    public String getNameP() {
        return nameP;
    }
}//calss
