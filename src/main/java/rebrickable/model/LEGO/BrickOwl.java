package rebrickable.model.LEGO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BrickOwl {

    // external id variables
    ArrayList<String> BrickOwl;

    // getters & setters
    public ArrayList<String> getBrickOwl() {
        return BrickOwl;
    }

    public void setBrickOwl(ArrayList<String> brickOwl) {
        BrickOwl = brickOwl;
    }
}
