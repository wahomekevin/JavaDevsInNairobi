package com.example.interview.nairobidevelopersearcherapp.domain.di;

/**
 * Created by talihomz on 10/9/2017.
 */

import com.example.interview.nairobidevelopersearcherapp.domain.GithubNairobiJavaUsersLoader;
import com.example.interview.nairobidevelopersearcherapp.domain.base.GithubService;
import com.example.interview.nairobidevelopersearcherapp.domain.base.GithubUsersLoader;

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
    GithubService providesGithubService(Retrofit retrofit)
    {
        return retrofit.create(GithubService.class);
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
    GithubUsersLoader providesGithubLoader(GithubService service)
    {
        return new GithubNairobiJavaUsersLoader(service);
    }
}
