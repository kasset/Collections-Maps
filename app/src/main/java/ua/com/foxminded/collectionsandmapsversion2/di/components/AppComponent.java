package ua.com.foxminded.collectionsandmapsversion2.di.components;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import ua.com.foxminded.collectionsandmapsversion2.di.App;

import ua.com.foxminded.collectionsandmapsversion2.di.modules.AppModule;
import ua.com.foxminded.collectionsandmapsversion2.di.modules.FragmentsModule;
import ua.com.foxminded.collectionsandmapsversion2.di.modules.MainActivityModule;

@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                MainActivityModule.class,
                FragmentsModule.class,
                AppModule.class
        }
)
public interface AppComponent extends AndroidInjector<App> {

        @Component.Builder
        interface Builder {
                @BindsInstance
                Builder application(App app);

                AppComponent builder();
        }
}
