package ua.com.foxminded.collectionsandmapsversion2.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ua.com.foxminded.collectionsandmapsversion2.model.Storage;
import ua.com.foxminded.collectionsandmapsversion2.presenter.MapsPresenter;

@Module(includes = StorageModule.class)
public class MapsModule {
    @Singleton
    @Provides
    public MapsPresenter provideMapsPresenter(Storage storage){
        return new MapsPresenter(storage);
    }

}
