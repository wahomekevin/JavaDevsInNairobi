package com.example.interview.nairobidevelopersearcherapp.users;

import com.example.interview.nairobidevelopersearcherapp.users.events.UserListEvent;

/**
 * Created by talihomz on 10/9/2017.
 */

public interface UsersPresenter
{
    void onCreate();
    void onDestroy();

    void loadUsers();

    void onEventMainThread(UserListEvent event);
}
