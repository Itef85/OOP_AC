package As4_Player;

public class As4_Stats {

    private String name;

    private String playerID;

    private int goals;


    public As4_Stats(String n, String id, int g) {
        name = n;
        playerID = id;
        goals = g;
    }//crop

    public String toString(){
        return name + ", " + playerID + ", " + goals;
    }//toString


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }
}//As4_Stats
