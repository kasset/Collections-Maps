package ua.com.foxminded.collectionsandmapsversion2.strategy;

abstract public class AbstractMicroOperation<T> extends AbstractOperation<T> {

    public AbstractMicroOperation(T t, int dataStructureType, int id) {
        super(t, dataStructureType, id);
    }
}
