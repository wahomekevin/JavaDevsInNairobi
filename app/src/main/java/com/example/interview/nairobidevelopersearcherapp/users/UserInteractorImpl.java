package com.example.interview.nairobidevelopersearcherapp.users;

/**
 * Created by talihomz on 10/10/2017.
 */

public class UserInteractorImpl implements UserInteractor {

    UserRepository mRepository;

    public UserInteractorImpl(UserRepository repository)
    {
        mRepository = repository;
    }

    @Override
    public void loadUsers() {
        mRepository.load();
    }
}
