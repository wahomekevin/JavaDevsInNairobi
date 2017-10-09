package com.example.interview.nairobidevelopersearcherapp.users.ui;

import com.example.interview.nairobidevelopersearcherapp.entities.GithubUser;

import java.util.List;

/**
 * Created by talihomz on 10/9/2017.
 */

public interface UsersView
{
    void showList();
    void hideList();
    void showProgress();
    void hideProgress();

    void showUsers(List<GithubUser> users);

    void onLoadUsersError(String error);
}
