package awesomeBowling.model;

public class Frame {

    private Roll firstRoll;
    private Roll secondRoll;
    private int scoreframe;
    private boolean isSpare;
    private boolean isStrike;

    public Frame() {
        this.firstRoll= new Roll();
        this.secondRoll=new Roll();
        this.scoreframe=0;
        this.isSpare=false;
        this.isStrike=false;
    }

    public boolean isSpare() {

        return isSpare;
    }

    public boolean isStrike() {
        return isStrike;
    }


    public Roll getFirstRoll() {
        return firstRoll;
    }


    public Roll getSecondRoll() {
        return secondRoll;
    }

    public int getScoreframe() {
        return scoreframe;
    }

    public void update(){
        if (this.firstRoll.isStrike() || this.secondRoll.isStrike())  this.isStrike = true;

        if (!this.isStrike &&
                ((this.firstRoll.getPinsDown()+this.secondRoll.getPinsDown()) ==10)){
            this.isSpare = true;
        }

        this.scoreframe=this.firstRoll.getPinsDown()+this.secondRoll.getPinsDown();

    }

}
