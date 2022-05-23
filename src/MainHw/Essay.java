package MainHw;

import java.util.ArrayList;

public class Essay extends Question{


    @Override
    public void createQuestion() {
        output.PrintLine("What is your Essay Question prompt");
        String Qprompt = input.getInText();
        setPrompt(Qprompt);
        setQuestionType("Essay");
    }

    @Override
    public int grade() {
        output.PrintLine("Must be graded by teacher");
        return 10;
    }

    @Override
    public void take() {
        boolean choice = true;
        ArrayList<String> Answers = new ArrayList<>();
        while (choice == true) {
            output.PrintLine("Please enter your essay response");
            String ans = input.getInText();
            Answers.add(ans);
            output.PrintLine("would you like to add another response(please chose a 1 or 2): \n 1) Yes \n 2) No");
            int pick = input.getInInt();
            switch (pick) {
                case 1:
                    choice = true;
                    break;
                case 2:
                    choice = false;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + pick);
            }
        }
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

    }
}
