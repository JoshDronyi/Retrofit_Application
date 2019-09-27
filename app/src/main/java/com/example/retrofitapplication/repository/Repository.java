package com.example.retrofitapplication.repository;

import com.example.retrofitapplication.retrofit.RetrofitInstance;
import com.example.retrofitapplication.retrofit.ShibeService;

import java.util.List;

import retrofit2.Call;

public class Repository {

    //a private constructor for the Repository to make it a singleton.
    private Repository() {
    }

    //A private static class whose only purpose is to hold the instance of the Repository.
    private static class RepositoryInstanceHolder {
        //This is the only place our constructor should be called.
        //The new instance is stored in a Repository variable called
        //instance.
        static Repository INSTANCE = new Repository();
    }

    //The one and only access point for outside methods to get an
    //instance of our Repository.
    public static Repository getInstance() {

        //Somewhat reluctantly give away your instance.
        return RepositoryInstanceHolder.INSTANCE;
    }


    //Again. Not sure about the Call<List<String>>
    //The repository's method to give other classes some shibes.
    //Takes an int to represent how many shibes.
    //Call is a type from Retrofit.
    public Call<List<String>> getShibes(int count) {
        //Not completely sure.
        //Theres an instance of a singleton Retrofit object.
        //It is creating an instance of our Shibe service i think
        //it asks the Shibe service for some shibes to return to the
        //method caller.
        return RetrofitInstance.getInstance()
                .create(ShibeService.class)
                .getShibes(count);
        /*return RetrofitInstance
                .createService(ShibeService.class)
                .getShibes(count);*/
    }


}
