package ua.com.foxminded.collectionsandmapsversion2.di.modules;


import ua.com.foxminded.collectionsandmapsversion2.presenter.BasePresenter;

public interface PresenterFactory {
    BasePresenter get(Class<?> presenterType);
}
