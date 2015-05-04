package src;

public class Question {
    private String question, answerA, answerB, answerC, answerD, correct;

    public Question(String question, String answerA, String answerB, String answerC, String answerD, String correct) {
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correct = correct;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswerA() {
        return answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public String getCorrect() {
        return String.valueOf(correct.trim().charAt(0));
    }
}