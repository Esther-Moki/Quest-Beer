package com.moringaschool.questbeer;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

import static java.util.regex.Pattern.matches;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityInstrumentationTest {
    //tells our device which activity to launch before each test,
    //thus here, we're instructing the instrumentation tests to launch the MainActivity before each test
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void validateEditText() {
        onView(withId(R.id.locationEditText)).perform(typeText("Nairobi"))
                .check(matches(withText("Nairobi")));
    }
    @Test
    public void locationIsSentToRestaurantsActivity(){
        String location = "Nairobi";
        onView(withId(R.id.locationEditText)).perform(typeText(location)).perform(closeSoftKeyboard());
        try {                             // the sleep method requires to be checked and handled so we use try block
            Thread.sleep(250);
        } catch (InterruptedException e){
            System.out.println("got interrupted!");
        }
        onView(withId(R.id.findBeersButton)).perform(click());
        onView(withId(R.id.locationTextView)).check(matches
                (withText("Here are all the pubs near: " + location)));
    }


//    public void locationIsSentToRestaurantsActivity() {
//        String location = "Nairobi";
//        onView(withId(R.id.locationEditText)).perform(typeText(location));
//        onView(withId(R.id.findBeersButton)).perform(click());
//        onView(withId(R.id.locationTextView)).check(matches
//                (withText("Here are all the beers near: " + location)));
//    }
}
