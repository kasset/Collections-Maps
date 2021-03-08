package ua.com.foxminded.collectionsandmapsversion2.model;

import android.os.Message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.com.foxminded.collectionsandmapsversion2.model.IModel;
import ua.com.foxminded.collectionsandmapsversion2.presenter.BaseContract;
import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractOperation;

public class Model implements IModel {

    private BaseContract.BasePresenter collectionsPresenter;
    private BaseContract.BasePresenter mapsPresenter;
    private HashMap<Integer, Map<Integer, Integer>> operationResults;

    public Model(BaseContract.BasePresenter collectionsPresenter) {
        this.collectionsPresenter = collectionsPresenter;
    }

    @Override
    public Message setOperation(List<AbstractOperation> operations) {
        return null;
    }

    @Override
    public HashMap restoreResults() {
        return null;
    }
}
