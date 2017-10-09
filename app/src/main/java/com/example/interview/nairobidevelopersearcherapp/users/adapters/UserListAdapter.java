package com.example.interview.nairobidevelopersearcherapp.users.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.interview.nairobidevelopersearcherapp.R;
import com.example.interview.nairobidevelopersearcherapp.entities.GithubUser;
import com.example.interview.nairobidevelopersearcherapp.lib.base.ImageLoader;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by talihomz on 10/9/2017.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.GitHubUserViewHolder> {

    List<GithubUser> mGitHubUsers;
    ImageLoader mImageLoader;

    public UserListAdapter(List<GithubUser> userList, ImageLoader imageLoader) {
        this.mGitHubUsers = userList;
        this.mImageLoader = imageLoader;
    }

    @Override
    public GitHubUserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new GitHubUserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GitHubUserViewHolder holder, int position) {
        GithubUser user = mGitHubUsers.get(position);
        holder.setUserId(user.login);
        holder.setGithubUrl(user.url);
        holder.setAvatar(user.avatar_url);
    }

    public void swapList(List<GithubUser> users)
    {
        mGitHubUsers = users;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mGitHubUsers.size();
    }

    public class GitHubUserViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.userNamesTextView)
        TextView mUserNamesText;

        @BindView(R.id.userGithubUrlTextView)
        TextView mGithubUrlText;

        @BindView(R.id.userAvatarImageView)
        ImageView mUserAvatarImage;

        public GitHubUserViewHolder(View itemView) {
            super(itemView);

            // get view references
            ButterKnife.bind(this, itemView);
        }

        public void setUserId(String username) {
            mUserNamesText.setText(username);
        }

        public void setAvatar(String avatar) {
            mImageLoader.loadImage(mUserAvatarImage, avatar);
        }

        public void setGithubUrl(String url) {
            mGithubUrlText.setText(url);
        }
    }
}

