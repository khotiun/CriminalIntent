package com.example.khotiun.criminalintent;

import android.text.format.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by hotun on 26.06.2017.
 */

public class Crime {

    private UUID mId;//айди обьекта
    private String mTitle;//название преступления
    private String mDate;//дата преступления
    private boolean mSolved;//было ли роскрыто преступление

    public Crime() {
        mId = UUID.randomUUID();//способ генерации уникальных идентификаторов
        mDate = new SimpleDateFormat("E,MMMM dd,yyyy").format(new Date());//орматирование текущей даты в определленном порядке

    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }
}
