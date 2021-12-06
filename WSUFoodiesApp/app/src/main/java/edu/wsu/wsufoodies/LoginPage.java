package edu.wsu.wsufoodies;

import androidx.appcompat.app.AppCompatActivity;
import edu.wsu.wsufoodies.retrofitStuff.*;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginPage extends AppCompatActivity {

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL="http://10.0.2.2:980";  // url to work w API

    EditText emailBox;
    EditText passwordBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        // Connect controls to retrieve text
        emailBox= findViewById(R.id.loginEmail);
        passwordBox = findViewById(R.id.loginPassword);

        // Start up the retrofit converter
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface= retrofit.create(RetrofitInterface.class);

        // Set listener for login button
        findViewById(R.id.goButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // If email is empty
                if((emailBox.getText().toString()).equals("")) {
                    Toast.makeText(getApplicationContext(), "Email not entered",Toast.LENGTH_SHORT)
                            .show();
                }

                else if((passwordBox.getText().toString()).equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Password not entered",Toast.LENGTH_SHORT)
                            .show();
                }

                else
                {
                    handleLogin(view);
                }
            }
        });
    }

    private void handleLogin(View v) {
        HashMap<String, String> map = new HashMap<>();

        map.put("email", emailBox.getText().toString());
        map.put("password", passwordBox.getText().toString());

        Call<LoginResult> call = retrofitInterface.executeLogin(map);
        call.enqueue(new Callback<LoginResult>() {
            @Override
            public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                if (response.code()==200)
                {
                    LoginResult result= response.body();

                    Toast.makeText(getApplicationContext(), "Login successful",Toast.LENGTH_LONG)
                            .show();

                    System.out.println("#########First Name: "+ result.getFirstName());
                    System.out.println("#########Last Name: "+ result.getLastName());

                    goHome(v, result);
                }
                else if(response.code()==404) {
                    Toast.makeText(getApplicationContext(), "Wrong credentials",Toast.LENGTH_LONG)
                            .show();
                }
            }

            @Override
            public void onFailure(Call<LoginResult> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(),Toast.LENGTH_LONG)
                        .show();
            }
        });
    }

    public void goMain(View v){
        startActivity(new Intent(LoginPage.this, ActMain.class));
    }

    public void goHome(View v, LoginResult result) {
        String name = result.getFirstName()+" "+result.getLastName();

        Intent myIntent = new Intent(LoginPage.this, HomePage.class);
        myIntent.putExtra("fullName", name);
        startActivity(myIntent);
    }
}