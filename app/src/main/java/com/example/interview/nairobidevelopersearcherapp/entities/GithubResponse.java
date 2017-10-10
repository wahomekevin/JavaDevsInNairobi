package com.example.interview.nairobidevelopersearcherapp.entities;

import java.util.List;

/**
 * Created by talihomz on 10/9/2017.
 */

public class GithubResponse
{
    private List<GithubUser> items;

    public List<GithubUser> getItems() {
        return items;
    }

    public void setItems(List<GithubUser> items) {
        this.items = items;
    }
}
