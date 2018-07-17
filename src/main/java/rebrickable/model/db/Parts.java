package rebrickable.model.db;

public class Parts {

    // variables to be mapped to db
    String part_num;
    String name;
    String part_url;

    // constructors

    public Parts(){
    }

    public Parts(String part_num, String name, String part_url) {
        this.part_num = part_num;
        this.name = name;
        this.part_url = part_url;
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

    public String getPart_url() {
        return part_url;
    }

    public void setPart_url(String part_url) {
        this.part_url = part_url;
    }
}
