package ua.com.foxminded.collectionsandmapsversion2;

import android.app.Application;

import ua.com.foxminded.collectionsandmapsversion2.di.components.AppComponent;

public class App extends Application {
    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.create();
    }

    public static AppComponent getComponent(){
        return component;
    }
}
