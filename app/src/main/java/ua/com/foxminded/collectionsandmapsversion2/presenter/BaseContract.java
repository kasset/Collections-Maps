package ua.com.foxminded.collectionsandmapsversion2.presenter;

import android.os.Message;

import java.util.HashMap;
import java.util.List;

import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractOperation;

public interface BaseContract {
    interface BaseView{
        void showProgressBar();
        void publishOperationResult(Message message);
    }
    interface BasePresenter{
        void attachView(BaseView view);
        void buttonClicked(int size);
        void publishResult(Message message);
        void restoreResults();
        void detachView();
    }
    interface Model{
        Message setOperation(List<AbstractOperation> operations);
        HashMap restoreResults();
    }
}
