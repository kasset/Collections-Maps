package ua.com.foxminded.collectionsandmapsversion2.di.modules;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import ua.com.foxminded.collectionsandmapsversion2.presenter.BasePresenter;

public class BasePresenterFactory implements PresenterFactory {

    private Map<Class<?>, Provider<BasePresenter>> presenterMap;

    @Inject
    public BasePresenterFactory(Map<Class<?>, Provider<BasePresenter>> presenterMap) {
        this.presenterMap = presenterMap;
    }

    @Override
    public BasePresenter get(Class<?> presenterType) {
        return this.presenterMap.get(presenterType).get();
    }
}


