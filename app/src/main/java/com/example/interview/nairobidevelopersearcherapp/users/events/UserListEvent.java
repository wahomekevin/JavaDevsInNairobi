package com.example.interview.nairobidevelopersearcherapp.users.events;

import com.example.interview.nairobidevelopersearcherapp.entities.GithubUser;

import java.util.List;

/**
 * Created by talihomz on 10/9/2017.
 */

public class UserListEvent {
    private List<GithubUser> mUsers;
    private String mError;

    public void setUsers(List<GithubUser> users)
    {
        mUsers = users;
    }

    public void setError(String error)
    {
        mError = error;
    }

    public String getError() {
        return mError;
    }

    public List<GithubUser> getUsers()
    {
        return mUsers;
    }
}
