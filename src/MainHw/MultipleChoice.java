package MainHw;

import java.util.ArrayList;
import java.util.HashMap;

public class MultipleChoice extends Question{

    HashMap<Integer, String> map = new HashMap<>();
    public HashMap<Integer, String> getChoices() {
        return map;
    }

    @Override
    public void take() {
        boolean choice = true;
        ArrayList<String> Answers = new ArrayList<>();
        while (choice == true) {
            output.PrintLine("Please pick one of the multiple Choices");
            String ans = input.getInText();
            Answers.add(ans);
            output.PrintLine("would you like to pick another option(please chose a 1 or 2): \n 1) Yes \n 2) No");
            int pick = input.getInInt();
            switch (pick) {
                case 1:
                    choice = true;
                    break;
                case 2:
                    choice = false;
                    break;
            }
        }
        this.response = new Response(Answers);
    }

    @Override
    public void display() {
        output.PrintLine(getPrompt());
        map.forEach((key, value) -> output.PrintLine(key + ") " + value));
    }

    @Override
    public void displayWithCorrect() {
        output.PrintLine(getPrompt());
        map.forEach((key, value) -> output.PrintLine(key + ") " + value));
        output.PrintLine(correctAnswer.getResponses().toString());

    }


    @Override
    public void modify() {
        output.PrintLine("please chose what you would like to change a 1 or 2: \n 1) prompt \n 2) Multiple choice \n 3) Change nothing");
        int pick = input.getInInt();
        switch (pick) {
            case 1:
                output.PrintLine("Please enter a new Prompt");
                this.Prompt = input.getInText();
                break;
            case 2:
                output.PrintLine("Please enter how many multiple choice you would like to change");
                int choice = input.getInInt();
                while (choice < 0 || choice > map.size()) {
                    choice = input.getInInt();
                    output.PrintLine("Please enter a a valid number");
                }
                for (int x = 1; x <= choice; x++) {
                    output.PrintLine("Please enter the number of the choice you would like to change");
                    int key = input.getInInt();
                    output.PrintLine("Please enter the new choice");
                    String newOption = input.getInText();
                    map.put(key, newOption);
                    break;
                }
            case 3:
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + pick);
        }
        output.PrintLine("would you like to modify the correct answer to this Question(please chose a 1 or 2): \n 1) Yes \n 2) No");
        int pick2 = input.getInInt();
        switch (pick2) {
            case 1:
                output.PrintLine("Please enter the correct answer, please chose the number of the multiple choice ");
                String choice2 = input.getInText();
                ArrayList<String> answer = new ArrayList<>();
                answer.add(choice2);
                this.correctAnswer = new Response(answer);
            case 2:
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + pick2);
        }
    }

    @Override
    public void createQuestion() {
        output.PrintLine("What is your Question prompt");
        //String Qprompt = input.getInText();
        Prompt = input.getInText();
        /* setPrompt(Qprompt); */

        int i = 1;
        boolean choice = true;
        while((choice == true )&& (i <= 10)){
            output.PrintLine("Enter choice #"+i);
            String option = input.getInText();
            map.put(i, option);

            output.PrintLine("would you like to add another Choice(you can add up to 10): \n 1) Yes \n 2) No");
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
                    System.err.println ( "Unrecognized option");
                    break;
            }

        }
        output.PrintLine("Please enter the correct answer( Choose the number of the multiple choice ex: 1  ");
        String choice2 = input.getInText();
        ArrayList<String> answer = new ArrayList<>();
        answer.add(choice2);
        this.correctAnswer = new Response(answer);
    }

    @Override
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

