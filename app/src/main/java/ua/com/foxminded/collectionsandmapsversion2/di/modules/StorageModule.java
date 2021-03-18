package ua.com.foxminded.collectionsandmapsversion2.di.modules;

import dagger.Module;
import ua.com.foxminded.collectionsandmapsversion2.model.Storage;
import ua.com.foxminded.collectionsandmapsversion2.presenter.CollectionsPresenter;
import ua.com.foxminded.collectionsandmapsversion2.presenter.MapsPresenter;

@Module
public class StorageModule {
    public Storage provideStorage() {
        return new Storage();
    }
}
