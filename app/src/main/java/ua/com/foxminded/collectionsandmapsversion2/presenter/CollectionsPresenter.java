package ua.com.foxminded.collectionsandmapsversion2.presenter;

import android.os.Message;

import ua.com.foxminded.collectionsandmapsversion2.ListOfCollectionsOperation;
import ua.com.foxminded.collectionsandmapsversion2.presenter.BaseContract;
import ua.com.foxminded.collectionsandmapsversion2.model.IModel;

public class CollectionsPresenter implements BaseContract.BasePresenter {

    private BaseContract.BaseView collectionView;
    private IModel iModel;

    public CollectionsPresenter(IModel iModel) {
        this.iModel = iModel;
    }

    @Override
    public void attachView(BaseContract.BaseView view) {

        collectionView = view;
    }

    @Override
    public void buttonClicked(int size) {
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
        collectionView = null;
    }
}
