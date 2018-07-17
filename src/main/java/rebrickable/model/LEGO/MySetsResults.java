package rebrickable.model.LEGO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MySetsResults {

    // set results variables
    int list_id;
    int quantity;
    boolean include_spares;
    Set set;

    // getters & setters
    public int getList_id() {
        return list_id;
    }

    public void setList_id(int list_id) {
        this.list_id = list_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isInclude_spares() {
        return include_spares;
    }

    public void setInclude_spares(boolean include_spares) {
        this.include_spares = include_spares;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }
}
