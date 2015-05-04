package src;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class Dice extends JDialog {

    private int randomNumber;
    private JLabel dice;
    private JLabel diceFace;

    public Dice(Frame owner) {
        super(owner, true);
        createComponents();
        this.pack();
    }

    public int getRandomNumber() {
        return randomNumber;
    }
    
    private void createComponents() {
        this.setSize(150, 150);
        this.setBackground(Color.BLACK);
        dice = createDice();
        this.add(dice, BorderLayout.NORTH);
        Timer timerDiceGif = new Timer(2000, e -> {
            dice.setVisible(false);
            diceFace.setVisible(true);
        });
        timerDiceGif.start();
        diceFace = createDiceFace();
        this.add(diceFace, BorderLayout.CENTER);
        randomNumber = calculateRandomNumber();
        selectFace();
        Timer timerClose = new Timer(3000, e -> dispose());
        timerClose.start();
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setVisible(true);
    }

    private int calculateRandomNumber() {
        Random rand = new Random(System.currentTimeMillis());
        return rand.nextInt((6 - 1) + 1) + 1;
    }

    private void selectFace() {
        switch (randomNumber){
            case 1:  setImageToLabel("src/resources/One.png", diceFace);
                break;
            case 2:  setImageToLabel("src/resources/Two.png", diceFace);
                break;
            case 3:  setImageToLabel("src/resources/Three.png", diceFace);
                break;
            case 4:  setImageToLabel("src/resources/Four.png", diceFace);
                break;
            case 5:  setImageToLabel("src/resources/Five.png", diceFace);
                break;
            case 6:  setImageToLabel("src/resources/Six.png", diceFace);
                break;
        }
    }

    private JLabel createDice() {
        dice = new JLabel();
        setImageToLabel("src/resources/Dice.gif", dice);
        dice.setHorizontalAlignment(JLabel.CENTER);
        dice.setVisible(true);
        return dice;
    }

    private void setImageToLabel(String image, JLabel label) {
        ImageIcon dice = new ImageIcon(image);
        label.setIcon(dice);
    }

    private JLabel createDiceFace() {
        diceFace = new JLabel();
        diceFace.setHorizontalAlignment(JLabel.CENTER);
        diceFace.setVisible(false);
        return diceFace;
    }
}