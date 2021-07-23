package ua.com.foxminded.collectionsandmapsversion2.presenter;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import ua.com.foxminded.collectionsandmapsversion2.OperationsCreator;
import ua.com.foxminded.collectionsandmapsversion2.model.Model;
import ua.com.foxminded.collectionsandmapsversion2.view.BaseFragment;


public abstract class BasePresenter<T extends OperationsCreator> {

    protected BaseFragment view;
    protected Model storage;
    protected Disposable disposable;
    protected T operationsList;

    public BasePresenter(Model storage) {
        this.storage = storage;
    }

    public void attachView(BaseFragment view) {
        this.view = view;
        operationsList = getOperationsCreator();
    }

    public void initiateCalculation(int size) {
        view.showInitiateCalculating();
        storage.setOperation(operationsList.createFillingOperations(size),
                operationsList.createMicroOperations());
    }

    public abstract T getOperationsCreator();

    public void getResult(int fragmentKey) {
        disposable = storage.getOperationResults()
                .filter(result -> result.fragmentType == fragmentKey)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> view.publishOperationResult(result.idOperation, result.duration));
    }

    public void detachView() {
        disposable.dispose();
        view = null;
    }

}
