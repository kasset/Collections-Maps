package ua.com.foxminded.collectionsandmapsversion2.di.modules;


import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import ua.com.foxminded.collectionsandmapsversion2.model.Storage;
import ua.com.foxminded.collectionsandmapsversion2.model.Model;

@Module(includes = {PresentersModule.class})
public abstract class AppModule {

    @Binds
    @Singleton
    abstract Model bindStorage(Storage storage);
}
