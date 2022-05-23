package MainHw;

public class Test extends Survey{

    private static Out output = new ConsoleOutput();
    private static In input = new ConsoleInput(output);
    public Test(String name) {
        super(name);
    }

    @Override
    public void grade(){
        int totalScore = this.questions.size() * 10;
        int userScore = this.getGrade();
        double finalGrade = ((double)userScore/ (double)totalScore) * 100;

        output.PrintLine(String.format("Total: %f percent", finalGrade));
    }

    private int getGrade(){
        int grade = 0;
        int numQuestions = this.questions.size();
        for (int i = 0; i < numQuestions; i++) {
            output.PrintLine("Question "+(i+1)+": "+this.questions.get(i).grade());
            grade = grade + this.questions.get(i).grade();
        }
        return grade;
    }
}
