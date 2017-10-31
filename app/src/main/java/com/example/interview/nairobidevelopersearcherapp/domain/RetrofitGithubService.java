package com.example.interview.nairobidevelopersearcherapp.domain;

import com.example.interview.nairobidevelopersearcherapp.domain.base.GithubService;
import com.example.interview.nairobidevelopersearcherapp.domain.base.GithubServiceListener;
import com.example.interview.nairobidevelopersearcherapp.entities.GithubResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by talihomz on 10/9/2017.
 */

public class RetrofitGithubService implements GithubService
{
    private RetrofitGithubAPI mApi;

    public RetrofitGithubService(RetrofitGithubAPI api)
    {
        mApi = api;
    }

    @Override
    public void loadNairobiJavaDevelopers(final GithubServiceListener listener)
    {
        String query = "location:Kenya language:Java";
        int page = 1;
        int resultsPerPage = 1000;

        Call<GithubResponse> call = mApi.listUsers(query, page, resultsPerPage);
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
