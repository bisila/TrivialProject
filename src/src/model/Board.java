package src.model;

import java.util.ArrayList;
import src.Player;

public final class Board {

    private Square firstSquare, lastSquare;
    private final MainSquare mainSquare;
    private int squareId;
    private final ArrayList<Square> squaresList;
    private ArrayList<Player> players;
    private Player actualPlayer;
    private int actualPlayerPosition;

    public Board(ArrayList<Player> players) {
        this.mainSquare = new MainSquare(0);
        this.squaresList = new ArrayList<>();
        this.squareId = 1;
        this.players = players;
        this.actualPlayer = players.get(0);
        this.actualPlayerPosition = 0;
        squaresList.add(mainSquare);
        build();
        paintBoard();
    }

    public ArrayList<Square> getSquaresList() {
        return squaresList;
    }

    public Player getActualPlayer() {
        return actualPlayer;
    }

    public void setActualPlayer(Player actualPlayer) {
        this.actualPlayer = actualPlayer;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Square getFirstSquare() {
        return firstSquare;
    }

    public Square getLastSquare() {
        return lastSquare;
    }

    public MainSquare getMainSquare() {
        return mainSquare;
    }

    public int getActualPlayerPosition() {
        return actualPlayerPosition;
    }
    
    public void swapPlayer(){
        if (actualPlayerPosition == players.size() - 1){
            actualPlayerPosition = 0;
        } else {
            actualPlayerPosition++;
        }
        actualPlayer = players.get(actualPlayerPosition);
    }
    
    private void paintBoard() {
        setColorsForSquare(Color.historia, 8, 23, 40, 63, 78, 2, 20, 32, 44, 56, 68);
        setColorsForSquare(Color.deportes, 14, 37, 52, 75, 60, 6, 18, 30, 42, 54, 72);
        setColorsForSquare(Color.espectaculo, 11, 26, 34, 49, 66, 4, 16, 28, 46, 58, 70);
        setColorsForSquare(Color.cienciaytecnologia, 13, 21, 36, 53, 76, 3, 15, 33, 45, 57, 69);
        setColorsForSquare(Color.geografia, 10, 27, 50, 65, 73, 7, 19, 31, 43, 55, 67);
        setColorsForSquare(Color.arteyliteratura, 24, 39, 47, 62, 1, 5, 17, 29, 41, 59, 71);
    }

    public void setColorsForSquare(Color color, int... id) {
        for (int i = 0; i < id.length; i++) {
            getSquareById(id[i]).setColor(color);
        }
    }

    private void addTheFirstSquare(Square square) {
        this.firstSquare = square;
        this.firstSquare.setId(squareId);
        this.lastSquare = this.firstSquare;
        squaresList.add(square);
        squareId++;
    }

    private void buildOutsideSegment() {
        addCheeseSquare();
        addSquare(new NormalSquare(squareId));
        addSquare(new DiceSquare(squareId));
        addSquare(new NormalSquare(squareId));
        addSquare(new NormalSquare(squareId));
        addSquare(new DiceSquare(squareId));
        addSquare(new NormalSquare(squareId));
    }

    private void addCheeseSquare() {
        CheeseSquare cheeseSquare = new CheeseSquare(squareId);
        addSquare(cheeseSquare);

        Square normalSquare = new NormalSquare(squareId);
        cheeseSquare.setMiddle(normalSquare);
        normalSquare.setLeft(cheeseSquare);
        squaresList.add(normalSquare);
        squareId++;

        normalSquare = buildAxisSegment(normalSquare);

        linkMiddleSquare(normalSquare);
    }

    public Square getSquareById(int actualSquareId) {
        for (Square actualSquare : squaresList) {
            if (actualSquare.getId() == actualSquareId) {
                return actualSquare;
            }
        }
        return null;
    }

    private void addSquare(Square square) {
        if (squareId != 1) {
            lastSquare.setRight(square);
            square.setLeft(lastSquare);
            lastSquare = square;
            squaresList.add(square);
            squareId++;
        } else {
            addTheFirstSquare(square);
        }
    }

    private void build() {
        for (int i = 0; i < 6; i++) {
            buildOutsideSegment();
        }
        lastSquare.setRight(firstSquare);
        firstSquare.setLeft(lastSquare);
    }

    private Square buildAxisSegment(Square normalSquare) {
        Square nextNormalSquare;

        for (int i = 3; i < 8; i++) {
            nextNormalSquare = new NormalSquare(squareId);
            normalSquare.setRight(nextNormalSquare);
            nextNormalSquare.setLeft(normalSquare);
            squaresList.add(nextNormalSquare);
            squareId++;
            normalSquare = nextNormalSquare;
        }
        
        return normalSquare;
    }

    private void linkMiddleSquare(Square normalSquare) {
        switch (normalSquare.getId()) {
            case 7:
                mainSquare.setBrownAxis(normalSquare);
            case 20:
                mainSquare.setRedAxis(normalSquare);
            case 33:
                mainSquare.setBlueAxis(normalSquare);
            case 46:
                mainSquare.setYellowAxis(normalSquare);
            case 59:
                mainSquare.setGreenAxis(normalSquare);
            case 72:
                mainSquare.setPurpleAxis(normalSquare);
        }
        normalSquare.setRight(mainSquare);
    }
    
    public boolean canIMoveTo(int actualId, int number, int destinationId) {
        Moves moves = new Moves(getSquareById(actualId), number);
        return moves.getSquaresToMove().contains(getSquareById(destinationId));
    }
}
