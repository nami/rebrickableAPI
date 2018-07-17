package rebrickable.model.LEGO;

import java.util.HashMap;

public class PartsResults {

    // root variables for lego parts
    String part_num;
    String name;
    int part_cat_id;
    String part_url;
    String part_img_url;
    HashMap<String, String[]> external_ids;

    public HashMap<String, String[]> getExternal_ids() {
        return external_ids;
    }

    public void setExternal_ids(HashMap<String, String[]> external_ids) {
        this.external_ids = external_ids;
    }

    // getters & setters
    public String getPart_num() {
        return part_num;
    }

    public void setPart_num(String part_num) {
        this.part_num = part_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPart_cat_id() {
        return part_cat_id;
    }

    public void setPart_cat_id(int part_cat_id) {
        this.part_cat_id = part_cat_id;
    }

    public String getPart_url() {
        return part_url;
    }

    public void setPart_url(String part_url) {
        this.part_url = part_url;
    }

    public String getPart_img_url() {
        return part_img_url;
    }

    public void setPart_img_url(String part_img_url) {
        this.part_img_url = part_img_url;
    }


}
