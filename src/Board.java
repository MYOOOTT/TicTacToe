
public class Board {
    private boolean winner;
    private Square[][] gameBoard;
    boolean isX;
    char winningPlayer;

    public Board() {
        isX = true;
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
            System.out.print("| ");
            for(int j = 0; j < 3; j++) {
                char space = gameBoard[i][j].getSpace();
                System.out.print(space + " |");
            }
            System.out.println();
        }
        System.out.println();
    }

    boolean checkWinner() {
        return checkRows() || checkColumns() || checkDiagonals();
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
            if (winCounter == 3) {
                rowWinner = true;
                winningPlayer = winChar;
            }
        }
        return rowWinner;
    }

    boolean checkColumns() {
        boolean columnWinner = false;
        for (int column = 0; column < 3; column++) {
            int winCounter = 0;
            char winChar = gameBoard[0][column].getSpace();
            for (int row = 0; row < 3; row++){
                if (winChar == ' ') // go to next column if first space is nothing
                    break;
                if (gameBoard[row][column].getSpace() == winChar)
                    winCounter++;
            }
            if (winCounter == 3) {
                columnWinner = true;
                winningPlayer = winChar;
            }
        }
        return columnWinner;
    }

    boolean checkDiagonals() {
        boolean diagonalWinner = false;
        int winCounter = 0;
        for (int row = 0; row < 3; row++){ //checking diagonal line topleft > bottomright

            char winChar = gameBoard[0][0].getSpace();
            if(winChar == ' ')
                break;

            if(gameBoard[row][row].getSpace() == winChar)
                winCounter++;

            if (winCounter == 3) {
                winningPlayer = winChar;
                return true;
            }
        }

        winCounter = 0;

        if (diagonalWinner == false) {//if the first pass comes up with nothing
            int column = 0;
            for (int row = 2; row > -1; row--){ //checking diagonal line bottomleft > topright
                char winChar = gameBoard[2][0].getSpace();
                if(winChar == ' ')
                    break;

                if(gameBoard[row][column].getSpace() == winChar)
                    winCounter++;
                column++;

                if (winCounter == 3)
                    winningPlayer = winChar;
                    return true;

            }
        }
        return false;
    }

    void turn(int index) {
        System.out.println();
        int row = index / 3;
        int column = index % 3;
        char existingSpace = getTile(row, column);
        if (existingSpace == 'X' || existingSpace == 'O') {
            System.out.println("Sorry, existing space already! Try again.");
        } else {
            if (isX) {
                gameBoard[row][column].changeState(1);
                isX = !isX;
            } else {
                gameBoard[row][column].changeState(-1);
                isX = !isX;
            }
        }
    }

    char getTile (int row, int column){
        return gameBoard[row][column].getSpace();
    }

    char getWinChar() {
        return winningPlayer;
    }

    boolean getIsX(){
        return isX;
    }

}
