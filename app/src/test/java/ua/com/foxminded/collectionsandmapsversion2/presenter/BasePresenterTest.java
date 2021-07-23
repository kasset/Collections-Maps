package ua.com.foxminded.collectionsandmapsversion2.presenter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import ua.com.foxminded.collectionsandmapsversion2.Keys;
import ua.com.foxminded.collectionsandmapsversion2.ListOfCollectionsOperation;
import ua.com.foxminded.collectionsandmapsversion2.OperationsCreator;
import ua.com.foxminded.collectionsandmapsversion2.model.Model;
import ua.com.foxminded.collectionsandmapsversion2.model.Storage;
import ua.com.foxminded.collectionsandmapsversion2.view.BaseFragment;

@RunWith(MockitoJUnitRunner.class)
public class BasePresenterTest {

    private static int SIZE = 10000;
    @Mock
    private Model storage;
    @Mock
    private BaseFragment view;
    @Mock
    private BasePresenter basePresenter;

    @Before
    public void setUp() throws Exception {
        storage = Mockito.mock(Storage.class);
        view = Mockito.mock(BaseFragment.class);
        basePresenter = Mockito.mock(BasePresenter.class);
        basePresenter.attachView(view);
    }

    @Test
    public void initiateCalculationIsStarted() {
        Mockito.doNothing().when(basePresenter).initiateCalculation(SIZE);
        basePresenter.initiateCalculation(SIZE);
        Mockito.verify(basePresenter, Mockito.times(1)).initiateCalculation(SIZE);
    }


    @Test
    public void initiateCalculationIsFailed() {
        NegativeArraySizeException fakeException = new NegativeArraySizeException();
        Mockito.doThrow(fakeException).when(basePresenter).initiateCalculation(-10000);
        Mockito.verify(basePresenter, Mockito.times(0)).initiateCalculation(-10000);
    }

    @Test
    public void getOperationsCreatorReturnOperations() {
        ListOfCollectionsOperation collectionsOperation = new ListOfCollectionsOperation();
        Mockito.when(basePresenter.getOperationsCreator()).thenReturn(collectionsOperation);
        Assert.assertEquals(collectionsOperation, basePresenter.getOperationsCreator());
        Mockito.verify(basePresenter, Mockito.times(1)).getOperationsCreator();
    }

    @Test
    public void getOperationsCreatorReturnNull() {
        Mockito.when(basePresenter.getOperationsCreator()).thenReturn(null);
        Assert.assertNull(basePresenter.getOperationsCreator());
        Mockito.verify(basePresenter, Mockito.times(1)).getOperationsCreator();
    }

    @Test
    public void getResultIsSuccess() {
        Mockito.doNothing().when(basePresenter).getResult(Keys.COLLECTION);
        basePresenter.getResult(Keys.COLLECTION);
        Mockito.verify(basePresenter, Mockito.times(1)).getResult(Keys.COLLECTION);
    }

    @Test
    public void getResultIsEmpty() {
        NullPointerException fakeException = new NullPointerException();
        Mockito.doThrow(fakeException).when(basePresenter).getResult(Keys.COLLECTION);
        Mockito.verify(basePresenter, Mockito.times(0)).getResult(Keys.COLLECTION);
    }

    @After
    public void tearDown() throws Exception {
        basePresenter.detachView();
    }
}