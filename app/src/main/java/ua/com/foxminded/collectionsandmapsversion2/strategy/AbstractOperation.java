package ua.com.foxminded.collectionsandmapsversion2.strategy;

import ua.com.foxminded.collectionsandmapsversion2.OperationResult;

abstract public class AbstractOperation<T> {
    protected T t;
    protected int dataStructureType;
    protected int id;


    public AbstractOperation(T t, int dataStructureType, int id) {
        this.t = t;
        this.dataStructureType = dataStructureType;
        this.id = id;
    }

    public OperationResult run() {
        int start = (int) System.currentTimeMillis();
        operation(t);
        int time = (int) System.currentTimeMillis() - start;
        OperationResult result = new OperationResult();
        result.duration = time;
        result.fragmentType = dataStructureType;
        result.idOperation = id;
        return result;
    }


    protected abstract void operation(T dataStructure);
}

