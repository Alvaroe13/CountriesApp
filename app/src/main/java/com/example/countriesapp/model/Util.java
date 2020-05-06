package com.example.countriesapp.model;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.countriesapp.R;

import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

public class Util {

    /**
     * this method will upload image by using Glide
     * @param picture
     * @param flagURL
     * @param progressDrawableBar
     */
    public static void loadPicture(ImageView picture, String flagURL, CircularProgressDrawable progressDrawableBar){
        //lets add some options to work by default
        RequestOptions opts  = new RequestOptions()
                .placeholder(progressDrawableBar)
                .error(R.mipmap.ic_launcher_round);
        //here we set info using Glide
        Glide.with(picture.getContext()).setDefaultRequestOptions(opts).load(flagURL).into(picture);
    }

    /**
     * we create a ProgressBar spin with custom details.
     * @param context
     * @return
     */
    public static CircularProgressDrawable getProgressBar(Context context){
        CircularProgressDrawable progressDrawableBar = new CircularProgressDrawable(context);
        progressDrawableBar.setStrokeWidth(10f);
        progressDrawableBar.setCenterRadius(50f);
        progressDrawableBar.start();
        return  progressDrawableBar;
    }



}
