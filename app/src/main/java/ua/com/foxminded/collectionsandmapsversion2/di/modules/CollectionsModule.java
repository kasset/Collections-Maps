package ua.com.foxminded.collectionsandmapsversion2.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ua.com.foxminded.collectionsandmapsversion2.model.Storage;
import ua.com.foxminded.collectionsandmapsversion2.presenter.CollectionsPresenter;

@Module(includes = StorageModule.class)
public class CollectionsModule {
    @Singleton
    @Provides
    public CollectionsPresenter provideCollectionsPresenter(Storage storage){
        return new CollectionsPresenter(storage);
    }
}
