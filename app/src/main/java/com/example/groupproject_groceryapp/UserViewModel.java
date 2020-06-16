package com.example.groupproject_groceryapp;

import com.example.groupproject_groceryapp.AppDatabase;
import com.example.groupproject_groceryapp.AppDatabaseSingleton;
import com.example.groupproject_groceryapp.User;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class UserViewModel extends ViewModel {


    public void insert(Context context, User user) {
        AppDatabase db = AppDatabaseSingleton.getDatabase(context);
        db.getTransactionExecutor().execute(() -> {
            db.userDao().insertUser(user);
        });
    }

    public void delete(Context context) {
        AppDatabase db = AppDatabaseSingleton.getDatabase(context);
        db.getTransactionExecutor().execute(() -> {
            db.userDao().nukeTable();
        });
    }

    public LiveData<List<User>> loadAllByIds(Context context) {
        AppDatabase db = AppDatabaseSingleton.getDatabase(context);
        return db.userDao().loadAllByIds();

    }
}
