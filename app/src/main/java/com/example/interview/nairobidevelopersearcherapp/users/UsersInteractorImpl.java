package com.example.interview.nairobidevelopersearcherapp.users;

/**
 * Created by talihomz on 10/10/2017.
 */

public class UsersInteractorImpl implements UsersInteractor {

    UsersRepository mRepository;

    public UsersInteractorImpl(UsersRepository repository)
    {
        mRepository = repository;
    }

    @Override
    public void loadUsers() {
        mRepository.load();
    }
}
