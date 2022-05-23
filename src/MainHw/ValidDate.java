package MainHw;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;

public class ValidDate extends Question{
    @Override
    public void take() {
        output.PrintLine("Please enter a date in the MM/dd/yyy");
        String ans = validateJavaDate();
        ArrayList<String> Answers = new ArrayList<>();
        Answers.add(ans);
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
                output.PrintLine("Please enter the correct answer MM/dd/yyyy");
                String choice2 = validateJavaDate();
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
        output.PrintLine("What is your Correct Date prompt.");
        String Qprompt = input.getInText();
        setPrompt(Qprompt);
        output.PrintLine("Please enter the correct answer MM/dd/yyyy");
        String choice2 = validateJavaDate();
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
//https://beginnersbook.com/2013/05/java-date-format-validation/ got help from here
    public static String validateJavaDate()
    {

        SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
            sdfrmt.setLenient(false);

            boolean correct = true;

            while(true){
                String strDate = input.getInText();
                try
                {
                    Date javaDate = sdfrmt.parse(strDate);
                    System.out.println(strDate+" is valid date format");
                    return strDate;
                }
                /* Date format is invalid */
                catch (ParseException e)
                {
                    System.out.println(strDate+" is Invalid Date format please enter Again\n");
                }
            }

            }

        }


