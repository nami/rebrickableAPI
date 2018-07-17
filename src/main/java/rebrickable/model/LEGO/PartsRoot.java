package rebrickable.model.LEGO;

public class PartsRoot {

    // root variables for lego sets
    int count;
    String next;
    String previous;
    PartsResults[] results;

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

    public PartsResults[] getResults() {
        return results;
    }

    public void setResults(PartsResults[] results) {
        this.results = results;
    }
}
