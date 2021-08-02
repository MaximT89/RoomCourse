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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public int getUserAge() {
        return mUserAge;
    }

    public void setUserAge(int mUserAge) {
        this.mUserAge = mUserAge;
    }

    public String getUserCity() {
        return mUserCity;
    }

    public void setUserCity(String mUserCity) {
        this.mUserCity = mUserCity;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", mUserName='" + mUserName + '\'' +
                ", mUserAge=" + mUserAge +
                ", mUserCity='" + mUserCity + '\'' +
                '}';
    }
}
