package MainHw;
import utils.*;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;


public class Survey implements Serializable {

    public Response response;
//new
    protected ArrayList<ArrayList> SurveyResponse;

    protected ArrayList<ArrayList<ArrayList>> SurveyResponseList;




    private static Out output = new ConsoleOutput();
    private static In input = new ConsoleInput(output);

    protected String surveyName;
    //implement questions class

    protected ArrayList<Question> questions;

    public Response getResponseCorrectAnswer() {
        return response;
    }

    public void grade() {

    }

    //implement correct answer
    //protected ResponseCorrectAnswer responseCorrectAnswer;

    public Survey(String name){
        this.surveyName = name;
        this.questions = new ArrayList<Question>();
        this.SurveyResponseList = new ArrayList<>();
    }
//new
    public void addToResponseList(ArrayList<ArrayList> response){
        this.SurveyResponseList.add(response);
    }

    public void addQuestion(Question question){
        this.questions.add(question);
    }

//    //public void addResponse(Object Answer){
//        this.response.add(Answer);
//    }

    public ArrayList<Question> getQuestions() { return this.questions; }


    public void Take(){
        ArrayList<ArrayList> response = new ArrayList<>();
        int numQuestions = this.questions.size();
        for (int i = 1; i <= numQuestions; i++) {
            output.PrintLine(i+") ");
            this.questions.get(i-1).display();
            this.questions.get(i-1).take();
            response.add(this.questions.get(i-1).getResponse().getResponses());
            output.PrintLine("\n");
        }
        addToResponseList(response);
    }

    public void tabulate(){
        int numQuestions = this.questions.size();
        if (SurveyResponseList.size() == 0){
            output.PrintLine("No responses recorded in this file!");
            return;
        }
        for (int i = 1; i <= numQuestions; i++) {
            this.questions.get(i-1).display();
            output.PrintLine("\n");
            output.PrintLine("These are the replies: ");
            ArrayList<String> replies = new ArrayList<String>();
            for (ArrayList<ArrayList> arrayLists : SurveyResponseList) {
                replies.add(arrayLists.get(i - 1).toString());
                output.PrintLine(arrayLists.get(i - 1).toString());
            }
            output.PrintLine("\n");
            output.PrintLine("TABULATIONS: \n");
            Set<String> set = new LinkedHashSet<>();
            set.addAll(replies);
            if(this.questions.get(i-1).getQuestionType() == "Essay") {
                for (ArrayList<ArrayList> arrayLists : SurveyResponseList) {
                    output.PrintLine(arrayLists.get(i - 1).toString());
                }
            }else {
                for (String s : set) {
                    output.PrintLine(s + " : " + Collections.frequency(replies, s));
                }
            }
        }
    }









    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }














}


