package com.example.finaldeliverableleviknight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;

public class SecoundActivity extends AppCompatActivity {

    private Family family;
    private RecyclerView mRecyclerView;
    private PersonToPersonAdapter mainAdapter;
    LinkedList<String> defaultList = new LinkedList<String>();
    HashMap<String, String> families;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);                                     // Basic setup
        setContentView(R.layout.activity_secound);

        Intent intent = getIntent();                                            // Get the intent from main and place Hashmap into local variable
        Serializable data = intent.getSerializableExtra("families");
        families = (HashMap<String, String>)data;

        family = new Family(families);                                          // Create instance of the Family class

        mRecyclerView = findViewById(R.id.recyclerview);                        // Connect view

        defaultList = family.createFamilyNamesList();                           // call Family class to create the list for display

        mainAdapter = new PersonToPersonAdapter(this, defaultList);      // setup Adapter in PersonToPerson class
        mRecyclerView.setAdapter(mainAdapter);                                  // send recyclerview to Adapter
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));   // establish layout for Adapter
    }
}