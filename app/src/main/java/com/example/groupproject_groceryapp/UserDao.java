package com.example.groupproject_groceryapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;


import com.example.groupproject_groceryapp.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("DELETE FROM user")
    public void nukeTable();


    @Query("SELECT * FROM user")
    LiveData<List<User>> loadAllByIds();

    @Insert
    void insertUser(User user);

    @Delete
    void delete(User[] user);
}
