package ua.com.foxminded.collectionsandmapsversion2;

import android.view.View;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.action.ViewActions.swipeRight;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayingAtLeast;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class MainActivityTest {

    private static String SIZE = "10000";

    @Rule
    public ActivityScenarioRule rule = new ActivityScenarioRule(MainActivity.class);

    @Test
    public void testVisibility() {
        Espresso.onView(withId(R.id.sizeOfCollectionEditText)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.calculateButton)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.tabs)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.pager)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.calculateButton)).check(matches(isClickable()));
    }

    @Test
    public void testViewPagerAnimation() {
        Espresso.onView(withId(R.id.pager)).perform(withCustomConstraints(swipeLeft(), isDisplayingAtLeast(70)));
        Espresso.onView(withId(R.id.pager)).perform(withCustomConstraints(swipeRight(), isDisplayingAtLeast(70)));
    }

    @Test
    public void testCalculationIsSuccessful() {
        Espresso.onView(withId(R.id.sizeOfCollectionEditText)).perform(typeText(SIZE), closeSoftKeyboard());
        Espresso.onView(withId(R.id.calculateButton)).perform(click());
        Espresso.onView(withId(R.id.pager)).perform(withCustomConstraints(swipeLeft(), isDisplayingAtLeast(70)));
        Espresso.onView(withId(R.id.pager)).perform(withCustomConstraints(swipeRight(), isDisplayingAtLeast(70)));
    }

    @Test
    public void testCalculationWithNull() {
        Espresso.onView(withId(R.id.sizeOfCollectionEditText)).perform(typeText(""), closeSoftKeyboard());
        Espresso.onView(withId(R.id.calculateButton)).perform(click());
    }

    public static ViewAction withCustomConstraints(final ViewAction action, final Matcher<View> constraints) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return constraints;
            }

            @Override
            public String getDescription() {
                return action.getDescription();
            }

            @Override
            public void perform(UiController uiController, View view) {
                action.perform(uiController, view);
            }
        };
    }
}