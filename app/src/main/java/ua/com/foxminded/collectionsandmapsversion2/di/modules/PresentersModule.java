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
public interface PresentersModule {

    @Binds
    @IntoMap
    @ClassKey(CollectionsPresenter.class)
    BasePresenter bindCollectionsPresenter(CollectionsPresenter collectionsPresenter);

    @Binds
    @IntoMap
    @ClassKey(MapsPresenter.class)
    BasePresenter bindMapsPresenter(MapsPresenter mapsPresenter);

    @Binds
    PresenterFactory bindBasePresenterFactory(BasePresenterFactory basePresenterFactory);

}
