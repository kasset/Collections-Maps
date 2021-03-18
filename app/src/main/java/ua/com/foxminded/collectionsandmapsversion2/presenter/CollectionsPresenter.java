package ua.com.foxminded.collectionsandmapsversion2.presenter;

import android.os.Message;

public class CollectionsPresenter implements BaseContract.BasePresenter {

    private BaseContract.BaseView collectionView;
    private BaseContract.Model model;

    public CollectionsPresenter(BaseContract.Model model) {
        this.model= model;
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
