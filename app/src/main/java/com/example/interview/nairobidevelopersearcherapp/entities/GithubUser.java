package com.example.interview.nairobidevelopersearcherapp.entities;

/**
 * Created by talihomz on 10/9/2017.
 */

public class GithubUser
{
    private String login;
    private String url;
    private String avatar_url;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
