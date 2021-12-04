package edu.wsu.wsufoodies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProfilePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
    }

    public void goHome(View v){
        startActivity(new Intent(ProfilePage.this, HomePage.class));
    }

    public void goProfile(View v){
        startActivity(new Intent(ProfilePage.this, ProfilePage.class));
    }

    public void goAdd(View v){
        startActivity(new Intent(ProfilePage.this, AddPage.class));
    }

    public void goMain(View v){
        startActivity(new Intent( ProfilePage.this, ActMain.class));
    }
}