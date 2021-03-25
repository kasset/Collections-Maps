package ua.com.foxminded.collectionsandmapsversion2.di.components;

import java.util.Map;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import ua.com.foxminded.collectionsandmapsversion2.di.App;
import ua.com.foxminded.collectionsandmapsversion2.di.modules.AppModule;
import ua.com.foxminded.collectionsandmapsversion2.di.modules.MainActivityModule;
import ua.com.foxminded.collectionsandmapsversion2.di.modules.BaseFragmentModule;
import ua.com.foxminded.collectionsandmapsversion2.presenter.BasePresenter;

@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                MainActivityModule.class,
                BaseFragmentModule.class,
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
