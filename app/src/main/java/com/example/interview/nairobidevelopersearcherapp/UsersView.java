package com.example.interview.nairobidevelopersearcherapp;

import com.example.interview.nairobidevelopersearcherapp.models.GitHubUser;

import java.util.List;

/**
 * Created by talihomz on 10/9/2017.
 */

public interface UsersView
{
    void showUsers(List<GitHubUser> users);
    void showError(String errorMessage);
}
