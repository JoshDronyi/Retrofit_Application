package com.example.retrofitapplication.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ShibeService {

    // result = "".../shibes?count=" + count
    @GET(Constants.SHIBE_PATH) //Defines a get method that asks the Shibe suppliers for some shibes.
    Call<List<String>> getShibes(@Query("count") int count);



}
