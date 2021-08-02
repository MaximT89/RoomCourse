package com.example.roomcourse;

import androidx.room.Dao;
import androidx.room.Transaction;

import java.util.List;

@Dao
public abstract class UserDao implements BaseDao {

    @Transaction
    public List<User> insertAndGetAllUsers(User user){
        insertUser(user);
        return getAllUser();
    }
}
