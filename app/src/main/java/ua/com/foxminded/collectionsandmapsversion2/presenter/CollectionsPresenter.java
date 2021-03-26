package ua.com.foxminded.collectionsandmapsversion2.presenter;

import android.os.Message;

import ua.com.foxminded.collectionsandmapsversion2.ListOfCollectionsOperation;
import ua.com.foxminded.collectionsandmapsversion2.model.Storage;
import ua.com.foxminded.collectionsandmapsversion2.view.CollectionFragment;

public class CollectionsPresenter extends BasePresenter {

    private BaseContract.BaseView collectionView;

    public CollectionsPresenter(BaseContract.Model storage) {
        super(storage);
    }


    @Override
    public void attachView(BaseContract.BaseView view) {
        this.collectionView = view;
    }

    @Override
    public void initiateCalculation(int size) {
        collectionView.showProgressBar();
    }

    @Override
    public void publishResult(Message message) {
        collectionView.publishOperationResult(message);
    }

    @Override
    public void restoreResults() {
    }

    @Override
    public void detachView() {
        this.collectionView = null;
    }
}
