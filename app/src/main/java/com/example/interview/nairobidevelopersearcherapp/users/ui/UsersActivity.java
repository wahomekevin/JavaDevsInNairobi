package com.example.interview.nairobidevelopersearcherapp.users.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.interview.nairobidevelopersearcherapp.R;
import com.example.interview.nairobidevelopersearcherapp.UsersApp;
import com.example.interview.nairobidevelopersearcherapp.entities.GithubUser;
import com.example.interview.nairobidevelopersearcherapp.users.UsersPresenter;
import com.example.interview.nairobidevelopersearcherapp.users.adapters.UserListAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UsersActivity extends AppCompatActivity implements UsersView
{
    @BindView(R.id.devsListRecyclerView)
    RecyclerView mUserListRecyclerView;

    @BindView(R.id.loadUsersProgressBar)
    ProgressBar mProgress;

    @Inject
    UserListAdapter mAdapter;

    @Inject
    UsersPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupInjection();

        // create view references
        ButterKnife.bind(this);

        // setup recycler view
        setupRecyclerView();

        mPresenter.onCreate();
        mPresenter.loadUsers();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDestroy();
        super.onDestroy();
    }

    private void setupInjection() {
        UsersApp app = new UsersApp();
        app.getUserListComponent(this, this).inject(this);
    }

    private void setupRecyclerView()
    {
        mUserListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mUserListRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showList() {
        mUserListRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideList() {
        mUserListRecyclerView.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        mProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgress.setVisibility(View.GONE);
    }

    @Override
    public void showUsers(List<GithubUser> users) {
        mAdapter.swapList(users);
    }

    @Override
    public void onLoadUsersError(String error) {
        Toast.makeText(this, "Could not load from repository", Toast.LENGTH_SHORT).show();
    }
}
