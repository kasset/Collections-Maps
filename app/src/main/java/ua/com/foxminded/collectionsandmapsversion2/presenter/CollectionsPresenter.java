package ua.com.foxminded.collectionsandmapsversion2.presenter;

import javax.inject.Inject;

import ua.com.foxminded.collectionsandmapsversion2.model.Model;

public class CollectionsPresenter extends BasePresenter {

    @Inject
    public CollectionsPresenter(Model storage) {
        super(storage);
    }

}
