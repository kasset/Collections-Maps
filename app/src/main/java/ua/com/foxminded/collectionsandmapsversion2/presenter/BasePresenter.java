package ua.com.foxminded.collectionsandmapsversion2.presenter;

import android.os.Message;


abstract public class BasePresenter implements BaseContract.BasePresenter {

    BaseContract.Model storage;

    public BasePresenter(BaseContract.Model storage) {
        this.storage = storage;
    }

    @Override
    public void attachView(BaseContract.BaseView view) {

    }

    @Override
    public void initiateCalculation(int size) {

    }

    @Override
    public void publishResult(Message message) {

    }

    @Override
    public void restoreResults() {

    }

    @Override
    public void detachView() {

    }
}
