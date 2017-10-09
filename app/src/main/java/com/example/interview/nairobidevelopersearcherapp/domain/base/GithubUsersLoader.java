package com.example.interview.nairobidevelopersearcherapp.domain.base;

import com.example.interview.nairobidevelopersearcherapp.domain.GithubNairobiJavaUsersListener;

/**
 * Created by talihomz on 10/9/2017.
 */

public interface GithubUsersLoader
{
    void loadNairobiJavaDevelopers(GithubNairobiJavaUsersListener listener);
}
