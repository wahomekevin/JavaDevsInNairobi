package com.example.interview.nairobidevelopersearcherapp.users.di;

import com.example.interview.nairobidevelopersearcherapp.domain.base.GithubService;
import com.example.interview.nairobidevelopersearcherapp.entities.GithubUser;
import com.example.interview.nairobidevelopersearcherapp.lib.base.EventBus;
import com.example.interview.nairobidevelopersearcherapp.lib.base.ImageLoader;
import com.example.interview.nairobidevelopersearcherapp.users.UsersInteractor;
import com.example.interview.nairobidevelopersearcherapp.users.UsersInteractorImpl;
import com.example.interview.nairobidevelopersearcherapp.users.UsersPresenter;
import com.example.interview.nairobidevelopersearcherapp.users.UsersPresenterImpl;
import com.example.interview.nairobidevelopersearcherapp.users.UsersRepository;
import com.example.interview.nairobidevelopersearcherapp.users.UsersRepositoryImpl;
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
    UsersRepository providesUserRepository(GithubService userLoader, EventBus eventBus){
        return new UsersRepositoryImpl(userLoader, eventBus);
    }

    @Provides
    @Singleton
    UsersPresenter providesUsersPresenter(EventBus eventBus, UsersView view, UsersInteractor interactor)
    {
        return new UsersPresenterImpl(eventBus, view, interactor);
    }

    @Provides
    @Singleton
    UsersInteractor providesUserInteractor(UsersRepository repository)
    {
        return new UsersInteractorImpl(repository);
    }
}
