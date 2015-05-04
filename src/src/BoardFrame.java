package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;
import src.model.Board;
import src.model.CheeseSquare;
import src.model.DiceSquare;
import src.model.MainSquare;
import src.model.NormalSquare;

public class BoardFrame extends javax.swing.JFrame {

    private final AskForm askForm;
    private final ArrayList<JButton> botones;
    private final ArrayList<JLabel> playersLabels;
    private int lastButtonPressedId;
    private int diceNumber;
    private final Board board;
    private JLabel jLabelPlaying,jLabelDice;

    public BoardFrame(Board board) {
        this.setResizable(false);
        this.lastButtonPressedId = 0;
        this.botones = new ArrayList<>();
        this.board = board;
        askForm = new AskForm();
        initComponents();
        jLabelPlaying = new JLabel();
        jLabelPlaying.setText(" JUGANDO: " + board.getPlayers().get(board.getActualPlayerPosition()).getName());
        jLabelPlaying.setFont(new Font("Times New Roman", Font.BOLD, 15));
        jLabelPlaying.setForeground(Color.WHITE);
        jLabelPlaying.setSize(320, 50);
        jLabel1.add(jLabelPlaying);
        jLabelPlaying.setVisible(true);
        jLabelDice = new JLabel();
        jLabelDice.setText(" DADO: " + diceNumber);
        jLabelDice.setFont(new Font("Times New Roman", Font.BOLD, 15));
        jLabelDice.setForeground(Color.WHITE);
        jLabelDice.setSize(320, 90);
        jLabel1.add(jLabelDice);
        jLabelDice.setVisible(true);
        this.playersLabels = new ArrayList<>();
        initializePlayerLabels();
        addEventToAllButtons();
        addButtonsToLocalArrayList();
        for (JButton boton : botones) {
            boton.setBorderPainted(false);
            boton.setContentAreaFilled(false);
        }
        showCheeses();
    }

    private void showCheeses() {
        for (JLabel playerLabel : playersLabels) {
            playerLabel.setVisible(false);
        }
        for (int i = 0; i < board.getPlayers().size(); i++) {
            playersLabels.get(i).setVisible(true);
        }
    }

    private void addEventToAllButtons() {
        SquareActionPerformed(Square0);
        SquareActionPerformed(Square1);
        SquareActionPerformed(Square2);
        SquareActionPerformed(Square3);
        SquareActionPerformed(Square4);
        SquareActionPerformed(Square5);
        SquareActionPerformed(Square6);
        SquareActionPerformed(Square7);
        SquareActionPerformed(Square8);
        SquareActionPerformed(Square9);
        SquareActionPerformed(Square10);
        SquareActionPerformed(Square11);
        SquareActionPerformed(Square12);
        SquareActionPerformed(Square13);
        SquareActionPerformed(Square14);
        SquareActionPerformed(Square14);
        SquareActionPerformed(Square15);
        SquareActionPerformed(Square16);
        SquareActionPerformed(Square17);
        SquareActionPerformed(Square18);
        SquareActionPerformed(Square19);
        SquareActionPerformed(Square20);
        SquareActionPerformed(Square21);
        SquareActionPerformed(Square22);
        SquareActionPerformed(Square23);
        SquareActionPerformed(Square24);
        SquareActionPerformed(Square25);
        SquareActionPerformed(Square26);
        SquareActionPerformed(Square27);
        SquareActionPerformed(Square28);
        SquareActionPerformed(Square29);
        SquareActionPerformed(Square30);
        SquareActionPerformed(Square31);
        SquareActionPerformed(Square32);
        SquareActionPerformed(Square33);
        SquareActionPerformed(Square34);
        SquareActionPerformed(Square35);
        SquareActionPerformed(Square36);
        SquareActionPerformed(Square37);
        SquareActionPerformed(Square38);
        SquareActionPerformed(Square40);
        SquareActionPerformed(Square41);
        SquareActionPerformed(Square42);
        SquareActionPerformed(Square43);
        SquareActionPerformed(Square44);
        SquareActionPerformed(Square45);
        SquareActionPerformed(Square46);
        SquareActionPerformed(Square47);
        SquareActionPerformed(Square48);
        SquareActionPerformed(Square49);
        SquareActionPerformed(Square50);
        SquareActionPerformed(Square51);
        SquareActionPerformed(Square52);
        SquareActionPerformed(Square53);
        SquareActionPerformed(Square54);
        SquareActionPerformed(Square55);
        SquareActionPerformed(Square56);
        SquareActionPerformed(Square57);
        SquareActionPerformed(Square58);
        SquareActionPerformed(Square59);
        SquareActionPerformed(Square60);
        SquareActionPerformed(Square61);
        SquareActionPerformed(Square62);
        SquareActionPerformed(Square63);
        SquareActionPerformed(Square64);
        SquareActionPerformed(Square65);
        SquareActionPerformed(Square66);
        SquareActionPerformed(Square67);
        SquareActionPerformed(Square68);
        SquareActionPerformed(Square69);
        SquareActionPerformed(Square70);
        SquareActionPerformed(Square71);
        SquareActionPerformed(Square72);
        SquareActionPerformed(Square73);
        SquareActionPerformed(Square74);
        SquareActionPerformed(Square75);
        SquareActionPerformed(Square76);
        SquareActionPerformed(Square77);
        SquareActionPerformed(Square78);
    }

    private void addButtonsToLocalArrayList() {
        botones.add(Square0);
        botones.add(Square1);
        botones.add(Square2);
        botones.add(Square3);
        botones.add(Square4);
        botones.add(Square5);
        botones.add(Square6);
        botones.add(Square7);
        botones.add(Square8);
        botones.add(Square9);
        botones.add(Square10);
        botones.add(Square11);
        botones.add(Square12);
        botones.add(Square13);
        botones.add(Square14);
        botones.add(Square15);
        botones.add(Square16);
        botones.add(Square17);
        botones.add(Square18);
        botones.add(Square19);
        botones.add(Square20);
        botones.add(Square21);
        botones.add(Square22);
        botones.add(Square23);
        botones.add(Square24);
        botones.add(Square25);
        botones.add(Square26);
        botones.add(Square27);
        botones.add(Square28);
        botones.add(Square29);
        botones.add(Square30);
        botones.add(Square31);
        botones.add(Square32);
        botones.add(Square33);
        botones.add(Square34);
        botones.add(Square35);
        botones.add(Square36);
        botones.add(Square37);
        botones.add(Square38);
        botones.add(Square39);
        botones.add(Square40);
        botones.add(Square41);
        botones.add(Square42);
        botones.add(Square43);
        botones.add(Square44);
        botones.add(Square45);
        botones.add(Square46);
        botones.add(Square47);
        botones.add(Square48);
        botones.add(Square49);
        botones.add(Square50);
        botones.add(Square51);
        botones.add(Square52);
        botones.add(Square53);
        botones.add(Square54);
        botones.add(Square55);
        botones.add(Square56);
        botones.add(Square57);
        botones.add(Square58);
        botones.add(Square59);
        botones.add(Square60);
        botones.add(Square61);
        botones.add(Square62);
        botones.add(Square63);
        botones.add(Square64);
        botones.add(Square65);
        botones.add(Square66);
        botones.add(Square67);
        botones.add(Square68);
        botones.add(Square69);
        botones.add(Square70);
        botones.add(Square71);
        botones.add(Square72);
        botones.add(Square73);
        botones.add(Square74);
        botones.add(Square75);
        botones.add(Square76);
        botones.add(Square77);
        botones.add(Square78);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        player6 = new javax.swing.JLabel();
        player5 = new javax.swing.JLabel();
        player4 = new javax.swing.JLabel();
        player3 = new javax.swing.JLabel();
        player2 = new javax.swing.JLabel();
        player1 = new javax.swing.JLabel();
        Square0 = new javax.swing.JButton();
        Square53 = new javax.swing.JButton();
        Square19 = new javax.swing.JButton();
        Square20 = new javax.swing.JButton();
        Square7 = new javax.swing.JButton();
        Square6 = new javax.swing.JButton();
        Square5 = new javax.swing.JButton();
        Square4 = new javax.swing.JButton();
        Square3 = new javax.swing.JButton();
        Square2 = new javax.swing.JButton();
        Square42 = new javax.swing.JButton();
        Square41 = new javax.swing.JButton();
        Square43 = new javax.swing.JButton();
        Square44 = new javax.swing.JButton();
        Square45 = new javax.swing.JButton();
        Square46 = new javax.swing.JButton();
        Square18 = new javax.swing.JButton();
        Square17 = new javax.swing.JButton();
        Square16 = new javax.swing.JButton();
        Square15 = new javax.swing.JButton();
        Square54 = new javax.swing.JButton();
        Square55 = new javax.swing.JButton();
        Square56 = new javax.swing.JButton();
        Square57 = new javax.swing.JButton();
        Square58 = new javax.swing.JButton();
        Square59 = new javax.swing.JButton();
        Square72 = new javax.swing.JButton();
        Square71 = new javax.swing.JButton();
        Square70 = new javax.swing.JButton();
        Square69 = new javax.swing.JButton();
        Square68 = new javax.swing.JButton();
        Square67 = new javax.swing.JButton();
        Square33 = new javax.swing.JButton();
        Square32 = new javax.swing.JButton();
        Square31 = new javax.swing.JButton();
        Square30 = new javax.swing.JButton();
        Square29 = new javax.swing.JButton();
        Square28 = new javax.swing.JButton();
        Square73 = new javax.swing.JButton();
        Square1 = new javax.swing.JButton();
        Square14 = new javax.swing.JButton();
        Square27 = new javax.swing.JButton();
        Square40 = new javax.swing.JButton();
        Square66 = new javax.swing.JButton();
        Square65 = new javax.swing.JButton();
        Square64 = new javax.swing.JButton();
        Square63 = new javax.swing.JButton();
        Square62 = new javax.swing.JButton();
        Square61 = new javax.swing.JButton();
        Square60 = new javax.swing.JButton();
        Square52 = new javax.swing.JButton();
        Square51 = new javax.swing.JButton();
        Square50 = new javax.swing.JButton();
        Square49 = new javax.swing.JButton();
        Square48 = new javax.swing.JButton();
        Square47 = new javax.swing.JButton();
        Square39 = new javax.swing.JButton();
        Square38 = new javax.swing.JButton();
        Square37 = new javax.swing.JButton();
        Square36 = new javax.swing.JButton();
        Square35 = new javax.swing.JButton();
        Square34 = new javax.swing.JButton();
        Square26 = new javax.swing.JButton();
        Square25 = new javax.swing.JButton();
        Square24 = new javax.swing.JButton();
        Square23 = new javax.swing.JButton();
        Square22 = new javax.swing.JButton();
        Square21 = new javax.swing.JButton();
        Square13 = new javax.swing.JButton();
        Square12 = new javax.swing.JButton();
        Square11 = new javax.swing.JButton();
        Square10 = new javax.swing.JButton();
        Square9 = new javax.swing.JButton();
        Square8 = new javax.swing.JButton();
        Square78 = new javax.swing.JButton();
        Square77 = new javax.swing.JButton();
        Square76 = new javax.swing.JButton();
        Square75 = new javax.swing.JButton();
        Square74 = new javax.swing.JButton();
        diceButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        player6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/queso.png"))); // NOI18N
        getContentPane().add(player6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, -1, -1));

        player5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/queso.png"))); // NOI18N
        getContentPane().add(player5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, -1, -1));

        player4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/queso.png"))); // NOI18N
        getContentPane().add(player4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, -1, -1));

        player3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/queso.png"))); // NOI18N
        getContentPane().add(player3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, -1, -1));

        player2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/queso.png"))); // NOI18N
        getContentPane().add(player2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, -1, -1));

        player1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/queso.png"))); // NOI18N
        getContentPane().add(player1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, -1, -1));

        Square0.setBackground(new java.awt.Color(45, 40, 40));
        Square0.setBorderPainted(false);
        Square0.setContentAreaFilled(false);
        getContentPane().add(Square0, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 80, 80));

        Square53.setBorderPainted(false);
        Square53.setContentAreaFilled(false);
        getContentPane().add(Square53, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 50, 60));

        Square19.setBorderPainted(false);
        Square19.setContentAreaFilled(false);
        getContentPane().add(Square19, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 20, 20));

        Square20.setBorderPainted(false);
        Square20.setContentAreaFilled(false);
        getContentPane().add(Square20, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 20, 20));

        Square7.setBorderPainted(false);
        Square7.setContentAreaFilled(false);
        getContentPane().add(Square7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 50, 20));

        Square6.setBorderPainted(false);
        Square6.setContentAreaFilled(false);
        getContentPane().add(Square6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 50, 20));

        Square5.setBorderPainted(false);
        Square5.setContentAreaFilled(false);
        getContentPane().add(Square5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 50, 20));

        Square4.setBorderPainted(false);
        Square4.setContentAreaFilled(false);
        getContentPane().add(Square4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 50, 20));

        Square3.setBorderPainted(false);
        Square3.setContentAreaFilled(false);
        getContentPane().add(Square3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 50, 20));

        Square2.setBorderPainted(false);
        Square2.setContentAreaFilled(false);
        getContentPane().add(Square2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 50, 20));

        Square42.setBorderPainted(false);
        Square42.setContentAreaFilled(false);
        getContentPane().add(Square42, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 470, 50, 20));

        Square41.setBorderPainted(false);
        Square41.setContentAreaFilled(false);
        getContentPane().add(Square41, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 490, 50, 20));

        Square43.setBorderPainted(false);
        Square43.setContentAreaFilled(false);
        getContentPane().add(Square43, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, 50, 20));

        Square44.setBorderPainted(false);
        Square44.setContentAreaFilled(false);
        getContentPane().add(Square44, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, 50, 20));

        Square45.setBorderPainted(false);
        Square45.setContentAreaFilled(false);
        getContentPane().add(Square45, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, 50, 20));

        Square46.setBorderPainted(false);
        Square46.setContentAreaFilled(false);
        getContentPane().add(Square46, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, 50, 20));

        Square18.setBorderPainted(false);
        Square18.setContentAreaFilled(false);
        getContentPane().add(Square18, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 20, 20));

        Square17.setBorderPainted(false);
        Square17.setContentAreaFilled(false);
        getContentPane().add(Square17, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 20, 20));

        Square16.setBorderPainted(false);
        Square16.setContentAreaFilled(false);
        getContentPane().add(Square16, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 20, 20));

        Square15.setBorderPainted(false);
        Square15.setContentAreaFilled(false);
        getContentPane().add(Square15, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 20, 20));

        Square54.setBorderPainted(false);
        Square54.setContentAreaFilled(false);
        getContentPane().add(Square54, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 20, 20));

        Square55.setBorderPainted(false);
        Square55.setContentAreaFilled(false);
        getContentPane().add(Square55, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 20, 20));

        Square56.setBorderPainted(false);
        Square56.setContentAreaFilled(false);
        getContentPane().add(Square56, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 20, 20));

        Square57.setBorderPainted(false);
        Square57.setContentAreaFilled(false);
        getContentPane().add(Square57, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 20, 20));

        Square58.setBorderPainted(false);
        Square58.setContentAreaFilled(false);
        getContentPane().add(Square58, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 20, 20));

        Square59.setBorderPainted(false);
        Square59.setContentAreaFilled(false);
        getContentPane().add(Square59, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 20, 20));

        Square72.setBorderPainted(false);
        Square72.setContentAreaFilled(false);
        getContentPane().add(Square72, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 20, 20));

        Square71.setBorderPainted(false);
        Square71.setContentAreaFilled(false);
        Square71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Square71ActionPerformed(evt);
            }
        });
        getContentPane().add(Square71, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 20, 20));

        Square70.setContentAreaFilled(false);
        getContentPane().add(Square70, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 20, 20));

        Square69.setBorderPainted(false);
        Square69.setContentAreaFilled(false);
        getContentPane().add(Square69, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 20, 20));

        Square68.setBorderPainted(false);
        Square68.setContentAreaFilled(false);
        getContentPane().add(Square68, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 20, 20));

        Square67.setBorderPainted(false);
        Square67.setContentAreaFilled(false);
        Square67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Square67ActionPerformed(evt);
            }
        });
        getContentPane().add(Square67, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 20, 20));

        Square33.setBorderPainted(false);
        Square33.setContentAreaFilled(false);
        getContentPane().add(Square33, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, 20, 20));

        Square32.setBorderPainted(false);
        Square32.setContentAreaFilled(false);
        getContentPane().add(Square32, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 340, 20, 20));

        Square31.setBorderPainted(false);
        Square31.setContentAreaFilled(false);
        getContentPane().add(Square31, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, 20, 20));

        Square30.setBorderPainted(false);
        Square30.setContentAreaFilled(false);
        getContentPane().add(Square30, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 20, 20));

        Square29.setBorderPainted(false);
        Square29.setContentAreaFilled(false);
        getContentPane().add(Square29, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, 20, 20));

        Square28.setBorderPainted(false);
        Square28.setContentAreaFilled(false);
        getContentPane().add(Square28, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, 20, 20));

        Square73.setBorderPainted(false);
        Square73.setContentAreaFilled(false);
        getContentPane().add(Square73, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 20, 20));

        Square1.setBorderPainted(false);
        Square1.setContentAreaFilled(false);
        getContentPane().add(Square1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 60, 60));

        Square14.setBorderPainted(false);
        Square14.setContentAreaFilled(false);
        getContentPane().add(Square14, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 50, 60));

        Square27.setBorderPainted(false);
        Square27.setContentAreaFilled(false);
        getContentPane().add(Square27, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, 50, 60));

        Square40.setBorderPainted(false);
        Square40.setContentAreaFilled(false);
        getContentPane().add(Square40, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 530, 50, 60));

        Square66.setBorderPainted(false);
        Square66.setContentAreaFilled(false);
        getContentPane().add(Square66, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 50, 60));

        Square65.setBorderPainted(false);
        Square65.setContentAreaFilled(false);
        getContentPane().add(Square65, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 20, 20));

        Square64.setBorderPainted(false);
        Square64.setContentAreaFilled(false);
        getContentPane().add(Square64, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 20, 20));

        Square63.setBorderPainted(false);
        Square63.setContentAreaFilled(false);
        getContentPane().add(Square63, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 20, 20));

        Square62.setBorderPainted(false);
        Square62.setContentAreaFilled(false);
        getContentPane().add(Square62, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 20, 20));

        Square61.setBorderPainted(false);
        Square61.setContentAreaFilled(false);
        getContentPane().add(Square61, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 20, 20));

        Square60.setBorderPainted(false);
        Square60.setContentAreaFilled(false);
        getContentPane().add(Square60, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 20, 20));

        Square52.setBorderPainted(false);
        Square52.setContentAreaFilled(false);
        getContentPane().add(Square52, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, 20, 20));

        Square51.setBorderPainted(false);
        Square51.setContentAreaFilled(false);
        getContentPane().add(Square51, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 500, 20, 20));

        Square50.setBorderPainted(false);
        Square50.setContentAreaFilled(false);
        getContentPane().add(Square50, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 520, 20, 20));

        Square49.setBorderPainted(false);
        Square49.setContentAreaFilled(false);
        getContentPane().add(Square49, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 540, 20, 20));

        Square48.setBorderPainted(false);
        Square48.setContentAreaFilled(false);
        getContentPane().add(Square48, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 550, 20, 20));

        Square47.setBorderPainted(false);
        Square47.setContentAreaFilled(false);
        getContentPane().add(Square47, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 560, 20, 20));

        Square39.setBorderPainted(false);
        Square39.setContentAreaFilled(false);
        getContentPane().add(Square39, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 560, 20, 20));

        Square38.setBorderPainted(false);
        Square38.setContentAreaFilled(false);
        getContentPane().add(Square38, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 550, 20, 20));

        Square37.setBorderPainted(false);
        Square37.setContentAreaFilled(false);
        getContentPane().add(Square37, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 540, 20, 20));

        Square36.setBorderPainted(false);
        Square36.setContentAreaFilled(false);
        getContentPane().add(Square36, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 520, 20, 20));

        Square35.setBorderPainted(false);
        Square35.setContentAreaFilled(false);
        getContentPane().add(Square35, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 500, 20, 20));

        Square34.setBorderPainted(false);
        Square34.setContentAreaFilled(false);
        getContentPane().add(Square34, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 470, 20, 20));

        Square26.setBorderPainted(false);
        Square26.setContentAreaFilled(false);
        getContentPane().add(Square26, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 380, 20, 20));

        Square25.setBorderPainted(false);
        Square25.setContentAreaFilled(false);
        getContentPane().add(Square25, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 340, 20, 20));

        Square24.setBorderPainted(false);
        Square24.setContentAreaFilled(false);
        getContentPane().add(Square24, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 310, 20, 20));

        Square23.setBorderPainted(false);
        Square23.setContentAreaFilled(false);
        getContentPane().add(Square23, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 270, 20, 20));

        Square22.setBorderPainted(false);
        Square22.setContentAreaFilled(false);
        getContentPane().add(Square22, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 230, 20, 20));

        Square21.setBorderPainted(false);
        Square21.setContentAreaFilled(false);
        getContentPane().add(Square21, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, 20, 20));

        Square13.setBorderPainted(false);
        Square13.setContentAreaFilled(false);
        getContentPane().add(Square13, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 20, 20));

        Square12.setBorderPainted(false);
        Square12.setContentAreaFilled(false);
        getContentPane().add(Square12, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 20, 20));

        Square11.setBorderPainted(false);
        Square11.setContentAreaFilled(false);
        getContentPane().add(Square11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 20, 20));

        Square10.setBorderPainted(false);
        Square10.setContentAreaFilled(false);
        Square10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Square10ActionPerformed(evt);
            }
        });
        getContentPane().add(Square10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 20, 20));

        Square9.setBorderPainted(false);
        Square9.setContentAreaFilled(false);
        Square9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Square9ActionPerformed(evt);
            }
        });
        getContentPane().add(Square9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 20, 20));

        Square8.setBorderPainted(false);
        Square8.setContentAreaFilled(false);
        getContentPane().add(Square8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 20, 20));

        Square78.setBorderPainted(false);
        Square78.setContentAreaFilled(false);
        getContentPane().add(Square78, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 20, 20));

        Square77.setBorderPainted(false);
        Square77.setContentAreaFilled(false);
        getContentPane().add(Square77, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 20, 20));

        Square76.setBorderPainted(false);
        Square76.setContentAreaFilled(false);
        getContentPane().add(Square76, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 20, 20));

        Square75.setBorderPainted(false);
        Square75.setContentAreaFilled(false);
        getContentPane().add(Square75, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 20, 20));

        Square74.setBorderPainted(false);
        Square74.setContentAreaFilled(false);
        getContentPane().add(Square74, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 20, 20));

        diceButton.setBackground(new java.awt.Color(240, 145, 1));
        diceButton.setText("Dado");
        diceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diceButtonActionPerformed(evt);
            }
        });
        getContentPane().add(diceButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 540, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Tablero.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void diceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diceButtonActionPerformed
        Dice dice = new Dice(this);
        diceNumber = dice.getRandomNumber();
        jLabelDice.setText(" DADO: " + diceNumber);
        diceButton.setVisible(false);
    }//GEN-LAST:event_diceButtonActionPerformed

    private void Square71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Square71ActionPerformed
    }//GEN-LAST:event_Square71ActionPerformed

    private void Square10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Square10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Square10ActionPerformed

    private void Square9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Square9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Square9ActionPerformed

    private void Square67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Square67ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Square67ActionPerformed

    private void SquareActionPerformed(JButton boton) {
        boton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JButton buttonPressed = (JButton) e.getSource();
                if (board.canIMoveTo(lastButtonPressedId, diceNumber, botones.indexOf(buttonPressed))) {
                    lastButtonPressedId = botones.indexOf(buttonPressed);
                    if (board.getSquareById(botones.indexOf(buttonPressed)) instanceof DiceSquare) {
                        moveCheese(playersLabels.get(board.getActualPlayerPosition()), getXOf(buttonPressed), getYOf(buttonPressed));
                    } else if (board.getSquareById(botones.indexOf(buttonPressed)) instanceof NormalSquare || board.getSquareById(botones.indexOf(buttonPressed)) instanceof CheeseSquare) {
                        String category = board.getSquareById(botones.indexOf(buttonPressed)).getColor().toString();
                        //moveCheese(playersLabels.get(board.getActualPlayerPosition()), getXOf(buttonPressed), getYOf(buttonPressed));
                        WindowPopUpQuestion aux = createWindowPopUpQuestion(category);
                        Timer timer = new Timer(5000, j -> {
                            if (aux.getCorrect()) {
                                System.out.println("CORRECTO");
                            } else {
                                System.out.println("FALSOOO");
                                board.swapPlayer();
                                jLabelPlaying.setText(" JUGANDO: " + board.getActualPlayer().getName());
                            }
                            moveCheese(playersLabels.get(board.getActualPlayerPosition()), getXOf(buttonPressed), getYOf(buttonPressed));
                        });
                        timer.setRepeats(false);
                        timer.start();

                    } else if (board.getSquareById(botones.indexOf(buttonPressed)) instanceof MainSquare) {
                        Random rand = new Random(System.currentTimeMillis());
                        String[] categories = {"historia", "geografia", "deportes", "espectaculo", "cienciaytecnologia", "arteyliteratura"};
                        String category = categories[rand.nextInt(categories.length)];
                        //moveCheese(playersLabels.get(board.getActualPlayerPosition()), getXOf(buttonPressed), getYOf(buttonPressed));
                        WindowPopUpQuestion aux = createWindowPopUpQuestion(category);
                        Timer timer = new Timer(5000, j -> {
                            if (aux.getCorrect()) {
                                System.out.println("CORRECTO");
                            } else {
                                System.out.println("FALSOOO");
                                board.swapPlayer();
                                jLabelPlaying.setText(" JUGANDO: " + board.getActualPlayer().getName());
                                moveCheese(playersLabels.get(board.getActualPlayerPosition()), getXOf(buttonPressed), getYOf(buttonPressed));
                            }
                        });
                        timer.setRepeats(false);
                        timer.start();
                    }
                    
                    diceButton.setVisible(true);
                }
            }
        });
    }

    private void moveCheese(JLabel cheese, int xCords, int yCords) {
        setCheeseAtLocation(cheese, xCords, yCords);
    }

    private void setCheeseAtLocation(JLabel cheese, int x, int y) {
        cheese.setLocation(x, y);
    }

    private WindowPopUpQuestion createWindowPopUpQuestion(String category) {
        this.setEnabled(false);
        return new WindowPopUpQuestion(askForm, category, this);
    }

    private int getYOf(JButton jButton) {
        return (int) jButton.getLocation().getY();
    }

    private int getXOf(JButton jButton) {
        return (int) jButton.getLocation().getX();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Square0;
    private javax.swing.JButton Square1;
    private javax.swing.JButton Square10;
    private javax.swing.JButton Square11;
    private javax.swing.JButton Square12;
    private javax.swing.JButton Square13;
    private javax.swing.JButton Square14;
    private javax.swing.JButton Square15;
    private javax.swing.JButton Square16;
    private javax.swing.JButton Square17;
    private javax.swing.JButton Square18;
    private javax.swing.JButton Square19;
    private javax.swing.JButton Square2;
    private javax.swing.JButton Square20;
    private javax.swing.JButton Square21;
    private javax.swing.JButton Square22;
    private javax.swing.JButton Square23;
    private javax.swing.JButton Square24;
    private javax.swing.JButton Square25;
    private javax.swing.JButton Square26;
    private javax.swing.JButton Square27;
    private javax.swing.JButton Square28;
    private javax.swing.JButton Square29;
    private javax.swing.JButton Square3;
    private javax.swing.JButton Square30;
    private javax.swing.JButton Square31;
    private javax.swing.JButton Square32;
    private javax.swing.JButton Square33;
    private javax.swing.JButton Square34;
    private javax.swing.JButton Square35;
    private javax.swing.JButton Square36;
    private javax.swing.JButton Square37;
    private javax.swing.JButton Square38;
    private javax.swing.JButton Square39;
    private javax.swing.JButton Square4;
    private javax.swing.JButton Square40;
    private javax.swing.JButton Square41;
    private javax.swing.JButton Square42;
    private javax.swing.JButton Square43;
    private javax.swing.JButton Square44;
    private javax.swing.JButton Square45;
    private javax.swing.JButton Square46;
    private javax.swing.JButton Square47;
    private javax.swing.JButton Square48;
    private javax.swing.JButton Square49;
    private javax.swing.JButton Square5;
    private javax.swing.JButton Square50;
    private javax.swing.JButton Square51;
    private javax.swing.JButton Square52;
    private javax.swing.JButton Square53;
    private javax.swing.JButton Square54;
    private javax.swing.JButton Square55;
    private javax.swing.JButton Square56;
    private javax.swing.JButton Square57;
    private javax.swing.JButton Square58;
    private javax.swing.JButton Square59;
    private javax.swing.JButton Square6;
    private javax.swing.JButton Square60;
    private javax.swing.JButton Square61;
    private javax.swing.JButton Square62;
    private javax.swing.JButton Square63;
    private javax.swing.JButton Square64;
    private javax.swing.JButton Square65;
    private javax.swing.JButton Square66;
    private javax.swing.JButton Square67;
    private javax.swing.JButton Square68;
    private javax.swing.JButton Square69;
    private javax.swing.JButton Square7;
    private javax.swing.JButton Square70;
    private javax.swing.JButton Square71;
    private javax.swing.JButton Square72;
    private javax.swing.JButton Square73;
    private javax.swing.JButton Square74;
    private javax.swing.JButton Square75;
    private javax.swing.JButton Square76;
    private javax.swing.JButton Square77;
    private javax.swing.JButton Square78;
    private javax.swing.JButton Square8;
    private javax.swing.JButton Square9;
    private javax.swing.JButton diceButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel player1;
    private javax.swing.JLabel player2;
    private javax.swing.JLabel player3;
    private javax.swing.JLabel player4;
    private javax.swing.JLabel player5;
    private javax.swing.JLabel player6;
    // End of variables declaration//GEN-END:variables

    private void initializePlayerLabels() {
        this.playersLabels.add(player1);
        this.playersLabels.add(player2);
        this.playersLabels.add(player3);
        this.playersLabels.add(player4);
        this.playersLabels.add(player5);
        this.playersLabels.add(player6);
    }
}
