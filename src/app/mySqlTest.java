package app;

public class mySqlTest {
    private String name;
    private int timer;
    private int xp;

    public mySqlTest() {
    }

    public mySqlTest(int xp, int timer, String name) {
        this.xp = xp;
        this.timer = timer;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

}
