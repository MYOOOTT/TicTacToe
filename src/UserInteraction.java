import java.util.Scanner;

public class UserInteraction {
    Scanner receive = new Scanner(System.in);
    int[][] grid = new int[3][3];

    public UserInteraction(Scanner reader) {
        receive = reader;

        int counter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = counter;
                counter++;
            }
        }
    }


    int askUser(){
        System.out.println("What space?");

        for (int i = 0; i < 3; i++) {
            System.out.println();
            for (int j = 0; j < 3; j++) {
                int number = grid[i][j];
                System.out.print(number + " " + "| ");
            }
        }
        System.out.println();
        return receive.nextInt();
    }

}
