package Model;

/**
 * Created by Kev on 25/02/2018.
 */

public class ListItem {

    private String description;
    private String name;

    //public ListItem() {
   // }

    public ListItem(String name, String description) {
        this.name = name;
        this.description = description;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


}
