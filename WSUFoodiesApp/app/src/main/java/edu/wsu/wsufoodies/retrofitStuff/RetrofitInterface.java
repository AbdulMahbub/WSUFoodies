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
    Call<Void> executeRegister(@Body HashMap<String, String> map);
}
