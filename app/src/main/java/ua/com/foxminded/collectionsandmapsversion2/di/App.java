package ua.com.foxminded.collectionsandmapsversion2.di;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;


public class App extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return null;
    }

}
