package com.example.interview.nairobidevelopersearcherapp.domain;

import com.example.interview.nairobidevelopersearcherapp.domain.base.NairobiJavaUsersListener;
import com.example.interview.nairobidevelopersearcherapp.entities.GithubResponse;
import com.example.interview.nairobidevelopersearcherapp.domain.base.UsersLoader;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by talihomz on 10/9/2017.
 */

public class RetrofitNairobiJavaUsersLoader implements UsersLoader
{
    private RetrofitGithubAPI mService;

    public RetrofitNairobiJavaUsersLoader(RetrofitGithubAPI service)
    {
        mService = service;
    }

    @Override
    public void loadNairobiJavaDevelopers(final NairobiJavaUsersListener listener)
    {
        String query = "location:Nairobi language:Java";
        int page = 1;
        int resultsPerPage = 100;

        Call<GithubResponse> call = mService.listUsers(query, page, resultsPerPage);
        call.enqueue(new Callback<GithubResponse>() {
            @Override
            public void onResponse(Call<GithubResponse> call, Response<GithubResponse> response)
            {
                listener.onUsersLoaded(response.body());
            }

            @Override
            public void onFailure(Call<GithubResponse> call, Throwable t)
            {
                listener.onError(t.getMessage());
            }
        });
    }

}
