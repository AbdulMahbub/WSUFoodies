package edu.wsu.wsufoodies.retrofitStuff;

import com.google.gson.annotations.SerializedName;

public class LoginResult {

    @SerializedName("firstName")
    private String firstName;

    @SerializedName("lastName") //<---- this is needed if the var names r diff
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

