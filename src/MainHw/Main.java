package MainHw;

import java.io.*;
import java.util.ArrayList;
//Quentin McKnight

public class Main {

    //standard way to display output
    private static Out output = new ConsoleOutput();

    //standard way to take in input
    private static In input = new ConsoleInput(output);

    //creating a new survey object
    private static MenuNav myMenu = new MenuNav();

    private static Survey currentSurvey = null;
    private static String testOrSurvey = null;
    public static String getSurveyTestType() {
        return testOrSurvey;
    }
    public static void setSurveyTestType(String testOrSurvey) {
        Main.testOrSurvey = testOrSurvey;
    }
    public static Survey getCurrentSurvey() {
        return currentSurvey;
    }
    public static void setCurrentSurvey(Survey currentSurvey) {
        Main.currentSurvey = currentSurvey;
    }

    //start the program

    public static void main (String[]args) throws IOException, ClassNotFoundException {
        System.out.println("1) Survey\n2) Test");
        System.out.print("Selection: ");
        while(true){
            int choice = input.getInInt();
            if(choice == 1) {
                setSurveyTestType("Survey");
                StartSurvey();
            }
            else if(choice == 2){
                setSurveyTestType("Test");
                StartTest();
            }
            else{
                output.PrintLine("please put in a vaild option");
            }
        }
    }

    public static void StartSurvey() throws IOException, ClassNotFoundException {
        myMenu.mainMenu();
        output.PrintLine("please Pick a option");
        myMenu.mainMenuChoice(input.getInInt());
    }

    public static void StartTest() throws IOException, ClassNotFoundException {
        myMenu.mainMenu_2();
        output.PrintLine("please Pick a option");
        myMenu.mainMenuChoice_2(input.getInInt());
    }

    //create my survey
    public static void createSurveyTest() throws IOException, ClassNotFoundException {
        output.PrintLine("Name of your " + getSurveyTestType() );
        //String surveyName = input.getInText(); //delete
        if (getSurveyTestType() == "Survey") {
            setCurrentSurvey(new Survey(input.getInText()));
        } else {
            setCurrentSurvey(new Test(input.getInText()));
        }
        output.PrintLine("How many questions do you wish to create: ");
        int PickQuestion = input.getInInt();
        while( PickQuestion != 0 ){
            output.PrintLine("Add question ");
            myMenu.Questions();
            int pick = input.getInInt();
            while(pick < 0 || pick > 6){
                pick = input.getInInt();
            }
            myMenu.questionChoice(pick);
            PickQuestion--;

        }
        if (getSurveyTestType() == "Survey") {
            StartSurvey();
        } else {
            StartTest();
        }
    }

   //main driver of the program


    //this prints the survey
    public static void printSurvey() throws IOException, ClassNotFoundException {
        Survey curSurvey = getCurrentSurvey();

        if (curSurvey == null) {
            output.PrintLine("You have not selected a survey");
        } else if (getSurveyTestType() == "Survey") {
            output.PrintLine(curSurvey.getSurveyName() + " is being printed \n");
            ArrayList<Question> AllQuestions = curSurvey.getQuestions();
            for (int i = 1; i <= AllQuestions.size(); i++) {
                output.PrintLine("Question" + i + ") ");
                AllQuestions.get(i - 1).display();
                output.PrintLine("\n");
            }
        } else {
            output.PrintLine(curSurvey.getSurveyName() + " is being printed \n");
            ArrayList<Question> AllQuestions = curSurvey.getQuestions();
            output.PrintLine("would you like to see the correct answer to this Question(please chose a 1 or 2): \n 1) Yes \n 2) No");
            int choice = input.getInInt();
            switch (choice) {
                case 1:
                    for (int i = 1; i <= AllQuestions.size(); i++) {
                        output.PrintLine("Question" + i + ") ");
                        AllQuestions.get(i - 1).displayWithCorrect();
                        output.PrintLine("\n");}
                    break;
                case 2:
                    for (int i = 1; i <= AllQuestions.size(); i++) {
                        output.PrintLine("Question" + i + ") ");
                        AllQuestions.get(i - 1).display();
                        output.PrintLine("\n");}
                    break;

                default:
                    System.err.println("Unrecognized option");
                    break;
                    }
            }

            if (getSurveyTestType() == "Survey") {
                StartSurvey();
            } else {
                StartTest();
            }
        }



    public static void tabulate() throws IOException, ClassNotFoundException {
        Survey curSurvey = getCurrentSurvey();
        if(curSurvey == null){
            output.PrintLine("You have not selected a survey");
        }
        else{
            output.PrintLine("\n"+curSurvey.getSurveyName()+" is tabulated below: \n");
            curSurvey.tabulate();
            }
        if (getSurveyTestType() == "Survey") {
            StartSurvey();
        } else {
            StartTest();
        }
    }


    public static void grade() throws IOException, ClassNotFoundException {
        output.PrintLine("Test will be graded automatically once you take them");
        StartTest();
    }


    //this takes the survey
    public static void takeSurvey() throws IOException, ClassNotFoundException {
        Survey curSurvey = getCurrentSurvey();

        if(curSurvey == null){
            output.PrintLine("You have not selected a survey");
        }
        else{
            output.PrintLine(curSurvey.getSurveyName() + " is being Taken ");
            ArrayList<Question> AllQuestions = curSurvey.getQuestions();
            curSurvey.Take();
            curSurvey.grade();
//            for (int i = 1; i <= AllQuestions.size(); i++){
//                output.PrintLine(i+") ");
//                AllQuestions.get(i-1).display();
//                AllQuestions.get(i-1).take();
//                output.PrintLine("\n");
//            }
        }

        if (getSurveyTestType() == "Survey") {
            StartSurvey();
        } else {
            StartTest();
        }
    }

    public static void modifySurvey() throws IOException, ClassNotFoundException {
        Survey curSurvey = getCurrentSurvey();

        if(curSurvey == null){
            output.PrintLine("You have not selected a survey");
        }
        else{
            output.PrintLine(curSurvey.getSurveyName() + " is being modified ");
            ArrayList<Question> AllQuestions = curSurvey.getQuestions();
            for (int i = 1; i <= AllQuestions.size(); i++){
                output.PrintLine(i+") ");
                AllQuestions.get(i-1).display();
                AllQuestions.get(i-1).modify();
                output.PrintLine("\n");
            }
        }
        if (getSurveyTestType() == "Survey") {
            StartSurvey();
        } else {
            StartTest();
        }
    }

    public static void saveSurvey() throws IOException, ClassNotFoundException {
        Survey survey = getCurrentSurvey();
        if(survey == null){
            output.PrintLine("There is no survey to save!");
        }else if(getSurveyTestType() == "Survey"){
            if(survey.questions.get(0).getResponse() == null){
            File directory = getDirectory();
            serialize(directory, getCurrentSurvey());
            setCurrentSurvey(null);}
            else{
                getCurrentSurvey().setSurveyName(getCurrentSurvey().getSurveyName() + "__Response");
                File directory = getDirectory();
                serialize(directory, getCurrentSurvey());
                setCurrentSurvey(null);
            }
        }else {
            if(survey.questions.get(0).getResponse() == null){
                getCurrentSurvey().setSurveyName(getCurrentSurvey().getSurveyName() + "__Test");
                File directory = getDirectory();
                serialize(directory, getCurrentSurvey());
                setCurrentSurvey(null);}
            else{
                getCurrentSurvey().setSurveyName(getCurrentSurvey().getSurveyName() + "__Response");
                File directory = getDirectory();
                serialize(directory, getCurrentSurvey());
                setCurrentSurvey(null);
            }

        }

        if (getSurveyTestType() == "Survey") {
            StartSurvey();
        } else {
            StartTest();
        }
    }



    public static void LoadSurvey() throws IOException, ClassNotFoundException {
        File surveyDirectory = getDirectory();

        File[] allSurvey = surveyDirectory.listFiles();
        //Code below gotten from https://stackoverflow.com/questions/5694385/getting-the-filenames-of-all-files-in-a-folder
        ArrayList<String> availableSurvey = new ArrayList<String>();
        if (allSurvey.length > 0) {
            output.PrintLine("pick your survey");
        } else {
            output.PrintLine("there are no surveys");
            StartSurvey();
        }
        for (int i = 0; i < allSurvey.length; i++) {
            if (allSurvey[i].isFile()) {
                output.PrintLine((i + 1) + ") " + allSurvey[i].getName());
                availableSurvey.add(allSurvey[i].getName());
            }
        }
        helperloadSurvey(availableSurvey);
    }


    public static void helperloadSurvey(ArrayList<String> availFiles) throws IOException, ClassNotFoundException {
     //  String type = getSurveyTestType();
        int availFileLength = availFiles.size();
        int choice = input.getInInt();

        while (choice < 0 || choice > availFileLength) {
            choice = input.getInInt();
        }
        File dir = getDirectory();
        setCurrentSurvey(deserialize(dir, availFiles.get(choice - 1)));
        if (getSurveyTestType() == "Survey") {
            StartSurvey();
        } else {
            StartTest();
        }
    }

//https://mkyong.com/java/how-to-read-and-write-java-object-to-a-file/ got help from this site

    public static void serialize(File directory, Survey object){
        try{
            FileOutputStream newFile = new FileOutputStream(directory + File.separator + object.surveyName);
            ObjectOutputStream o = new ObjectOutputStream(newFile);
            o.writeObject(object);
            o.close();
            newFile.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Survey deserialize(File directory, String file) {
        Survey loadedSurvey = null;
        try{
            FileInputStream newFile = new FileInputStream(new File(directory + File.separator + file));
            ObjectInputStream oi = new ObjectInputStream(newFile);
            loadedSurvey = (Survey) oi.readObject();
            oi.close();
            newFile.close();
            return loadedSurvey;

        }catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
            output.PrintLine(" could not be deserialized!");
            return loadedSurvey;
        }
    }
//https://stackoverflow.com/questions/15701707/how-to-create-a-folder-in-eclipse-for-storing-serialized-objects
    public static File getDirectory()
    {
        File serializedDir;
        serializedDir = new File("SurveyDirectory");
        if (!serializedDir.exists()) {
            serializedDir.mkdir();
        }
        return serializedDir;
    }
}



