package ua.com.foxminded.collectionsandmapsversion2.di;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import ua.com.foxminded.collectionsandmapsversion2.di.components.DaggerAppComponent;


public class App extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).builder();
    }

}
