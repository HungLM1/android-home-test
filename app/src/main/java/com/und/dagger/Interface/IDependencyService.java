package com.und.dagger.Interface;

import com.und.application.uApplication;
import com.und.dagger.dependency.uDependencyService;
import com.und.view.activity.MainPresenter;

import javax.inject.Singleton;
import dagger.Component;

/**
 * Created by hungle on 01/03/2019.
 */

@Singleton
@Component(modules = {uDependencyService.class})
public interface IDependencyService {

    void inject(uApplication app);

    void inject(MainPresenter presenter);

    final class Initializer {

        public static IDependencyService init(uApplication app) {

            return DaggerIDependencyService.builder().build();
        }
    }
}
