package MainHw;
import java.io.Serializable;
import java.util.Scanner;

public class ConsoleInput implements In {
    private Out output;
    public ConsoleInput(Out output){
        this.output = output;
    }

    @Override
    public String getInText() {

        while(true)
        {

            Scanner reader = new Scanner(System.in);;
            String input = reader.nextLine();

            if(input.length() > 0)
                return input;
            else
                this.output.PrintLine("Invalid input: ");
        }
    }


    @Override
    public int getInInt() {
        while(true)
        {
            Scanner reader = new Scanner(System.in);;
            String input = reader.nextLine();

            if(checkInt(input))
                return Integer.parseInt(input);
            else
                this.output.PrintLine("Invalid input: ");
        }
    }

    private Boolean checkInt(String input){
        try
        {
            Integer.parseInt(input);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }


}
