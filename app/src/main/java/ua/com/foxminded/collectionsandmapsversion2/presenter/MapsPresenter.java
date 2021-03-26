package ua.com.foxminded.collectionsandmapsversion2.presenter;

import android.os.Message;

import ua.com.foxminded.collectionsandmapsversion2.model.Storage;


public class MapsPresenter extends BasePresenter {

    private BaseContract.BaseView mapsView;

    public MapsPresenter(BaseContract.Model storage) {
        super(storage);
    }

    @Override
    public void attachView(BaseContract.BaseView view) {
        mapsView = view;
    }

    @Override
    public void initiateCalculation(int size) {
        mapsView.showProgressBar();
    }

    @Override
    public void publishResult(Message message) {
        mapsView.publishOperationResult(message);
    }

    @Override
    public void restoreResults() {
    }

    @Override
    public void detachView() {
        mapsView = null;
    }
}
