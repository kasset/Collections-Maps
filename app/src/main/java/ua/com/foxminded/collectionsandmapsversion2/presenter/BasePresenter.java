package ua.com.foxminded.collectionsandmapsversion2.presenter;

import android.os.Message;

import javax.inject.Inject;

import ua.com.foxminded.collectionsandmapsversion2.ListOfCollectionsOperation;
import ua.com.foxminded.collectionsandmapsversion2.ListOfMapsOperation;
import ua.com.foxminded.collectionsandmapsversion2.model.Model;
import ua.com.foxminded.collectionsandmapsversion2.model.Storage;
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

    public void publishResult(Message message) {
        view.publishOperationResult(message);
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
