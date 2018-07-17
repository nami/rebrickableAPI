package rebrickable.model.LEGO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LEGO {

    // external id variable
    ArrayList<String> LEGO;

    // getters & setters
    public ArrayList<String> getLEGO() {
        return LEGO;
    }

    public void setLEGO(ArrayList<String> LEGO) {
        this.LEGO = LEGO;
    }
}
