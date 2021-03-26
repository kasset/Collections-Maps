package ua.com.foxminded.collectionsandmapsversion2.di.modules;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import ua.com.foxminded.collectionsandmapsversion2.view.BaseFragment;

@Module
public abstract class BaseFragmentModule {
    @ContributesAndroidInjector
    abstract BaseFragment baseFragment();
}
