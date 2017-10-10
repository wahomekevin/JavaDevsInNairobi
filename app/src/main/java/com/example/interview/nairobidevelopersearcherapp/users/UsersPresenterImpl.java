package com.example.interview.nairobidevelopersearcherapp.users;

import com.example.interview.nairobidevelopersearcherapp.lib.base.EventBus;
import com.example.interview.nairobidevelopersearcherapp.users.events.UserListEvent;
import com.example.interview.nairobidevelopersearcherapp.users.ui.UsersView;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by talihomz on 10/9/2017.
 */

public class UsersPresenterImpl implements UsersPresenter
{
    private UsersView mUsersView;
    private EventBus mEventBus;
    private UsersInteractor mInteractor;

    public UsersPresenterImpl(EventBus eventBus, UsersView view, UsersInteractor interactor)
    {
        mEventBus = eventBus;
        mUsersView = view;
        mInteractor = interactor;
    }

    @Override
    public void onCreate() {
        mEventBus.register(this);
    }

    @Override
    public void onDestroy() {
        mEventBus.unregister(this);
        mUsersView = null;
    }

    @Override
    public void loadUsers() {
        if(mUsersView != null)
        {
            mUsersView.hideList();
            mUsersView.showProgress();
            mInteractor.loadUsers();
        }
    }

    @Override
    @Subscribe
    public void onEventMainThread(UserListEvent event) {
        if(this.mUsersView != null)
        {
            mUsersView.hideProgress();
            mUsersView.showList();

            String error = event.getError();
            if( error != null )
                mUsersView.onLoadUsersError(error);
            else
                mUsersView.showUsers(event.getUsers());
        }
    }
}
