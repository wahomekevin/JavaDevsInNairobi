package com.example.interview.nairobidevelopersearcherapp;

import android.app.Activity;
import android.app.Application;

import com.example.interview.nairobidevelopersearcherapp.domain.di.DomainModule;
import com.example.interview.nairobidevelopersearcherapp.lib.di.LibModule;
import com.example.interview.nairobidevelopersearcherapp.users.di.DaggerUserListComponent;
import com.example.interview.nairobidevelopersearcherapp.users.di.UserListComponent;
import com.example.interview.nairobidevelopersearcherapp.users.di.UserListModule;
import com.example.interview.nairobidevelopersearcherapp.users.ui.UsersView;

/**
 * Created by talihomz on 10/9/2017.
 */

public class UsersApp extends Application
{
    private DomainModule mDomainModule;
    private LibModule mlibModule;
    private UserListComponent mUserList;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public UserListComponent getUserListComponent(Activity activity, UsersView view)
    {
        return DaggerUserListComponent
                .builder()
                .domainModule(new DomainModule())
                .libModule(new LibModule(activity))
                .userListModule(new UserListModule(view))
                .build();
    }
}
