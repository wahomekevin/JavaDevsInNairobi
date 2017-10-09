package com.example.interview.nairobidevelopersearcherapp.libs;

import com.example.interview.nairobidevelopersearcherapp.libs.base.UsersLoader;
import com.example.interview.nairobidevelopersearcherapp.models.GithubUsersResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by talihomz on 10/9/2017.
 */

public class RetrofitUsersLoader implements UsersLoader
{
    private final String GITHUB_URL = "https://api.github.com/search/";
    private Retrofit retrofit;
    private GithubService service;

    public RetrofitUsersLoader()
    {
        retrofit = new Retrofit.Builder()
                .baseUrl(GITHUB_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(GithubService.class);
    }

    @Override
    public void load()
    {
        String query = "location:Nairobi language:Java";
        int page = 1;
        int resultsPerPage = 20;

        Call<GithubUsersResponse> call = service.listUsers(query, page, resultsPerPage);
        call.enqueue(new Callback<GithubUsersResponse>() {
            @Override
            public void onResponse(Call<GithubUsersResponse> call, Response<GithubUsersResponse> response)
            {
                // TODO: 10/9/2017 send response via event bus to activity
            }

            @Override
            public void onFailure(Call<GithubUsersResponse> call, Throwable t)
            {
                // TODO: 10/9/2017 send error response
            }
        });
    }
}
