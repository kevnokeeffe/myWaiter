package Model;

/**
 * Created by Kev on 22/02/2018.
 */

public class Order {
    private int id;
    private String Starter;
    private String Main;
    private String Desert;
    private String Drink;

    public Order(){

    }

    public Order(int id, String Starter, String Main, String Desert, String Drink){
    this.id = id;
    this.Starter = Starter;
    this.Main = Main;
    this.Desert = Desert;
    this.Drink = Drink;

    }
    public Order(String Starter, String Main, String Desert, String Drink){
        this.Starter = Starter;
        this.Main = Main;
        this.Desert = Desert;
        this.Drink = Drink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStarter() {
        return Starter;
    }

    public void setStarter(String starter) {
        Starter = starter;
    }

    public String getMain() {
        return Main;
    }

    public void setMain(String main) {
        Main = main;
    }

    public String getDesert() {
        return Desert;
    }

    public void setDesert(String desert) {
        Desert = desert;
    }

    public String getDrink() {
        return Drink;
    }

    public void setDrink(String drink) {
        Drink = drink;
    }
}
