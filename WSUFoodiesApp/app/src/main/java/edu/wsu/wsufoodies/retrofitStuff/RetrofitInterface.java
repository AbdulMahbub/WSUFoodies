package edu.wsu.wsufoodies.retrofitStuff;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitInterface {

    // @POST("/login")
    @POST("/loginUser")
    Call<LoginResult> executeLogin(@Body HashMap<String, String> map);

    @POST("/addUser")
    default Call<Void> executeRegister(@Body edu.wsu.wsufoodies.User u) {
        return null;
    }
}
