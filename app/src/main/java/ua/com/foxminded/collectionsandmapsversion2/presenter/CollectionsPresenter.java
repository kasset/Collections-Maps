package ua.com.foxminded.collectionsandmapsversion2.presenter;

import javax.inject.Inject;

import io.reactivex.rxjava3.disposables.Disposable;
import ua.com.foxminded.collectionsandmapsversion2.ListOfCollectionsOperation;
import ua.com.foxminded.collectionsandmapsversion2.model.Model;

public class CollectionsPresenter extends BasePresenter {

    private ListOfCollectionsOperation collectionsOperation = new ListOfCollectionsOperation();
    private Disposable disposable;

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
        disposable = storage.setOperation(collectionsOperation.createFillingOperations(size),
                collectionsOperation.createMicroOperations())
                .subscribe(map -> map.get(1000));
    }

    @Override
    public void detachView() {
        super.detachView();
        disposable.dispose();
    }
}
