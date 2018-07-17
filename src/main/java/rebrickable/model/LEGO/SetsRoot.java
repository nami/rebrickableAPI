package rebrickable.model.LEGO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetsRoot {

    // root variables for lego sets
    int count;
    String next;
    String previous;
    SetsResults[] results;

    // getters & setters
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public SetsResults[] getResults() {
        return results;
    }

    public void setResults(SetsResults[] results) {
        this.results = results;
    }
}
