package model;

public class Player {
    long id;
    String fName;
    String lName;
    long score;

    public Player(long id, String fName, String lName, long score) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }
}
