package src;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class AskForm {

    private Question question;
    HashMap<String, ArrayList<Question>> map;
    private ArrayList<Question> arrayQuestion;
    private File fichero;


    public AskForm() {
        map = new HashMap<>();
        initializeMap();
    }

    private void initializeMap() {
        map.put("arteyliteratura", initializeQuestionCategories("arteyliteratura"));
        map.put("cienciaytecnologia", initializeQuestionCategories("cienciaytecnologia"));
        map.put("deportes", initializeQuestionCategories("deportes"));
        map.put("espectaculo", initializeQuestionCategories("espectaculo"));
        map.put("geografia", initializeQuestionCategories("geografia"));
        map.put("historia", initializeQuestionCategories("historia"));
    }

    private ArrayList<Question> initializeQuestionCategories(String category) {
        return checkArrayQuestion(new ArrayList<>(), category);
    }

    private ArrayList<Question> checkArrayQuestion(ArrayList<Question> checkArrayListQuestion, String category) {
        fichero = new File(category);
        ArrayList<Question> arrayQuestion = null;
        if (checkArrayListQuestion == null || checkArrayListQuestion.size() == 0) {
            arrayQuestion = getArrayQuestions(fichero.getAbsolutePath());
            //arrayQuestion = getArrayQuestions("Trivial/src/" + category);
        }
        return arrayQuestion;
    }

    public ArrayList<Question> getArrayQuestions(String ruta) {
        arrayQuestion = new ArrayList<>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(ruta);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        String linea;
        try {
            linea = br.readLine();
            while(linea!=null){
                String dato[] = linea.split("@");
                Question question = new Question(dato[0], dato[1], dato[2], dato[3], dato[4], (dato[5]));
                arrayQuestion.add(question);
                linea=br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayQuestion;
    }

    public Question getQuestion(String category) {
        if (map.get(category).size() == 0)
            map.put(category, initializeQuestionCategories(category));

        question = map.get(category).get(0);
        map.get(category).remove(0);
        return question;
    }
}
