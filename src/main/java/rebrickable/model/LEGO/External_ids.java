package rebrickable.model.LEGO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class External_ids {

    // external ids variables
    BrickLink brickLink;
    LEGO lego;
    BrickOwl brickOwl;
    LDraw lDraw;

    // getters & setters
    public BrickLink getBrickLink() {
        return brickLink;
    }

    public void setBrickLink(BrickLink brickLink) {
        this.brickLink = brickLink;
    }

    public LEGO getLego() {
        return lego;
    }

    public void setLego(LEGO lego) {
        this.lego = lego;
    }

    public BrickOwl getBrickOwl() {
        return brickOwl;
    }

    public void setBrickOwl(BrickOwl brickOwl) {
        this.brickOwl = brickOwl;
    }

    public LDraw getlDraw() {
        return lDraw;
    }

    public void setlDraw(LDraw lDraw) {
        this.lDraw = lDraw;
    }
}
