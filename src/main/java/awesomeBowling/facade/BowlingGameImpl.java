package awesomeBowling.facade;

import awesomeBowling.model.Frame;
import awesomeBowling.exception.GameOverException;
import awesomeBowling.exception.IncorrectPinsDownException;

public class BowlingGameImpl implements BowlingGame{

    private int current;
    private int totalGameScore;
    private Frame[] frames;
    private int maxFrames;

    public BowlingGameImpl() {
        this.current = 0;
        this.totalGameScore = 0;
        this.frames =new Frame[11];
        this.maxFrames=22;
        this.initialFrames();
    }

    @Override
    public void roll(int pinsDown) throws IncorrectPinsDownException, GameOverException {
        this.checkRoll(pinsDown, current);
        if(current%2==0){
            this.frames[current/2].getFirstRoll().setPinsDown(pinsDown);
            if (pinsDown==10){
                this.frames[current/2].update();
                current=current+2;
                return;
            }
        }else {
            this.frames[current/2].getSecondRoll().setPinsDown(pinsDown);

        }
        this.frames[current/2].update();
        current++;


    }

    @Override
    public void checkRoll(int pinsDown, int current) throws IncorrectPinsDownException, GameOverException {
        if (pinsDown<0 || pinsDown>10) {
            throw new IncorrectPinsDownException("Please chose a number between 0 and 10");
        }
        if (!(current%2==0) && this.frames[current/2].getFirstRoll().getPinsDown()>0 && pinsDown==10){
            throw new IncorrectPinsDownException(String.format(
                    "Please chose a number between %d and %d",
                    0 , 10-this.frames[current/2].getFirstRoll().getPinsDown()
            )
                    );
        }
        if (current >= this.maxFrames &&
                (!this.frames[10].isStrike() || !this.frames[10].isSpare())){
            throw new GameOverException("Game Over you can't roll anymore. Please wait for your score");

        }

    }

    @Override
    public int score() {

        for (int i=0; i< 9 ;i++){
            int j = i+1;
            this.totalGameScore+= this.frames[i].isStrike() ?
                    this.frames[i].getScoreframe()+ frames[j].getScoreframe() :
                    (this.frames[i].isSpare() ? this.frames[i].getScoreframe() +
                            this.frames[j].getFirstRoll().getPinsDown() :
                            this.frames[i].getScoreframe()
                            );
        }

        return this.getTotalGameScore();

    }

    @Override
    public String reviewScore() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i< frames.length-1;i++){
            if (frames[i].isStrike()){
                stringBuilder.append("X ");
                i++;
            }else if (frames[i].isSpare()){
                stringBuilder.append(frames[i].getFirstRoll().getPinsDown() + "/ ");
                i++;
            }else {
                stringBuilder.append(
                        frames[i].getScoreframe() == 0 ?
                         " --" :
                        frames[i].getScoreframe() + " --");
            }
        }
        return stringBuilder.toString();
    }



    public int getTotalGameScore() {
        return totalGameScore;
    }

    @Override
    public void initialFrames(){
        for (int i=0;i< frames.length ;i++){
            frames[i]= new Frame();
        }
    }

}
