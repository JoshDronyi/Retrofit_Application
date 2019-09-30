package com.example.retrofitapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.retrofitapplication.R;

import java.util.List;

//Create a class that extend sthe recyclerview's adapter class.
//The adapter class takes in a ViewHolder class.
public class ShibeAdapter extends RecyclerView.Adapter<ShibeAdapter.ShibeViewHolder> {

    //Declare a variable of type list of strings to hold the list of shibe urls
    private List<String> shibeUrls;
    //Declare a Context variable to hold our context
    private Context context;

    //Constructor that takes a list of shibe urls
    public ShibeAdapter(List<String> shibeUrls) {
        //assign our list variable to the shibe urls that got passed in.
        this.shibeUrls = shibeUrls;
    }

    @NonNull
    @Override //Method used to creates the view holder
    public ShibeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //puts context from the parent viewgroup into our context variable that we declared by
        //didnt instantiate.
        context = parent.getContext();

        //Declared a view object and assigned it a View object that contains the contents of sibe_item xml file.
        View view = LayoutInflater.from(context).inflate(
                R.layout.shibe_item,
                parent,
                false);
        //returns a newly instantiated ViewHolder object that has a view object
        // with the contents of shibe_item xml file.
        return new ShibeViewHolder(view);
    }

    @Override //Binds the Views of the view holder to the information contained in the class
    public void onBindViewHolder(@NonNull ShibeViewHolder holder, int position) {
        //Take one url from the list of urls passed in from our constructor
        //by calling the get method and passing in the int representing our
        // current position in the array.
        String shibeUrl = shibeUrls.get(position);

        //Gives the static Glide Object context
        Glide.with(context)
                .load(shibeUrl)//Gives the glide object the url of which shibe to load.
                .circleCrop() //Formats how the picture fits into the image view.
                .into(holder.ivShibeImage); //tells the glide object which view object to load the shibe picture into.
    }

    @Override //A method that can be called to return how many items are in the list.
    public int getItemCount() {
        //the statement that actually returns the size of list.
        return shibeUrls.size();
    }

    //A class to define what a ShibeViewHolder should look like
    class ShibeViewHolder extends RecyclerView.ViewHolder {
        //Declare an ImageView variable called iveShibeImage.
        ImageView ivShibeImage;

        //The constructor of the ShibeViewHolder. Receives the View sent in line 44.
        ShibeViewHolder(@NonNull View itemView) {
            super(itemView); //always call the parent's constructor.
            //assign the ImageView variable to the View with the id iv_shibe_image.
            ivShibeImage = itemView.findViewById(R.id.iv_shibe_image);
        }
    }
}