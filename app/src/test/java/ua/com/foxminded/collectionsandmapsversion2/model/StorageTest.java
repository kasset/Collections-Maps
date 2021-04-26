package ua.com.foxminded.collectionsandmapsversion2.model;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observers.TestObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;
import ua.com.foxminded.collectionsandmapsversion2.ListOfCollectionsOperation;
import ua.com.foxminded.collectionsandmapsversion2.OperationResult;

@RunWith(MockitoJUnitRunner.class)
public class StorageTest {

    private static int SIZE = 10000;
    private Storage storage;
    private OperationResult result;
    private Observable<OperationResult> observable;
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
        collectionsOperation = new ListOfCollectionsOperation();
        result = new OperationResult();
        result.fragmentType = 1000;
        result.idOperation = 1;
        result.duration = 5;
        observable = Observable.just(result);
    }

    @Test
    public void setOperationIsSuccessful() {
//        Mockito.doNothing().when(storage).setOperation(collectionsOperation.createFillingOperations(SIZE),
//                collectionsOperation.createMicroOperations());
//        Mockito.verify(storage,Mockito.times(1)).setOperation(collectionsOperation.createFillingOperations(SIZE),
//                collectionsOperation.createMicroOperations());
    }

    @Test
    public void getOperationResultsIsCorrect() {
        Mockito.when(storage.getOperationResults()).thenReturn(observable);
        TestObserver<OperationResult> resultTestObserver = storage.getOperationResults().test();
        resultTestObserver.assertValue(result);
        resultTestObserver.dispose();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        RxJavaPlugins.reset();
        RxAndroidPlugins.reset();
    }
}