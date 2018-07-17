package rebrickable.model.LEGO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetsResults {

    // variables for lego sets
    String set_num;
    String name;
    int year;
    int theme_id;
    int num_parts;
    String set_img_url;
    String set_url;
    String last_modified_dt;


    // getters & setters
    public String getSet_num() {
        return set_num;
    }

    public void setSet_num(String set_num) {
        this.set_num = set_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTheme_id() {
        return theme_id;
    }

    public void setTheme_id(int theme_id) {
        this.theme_id = theme_id;
    }

    public int getNum_parts() {
        return num_parts;
    }

    public void setNum_parts(int num_parts) {
        this.num_parts = num_parts;
    }

    public String getSet_img_url() {
        return set_img_url;
    }

    public void setSet_img_url(String set_img_url) {
        this.set_img_url = set_img_url;
    }

    public String getSet_url() {
        return set_url;
    }

    public void setSet_url(String set_url) {
        this.set_url = set_url;
    }

    public String getLast_modified_dt() {
        return last_modified_dt;
    }

    public void setLast_modified_dt(String last_modified_dt) {
        this.last_modified_dt = last_modified_dt;
    }
}
