package ua.com.foxminded.collectionsandmapsversion2.presenter;

import javax.inject.Inject;

import ua.com.foxminded.collectionsandmapsversion2.ListOfMapsOperation;
import ua.com.foxminded.collectionsandmapsversion2.OperationsCreator;
import ua.com.foxminded.collectionsandmapsversion2.model.Model;

public class MapsPresenter extends BasePresenter {

    @Inject
    public MapsPresenter(Model storage) {
        super(storage);
    }

    @Override
    public OperationsCreator getOperationsCreator() {
        return new ListOfMapsOperation();
    }

}
