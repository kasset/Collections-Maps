package ua.com.foxminded.collectionsandmapsversion2.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import ua.com.foxminded.collectionsandmapsversion2.model.Storage;
import ua.com.foxminded.collectionsandmapsversion2.presenter.BaseContract;
import ua.com.foxminded.collectionsandmapsversion2.presenter.BasePresenter;
import ua.com.foxminded.collectionsandmapsversion2.presenter.CollectionsPresenter;
import ua.com.foxminded.collectionsandmapsversion2.presenter.MapsPresenter;
import ua.com.foxminded.collectionsandmapsversion2.view.CollectionFragment;
import ua.com.foxminded.collectionsandmapsversion2.view.MapFragment;

@Module
public class AppModule {

    @Provides
    @IntoMap
    @ClassKey(CollectionFragment.class)
    public BaseContract.BasePresenter provideCollectionsPresenter(Storage storage) {
        return new CollectionsPresenter(storage);
    }

    @Provides
    @IntoMap
    @ClassKey(MapFragment.class)
    public BaseContract.BasePresenter provideMapsPresenter(Storage storage) {
        return new MapsPresenter(storage);
    }

    @Singleton
    @Provides
    public Storage provideStorage() {
        return new Storage();
    }

}
