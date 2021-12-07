package com.example.finaldeliverableleviknight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    HashMap<String, String> families = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showCalculations(View view) {       // Called from onClick

        ReadUIValues();
                                                    // Creates intent for secoundActivity and passes the Hashmap the ReadUIValues created.
        Intent intent = new Intent(this, SecoundActivity.class);
        intent.putExtra("families", families);
        startActivity(intent);
    }

    public void ReadUIValues() {

        EditText editText = null;
        EditText editNumber = null;
        families = new HashMap<String, String>();               // Setup the hash map for reading user input

                                                                // Repeatedly checks all the EditTexts for user input and then calls the addToFamilies method to put in Hashmap
        editText = findViewById(R.id.editTextTextPersonName);
        editNumber = findViewById(R.id.editTextNumber);
        AddToFamilies(editText, editNumber);

        editText = findViewById(R.id.editTextTextPersonName2);
        editNumber = findViewById(R.id.editTextNumber2);
        AddToFamilies(editText, editNumber);

        editText = findViewById(R.id.editTextTextPersonName3);
        editNumber = findViewById(R.id.editTextNumber3);
        AddToFamilies(editText, editNumber);

        editText = findViewById(R.id.editTextTextPersonName4);
        editNumber = findViewById(R.id.editTextNumber4);
        AddToFamilies(editText, editNumber);

        editText = findViewById(R.id.editTextTextPersonName5);
        editNumber = findViewById(R.id.editTextNumber5);
        AddToFamilies(editText, editNumber);

        editText = findViewById(R.id.editTextTextPersonName6);
        editNumber = findViewById(R.id.editTextNumber6);
        AddToFamilies(editText, editNumber);
    }

    public void AddToFamilies(EditText editText, EditText editNumber) {
        try {
            if (editText.getText().toString() != null || editNumber.getText().toString() != null) {
                families.put(editText.getText().toString(), editNumber.getText().toString());       // If nothing form user input is null add to the Hashmap
            } else {
                families.put("Zero", "0");
            }
        } catch(Exception e) {                                       // If else and Try catch are redundantly checking for null values coming from user input
            families.put("Zero", "0");
        }
    }
}

