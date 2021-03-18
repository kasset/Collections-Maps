package ua.com.foxminded.collectionsandmapsversion2.presenter;

import android.os.Message;

public class MapsPresenter implements BaseContract.BasePresenter {

    private BaseContract.BaseView mapsView;
    private BaseContract.Model model;

    public MapsPresenter(BaseContract.Model model) {
        this.model = model;
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
