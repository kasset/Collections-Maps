package ua.com.foxminded.collectionsandmapsversion2.di.components;

import javax.inject.Singleton;

import dagger.Component;
import ua.com.foxminded.collectionsandmapsversion2.di.modules.CollectionsModule;
import ua.com.foxminded.collectionsandmapsversion2.di.modules.MapsModule;

@Singleton
@Component(modules = {CollectionsModule.class, MapsModule.class})
public interface AppComponent {
    void inject();

}
