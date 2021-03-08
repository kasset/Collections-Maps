package ua.com.foxminded.collectionsandmapsversion2.presenter;

import android.os.Message;


import ua.com.foxminded.collectionsandmapsversion2.presenter.BaseContract;
import ua.com.foxminded.collectionsandmapsversion2.model.IModel;

public class MapsPresenter implements BaseContract.BasePresenter {

    private BaseContract.BaseView mapsView;
    private IModel iModel;

    public MapsPresenter(IModel IModel) {
        this.iModel = IModel;
    }

    @Override
    public void attachView(BaseContract.BaseView view) {

        mapsView = view;
    }

    @Override
    public void buttonClicked(int size) {
        mapsView.showProgressBar();

    }

    @Override
    public void publishResult(Message message) {

    }

    @Override
    public void restoreResults() {

    }

    @Override
    public void detachView() {

        mapsView = null;
    }
}
