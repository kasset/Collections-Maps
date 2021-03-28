package ua.com.foxminded.collectionsandmapsversion2.presenter;

import android.os.Message;

import ua.com.foxminded.collectionsandmapsversion2.view.BaseFragment;


abstract public class BasePresenter {

    public BasePresenter() {
    }

    public abstract void attachView(BaseFragment view);

    public abstract void initiateCalculation(int size);

    public abstract void publishResult(Message message);

    public abstract void restoreResults();

    public abstract void detachView();
}
