package com.example.interview.nairobidevelopersearcherapp.lib.base;

/**
 * Created by talihomz on 10/9/2017.
 */

public interface EventBus
{
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
