package com.example.interview.nairobidevelopersearcherapp.users.di;

import com.example.interview.nairobidevelopersearcherapp.domain.base.UsersLoader;
import com.example.interview.nairobidevelopersearcherapp.entities.GithubUser;
import com.example.interview.nairobidevelopersearcherapp.lib.base.EventBus;
import com.example.interview.nairobidevelopersearcherapp.lib.base.ImageLoader;
import com.example.interview.nairobidevelopersearcherapp.users.UserInteractor;
import com.example.interview.nairobidevelopersearcherapp.users.UserInteractorImpl;
import com.example.interview.nairobidevelopersearcherapp.users.UserPresenter;
import com.example.interview.nairobidevelopersearcherapp.users.UserPresenterImpl;
import com.example.interview.nairobidevelopersearcherapp.users.UserRepository;
import com.example.interview.nairobidevelopersearcherapp.users.UserRepositoryImpl;
import com.example.interview.nairobidevelopersearcherapp.users.adapters.UserListAdapter;
import com.example.interview.nairobidevelopersearcherapp.users.ui.UsersView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by talihomz on 10/9/2017.
 */

@Module
public class UserListModule {

    UsersView mView;

    public UserListModule(UsersView view)
    {
        mView = view;
    }

    @Provides
    @Singleton
    UsersView providesUsersView()
    {
        return mView;
    }

    @Provides
    @Singleton
    UserListAdapter providesUserAdapter(List<GithubUser> githubUsers, ImageLoader imageLoader){
        return new UserListAdapter(githubUsers, imageLoader);
    }

    @Provides
    @Singleton
    List<GithubUser> providesGithubUsers() {
        return new ArrayList<>();
    }

    @Provides
    @Singleton
    UserRepository providesUserRepository(UsersLoader userLoader, EventBus eventBus){
        return new UserRepositoryImpl(userLoader, eventBus);
    }

    @Provides
    @Singleton
    UserPresenter providesUsersPresenter(EventBus eventBus, UsersView view, UserInteractor interactor)
    {
        return new UserPresenterImpl(eventBus, view, interactor);
    }

    @Provides
    @Singleton
    UserInteractor providesUserInteractor(UserRepository repository)
    {
        return new UserInteractorImpl(repository);
    }
}
