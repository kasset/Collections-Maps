package ua.com.foxminded.collectionsandmapsversion2.model;

import android.os.Message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import ua.com.foxminded.collectionsandmapsversion2.presenter.BaseContract;
import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractOperation;

public class Storage implements BaseContract.Model{

    @Inject
    private BaseContract.BasePresenter collectionsPresenter;
    @Inject
    private BaseContract.BasePresenter mapsPresenter;
    private HashMap<Integer, Map<Integer, Integer>> operationResults;

    public Storage(BaseContract.BasePresenter collectionsPresenter, BaseContract.BasePresenter mapsPresenter) {
        this.collectionsPresenter = collectionsPresenter;
        this.mapsPresenter = mapsPresenter;
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
