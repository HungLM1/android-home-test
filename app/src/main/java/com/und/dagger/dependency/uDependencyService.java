package com.und.dagger.dependency;

import com.und.api.uAPIService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hungle on 01/03/2019.
 */

@Module
public class uDependencyService {

    @Provides
    @Singleton
    public uAPIService getAPIService()
    {
        return new uAPIService();
    }
}
