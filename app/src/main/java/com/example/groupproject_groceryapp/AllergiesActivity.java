package com.example.groupproject_groceryapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;


public class AllergiesActivity extends AppCompatActivity {
    MyAllergyAdapter myAdapter;
    String[] data1;
    RecyclerView recyclerView;
    private UserViewModel userViewModel;
    private EditText AllergyEntry;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergies);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        recyclerView = findViewById(R.id.RecyclerView);
        final Observer<List<User>>  getUsersObserver = newUsers -> {
            if (newUsers == null || newUsers.size() <= 0) {
                return;
            }
            data1 = new String[newUsers.size()];
        for(int i = 0; i < newUsers.size(); i++){
            User user = newUsers.get(i);

            if (user == null) {
                return;
            }
            else
                data1[i] = user.getAllergy();
            }

            myAdapter = new MyAllergyAdapter(this, data1);
            recyclerView.setAdapter(myAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

        };

        userViewModel.loadAllByIds(this).observe(this, getUsersObserver);




    }

    public void clear(View view){
        userViewModel.delete(this);
        finish();
    }
    public void back(View view){
        finish();
    }

    public String[] getAllergies(){
        return data1;
    }

    public void updateDatabase(View view) {
        int ID;
        if(data1 == null)
        ID = 0;
        else
        ID = data1.length + 1;


        AllergyEntry = (EditText) findViewById(R.id.AllergyAdd);

        User user1 = new User();
        if ((AllergyEntry.getText().toString().isEmpty())) {
            AllergyEntry.setError(getString(R.string.Empty));
        }
    if(!AllergyEntry.getText().toString().isEmpty())
        user1.setAllergy(AllergyEntry.getText().toString());

        user1.setID(ID);

        userViewModel.insert(this, user1);

        if (myAdapter == null){

            final Observer<List<User>>  getUsersObserver = newUsers -> {
                if (newUsers == null || newUsers.size() <= 0) {
                    return;
                }
                data1 = new String[newUsers.size()];
                for(int i = 0; i < newUsers.size(); i++){
                    User user = newUsers.get(i);

                    if (user == null) {
                        return;
                    }
                    else
                        data1[i] = user.getAllergy();
                }

                myAdapter = new MyAllergyAdapter(this, data1);
                recyclerView.setAdapter(myAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));

            };

            userViewModel.loadAllByIds(this).observe(this, getUsersObserver);
        }
        else myAdapter.notifyDataSetChanged();

    }
}
