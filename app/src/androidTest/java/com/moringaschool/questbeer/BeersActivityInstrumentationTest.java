package com.moringaschool.questbeer;


import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.not;

import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class BeersActivityInstrumentationTest {
    @Rule
    public ActivityScenarioRule<BeersActivity> activityTestRule =
            new ActivityScenarioRule<>(BeersActivity.class);

    private View activityDecorView;
    @Before
    public void setUp() {
        activityTestRule.getScenario().onActivity(new ActivityScenario.ActivityAction<BeersActivity>() {
            @Override
            public void perform(BeersActivity activity) {
                activityDecorView = activity.getWindow().getDecorView();
            }
        });
    }

    //instructing Espresso to check that clicking on the first item (.atPosition(0)) in the ListView
    // results in a Toast that displays "Kentucky Brunch Brand Stout" when clicked
    @Test
    public void listItemClickDisplaysToastWithCorrectRestaurant() {
        String beerName = "Kentucky Brunch Brand Stout";
        onData(anything())
                .inAdapterView(withId(R.id.listView))
                .atPosition(0)
                .perform(click());
        onView(withText(beerName)).inRoot(withDecorView(not(activityDecorView)))
                .check(matches(withText(beerName)));
    }

}
