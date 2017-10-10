package com.example.interview.nairobidevelopersearcherapp.domain.base;

import com.example.interview.nairobidevelopersearcherapp.entities.GithubResponse;

/**
 * Created by talihomz on 10/9/2017.
 */

public interface NairobiJavaUsersListener {
    void onUsersLoaded(GithubResponse response);
    void onError(String message);
}
