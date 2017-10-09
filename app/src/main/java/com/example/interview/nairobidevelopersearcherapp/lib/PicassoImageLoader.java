package com.example.interview.nairobidevelopersearcherapp.lib;

import android.app.Activity;
import android.widget.ImageView;

import com.example.interview.nairobidevelopersearcherapp.lib.base.ImageLoader;
import com.squareup.picasso.Picasso;

/**
 * Created by talihomz on 10/9/2017.
 */

public class PicassoImageLoader implements ImageLoader
{
    private Picasso picasso;

    public void setLoaderContext(Activity activity)
    {
        picasso = Picasso.with(activity);
    }

    @Override
    public void loadImage(ImageView imageView, String Url)
    {
        picasso
            .load(Url)
            .centerCrop()
            .resize(96, 96)
            .into(imageView);
    }
}
