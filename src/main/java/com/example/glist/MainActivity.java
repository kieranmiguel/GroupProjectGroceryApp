/*Joette Damo
 * AD340 Project Assignment Group 5
 * June 16, 2020
 * Project ----Product-Recipe-Allergy List
 * Have two menus that pop up "main_menu" and "pop_up_menu"
 * 'Pop up menu you can either update or delete an item on the list when the item is click on the list.
 * main menu  called Add New Product-Recipe-Allergy Item; you can add or cancel an item to the list by clicking the plus button upper right corner.
 * Users enters into the list any product or brand of product with quantity.
 * User can enter recipe items with quantity.
 * User can enter name of store preferred.
 * User can add, update, delete, or cancel items from the "Add New Product-Recipe-Allergy Item"
 * User can add allergies to the list with preferred preferences of products.
 */


package com.example.glist;

import androidx.appcompat.app.AlertDialog;
        import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.EditText;
        import android.widget.ListView;
        import android.widget.PopupMenu;
        import android.widget.Toast;
        import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> list = new ArrayList<>();
    ListView list_view;
    ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_view = findViewById(R.id.list_view);
        arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, list);
        list_view.setAdapter(arrayAdapter);


        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);
                popupMenu.getMenuInflater().inflate(R.menu.pop_up_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()) {

                            case R.id.item_update:
                                //update
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                @SuppressLint("InflateParams") View v = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_dialog, null, false);
                                builder.setTitle("Update Item");
                                final EditText editText = v.findViewById(R.id.etItem);
                                editText.setText(list.get(position));

                                builder.setView(v);

                                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        if (!editText.getText().toString().isEmpty()) {
                                            list.set(position, editText.getText().toString().trim());
                                            arrayAdapter.notifyDataSetChanged();
                                            Toast.makeText(MainActivity.this, "Item Updated!", Toast.LENGTH_SHORT).show();

                                        } else {
                                            editText.setError("add item here !");
                                        }
                                    }
                                });

                                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });

                                builder.show();

                                break;

                            case R.id.item_del:
                                //delete
                                Toast.makeText(MainActivity.this, "Item Deleted", Toast.LENGTH_SHORT).show();
                                list.remove(position);
                                arrayAdapter.notifyDataSetChanged();

                                break;

                        }

                        return true;
                    }
                });

                popupMenu.show();

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.add_item) {//function to add
            _addItem();
        }

        return true;
    }


     // adding item

    private void _addItem() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Add New Product-Recipe-Allergy Item");

        @SuppressLint("InflateParams") View v = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_dialog, null, false);

        builder.setView(v);
        final EditText etItem = v.findViewById(R.id.etItem);
        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (!etItem.getText().toString().isEmpty()) {
                    list.add(etItem.getText().toString().trim());
                    arrayAdapter.notifyDataSetChanged();

                } else {
                    etItem.setError("add item here !");
                }
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.show();


    }
}
