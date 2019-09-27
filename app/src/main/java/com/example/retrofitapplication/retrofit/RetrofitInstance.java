package com.example.retrofitapplication.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    //Private Constructor for the instance.
    private RetrofitInstance() {
    }

    //Private class for holding the instance of Retrofit once created.
    private static class RetrofitInstanceHolder {

        //Create an instance of Retrofit.
         static Retrofit INSTANCE = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    //Public method to access instance of Retrofit

    public  static Retrofit getInstance(){
        return RetrofitInstanceHolder.INSTANCE;
    }



    //Optimized way for Retrofit

    public  static <S> S createService(Class <S> serviceClass){
        return  RetrofitInstanceHolder.INSTANCE.create(serviceClass);
    }


}
