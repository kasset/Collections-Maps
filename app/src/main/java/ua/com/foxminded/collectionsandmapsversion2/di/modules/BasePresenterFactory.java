package ua.com.foxminded.collectionsandmapsversion2.di.modules;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import ua.com.foxminded.collectionsandmapsversion2.presenter.BaseContract;

@Singleton
public class BasePresenterFactory {

    @Inject
    Map<Class<?>, BaseContract.BasePresenter> presenterMap;

    @Inject
    public BasePresenterFactory() {
    }

    public BaseContract.BasePresenter getPresenter(Class<?> presenterType) {
        return presenterMap.get(presenterType);
    }
}
