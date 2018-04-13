
public class Square {
    private char space;

    public Square() {
        changeState(0);
    }
    public Square (int state) {
        changeState(state);
    }

    void changeState(int state){
        switch(state) {
            case 1: space = 'X'; break;
            case -1: space = 'O'; break;
            case 0: space = ' '; break;
        }
    }

    char getSpace() {
        return space;
    }
}
