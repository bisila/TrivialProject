package src.model;

public abstract class Square {
    private Square left;
    private Square right;
    private int id;
    private Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Square(int id) {
        this.id = id;
    }

    public Square getLeft() {
        return left;
    }

    public Square getRight() {
        return right;
    }

    public void setLeft(Square left) {
        this.left = left;
    }

    public void setRight(Square right) {
        this.right = right;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        final Square other = (Square) obj;
        return getId() == other.getId();
    }
}