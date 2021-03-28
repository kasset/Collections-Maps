package ua.com.foxminded.collectionsandmapsversion2.model;

import android.os.Message;

import java.util.HashMap;
import java.util.List;

import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractOperation;

public interface Model {
    Message setOperation(List<AbstractOperation> operations);

    HashMap restoreResults();
}
