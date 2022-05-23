package MainHw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class ShortAnswer extends Question{
    int LIMIT = 250;

    @Override
    public void take() {

        ArrayList<String> Answers = new ArrayList<>();
        System.out.printf("Type in up your short answer up to %d characters (anything in excess will be truncated):", LIMIT);
        String s = input.getInText();
        if (s.length() > LIMIT) {
            s = s.substring(0, LIMIT);
            System.out.printf("You typed in more than %d characters... your input was truncated to \"%s\"%n", LIMIT, s);
        }
        Answers.add(s);
        this.response = new Response(Answers);


    }

    @Override
    public void display() {
        String questionP = getPrompt();
        output.PrintLine(questionP);
    }

    @Override
    public void displayWithCorrect() {
        String questionP = getPrompt();
        output.PrintLine(questionP);
        output.PrintLine(correctAnswer.getResponses().toString());
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
                output.PrintLine("Please enter correct answer");
                String choice = input.getInText();
                while(choice.length() > LIMIT){
                    output.PrintLine("Please enter a correct answer that is less then 250 charaters");
                    choice = input.getInText();
                }
                ArrayList<String> answer = new ArrayList<>();
                answer.add(choice);
                this.correctAnswer = new Response(answer);
            case 2:
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + pick);
        }

    }

    @Override
    public void createQuestion() {
        output.PrintLine("What is your Short answer Question prompt");
        String Qprompt = input.getInText();
        setPrompt(Qprompt);
        output.PrintLine("Please enter correct answer");
        String choice = input.getInText();
        while(choice.length() > LIMIT){
            output.PrintLine("Please enter a correct answer that is less then 250 charaters");
            choice = input.getInText();
        }
        ArrayList<String> answer = new ArrayList<>();
        answer.add(choice);
        this.correctAnswer = new Response(answer);
    }


    @Override
    public int grade() {
        ArrayList<String> response = getResponse().getResponses();
        Collections.sort(response);
        ArrayList<String> correctAnswer = getCorrectAnswer().getResponses();
        Collections.sort(correctAnswer);

        if (response.size() > correctAnswer.size()) {
            output.PrintLine("Response size from user is greater than correct answer size so you will be given a zero");
            return 0;
        }
        for (int i = 0; i < response.size(); i++) {
            if (correctAnswer.get(0).replaceAll("\\s+","").toUpperCase(Locale.ROOT).equals(response.get(0).replaceAll("\\s+","").toUpperCase(Locale.ROOT))) {
                continue;
            }else{
                return 0;
            }
        }
        return 10;
    }
    }

