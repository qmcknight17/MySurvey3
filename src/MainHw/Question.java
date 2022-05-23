package MainHw;

import java.io.*;
import java.util.ArrayList;

public abstract class Question implements Serializable{

    public static Out output = new ConsoleOutput();
    public static In input = new ConsoleInput(output);

    public String Prompt;
    public Response response;
    public String QuestionType;
    public Response correctAnswer;


    public Question(){
        this.correctAnswer = new Response(new ArrayList<String>());
    }

//delete

    public void setQuestionType(String questionType) {
        QuestionType = questionType;
    }

    public Response getCorrectAnswer() {
        return correctAnswer;
    }
    public String getQuestionType(){ return this.QuestionType; }

    public void setPrompt(String prompt) {
        Prompt = prompt;
    }

    public Response getResponse() { return this.response; }

//    public void setCorrectAnswer(String correctAnswer) {
//        CorrectAnswer = correctAnswer;
//    }

    public String getPrompt() {
        return Prompt;
    };

    public abstract void take();


    public abstract void display();
    public abstract void displayWithCorrect();

    public abstract void modify();

    public abstract void createQuestion ();
    public abstract int grade();









    }





