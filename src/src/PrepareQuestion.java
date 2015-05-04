package src;

public class PrepareQuestion {
    private String question;
    private String[] replyArray = new String[4];

    public PrepareQuestion(String question, String reply1, String reply2, String reply3, String reply4){
        this.question = question;
        replyArray[0] = reply1;
        replyArray[1] = reply2;
        replyArray[2] = reply3;
        replyArray[3] = reply4;
    }

    public String getQuestion(){
        return question;
    }

    public String[] getReplyArray(){
        return replyArray;
    }

}
