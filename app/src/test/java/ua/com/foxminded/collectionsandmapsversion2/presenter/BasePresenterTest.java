package ua.com.foxminded.collectionsandmapsversion2.presenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import ua.com.foxminded.collectionsandmapsversion2.ListOfCollectionsOperation;
import ua.com.foxminded.collectionsandmapsversion2.OperationsCreator;
import ua.com.foxminded.collectionsandmapsversion2.model.Model;
import ua.com.foxminded.collectionsandmapsversion2.model.Storage;
import ua.com.foxminded.collectionsandmapsversion2.view.BaseFragment;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BasePresenterTest {

    private static int SIZE = 10000;
    @Mock
    private Model storage;
    @Mock
    private BaseFragment view;

    private BasePresenter basePresenter;

    @Before
    public void setUp() throws Exception {
        storage = Mockito.mock(Storage.class);
        view = Mockito.mock(BaseFragment.class);
        basePresenter = new BasePresenter(storage) {
            @Override
            public OperationsCreator getOperationsCreator() {
                return new ListOfCollectionsOperation();
            }
        };
        basePresenter.attachView(view);
    }

    @Test
    public void initiateCalculationIsStarted() {
        Mockito.doNothing().when(view).showInitiateCalculating();
        view.showInitiateCalculating();
        Mockito.verify(view, Mockito.times(1)).showInitiateCalculating();
    }

    @Test
    public void getOperationsCreator() {
    }

    @Test
    public void getResult() {
    }

    @After
    public void tearDown() throws Exception {
//        basePresenter.detachView();
    }
}