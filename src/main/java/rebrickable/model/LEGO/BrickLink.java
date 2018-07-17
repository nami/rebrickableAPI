package rebrickable.model.LEGO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BrickLink {

    // external id variable
    ArrayList<String> Bricklink;

    // getters & setters
    public ArrayList<String> getBricklink() {
        return Bricklink;
    }

    public void setBricklink(ArrayList<String> bricklink) {
        Bricklink = bricklink;
    }

}
