package ua.com.foxminded.collectionsandmapsversion2.presenter;

import javax.inject.Inject;

import ua.com.foxminded.collectionsandmapsversion2.ListOfCollectionsOperation;
import ua.com.foxminded.collectionsandmapsversion2.model.Model;

public class CollectionsPresenter extends BasePresenter {

    private ListOfCollectionsOperation collectionsOperation = new ListOfCollectionsOperation();

    @Inject
    public CollectionsPresenter(Model storage) {
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
        storage.setOperation(collectionsOperation.createFillingOperations(size),
                collectionsOperation.createMicroOperations());
    }

}
