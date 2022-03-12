package awesomeBowling.model;

public class Roll{

    private int pinsDown;
    private boolean isStrike;


    public Roll() {
        this.pinsDown=0;
        this.isStrike=false;
    }

    public int getPinsDown() {
        return pinsDown;
    }

    public void setPinsDown(int pinsDown) {
        if (pinsDown==10)
            isStrike = true;
        this.pinsDown = pinsDown;
    }

    public boolean isStrike() {
        return isStrike;
    }

    @Override
    public String toString() {
        return "awesomeBowling.model.Roll{" +
                "pinsDown=" + pinsDown +
                ", isStrike=" + isStrike +
                '}';
    }
}
