package ua.com.foxminded.collectionsandmapsversion2.view;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.lifecycle.Lifecycle;
import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ua.com.foxminded.collectionsandmapsversion2.R;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
public class MapFragmentTest {

    private FragmentScenario fragmentScenario;

    @Before
    public void setUp() throws Exception {
        fragmentScenario = FragmentScenario.launchInContainer(MapFragment.class);
        fragmentScenario.moveToState(Lifecycle.State.STARTED);
    }

    @Test
    public void testRecyclerViewIsVisible() {
        Espresso.onView(withId(R.id.recyclerView_Map)).check(matches(isDisplayed()));
    }
}