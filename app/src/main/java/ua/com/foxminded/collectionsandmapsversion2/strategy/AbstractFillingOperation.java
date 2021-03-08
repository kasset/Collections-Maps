package ua.com.foxminded.collectionsandmapsversion2.strategy;

abstract public class AbstractFillingOperation<T> extends AbstractOperation<T> {

    protected int size;

    public AbstractFillingOperation(T t, int size, int dataStructureType, int id) {
        super(t, dataStructureType, id);
        this.size = size;
    }
}
