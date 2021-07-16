package com.example.roomcourse;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String mUserName;

    @ColumnInfo(name = "age")
    public int mUserAge;

    @ColumnInfo(name = "city")
    public String mUserCity;

    public User(int id, String mUserName, int mUserAge, String mUserCity) {
        this.id = id;
        this.mUserName = mUserName;
        this.mUserAge = mUserAge;
        this.mUserCity = mUserCity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public int getmUserAge() {
        return mUserAge;
    }

    public void setmUserAge(int mUserAge) {
        this.mUserAge = mUserAge;
    }

    public String getmUserCity() {
        return mUserCity;
    }

    public void setmUserCity(String mUserCity) {
        this.mUserCity = mUserCity;
    }
}
