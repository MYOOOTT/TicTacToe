
public class Board {
    private boolean winner;
    private Square[][] gameBoard;
    boolean firstPlayerTurn;

    public Board() {
        firstPlayerTurn = true;
        winner = false;
        gameBoard = new Square[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                gameBoard[i][j] = new Square();
            }
        }
    }

    void displayBoard() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                char space = gameBoard[i][j].getSpace();
                System.out.print(space + " " + "| ");
            }
            System.out.println();
        }
        System.out.println();
    }

    boolean checkWinner() {
        return checkRows() || checkColumns();
    }

    boolean checkRows() {
        boolean rowWinner = false;
        for (int row = 0; row < 3; row++) {
            int winCounter = 0;
            char winChar = gameBoard[row][0].getSpace();
            for (int column = 0; column < 3; column++){
                if (winChar == ' ') // go to next row if first space is space
                    break;
                if (gameBoard[row][column].getSpace() == winChar)
                    winCounter++;
            }
            if (winCounter == 3)
                rowWinner = true;
        }
        return rowWinner;
    }

    boolean checkColumns() {
        boolean rowWinner = false;
        for (int column = 0; column < 3; column++) {
            int winCounter = 0;
            char winChar = gameBoard[0][column].getSpace();
            for (int row = 0; row < 3; row++){
                if (winChar == ' ') // go to next column if first space is space
                    break;
                if (gameBoard[row][column].getSpace() == winChar)
                    winCounter++;
            }
            if (winCounter == 3)
                rowWinner = true;
        }
        return rowWinner;
    }

    void turn(int index) {
        int row = index / 3;
        int column = index % 3;
        char existingSpace = getTile(row, column);
        System.out.println("row:" + row);
        System.out.println("column:" + column);
        if (existingSpace == 'X' || existingSpace == 'O') {
            System.out.println("Sorry, existing space already! Try again.");
        } else {
            if (firstPlayerTurn) {
                gameBoard[row][column].changeState(1);
                firstPlayerTurn = !firstPlayerTurn;
            } else {
                gameBoard[row][column].changeState(-1);
                firstPlayerTurn = !firstPlayerTurn;
            }
        }
    }

        char getTile (int row, int column){
            return gameBoard[row][column].getSpace();
        }


}
