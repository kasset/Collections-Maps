package ua.com.foxminded.collectionsandmapsversion2.presenter;

import javax.inject.Inject;

import ua.com.foxminded.collectionsandmapsversion2.ListOfMapsOperation;
import ua.com.foxminded.collectionsandmapsversion2.model.Model;

public class MapsPresenter extends BasePresenter {

    private ListOfMapsOperation mapsOperation = new ListOfMapsOperation();

    @Inject
    public MapsPresenter(Model storage) {
        super(storage);
    }

    @Override
    public void initiateCalculation(int size) {
        super.initiateCalculation(size);
        createOperations(size);
    }

    @Override
    public void createOperations(int size) {
        super.createOperations(size);
        storage.setOperation(mapsOperation.createFillingOperations(size),
                mapsOperation.createMicroOperations());
    }
}
