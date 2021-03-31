package ua.com.foxminded.collectionsandmapsversion2.di.modules;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import ua.com.foxminded.collectionsandmapsversion2.presenter.BasePresenter;

public class BasePresenterFactory {

    Provider<Map<Class<?>, BasePresenter>> presenterMap;

    @Inject
    public BasePresenterFactory(Provider<Map<Class<?>, BasePresenter>> presenterMap) {
        this.presenterMap = presenterMap;
    }

    public BasePresenter getPresenter(Class<?> presenterType) {
        return this.presenterMap.get().get(presenterType);
    }
}


