package src;

import java.awt.*;
import java.util.HashMap;

public class Player {

    private String name;
    private Color color;
    private int playerPositionX = 0, playerPositionY = 0;
    private HashMap <String, Boolean> cheeseWon;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
        initializeCheeseWon();
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public int getPlayerPositionX() {
        return playerPositionX;
    }

    public int getPlayerPositionY() {
        return playerPositionY;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setPlayerPositionX(int playerPositionX) {
        this.playerPositionX = playerPositionX;
    }

    public void setPlayerPositionY(int playerPositionY) {
        this.playerPositionY = playerPositionY;
    }
    
    public HashMap<String, Boolean> getCheeseWon() {
        return cheeseWon;
    }

    public void initializeCheeseWon(){
        cheeseWon = new HashMap<>();
        cheeseWon.put("arteyliteratura", false);
        cheeseWon.put("cienciaytecnologia", false);
        cheeseWon.put("deportes", false);
        cheeseWon.put("espectaculo", false);
        cheeseWon.put("geografia", false);
        cheeseWon.put("historia", false);
    }
}
