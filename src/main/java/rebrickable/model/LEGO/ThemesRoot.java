package rebrickable.model.LEGO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// if it's not in your class, it will not map it
@JsonIgnoreProperties(ignoreUnknown = true)
// thie class is generic as there will be several API calls that will change results
public class ThemesRoot<T> {

    // root variables for themes
    int count;
    String next;
    String previous;
    ThemesResults[] results;

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

    public ThemesResults[] getResults() {
        return results;
    }

    public void setResults(ThemesResults[] results) {
        this.results = results;
    }
}
