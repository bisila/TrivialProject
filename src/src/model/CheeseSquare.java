package src.model;

public class CheeseSquare extends Square {
    private Square middle;

    public CheeseSquare(int id) {
        super(id);
    }
    
    public Square getMiddle() {
        return middle;
    }

    public void setMiddle(Square middle) {
        this.middle = middle;
    }

}