package awesomeBowling.program;

import awesomeBowling.exception.GameOverException;
import awesomeBowling.exception.IncorrectPinsDownException;
import awesomeBowling.facade.BowlingGame;
import awesomeBowling.facade.BowlingGameImpl;

import java.util.Scanner;

public class MainBowling {
    public static void main(String[] args){

        // New Game
        BowlingGame bowlingGame = new BowlingGameImpl();
        Scanner scanner = new Scanner(System.in);

        // Entering the pins dow for each roll
        System.out.println("New game is going start, Be ready !");
        while (bowlingGame.getCurrent()<22){
            System.out.println("Please enter number of pins down");
            System.out.println("Roll number : "+ bowlingGame.getCurrent()+1);
            int numberPins = scanner.nextInt();
            try {
                bowlingGame.roll(numberPins);
            } catch (IncorrectPinsDownException e) {
                System.out.println(e.getMessage());
            } catch (GameOverException e) {
                System.out.println(e.getMessage());
                break;
            }
        }

        System.out.println("congratulation you have a total score of : " + bowlingGame.score());
        System.out.println(bowlingGame.reviewScore());



    }
}
