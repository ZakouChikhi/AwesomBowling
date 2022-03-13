package awesomeBowling.facade;

import awesomeBowling.exception.GameOverException;
import awesomeBowling.exception.IncorrectPinsDownException;

public interface BowlingGame {

    void roll(int pinsDown) throws IncorrectPinsDownException, GameOverException;
    int score();

    void checkRoll(int pinsDown, int current) throws IncorrectPinsDownException, GameOverException;

    String reviewScore();

    void initialFrames();

    int getCurrent();


}
