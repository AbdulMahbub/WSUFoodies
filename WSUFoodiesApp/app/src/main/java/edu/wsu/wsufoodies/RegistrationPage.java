package edu.wsu.wsufoodies;


import static edu.wsu.wsufoodies.User.Standing.*;

import edu.wsu.wsufoodies.retrofitStuff.*;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistrationPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private final String BASE_URL = "http://10.0.2.2:980";
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String passwordConfirm;
    private int age;
    private User.Standing standing;
    private User newUser;

    EditText emailBox;
    EditText passwordBox;
    TextView message;
    EditText confirmPassword;// = findViewById(R.id.confirmPassword);
    EditText firstNameBox;// = findViewById(R.id.firstName);
    EditText lastNameBox;// = findViewById(R.id.lastName);
    EditText ageBox;// = findViewById(R.id.bdate);
    Spinner standingSelect;// = findViewById(R.id.standing);
    Button submit;
    String standings[]={"FRESHMAN","SOPHOMORE","JUNIOR","SENIOR","GRADUATE","ALUMNUS",
            "FACULTY"};

    User.Standing[] enumValues= new User.Standing[]{
            FRESHMAN, SOPHOMORE, JUNIOR, SENIOR, GRADUATE, ALUMNUS, FACULTY
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);

        message = (TextView) findViewById(R.id.textView2);
        message.setText("Registration Page");
        passwordBox = (EditText) findViewById(R.id.passwordRegister);
        emailBox = (EditText) findViewById(R.id.email);
        confirmPassword = (EditText) findViewById(R.id.confirmPassword);
        firstNameBox = (EditText) findViewById(R.id.firstName);
        lastNameBox = (EditText) findViewById(R.id.lastName);
        ageBox = (EditText) findViewById(R.id.bdate);
        standingSelect = (Spinner) findViewById(R.id.standing);
        submit = (Button) findViewById(R.id.button);

        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(
                this,R.array.userStandings, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        standingSelect.setAdapter(adapter);

        standingSelect.setOnItemSelectedListener(this);


        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface = retrofit.create(RetrofitInterface.class);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = emailBox.getText().toString();
                firstName = firstNameBox.getText().toString();
                lastName = lastNameBox.getText().toString();
                firstName = firstNameBox.getText().toString();
                password = passwordBox.getText().toString();
                passwordConfirm = confirmPassword.getText().toString();

                // standing = User.Standing.ALUMNUS;   //just default to alumnus until I can figure out how
                //to read value from spinner
                if (password.equals("")||firstName.equals("")||lastName.equals("")){
                    Toast.makeText(RegistrationPage.this, "Form incomplete!",
                            Toast.LENGTH_LONG).show();
                }
                else if (!password.equals(passwordConfirm)){
                    Toast.makeText(RegistrationPage.this, "Passwords don't match!",
                            Toast.LENGTH_LONG).show();
                }
                else {

                    if (!(ageBox.getText().toString()).equals("")){
                        age = Integer.parseInt(ageBox.getText().toString());
                        newUser = new User(lastName, firstName, password, email, standing,age);
                    }
                    else {
                        newUser = new User(lastName, firstName, password, email, standing);
                    }

                    message.setText("Welcome!");
                    Call<Void> call = retrofitInterface.executeRegister(newUser);
                    call.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {

                            if(response.code()== 404)
                            {
                                Toast.makeText(RegistrationPage.this,"Email is already taken",
                                        Toast.LENGTH_LONG).show();
                                return;
                            }
                            Toast.makeText(RegistrationPage.this,"Success!",
                                    Toast.LENGTH_LONG).show();

                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            Toast.makeText(RegistrationPage.this, t.getMessage(),
                                    Toast.LENGTH_LONG).show();


                        }
                    });
                }
            }
        });
    }

    /*
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        standing= enumValues[position];
        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

     */


    public void goMain(View v){
        startActivity(new Intent(RegistrationPage.this,
                ActMain.class)); }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text= adapterView.getItemAtPosition(i).toString();
        standing=enumValues[i];
        Toast.makeText(adapterView.getContext(),text,Toast.LENGTH_SHORT);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}