package com.example.interview.nairobidevelopersearcherapp.users;

import com.example.interview.nairobidevelopersearcherapp.domain.base.GithubService;
import com.example.interview.nairobidevelopersearcherapp.domain.base.GithubServiceListener;
import com.example.interview.nairobidevelopersearcherapp.entities.GithubResponse;
import com.example.interview.nairobidevelopersearcherapp.entities.GithubUser;
import com.example.interview.nairobidevelopersearcherapp.lib.base.EventBus;
import com.example.interview.nairobidevelopersearcherapp.users.events.UserListEvent;

import java.util.List;

/**
 * Created by talihomz on 10/9/2017.
 */

public class UsersRepositoryImpl implements UsersRepository {

    GithubService mUsersService;
    EventBus mEventBus;

    public UsersRepositoryImpl(GithubService usersService, EventBus eventBus)
    {
        mUsersService = usersService;
        mEventBus = eventBus;
    }

    @Override
    public void load() {
        mUsersService.loadNairobiJavaDevelopers(new GithubServiceListener() {
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
