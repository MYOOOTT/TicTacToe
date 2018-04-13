import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {

        Board game = new Board();
        Scanner scan = new Scanner(System.in);
        UserInteraction oof = new UserInteraction(scan);

        while(game.checkWinner() == false) {
            game.displayBoard();
            int intendedSpace = oof.askUser();
            game.turn(intendedSpace);
        }
    }
}
