package ua.com.foxminded.collectionsandmapsversion2.presenter;

import android.os.Message;

import javax.inject.Inject;

import ua.com.foxminded.collectionsandmapsversion2.ListOfCollectionsOperation;
import ua.com.foxminded.collectionsandmapsversion2.model.Storage;
import ua.com.foxminded.collectionsandmapsversion2.view.BaseFragment;
import ua.com.foxminded.collectionsandmapsversion2.view.CollectionFragment;

public class CollectionsPresenter extends BasePresenter {

    private BaseFragment collectionView;
    private Storage storage;

    @Inject
    public CollectionsPresenter(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void attachView(BaseFragment view) {
        this.collectionView = view;
    }

    @Override
    public void initiateCalculation(int size) {
        collectionView.showInitiateCalculating();
    }

    @Override
    public void publishResult(Message message) {
        collectionView.publishOperationResult(message);
    }

    @Override
    public void restoreResults() {
        storage.restoreResults();
    }

    @Override
    public void detachView() {
        this.collectionView = null;
    }
}
