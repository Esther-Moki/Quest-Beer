package com.moringaschool.questbeer;

import static org.junit.Assert.assertTrue;

import android.content.Intent;
import android.widget.TextView;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowActivity;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    private MainActivity activity;

    @BeforeClass
    public void  setUp() throws Exception {
        activity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();

    }
    // checking that the text in our MainActivity's TextView is equal to Quest Beer
    @Test
    public void validateTextViewContent(){
        TextView appNameTextView = activity.findViewById(R.id.appNameTextView);
        assertTrue("Quest Beer".equals(appNameTextView.getText().toString()));
    }
    //checks if BeersActivity is started when findBeersButton is clicked
    @Test
    public void secondActivityStarted(){
        activity.findViewById(R.id.findBeersButton).performClick();
        Intent expectedIntent = new Intent(activity, BeersActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }
}
