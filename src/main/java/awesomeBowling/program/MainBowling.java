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

        System.out.println("New game is going start, Be ready !");
        Scanner scanner = new Scanner(System.in);

        for (int i=1; i<=22;i++){
            System.out.println("Please enter number of pins down");
            System.out.println("Roll number : "+  i);
            int numberPins = scanner.nextInt();
            try {
                bowlingGame.roll(numberPins);
            } catch (IncorrectPinsDownException e) {
                System.out.println(e.getMessage());
                i--;
            } catch (GameOverException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(bowlingGame.score());

        System.out.println(bowlingGame.reviewScore());



    }
}
