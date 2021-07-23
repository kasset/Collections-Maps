package ua.com.foxminded.collectionsandmapsversion2.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import ua.com.foxminded.collectionsandmapsversion2.Keys;
import ua.com.foxminded.collectionsandmapsversion2.presenter.CollectionsPresenter;
import ua.com.foxminded.collectionsandmapsversion2.presenter.MapsPresenter;

public class BaseFragmentTest {

    private static int SIZE = 10000;

    @Mock
    private BaseFragment baseFragment;

    @Before
    public void setUp() throws Exception {
        baseFragment = Mockito.mock(BaseFragment.class);
    }

    @Test
    public void testSendSizeIsSuccessful() {
        Mockito.doNothing().when(baseFragment).sendSize(SIZE);
        baseFragment.sendSize(SIZE);
        Mockito.verify(baseFragment, Mockito.times(1)).sendSize(SIZE);
    }

    @Test
    public void testSendSizeIsFailed() {
        NegativeArraySizeException fakeException = new NegativeArraySizeException();
        Mockito.doThrow(fakeException).when(baseFragment).sendSize(-10000);
        Mockito.verify(baseFragment, Mockito.times(0)).sendSize(-10000);
    }

    @Test
    public void testGetResultIsCorrect() {
        Mockito.doNothing().when(baseFragment).getResults();
        baseFragment.getResults();
        Mockito.verify(baseFragment, Mockito.times(1)).getResults();
    }

    @Test
    public void testGetResultIsFailed() {
        NullPointerException fakeException = new NullPointerException();
        Mockito.doThrow(fakeException).when(baseFragment).getResults();
        Mockito.verify(baseFragment, Mockito.times(0)).getResults();
    }

    @Test
    public void testGetFragmentKeyIsCorrect() {
        Mockito.when(baseFragment.getFragmentKey()).thenReturn(Keys.COLLECTION);
        Assert.assertEquals(baseFragment.getFragmentKey(), Keys.COLLECTION);
        Mockito.verify(baseFragment, Mockito.times(1)).getFragmentKey();
    }

    @Test
    public void testGetFragmentKeyIsNull() {
        Mockito.when(baseFragment.getFragmentKey()).thenReturn(0);
        Assert.assertNotEquals(baseFragment.getFragmentKey(), Keys.COLLECTION);
        Mockito.verify(baseFragment, Mockito.times(1)).getFragmentKey();
    }

    @Test
    public void testGetPresenterClassIsCorrect() {
        Mockito.when(baseFragment.getPresenterClass()).thenReturn(CollectionsPresenter.class);
        Assert.assertEquals(baseFragment.getPresenterClass(), CollectionsPresenter.class);
        Mockito.verify(baseFragment, Mockito.times(1)).getPresenterClass();
    }

    @Test
    public void testGetPresenterClassIsWrong() {
        Mockito.when(baseFragment.getPresenterClass()).thenReturn(MapsPresenter.class);
        Assert.assertNotEquals(baseFragment.getPresenterClass(), CollectionsPresenter.class);
        Mockito.verify(baseFragment, Mockito.times(1)).getPresenterClass();
    }
}