package src.model;

import java.util.ArrayList;

public class Moves {

    private final Square sourceSquare;
    private ArrayList<Square> squaresToMove;
    private final int diceRoll;
    
    public Moves(Square sourceSquare, int diceRoll) {
        this.sourceSquare = sourceSquare;
        this.squaresToMove = new ArrayList<>();
        this.diceRoll = diceRoll;
        rightMove(sourceSquare, diceRoll);
        leftMove(sourceSquare, diceRoll);
    }

    public ArrayList<Square> getSquaresToMove() {
        return squaresToMove;
    }
    
    private void rightMove(Square square, int positionsToMove) {
        Square previousSquare = square;
        Square actualSquare = square;
        if (actualSquare instanceof CheeseSquare && positionsToMove==diceRoll) moveFromACheese(actualSquare, previousSquare, positionsToMove);
        if (actualSquare instanceof MainSquare ){
            moveFromMainSquare(actualSquare, previousSquare, positionsToMove);
            return;
        }
        for (int i = 1; i <= positionsToMove; i++) {
            previousSquare = actualSquare;
            actualSquare = actualSquare.getRight();
            if (actualSquare instanceof CheeseSquare && positionsToMove - i > 0) moveFromACheese(actualSquare, previousSquare, positionsToMove - i);
            if (actualSquare instanceof MainSquare && positionsToMove - i > 0){
                moveFromMainSquare(actualSquare, previousSquare, positionsToMove - i);
                return;
            }
        }
        if (!squaresToMove.contains(actualSquare)) squaresToMove.add(actualSquare);
    }
    
    private void leftMove(Square square, int positionsToMove) {
        Square previousSquare;
        Square actualSquare = square;
        if(actualSquare instanceof MainSquare) return;
        for (int i = 1; i <= positionsToMove; i++) {
            previousSquare = actualSquare;
            actualSquare = actualSquare.getLeft();
            if (actualSquare instanceof CheeseSquare && positionsToMove - i > 0) moveFromACheese(actualSquare, previousSquare, positionsToMove - i);
        }
        if (!squaresToMove.contains(actualSquare)) squaresToMove.add(actualSquare);
    }

    private void moveFromACheese(Square actualSquare, Square previousSquare, int positionsToMove) {
        CheeseSquare cheeseSquare = (CheeseSquare) actualSquare;
        
        if (previousSquare.equals(cheeseSquare.getLeft())) {
            rightMove(cheeseSquare.getRight(), positionsToMove - 1);
            axisMoveFromCheese(positionsToMove, cheeseSquare);
        }
        else if (previousSquare.equals(cheeseSquare.getRight())){
            leftMove(cheeseSquare.getLeft(), positionsToMove - 1);
            axisMoveFromCheese(positionsToMove, cheeseSquare);
        }
        else if (previousSquare.equals(cheeseSquare.getMiddle())) {
            rightMove(cheeseSquare.getRight(), positionsToMove - 1);
            leftMove(cheeseSquare.getLeft(), positionsToMove - 1);
        }
        else if(previousSquare.equals(cheeseSquare)){
            leftMove(cheeseSquare.getLeft(), positionsToMove - 1);
            axisMoveFromCheese(positionsToMove, cheeseSquare);
            
        }
    }

    private void axisMoveFromCheese(int positionsToMove, CheeseSquare cheeseSquare) {
        rightMove(cheeseSquare.getMiddle(), positionsToMove - 1);
    }

    private void moveFromMainSquare(Square actualSquare, Square previousSquare, int positionsToMove) {
        MainSquare mainSquare = (MainSquare) actualSquare;
        if (previousSquare != mainSquare.getBlueAxis()) axisMoveFromMainSquare(mainSquare.getBlueAxis(), positionsToMove);
        if (previousSquare != mainSquare.getBrownAxis()) axisMoveFromMainSquare(mainSquare.getBrownAxis(), positionsToMove);
        if (previousSquare != mainSquare.getGreenAxis()) axisMoveFromMainSquare(mainSquare.getGreenAxis(), positionsToMove);
        if (previousSquare != mainSquare.getPurpleAxis()) axisMoveFromMainSquare(mainSquare.getPurpleAxis(), positionsToMove);
        if (previousSquare != mainSquare.getRedAxis()) axisMoveFromMainSquare(mainSquare.getRedAxis(), positionsToMove);
        if (previousSquare != mainSquare.getYellowAxis()) axisMoveFromMainSquare(mainSquare.getYellowAxis(), positionsToMove);
    }
    
    private void axisMoveFromMainSquare(Square axis, int positionsToMove){
        leftMove(axis, positionsToMove - 1);
    }
}