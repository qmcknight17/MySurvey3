package MainHw;

import java.io.Serializable;
import java.util.ArrayList;

public class Response implements Serializable {
    private ArrayList<String> responses;

    public Response(ArrayList<String> responses){
        this.responses = responses;
    }

    public ArrayList<String> getResponses() {
        return this.responses;
    }

}
