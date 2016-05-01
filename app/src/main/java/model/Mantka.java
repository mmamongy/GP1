package model;

import java.util.ArrayList;

/**
 * Created by Maryam on 4/30/2016.
 */
public class Mantka {
    String name ;

    public Mantka(String name) {
        this.name = name;
    }

    ArrayList<String> ahya2 ;

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getAhya2() {
        return ahya2;
    }

    public void setAhya2(ArrayList<String> ahya2) {
        this.ahya2 = ahya2;
    }

    public String getName() {

        return name;
    }
}
