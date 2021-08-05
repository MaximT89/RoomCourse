package com.example.roomcourse;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

public interface BaseDao {

    @Query("SELECT * FROM users")
    List<User> getAllUser();

    @Query("SELECT * FROM users WHERE id = :id")
    Single<User> getUserById(long id);

    @Query("SELECT * FROM users WHERE id IN (:isList)")
    List<User> getUsersByIdList(List<Long> isList);

    @Query("SELECT * FROM users WHERE age > :age")
    List<User> getUsersByAge(int age);

    @Query("SELECT * FROM users WHERE age BETWEEN :minAge AND :maxAge")
    List<User> getUsersByAge(int minAge, int maxAge);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertUser(User user);

    @Update
    Completable updateUser(User user);

    @Delete
    Completable deleteUser(User user);
}
