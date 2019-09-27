package com.example.retrofitapplication.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitapplication.R;
import com.example.retrofitapplication.adapter.ShibeAdapter;
import com.example.retrofitapplication.viewmodel.MainViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //Declared variable for viewModel instance
    private MainViewModel viewModel;
    //Declared variable for recycleerview instance
    private RecyclerView rvShibes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //calls onCreate of the AppCompatActivity . passes saved instance.
        setContentView(R.layout.activity_main); //attached the layout "activity_main" to our main activity

        //initialize the viewModel instance
        viewModel = ViewModelProviders  //Make sure it is the one with an s at the end.
                .of(this)  //method that needs context to give to the ViewModel
                .get(MainViewModel.class); //method to reference which viewModel class you are looking for.

        //initialize the recyclerView instance
        rvShibes = findViewById(R.id.rv_shibes);

        //Declare and instantiate a LinearLayoutManager object called manager, gives manager context from Main Activity.
        LinearLayoutManager manager = new LinearLayoutManager(this);
        //tell the recyclerView which layout manager to use (the one we created)
        rvShibes.setLayoutManager(manager);

        //because the height of the imageView in shibe_item is a fixed 200dp
        rvShibes.setHasFixedSize(true);







        viewModel
                .getShibes(15) //the activity asks the viewModel for some Shibes and returns the Call Object.
                .enqueue(new Callback<List<String>>() { //a method of the Call Object to be called once the viewModel gets the information we asked for.
                    @Override
                    public void onResponse(Call<List<String>> call, Response<List<String>> response) {  //ViewModel had what we asked for and all is well
                        //Declare and instantiate an instance of the ShibeAdapter class called adapter.
                        // Pass the body of the response the viewModel gave us to the adapter
                        ShibeAdapter adapter = new ShibeAdapter(response.body());

                        //tell the recyclerView to use our handy dandy new ShibeAdapter.
                        rvShibes.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<List<String>> call, Throwable t) { //ViewModel says something went terribly terribly wrong (Sean Connory voice)
                        Toast.makeText(MainActivity.this, "FAILED!!", Toast.LENGTH_SHORT).show(); //Makes "Failed" pop up in the screen and disappear (rude!)
                        t.printStackTrace(); //prints the problem to the log.
                    }
                });



    }
}
