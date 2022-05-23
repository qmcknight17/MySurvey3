package MainHw;

import java.io.Serializable;

public class ConsoleOutput implements Out {

    @Override
    public void PrintString(String myString) {
        System.out.print(myString);
    }

    @Override
    public void PrintLine(String myString) {
        System.out.println(myString);
    }
}
