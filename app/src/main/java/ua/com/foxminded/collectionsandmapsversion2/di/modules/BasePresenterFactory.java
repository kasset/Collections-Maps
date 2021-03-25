package ua.com.foxminded.collectionsandmapsversion2.di.modules;

import java.util.Map;

import javax.inject.Inject;

import ua.com.foxminded.collectionsandmapsversion2.presenter.BaseContract;

public class BasePresenterFactory {

    @Inject
    Map<Class<?>, BaseContract.BasePresenter> presenterMap;

    public BaseContract.BasePresenter getPresenter(Class<?> presenterType) {
        return presenterMap.get(presenterType);
    }
}
