package edu.wsu.wsufoodies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProfilePage extends AppCompatActivity {

    String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        // Retrieve name from successful login
        userName= getIntent().getStringExtra("fullName");
    }

    public void goHome(View v){
        String name = userName;
        Intent myIntent = new Intent(ProfilePage.this, HomePage.class);
        myIntent.putExtra("fullName", name);
        startActivity(myIntent);
    }

    public void goProfile(View v){
        String name = userName;
        Intent myIntent = new Intent(ProfilePage.this, ProfilePage.class);
        myIntent.putExtra("fullName", name);
        startActivity(myIntent);
    }

    public void goAdd(View v){
        String name = userName;
        Intent myIntent = new Intent(ProfilePage.this, AddPage.class);
        myIntent.putExtra("fullName", name);
        startActivity(myIntent);
    }

    public void goMain(View v){
        startActivity(new Intent( ProfilePage.this, ActMain.class));
    }
}