package com.example.interview.nairobidevelopersearcherapp.lib.di;

import android.app.Activity;

import com.example.interview.nairobidevelopersearcherapp.lib.GreenRobotEventBus;
import com.example.interview.nairobidevelopersearcherapp.lib.PicassoImageLoader;
import com.example.interview.nairobidevelopersearcherapp.lib.base.EventBus;
import com.example.interview.nairobidevelopersearcherapp.lib.base.ImageLoader;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by talihomz on 10/9/2017.
 */

@Module
public class LibModule
{
    private Activity mActivity;

    public LibModule(Activity activity)
    {
        mActivity = activity;
    }

    @Provides
    @Singleton
    EventBus providesEventBus()
    {
        return new GreenRobotEventBus();
    }

    @Provides
    @Singleton
    ImageLoader providesImageLoader(Activity activity)
    {
        PicassoImageLoader loader = new PicassoImageLoader();

        if(activity != null)
        {
            loader.setLoaderContext(activity);
        }

        return loader;
    }

    @Provides
    @Singleton
    Activity providesActivity(){
        return this.mActivity;
    }
}
