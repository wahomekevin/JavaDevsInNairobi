package com.example.interview.nairobidevelopersearcherapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.interview.nairobidevelopersearcherapp.models.GitHubUser;

import java.util.List;

public class UsersActivity extends AppCompatActivity implements UsersView
{
    RecyclerView userListRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: 10/9/2017 setup recycler view
        setupRecyclerView();

        // TODO: 10/9/2017 load data
        loadDataFromGithub();
    }

    private void setupRecyclerView()
    {
        userListRecyclerView = (RecyclerView) findViewById(R.id.devsListRecyclerView);
        userListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void loadDataFromGithub()
    {

    }

    public void setupListAdapter(List<GitHubUser> userList)
    {
        UserListAdapter adapter = new UserListAdapter(userList);
        userListRecyclerView.setAdapter(adapter);
    }

    @Override
    public void showUsers(List<GitHubUser> users) {
        // TODO: 10/9/2017  Implement showing of user
    }

    @Override
    public void showError(String errorMessage) {
        // display error
    }

    // adapter to hold list of users
    class UserListAdapter extends RecyclerView.Adapter<GitHubUserViewHolder>
    {
        List<GitHubUser> mGitHubUsers;

        public UserListAdapter(List<GitHubUser> userList)
        {
            mGitHubUsers = userList;
        }

        @Override
        public GitHubUserViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
            return new GitHubUserViewHolder(view);
        }

        @Override
        public void onBindViewHolder(GitHubUserViewHolder holder, int position)
        {
            GitHubUser user = mGitHubUsers.get(position);
            holder.setUserId(user.login);
            holder.setGithubUrl(user.url);
            holder.setAvatar(user.avatar_url);
        }

        @Override
        public int getItemCount() {
            return mGitHubUsers.size();
        }
    }

    // hold each user item in the list
    class GitHubUserViewHolder extends RecyclerView.ViewHolder
    {
        TextView mUserNamesText;
        TextView mGithubUrlText;
        ImageView mUserAvatarImage;

        public GitHubUserViewHolder(View itemView) {
            super(itemView);

            // get view references
            mUserNamesText = (TextView) itemView.findViewById(R.id.userNamesTextView);
            mGithubUrlText = (TextView) itemView.findViewById(R.id.userGithubUrlTextView);
            mUserAvatarImage = (ImageView) itemView.findViewById(R.id.userAvatarImageView);
        }

        public void setUserId(String username)
        {
            mUserNamesText.setText(username);
        }

        public void setAvatar(String avatar)
        {


        }

        public void setGithubUrl(String url)
        {
            mGithubUrlText.setText(url);
        }
    }
}
