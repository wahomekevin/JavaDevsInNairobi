package com.example.interview.nairobidevelopersearcherapp.users.di;

import com.example.interview.nairobidevelopersearcherapp.domain.di.DomainModule;
import com.example.interview.nairobidevelopersearcherapp.lib.di.LibModule;
import com.example.interview.nairobidevelopersearcherapp.users.ui.UsersActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by talihomz on 10/9/2017.
 */

@Singleton
@Component(modules = {UserListModule.class, DomainModule.class, LibModule.class})
public interface UserListComponent {
    void inject(UsersActivity activity);
}
