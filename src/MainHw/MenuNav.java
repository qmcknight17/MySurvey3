package MainHw;

import java.io.IOException;

public class MenuNav extends Main {


    public void mainMenu(){
        System.out.println("1) Create a new Survey\n2) Display a Survey\n3) Load a Survey\n4) Save a Survey\n5) Take a Survey\n6) Modify a Survey\n7) Quit");
        System.out.print("Selection: ");
    }

    public static void mainMenuChoice(int x) throws IOException, ClassNotFoundException {
        switch (x)
        {
            case 1:

                createSurveyTest();

                break;

            case 2:
                printSurvey();
                break;

            case 3:
                LoadSurvey();
                break;

            case 4:
                saveSurvey();
                break;

            case 5:
                takeSurvey();
                break;

            case 6:
                modifySurvey();
                break;

            case 7:
                System.exit(0);
                break;

            default:
                System.err.println ( "Unrecognized option" );
                break;
        }
    }

    public void mainMenu_2(){
        System.out.println("1) Create a new Test\n2) Display a Test\n3) Load a Test\n4) Save a Test\n5) Take a Test\n6) Modify a Test\n7) Tabulate\n8) Grade\n9) Quit");
        System.out.print("Selection: ");
    }

    public static void mainMenuChoice_2(int x) throws IOException, ClassNotFoundException {
        switch (x)
        {
            case 1:
                createSurveyTest();
                break;

            case 2:
                printSurvey();
                break;

            case 3:
                LoadSurvey();
                break;

            case 4:
                saveSurvey();
                break;

            case 5:
                takeSurvey();
                break;

            case 6:
                modifySurvey();
                break;
            case 7:
                tabulate();

                break;

            case 8:
                grade();
                break;

            case 9:
                System.exit(0);
                break;

            default:
                System.err.println ( "Unrecognized option" );
                break;
        }
    }


    public void Questions(){
        System.out.println("1) Add a new T/F question");
        System.out.println("2) Add a new Multiple-Choice Question");
        System.out.println("3) Add a new short answer Question");
        System.out.println("4) Add a new essay question");
        System.out.println("5) Add a new date Question");
        System.out.println("6) Add a new matching Question");
        System.out.println("7) Return to previous Menu");
        System.out.print("Selection: ");
    }

    public static void questionChoice(int x) throws IOException, ClassNotFoundException {
        Question question = null;
        switch (x)
        {
            case 1:
                question = new TrueFalse();
                question.createQuestion();
                getCurrentSurvey().addQuestion(question);
                break;

            case 2:
                question = new MultipleChoice();
                question.createQuestion();
                getCurrentSurvey().addQuestion(question);
                break;
            case 3:
                question = new ShortAnswer();
                question.createQuestion();
                getCurrentSurvey().addQuestion(question);
                break;
            case 4:
                question = new Essay();
                question.createQuestion();
                getCurrentSurvey().addQuestion(question);

                break;

            case 5:
                question = new ValidDate();
                question.createQuestion();
                getCurrentSurvey().addQuestion(question);
                break;
            case 6:
                question = new Matching();
                question.createQuestion();
                getCurrentSurvey().addQuestion(question);
                break;
            case 7:
                StartSurvey();
                break;

            default:
                System.err.println ( "Unrecognized option" );
                break;
        }

    }



}
