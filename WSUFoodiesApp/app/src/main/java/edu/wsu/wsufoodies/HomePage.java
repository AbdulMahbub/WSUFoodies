package edu.wsu.wsufoodies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {
    String userName;
    TextView welcomeMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        // Retrieve name from successful login
        userName= getIntent().getStringExtra("fullName");

        // Connect controls to change text
        welcomeMessage= findViewById(R.id.welcomeText);

        // Display text retrieved from login screen
        welcomeMessage.setText("Welcome back, "+userName+"!");

    }

    public void goHome(View v){
        String name = userName;
        Intent myIntent = new Intent(HomePage.this, HomePage.class);
        myIntent.putExtra("fullName", name);
        startActivity(myIntent);
    }

    public void goProfile(View v){

        String name = userName;
        Intent myIntent = new Intent(HomePage.this, ProfilePage.class);
        myIntent.putExtra("fullName", name);
        startActivity(myIntent);
    }

    public void goAdd(View v){
        String name = userName;
        Intent myIntent = new Intent(HomePage.this, AddPage.class);
        myIntent.putExtra("fullName", name);
        startActivity(myIntent);
    }
}