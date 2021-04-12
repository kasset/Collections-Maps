package ua.com.foxminded.collectionsandmapsversion2.presenter;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.HashMap;
import java.util.Map;

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


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void initiateCalculation(int size) {
        super.initiateCalculation(size);
        createOperations(size);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void createOperations(int size) {
        super.createOperations(size);
        disposable = storage.setOperation(collectionsOperation.createFillingOperations(size),
                collectionsOperation.createMicroOperations())
                .subscribe(map -> publishResult(map.get(1000)));
    }

    @Override
    public void publishResult(Map<Integer, Integer> operationResult) {
        super.publishResult(operationResult);
    }

    @Override
    public void detachView() {
        super.detachView();
        disposable.dispose();
    }
}
