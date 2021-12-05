package edu.wsu.wsufoodies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    public void goHome(View v){
        startActivity(new Intent(HomePage.this, HomePage.class));
    }

    public void goProfile(View v){
        startActivity(new Intent(HomePage.this, ProfilePage.class));
    }

    public void goAdd(View v){
        startActivity(new Intent(HomePage.this, AddPage.class));
    }
}