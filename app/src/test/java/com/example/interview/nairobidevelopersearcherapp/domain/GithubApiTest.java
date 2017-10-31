package com.example.interview.nairobidevelopersearcherapp.domain;

import com.example.interview.nairobidevelopersearcherapp.BaseClass;
import com.example.interview.nairobidevelopersearcherapp.BuildConfig;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by talihomz on 10/11/2017.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class GithubApiTest extends BaseClass{
    private RetrofitGithubAPI mApi;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        // TODO: 10/11/2017 mock the github api
    }
}
