package rebrickable.model.LEGO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LDraw {

    // external id variables
    ArrayList<String> LDraw;

    // getters & setters
    public ArrayList<String> getLDraw() {
        return LDraw;
    }

    public void setLDraw(ArrayList<String> LDraw) {
        this.LDraw = LDraw;
    }
}
