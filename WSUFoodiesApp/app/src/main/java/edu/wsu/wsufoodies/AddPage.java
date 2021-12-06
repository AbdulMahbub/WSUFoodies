package edu.wsu.wsufoodies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AddPage extends AppCompatActivity {

    String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_page);

        // Retrieve name from successful login
        userName= getIntent().getStringExtra("fullName");
    }

    public void goHome(View v){
        String name = userName;
        Intent myIntent = new Intent(AddPage.this, HomePage.class);
        myIntent.putExtra("fullName", name);
        startActivity(myIntent);
    }

    public void goProfile(View v){
        String name = userName;
        Intent myIntent = new Intent(AddPage.this, ProfilePage.class);
        myIntent.putExtra("fullName", name);
        startActivity(myIntent);
    }

    public void goAdd(View v){
        String name = userName;
        Intent myIntent = new Intent(AddPage.this, AddPage.class);
        myIntent.putExtra("fullName", name);
        startActivity(myIntent);
    }
}