import java.util.Scanner;

public class UserInteraction {
    Scanner receive;
    int[][] grid = new int[3][3];
    Board gameBoard;

    public UserInteraction(Scanner reader, Board board) {
        receive = reader;
        gameBoard = board;
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = counter;
                counter++;
            }
        }
    }


    int askUser(){
        if(gameBoard.getIsX()) System.out.print("It is X's turn. ");
        else System.out.print("It is O's turn. ");
        System.out.println("What space?");
        for (int i = 0; i < 3; i++) {
            System.out.println();
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                int number = grid[i][j];
                System.out.print(number + " " + "| ");
            }
        }
        System.out.println();
        System.out.print(">");
        return receive.nextInt();
    }

}
