package ua.com.foxminded.collectionsandmapsversion2.presenter;

import android.os.Message;

import javax.inject.Inject;

import ua.com.foxminded.collectionsandmapsversion2.model.Storage;
import ua.com.foxminded.collectionsandmapsversion2.view.BaseFragment;


public class MapsPresenter extends BasePresenter {

    private BaseFragment mapsView;
    private Storage storage;

    @Inject
    public MapsPresenter(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void attachView(BaseFragment view) {
        mapsView = view;
    }

    @Override
    public void initiateCalculation(int size) {
        mapsView.showInitiateCalculating();
    }

    @Override
    public void publishResult(Message message) {
        mapsView.publishOperationResult(message);
    }

    @Override
    public void restoreResults() {
        storage.restoreResults();
    }

    @Override
    public void detachView() {
        mapsView = null;
    }
}
