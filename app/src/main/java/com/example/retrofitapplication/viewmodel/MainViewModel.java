package com.example.retrofitapplication.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.example.retrofitapplication.repository.Repository;
import java.util.List;
import retrofit2.Call;

public class MainViewModel extends AndroidViewModel {


    //Constructor for the view Model. Takes an application object without exception.
    public MainViewModel(@NonNull Application application) {
        super(application);//calls the parent class's constructor
    }

    //Rule being broken here
    //Not sure about the Call<> but it returns a list of strings.
    //Method inteded to be called when you want some Shibes. pass in an int to represent how many you want
    public Call<List<String>> getShibes(int count) {
        //returns the result of calling the only instance of the repository and asking it for some ("count" many) Shibes.
        return Repository.getInstance()
                .getShibes(count);
    }


}
