package com.example.listycity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

import android.widget.ListView;

import android.widget.Button;

import android.widget.EditText;


import android.view.View;



public class MainActivity extends AppCompatActivity {
    String deletedCity = null;

    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityList = findViewById(R.id.city_list);

        String []cities = {"Edmonton","Vancouver","Moscow", "Sydney", "Berlin", "Vienna","Tokyo","Beijing", "Osaka", "New Delhi"};

        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityAdapter = new ArrayAdapter<>(this,R.layout.content,dataList);
        cityList.setAdapter(cityAdapter);

        //handle the button logic

        EditText editText = findViewById(R.id.inputField);

        //confirm button
        Button confirmButton = findViewById(R.id.confirmbutton);

        //add cities button here
        Button addButton = findViewById(R.id.addbutton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //show the confirm button
                confirmButton.setVisibility(View.VISIBLE);
                //show the input field
                editText.setVisibility(View.VISIBLE);

            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //we need to add the city to the listview
                String userInput = editText.getText().toString(); // we got the string from the input field
                dataList.add(userInput);

                cityList.setAdapter(cityAdapter); //refreshing the list view

                editText.getText().clear(); //clear the text box

                //show the confirm button
                confirmButton.setVisibility(View.INVISIBLE);
                //show the input field
                editText.setVisibility(View.INVISIBLE);
            }
        });


        //delete cities button here
        //the city that is clicked on should be deleted

        ListView cityList = findViewById(R.id.city_list);

        cityList.setOnItemClickListener((parent, view, position, id) -> {
            // position gives you which item was clicked
            deletedCity = (String) parent.getItemAtPosition(position);
            //choose the deleted item name, and put it in a global string or list variable


        });


        Button deleteButton = findViewById(R.id.deletebutton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if the deleted cities variable has a item in it (not null/none), then delete that item
                //clear the variable by setting to null/none.

                if (deletedCity != null) {
                    //remove the city from the list
                    dataList.remove(deletedCity);

                    cityList.setAdapter(cityAdapter); //refreshing the list view

                    deletedCity = null;
                }


            }
        });
    }
}