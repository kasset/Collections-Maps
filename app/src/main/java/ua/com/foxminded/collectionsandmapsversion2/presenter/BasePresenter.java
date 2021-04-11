package ua.com.foxminded.collectionsandmapsversion2.presenter;

import java.util.Map;

import ua.com.foxminded.collectionsandmapsversion2.model.Model;
import ua.com.foxminded.collectionsandmapsversion2.view.BaseFragment;


public abstract class BasePresenter {

    protected BaseFragment view;
    protected Model storage;


    public BasePresenter(Model storage) {
        this.storage = storage;
    }

    public void attachView(BaseFragment view) {
        this.view = view;
    }

    public void initiateCalculation(int size) {
        view.showInitiateCalculating();
    }

    public void publishResult(Map<Integer, Integer> operationResult) {
        view.publishOperationResult(operationResult);
    }

    public void restoreResults() {
        storage.restoreResults();
    }

    public void detachView() {
        view = null;
    }

    public void createOperations(int size) {

    }

}
