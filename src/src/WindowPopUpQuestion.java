package src;


import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import src.AskForm;
import src.AskForm;
import src.BoardFrame;
import src.BoardFrame;
import src.Question;
import src.Question;

public class WindowPopUpQuestion extends JFrame{

    private JFrame frame;
    private JPanel panel;
    private GridLayout gridLayout;
    private JButton replyA, replyB, replyC, replyD;
    private JLabel questionLabel;
    private AskForm allContentOfCategory;
    private BoardFrame boardFrame;
    private Question oneQuestionOfACategory;
    private Boolean correct;

    public Boolean getCorrect() {
        return correct;
    }

    public WindowPopUpQuestion(AskForm askForm, String category, BoardFrame boardFrame) {
        this.allContentOfCategory = askForm;
        this.boardFrame = boardFrame;
        oneQuestionOfACategory = allContentOfCategory.getQuestion(category);
        initializeComponents();
    }

    private void initializeComponents() {
        initializeLabel();
        initializeGridLayout();
        initializeReplies();
        initializePanel();
        initializeFrame();
    }

    public void initializeLabel(){
        questionLabel = new JLabel(oneQuestionOfACategory.getQuestion());
        questionLabel.setHorizontalAlignment(JLabel.CENTER);
        questionLabel.setForeground(Color.WHITE);
    }

    public void initializeGridLayout(){
        gridLayout = new GridLayout(5,1);
        gridLayout.addLayoutComponent("replyA",replyA);
        gridLayout.addLayoutComponent("replyB",replyB);
        gridLayout.addLayoutComponent("replyC",replyC);
        gridLayout.addLayoutComponent("replyD",replyD);
    }

    public void initializeReplies(){
        initializeReplyButtons();
        initializeReplyBackground();
        setReplyHorizontalAlignment();
        repliesActionListener();
    }

    private void initializeReplyButtons() {
        replyA = new JButton(oneQuestionOfACategory.getAnswerA());
        replyB = new JButton(oneQuestionOfACategory.getAnswerB());
        replyC = new JButton(oneQuestionOfACategory.getAnswerC());
        replyD = new JButton(oneQuestionOfACategory.getAnswerD());
    }

    private void initializeReplyBackground() {
        replyA.setBackground(Color.LIGHT_GRAY);
        replyB.setBackground(Color.LIGHT_GRAY);
        replyC.setBackground(Color.LIGHT_GRAY);
        replyD.setBackground(Color.LIGHT_GRAY);
    }

    private void setReplyHorizontalAlignment() {
        replyA.setHorizontalAlignment(JLabel.CENTER);
        replyB.setHorizontalAlignment(JLabel.CENTER);
        replyC.setHorizontalAlignment(JLabel.CENTER);
        replyD.setHorizontalAlignment(JLabel.CENTER);
    }

    private void repliesActionListener() {
        replyA.addActionListener(e -> checkIfReplyIsCorrect(replyA));

        replyB.addActionListener(e -> checkIfReplyIsCorrect(replyB));

        replyC.addActionListener(e -> checkIfReplyIsCorrect(replyC));

        replyD.addActionListener(e -> checkIfReplyIsCorrect(replyD));
    }

    public void initializePanel(){
        panel = new JPanel();
        panel.setBackground(Color.darkGray);
        panel.setLayout(gridLayout);
        addComponentsToPanel();
    }

    public void initializeFrame(){
        frame = new JFrame("Responder Pregunta");
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setSize((int) questionLabel.getPreferredSize().getWidth() + 10, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
    }

    private void addComponentsToPanel() {
        panel.add(questionLabel);
        panel.add(replyA);
        panel.add(replyB);
        panel.add(replyC);
        panel.add(replyD);
    }

    private void checkIfReplyIsCorrect(JButton reply) {
        if (String.valueOf(reply.getText().trim().charAt(0)).equals(oneQuestionOfACategory.getCorrect())){
            reply.setBackground(Color.GREEN);
            this.correct = true;
        } else {
            reply.setBackground(Color.RED);
            getButtonOfCorrectReply().setBackground(Color.GREEN);
            this.correct = false;
        }
        disableOtherButtons();
        Timer timer = new Timer(4000, e -> {
            this.frame.dispose();
        });
        timer.start();
        boardFrame.setEnabled(true);
    }

    private JButton getButtonOfCorrectReply(){
        if (String.valueOf(replyA.getText().trim().charAt(0)).equals(oneQuestionOfACategory.getCorrect())){
            return replyA;
        }

        if (String.valueOf(replyB.getText().trim().charAt(0)).equals(oneQuestionOfACategory.getCorrect())){
            return replyB;
        }

        if (String.valueOf(replyC.getText().trim().charAt(0)).equals(oneQuestionOfACategory.getCorrect())){
            return replyC;
        }

        if (String.valueOf(replyD.getText().trim().charAt(0)).equals(oneQuestionOfACategory.getCorrect())){
            return replyD;
        }else return null;
    }

    private void disableOtherButtons() {
        replyA.setEnabled(false);
        replyB.setEnabled(false);
        replyC.setEnabled(false);
        replyD.setEnabled(false);
    }
}


//package src;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class WindowPopUpQuestion extends JDialog {
//
//    private JPanel panel;
//    private GridLayout gridLayout;
//    private JButton replyA, replyB, replyC, replyD;
//    private JLabel questionLabel;
//    private AskForm allContentOfCategory;
//    private BoardFrame boardFrame;
//    private Question oneQuestionOfACategory;
//    private Boolean correct;
//
//    public WindowPopUpQuestion(AskForm askForm, String category, BoardFrame boardFrame) {
//        //super(boardFrame, true);
//        this.allContentOfCategory = askForm;
//        this.boardFrame = boardFrame;
//        oneQuestionOfACategory = allContentOfCategory.getQuestion(category);
//        initializeComponents();
//    }
//
//    private void initializeComponents() {
//        initializeLabel();
//        initializeGridLayout();
//        initializeReplies();
//        initializePanel();
//        initializeDialog();
//    }
//
//    public void initializeLabel(){
//        questionLabel = new JLabel(oneQuestionOfACategory.getQuestion());
//        questionLabel.setHorizontalAlignment(JLabel.CENTER);
//        questionLabel.setForeground(Color.WHITE);
//    }
//
//    public void initializeGridLayout(){
//        gridLayout = new GridLayout(5,1);
//        gridLayout.addLayoutComponent("replyA",replyA);
//        gridLayout.addLayoutComponent("replyB",replyB);
//        gridLayout.addLayoutComponent("replyC",replyC);
//        gridLayout.addLayoutComponent("replyD",replyD);
//    }
//
//    public void initializeReplies(){
//        initializeReplyButtons();
//        initializeReplyBackground();
//        setReplyHorizontalAlignment();
//        repliesActionListener();
//    }
//
//    private void initializeReplyButtons() {
//        replyA = new JButton(oneQuestionOfACategory.getAnswerA());
//        replyB = new JButton(oneQuestionOfACategory.getAnswerB());
//        replyC = new JButton(oneQuestionOfACategory.getAnswerC());
//        replyD = new JButton(oneQuestionOfACategory.getAnswerD());
//    }
//
//    private void initializeReplyBackground() {
//        replyA.setBackground(Color.LIGHT_GRAY);
//        replyB.setBackground(Color.LIGHT_GRAY);
//        replyC.setBackground(Color.LIGHT_GRAY);
//        replyD.setBackground(Color.LIGHT_GRAY);
//    }
//
//    private void setReplyHorizontalAlignment() {
//        replyA.setHorizontalAlignment(JLabel.CENTER);
//        replyB.setHorizontalAlignment(JLabel.CENTER);
//        replyC.setHorizontalAlignment(JLabel.CENTER);
//        replyD.setHorizontalAlignment(JLabel.CENTER);
//    }
//
//    private void repliesActionListener() {
//        replyA.addActionListener(e -> checkIfReplyIsCorrect(replyA));
//
//        replyB.addActionListener(e -> checkIfReplyIsCorrect(replyB));
//
//        replyC.addActionListener(e -> checkIfReplyIsCorrect(replyC));
//
//        replyD.addActionListener(e -> checkIfReplyIsCorrect(replyD));
//    }
//
//    public void initializePanel(){
//        panel = new JPanel();
//        panel.setBackground(Color.darkGray);
//        panel.setLayout(gridLayout);
//        addComponentsToPanel();
//    }
//
//    public void initializeDialog(){
//        this.setTitle("Responder Pregunta");
//        this.setUndecorated(true);
//        this.setVisible(true);
//        this.setSize((int)questionLabel.getPreferredSize().getWidth() + 10, 400);
//        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//        this.add(panel);
//        this.setLocationRelativeTo(null);
//    }
//
//    private void addComponentsToPanel() {
//        panel.add(questionLabel);
//        panel.add(replyA);
//        panel.add(replyB);
//        panel.add(replyC);
//        panel.add(replyD);
//    }
//
//    private void checkIfReplyIsCorrect(JButton reply) {
//        if (String.valueOf(reply.getText().trim().charAt(0)).equals(oneQuestionOfACategory.getCorrect())){
//            reply.setBackground(Color.GREEN);
//            this.correct = true;
//        } else {
//            reply.setBackground(Color.RED);
//            getButtonOfCorrectReply().setBackground(Color.GREEN);
//            this.correct = false;
//        }
//        disableOtherButtons();
//        Timer timer = new Timer(4000, e -> {
//            this.dispose();
//        });
//        timer.start();
//        boardFrame.setEnabled(true);
//    }
//
//    public Boolean getCorrect() {
//        return correct;
//    }
//    
//    private JButton getButtonOfCorrectReply(){
//        if (String.valueOf(replyA.getText().trim().charAt(0)).equals(oneQuestionOfACategory.getCorrect())){
//            return replyA;
//        }
//
//        if (String.valueOf(replyB.getText().trim().charAt(0)).equals(oneQuestionOfACategory.getCorrect())){
//            return replyB;
//        }
//
//        if (String.valueOf(replyC.getText().trim().charAt(0)).equals(oneQuestionOfACategory.getCorrect())){
//            return replyC;
//        }
//
//        if (String.valueOf(replyD.getText().trim().charAt(0)).equals(oneQuestionOfACategory.getCorrect())){
//            return replyD;
//        }else return null;
//    }
//
//    private void disableOtherButtons() {
//        replyA.setEnabled(false);
//        replyB.setEnabled(false);
//        replyC.setEnabled(false);
//        replyD.setEnabled(false);
//    }
//}