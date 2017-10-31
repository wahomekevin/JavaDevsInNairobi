package com.example.interview.nairobidevelopersearcherapp.domain.di;

/**
 * Created by talihomz on 10/9/2017.
 */

import com.example.interview.nairobidevelopersearcherapp.domain.RetrofitGithubAPI;
import com.example.interview.nairobidevelopersearcherapp.domain.RetrofitGithubService;
import com.example.interview.nairobidevelopersearcherapp.domain.base.GithubService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class DomainModule
{
    private final static String GITHUB_URL = "https://api.github.com/search/";

    @Provides
    @Singleton
    RetrofitGithubAPI providesApi(Retrofit retrofit)
    {
        return retrofit.create(RetrofitGithubAPI.class);
    }

    @Provides
    @Singleton
    Retrofit providesRetrofit() {
        return new Retrofit.Builder()
            .baseUrl(GITHUB_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }


    @Provides
    @Singleton
    GithubService providesGithubService(RetrofitGithubAPI api)
    {
        return new RetrofitGithubService(api);
    }
}
