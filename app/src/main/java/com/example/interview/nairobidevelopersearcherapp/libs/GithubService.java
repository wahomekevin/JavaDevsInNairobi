package com.example.interview.nairobidevelopersearcherapp.libs;

import com.example.interview.nairobidevelopersearcherapp.models.GithubUsersResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by talihomz on 10/9/2017.
 */

public interface GithubService
{
    @GET("users")
    Call<GithubUsersResponse> listUsers(
            @Query("q") String query,
            @Query("page") int page,
            @Query("per_page") int resultsPerPage);
}
