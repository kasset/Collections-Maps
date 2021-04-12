package ua.com.foxminded.collectionsandmapsversion2.presenter;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import ua.com.foxminded.collectionsandmapsversion2.ListOfMapsOperation;
import ua.com.foxminded.collectionsandmapsversion2.model.Model;

public class MapsPresenter extends BasePresenter {

    private ListOfMapsOperation mapsOperation = new ListOfMapsOperation();
    private Disposable disposable;


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
        disposable = storage.setOperation(mapsOperation.createFillingOperations(size),
                mapsOperation.createMicroOperations())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(map -> publishResult(map.get(2000)));
    }

    @Override
    public void detachView() {
        super.detachView();
        disposable.dispose();
    }
}
