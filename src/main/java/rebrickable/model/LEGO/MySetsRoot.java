package rebrickable.model.LEGO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MySetsRoot {

    // root of my sets
    int count;
    String next;
    String previous;
    MySetsResults[] results;

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

    public MySetsResults[] getResults() {
        return results;
    }

    public void setResults(MySetsResults[] results) {
        this.results = results;
    }
}
