package com.example.groupproject_groceryapp;


import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;



import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.function.Consumer;

public class MyAllergyAdapter extends RecyclerView.Adapter<MyAllergyAdapter.ViewHolder> {

    String data1[];

    Context context;






    public MyAllergyAdapter(Context ct, String[] s1) {

        context = ct;
        data1 = s1;




    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.fragment_allergies, parent, false );

        return new ViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.text1.setText(data1[position]);

    }


    @Override
    public int getItemCount() {
        if(data1.length > 0) {
            return data1.length;
        }
        else return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.AllergyBox);

        }
    }

}
