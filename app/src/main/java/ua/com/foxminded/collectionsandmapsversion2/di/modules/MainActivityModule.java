package ua.com.foxminded.collectionsandmapsversion2.di.modules;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import ua.com.foxminded.collectionsandmapsversion2.MainActivity;

@Module
public interface MainActivityModule {
    @ContributesAndroidInjector
    MainActivity contributeMainActivity();
}
