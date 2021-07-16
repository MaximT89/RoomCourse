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

    public User(String mUserName, int mUserAge, String mUserCity) {
        this.mUserName = mUserName;
        this.mUserAge = mUserAge;
        this.mUserCity = mUserCity;
    }
}
