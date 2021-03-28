package ua.com.foxminded.collectionsandmapsversion2.di.modules;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import ua.com.foxminded.collectionsandmapsversion2.view.CollectionFragment;
import ua.com.foxminded.collectionsandmapsversion2.view.MapFragment;

@Module
public interface FragmentsModule {

    @ContributesAndroidInjector
    MapFragment contributeMapFragment();

    @ContributesAndroidInjector
    CollectionFragment contributeCollectionFragment();
}
