package ru.mail.hometask.Data;

import android.graphics.Color;

public class NumberModel {
    private String mTitle;
    private int mColor;

    public NumberModel(String title) {
        mTitle = title;
    }

    public int getmColor() {
        return mColor;
    }

    public void setmColor(int number) {
        if (number % 2 == 0)
            this.mColor = Color.RED;
        else
            this.mColor = Color.BLUE;
    }

    public String getmTitle() {
        return mTitle;
    }


}
