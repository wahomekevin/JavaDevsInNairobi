package com.example.interview.nairobidevelopersearcherapp.domain;

import com.example.interview.nairobidevelopersearcherapp.entities.GithubResponse;

/**
 * Created by talihomz on 10/9/2017.
 */

public interface GithubNairobiJavaUsersListener {
    void onUsersLoaded(GithubResponse response);
    void onError(String message);
}
