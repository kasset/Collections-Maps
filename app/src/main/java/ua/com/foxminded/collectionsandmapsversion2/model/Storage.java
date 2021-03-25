package ua.com.foxminded.collectionsandmapsversion2.model;

import android.os.Message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import ua.com.foxminded.collectionsandmapsversion2.presenter.BaseContract;
import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractOperation;
import ua.com.foxminded.collectionsandmapsversion2.view.CollectionFragment;

public class
Storage implements BaseContract.Model{

    private HashMap<Integer, Map<Integer, Integer>> operationResults = new HashMap<>();

    public Storage() {
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
