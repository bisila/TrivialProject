package src.model;

public class MainSquare extends Square {
    private Square redAxis;
    private Square yellowAxis;
    private Square greenAxis;
    private Square brownAxis;
    private Square blueAxis;
    private Square purpleAxis;

    public MainSquare(int id) {
        super(id);
    }

    public Square getRedAxis() {
        return redAxis;
    }

    public void setRedAxis(Square redAxis) {
        this.redAxis = redAxis;
    }

    public Square getYellowAxis() {
        return yellowAxis;
    }

    public void setYellowAxis(Square yellowAxis) {
        this.yellowAxis = yellowAxis;
    }

    public Square getGreenAxis() {
        return greenAxis;
    }

    public void setGreenAxis(Square greenAxis) {
        this.greenAxis = greenAxis;
    }

    public Square getBrownAxis() {
        return brownAxis;
    }

    public void setBrownAxis(Square brownAxis) {
        this.brownAxis = brownAxis;
    }

    public Square getBlueAxis() {
        return blueAxis;
    }

    public void setBlueAxis(Square blueAxis) {
        this.blueAxis = blueAxis;
    }

    public Square getPurpleAxis() {
        return purpleAxis;
    }

    public void setPurpleAxis(Square purpleAxis) {
        this.purpleAxis = purpleAxis;
    }
}