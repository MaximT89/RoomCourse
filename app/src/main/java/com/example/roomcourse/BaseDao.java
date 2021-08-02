package com.example.roomcourse;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface BaseDao {

    @Query("SELECT * FROM users")
    List<User> getAllUser();

    @Query("SELECT * FROM users WHERE id = :id")
    User getUserById(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);

    @Update
    void updateUser(User user);

    @Delete
    void deleteUser(User user);

}
