package Model;

/**
 * Created by Kev on 27/02/2018.
 */

public class Menu {


    private String Starter;
    private String Main;
    private String Desert;
    private String Drink;

    public Menu(String starter, String main, String desert, String drink) {
        Starter = starter;
        Main = main;
        Desert = desert;
        Drink = drink;
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
