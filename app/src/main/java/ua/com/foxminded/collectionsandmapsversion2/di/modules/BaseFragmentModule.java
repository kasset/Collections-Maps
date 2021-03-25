package ua.com.foxminded.collectionsandmapsversion2.di.modules;

import dagger.android.ContributesAndroidInjector;
import ua.com.foxminded.collectionsandmapsversion2.BaseFragment;

public abstract class BaseFragmentModule {
    @ContributesAndroidInjector
    abstract BaseFragment baseFragment();
}
