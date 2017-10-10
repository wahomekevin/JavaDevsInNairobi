package com.example.interview.nairobidevelopersearcherapp.domain;

import com.example.interview.nairobidevelopersearcherapp.entities.GithubResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by talihomz on 10/9/2017.
 */

public interface RetrofitGithubAPI
{
    @GET("users")
    Call<GithubResponse> listUsers(
            @Query("q") String query,
            @Query("page") int page,
            @Query("per_page") int resultsPerPage);
}
