package com.example.groupproject_groceryapp;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class User {

    @PrimaryKey
    @NonNull
    private int ID;

    @ColumnInfo(name = "Allergy")
    private String Allergy;



    public void setAllergy(String Allergy) {
        this.Allergy = Allergy;
    }

    public String getAllergy() {
        return Allergy;
    }

    public void setID(int ID){this.ID = ID;}

    public int getID(){return ID;}

}


