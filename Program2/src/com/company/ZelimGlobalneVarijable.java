package com.company;
import java.util.ArrayList;


public class ZelimGlobalneVarijable {

    private static ZelimGlobalneVarijable  instance;

    ArrayList<Integer> max;
    ArrayList<Integer> min;

    private ZelimGlobalneVarijable () {
        max= new ArrayList<>();
        min= new ArrayList<>();
    }

    public static ZelimGlobalneVarijable  getInstance() {
        if (instance == null) {
            instance = new ZelimGlobalneVarijable ();
        }
        return instance;
    }


}
