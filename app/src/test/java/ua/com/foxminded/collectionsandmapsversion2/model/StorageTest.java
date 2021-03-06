package ua.com.foxminded.collectionsandmapsversion2.model;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observers.TestObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;
import ua.com.foxminded.collectionsandmapsversion2.ListOfCollectionsOperation;
import ua.com.foxminded.collectionsandmapsversion2.OperationResult;
import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractOperation;

@RunWith(MockitoJUnitRunner.class)
public class StorageTest {

    private static int SIZE = 10000;
    private Model storage;
    private ListOfCollectionsOperation collectionsOperation;

    @BeforeClass
    public static void beforeClass() throws Exception {
        RxAndroidPlugins.reset();
        RxJavaPlugins.reset();
        RxJavaPlugins.setIoSchedulerHandler(scheduler -> Schedulers.trampoline());
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(schedulerCallable -> Schedulers.trampoline());
    }

    @Before
    public void setUp() {
        storage = Mockito.mock(Storage.class);
        collectionsOperation = Mockito.mock(ListOfCollectionsOperation.class);
    }

    @Test
    public void setOperationIsSuccessful() {
        List<AbstractOperation> fillingOperations = collectionsOperation.createFillingOperations(SIZE);
        HashMap<Integer, List<AbstractOperation>> microOperations = collectionsOperation.createMicroOperations();
        Mockito.doNothing().when(storage).setOperation(fillingOperations, microOperations);
        storage.setOperation(fillingOperations, microOperations);
        Mockito.verify(storage, Mockito.times(1)).setOperation(fillingOperations, microOperations);
    }

    @Test
    public void getOperationResultsIsCorrect() {
        OperationResult result = new OperationResult();
        result.fragmentType = 1000;
        result.idOperation = 1;
        result.duration = 5;
        Observable<OperationResult> observable = Observable.just(result);

        Mockito.when(storage.getOperationResults()).thenReturn(observable);
        TestObserver<OperationResult> resultTestObserver = storage.getOperationResults().test();
        resultTestObserver.assertValue(result);
        resultTestObserver.dispose();
    }

    @Test
    public void setOperationIsFailed() {
        NullPointerException fakeException = new NullPointerException();
        List<AbstractOperation> fillingOperations = new ArrayList<>();
        HashMap<Integer, List<AbstractOperation>> microOperations = new HashMap<>();
        Mockito.doThrow(fakeException).when(storage).setOperation(fillingOperations, microOperations);
        Mockito.verifyNoInteractions(storage);
    }

    @Test
    public void getOperationResultsIsEmpty() {
        Observable<OperationResult> observable = Observable.empty();
        Mockito.when(storage.getOperationResults()).thenReturn(observable);
        TestObserver<OperationResult> resultTestObserver = storage.getOperationResults().test();
        resultTestObserver.assertNoValues();
        resultTestObserver.dispose();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        RxJavaPlugins.reset();
        RxAndroidPlugins.reset();
    }
}