package edu.wsu.wsufoodies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AddPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_page);
    }

    public void goHome(View v){
        startActivity(new Intent(AddPage.this, HomePage.class));
    }

    public void goProfile(View v){
        startActivity(new Intent(AddPage.this, ProfilePage.class));
    }

    public void goAdd(View v){
        startActivity(new Intent(AddPage.this, AddPage.class));
    }
}