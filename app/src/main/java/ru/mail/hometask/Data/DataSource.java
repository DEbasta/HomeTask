package ru.mail.hometask.Data;

import java.util.ArrayList;
import java.util.List;



public class DataSource {
    private static final DataSource ourInstance = new DataSource();
    private final List<NumberModel> list;
    private final static int amount = 100;


    public static DataSource getInstance() {
        return ourInstance;
    }


    public List<NumberModel> getData() {
        return list;
    }


    public static NumberModel createNumberElem(String title, int i) {
        NumberModel number = new NumberModel(title);
        number.setmColor(i);
        return number;
    }


    private DataSource() {
        list = new ArrayList<>();
        for (int i = 1; i <= amount; ++i) {
            list.add(createNumberElem(Integer.toString(i), i));
        }
    }

}

