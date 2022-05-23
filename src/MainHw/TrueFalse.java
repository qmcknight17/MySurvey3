package MainHw;

import java.util.ArrayList;

public class TrueFalse extends Question {

    //public String response;


    @Override
    public void createQuestion() {
        output.PrintLine("What is your Question prompt");
       //String Qprompt = input.getInText();
        this.Prompt = input.getInText();
        /* setPrompt(Qprompt); */

        output.PrintLine("Please enter the correct answer T or F");
        String choice = input.getInText();
        while( !(choice.equalsIgnoreCase("T") || choice.equalsIgnoreCase("F"))){
            output.PrintLine("invalid Answer please enter : T or F");
            choice = input.getInText();
        }

        ArrayList<String> answer = new ArrayList<>();
        answer.add(choice);
        this.correctAnswer = new Response(answer);

        //will need to implement array
    }



    @Override
    public void display() {
        String questionP = getPrompt();
        output.PrintLine(questionP);
        output.PrintLine("T/F");
    }

    @Override
    public void displayWithCorrect() {
        String questionP = getPrompt();
        output.PrintLine(questionP);
        output.PrintLine("T/F");
        output.PrintLine(correctAnswer.getResponses().toString());
    }


    public void take(){
        output.PrintLine("what is your answer T or F");
        String ans = input.getInText();
        while( !(ans.equalsIgnoreCase("T") || ans.equalsIgnoreCase("F"))){
            output.PrintLine("invalid Answer please enter : T or F");
            ans = input.getInText();
        }
        ArrayList<String> Answers = new ArrayList<>();
        Answers.add(ans);
        this.response = new Response(Answers);
    }

    @Override
    public void modify() {
        output.PrintLine("would you like to modify this Question(please chose a 1 or 2): \n 1) Yes \n 2) No");
        int pick = input.getInInt();
        switch (pick) {
            case 1:
                output.PrintLine("Please enter a new Prompt");
                this.Prompt = input.getInText();
            case 2:
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + pick);
        }

        output.PrintLine("would you like to modify the correct answer to this Question(please chose a 1 or 2): \n 1) Yes \n 2) No");
        int pick2 = input.getInInt();
        switch (pick2) {
            case 1:
                output.PrintLine("Please enter the correct answer T or F");
                String choice = input.getInText();
                while( !(choice.equalsIgnoreCase("T") || choice.equalsIgnoreCase("F"))){
                    output.PrintLine("invalid Answer please enter : T or F");
                    choice = input.getInText();
                }
                ArrayList<String> answer = new ArrayList<>();
                answer.add(choice);
                this.correctAnswer = new Response(answer);
            case 2:
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + pick2);
        }

    }

    public int grade() {
        ArrayList<String> response = getResponse().getResponses();
        ArrayList<String> correctAnswer = getCorrectAnswer().getResponses();
        if (correctAnswer.get(0).equals(response.get(0))) {
            return 10;
        }else {
            return 0;
        }
    }



    }

