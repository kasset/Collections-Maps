package ua.com.foxminded.collectionsandmapsversion2.di.modules;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import ua.com.foxminded.collectionsandmapsversion2.presenter.BaseContract;
import ua.com.foxminded.collectionsandmapsversion2.presenter.BasePresenter;

@Singleton
public class BasePresenterFactory {

    @Inject
    Map<Class<?>, BasePresenter> presenterMap = new HashMap<>();

    @Inject
    public BasePresenterFactory() {
    }

    public BasePresenter getPresenter(Class<?> presenterType) {
        return this.presenterMap.get(presenterType);
    }
}
