package ua.com.foxminded.collectionsandmapsversion2.di.modules;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import ua.com.foxminded.collectionsandmapsversion2.presenter.BasePresenter;
import ua.com.foxminded.collectionsandmapsversion2.presenter.CollectionsPresenter;
import ua.com.foxminded.collectionsandmapsversion2.presenter.MapsPresenter;

@Module
public abstract class PresentersModule {

    @Binds
    @IntoMap
    @ClassKey(CollectionsPresenter.class)
    abstract BasePresenter bindCollectionsPresenter(CollectionsPresenter collectionsPresenter);

    @Binds
    @IntoMap
    @ClassKey(MapsPresenter.class)
    abstract BasePresenter bindMapsPresenter(MapsPresenter mapsPresenter);

    @Binds
    abstract PresenterFactory bindBasePresenterFactory(BasePresenterFactory basePresenterFactory);
}
