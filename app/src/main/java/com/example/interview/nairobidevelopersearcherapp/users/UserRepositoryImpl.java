package com.example.interview.nairobidevelopersearcherapp.users;

import com.example.interview.nairobidevelopersearcherapp.domain.base.NairobiJavaUsersListener;
import com.example.interview.nairobidevelopersearcherapp.domain.base.UsersLoader;
import com.example.interview.nairobidevelopersearcherapp.entities.GithubResponse;
import com.example.interview.nairobidevelopersearcherapp.entities.GithubUser;
import com.example.interview.nairobidevelopersearcherapp.lib.base.EventBus;
import com.example.interview.nairobidevelopersearcherapp.users.events.UserListEvent;

import java.util.List;

/**
 * Created by talihomz on 10/9/2017.
 */

public class UserRepositoryImpl implements UserRepository {

    UsersLoader mUsersLoader;
    EventBus mEventBus;

    public UserRepositoryImpl(UsersLoader usersLoader, EventBus eventBus)
    {
        mUsersLoader = usersLoader;
        mEventBus = eventBus;
    }

    @Override
    public void load() {
        mUsersLoader.loadNairobiJavaDevelopers(new NairobiJavaUsersListener() {
            @Override
            public void onUsersLoaded(GithubResponse response) {
                post(response.getItems(), null);
            }

            @Override
            public void onError(String message) {
                post(null, message);
            }
        });
    }

    private void post(List<GithubUser> users, String error)
    {
        UserListEvent event = new UserListEvent();
        event.setUsers(users);
        event.setError(error);
        mEventBus.post(event);
    }
}
