package MainHw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

public class Matching extends Question{

    HashMap<Integer, String> leftColQuestions = new HashMap<>();
    HashMap<Integer, String> rightColChoices = new HashMap<>();
    //ArrayList<String> rightColChoices = new ArrayList<>();


    public HashMap<Integer, String> getChoices() {
        return leftColQuestions;
    }

    public HashMap<Integer, String> getChoices2() {
        return rightColChoices;
    }



    @Override
    public void createQuestion() {
        output.PrintLine("What is your Matching Question prompt");

        Prompt = input.getInText();

        int i = 1;
        boolean choice = true;
        while((choice == true )&& (i <= 10)){
            output.PrintLine("Enter Left column Question #"+i);
            String option = input.getInText();
            leftColQuestions.put(i, option);
            output.PrintLine("would you like to add another question(you can add up to 10): \n 1) Yes \n 2) No");
            int ans = input.getInInt();
            switch (ans)
            {
                case 1:
                    i++;
                    break;

                case 2:
                    choice = false;
                    break;

                default:
                    System.err.println ( "Unrecognized option" );
                    break;
            }
        }


        for (int x = 1; x <= leftColQuestions.size(); x++) {
            output.PrintLine("Enter right-column answer #"+x);
            String option2 = input.getInText();
            rightColChoices.put(x, option2);
        }



        ArrayList<String> Answers = new ArrayList<>();
        for (int x = 1; x <= leftColQuestions.size(); x++) {
            output.PrintLine("Please enter the correct answer for Question " + x + " in the format of (Right column \"Integer\" left column \"Integer\" ex: 1 1 )");
            String ans = input.getInText().replaceAll("\\s+","");
            Answers.add(ans);
        }
        this.correctAnswer = new Response(Answers);

    }

    @Override
    public int grade() {
        ArrayList<String> response = getResponse().getResponses();
        ArrayList<String> correctAnswer = getCorrectAnswer().getResponses();

        for (int i = 0; i < leftColQuestions.size(); i++) {
            if (correctAnswer.get(i).equals(response.get(i))){
                continue;
            }else{
                return 0;
            }
        }
        return 10;
    }

    @Override
    public void modify() {

        output.PrintLine("please chose what you would like to change a 1,2,3 or 4: \n 1) prompt \n 2) Left Collum Question \n 3) Right Collum Choices \n 4) Change Nothing");
        int pick = input.getInInt();
        switch (pick) {
            case 1:
                output.PrintLine("Please enter a new Prompt");
                this.Prompt = input.getInText();
                break;
            case 2:
                output.PrintLine("Please enter how many Left collum Questions would you like to change");
                int choice = input.getInInt();
                while (choice < 0 || choice > leftColQuestions.size()) {
                    choice = input.getInInt();
                    output.PrintLine("Please enter a a valid number");
                }
                for (int x = 1; x <= choice; x++) {
                    output.PrintLine("Please enter the number of the question you would like to change");
                    int key = input.getInInt();
                    output.PrintLine("Please enter the new Question");
                    String newOption = input.getInText();
                    leftColQuestions.put(key, newOption);
                    break;
                }
            case 3:
                output.PrintLine("Please enter how many Right collum Choices you would you like to change");
                int choice2 = input.getInInt();
                while (choice2 < 0 || choice2 > leftColQuestions.size()) {
                    choice2 = input.getInInt();
                    output.PrintLine("Please enter a a valid number");
                }
                for (int x = 1; x <= choice2; x++) {
                    output.PrintLine("Please enter the number of the Choice you would like to change");
                    int key = input.getInInt();
                    output.PrintLine("Please enter the new Choice");
                    String newOption = input.getInText();
                    rightColChoices.put(key, newOption);
                    break;
                }

            case 4:
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + pick);
        }

        output.PrintLine("would you like to modify the correct answer to this Question(please chose a 1 or 2): \n 1) Yes \n 2) No");
        int pick2 = input.getInInt();
        switch (pick2) {
            case 1:

                ArrayList<String> Answers = new ArrayList<>();
                for (int x = 1; x <= leftColQuestions.size(); x++) {
                    output.PrintLine("Please enter the correct answer for Question " + x + " in the format of (Right column \"Integer\" left column \"Integer\" ex: 1 1 )");
                    String ans = input.getInText().replaceAll("\\s+","");
                    Answers.add(ans);
                }
                this.correctAnswer = new Response(Answers);
            case 2:
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + pick);
        }
    }

    @Override
    public void take(){
        ArrayList<String> Answers = new ArrayList<>();
        for (int x = 1; x <= leftColQuestions.size(); x++) {
            output.PrintLine("Please enter your choice" + x);
            String ans = input.getInText().replaceAll("\\s+","");
            Answers.add(ans);
        }
        this.response = new Response(Answers);
    }

    @Override
    public void display() {
        output.PrintLine(getPrompt());

        output.PrintLine("this is the left column");
        leftColQuestions.forEach((key, value) -> output.PrintLine(key + ") " + value ) );

        output.PrintLine("\nthis is the right column");

        for (Map.Entry<Integer, String> entry : rightColChoices.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            output.PrintLine(key + ") " + value);
        }


    }

    @Override
    public void displayWithCorrect() {
        output.PrintLine(getPrompt());
        output.PrintLine("this is the left column");
        leftColQuestions.forEach((key, value) -> output.PrintLine(key + ") " + value ) );
        output.PrintLine("\nthis is the right column");
        for (Map.Entry<Integer, String> entry : rightColChoices.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            output.PrintLine(key + ") " + value);
        }

        output.PrintLine("these are the correct answers");
        ArrayList<String> correctAnswer = getCorrectAnswer().getResponses();
        for (int i = 0; i < leftColQuestions.size(); i++) {
            output.PrintLine(correctAnswer.get(i));
        }
    }

    //take have it in each method

    //display then take in input


    //modfity get the specific index of a value

    //display then ask if they want to do promt or if they want to do one of the choices then proceed to modfity it



}
