package com.etisalat.sampletask;

import android.app.Activity;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAssertion;
import android.support.test.rule.ActivityTestRule;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.etisalat.sampletask.bases.ApplicationContextProvider;
import com.etisalat.sampletask.models.CachingDataHandler;
import com.etisalat.sampletask.views.MainActivity;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by Ahmed Etman on 4/26/2018.
 */

public class ActivityMainTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    private long cachedDateTime ;
    private String password ;


    @Before
    public void setUp() throws Exception {

        cachedDateTime  = CachingDataHandler.getDateTimeAsMillis(ApplicationContextProvider.getContext());
    }

    /**
     * getting the time of the last update and then perform click on Refresh button
     * then get the new time and compare them with each other.
     * if there is difference, then 
     * @throws InterruptedException
     */
    @Test
    public void testCaching() throws InterruptedException {
        Espresso.onView(withId(R.id.btn_refresh)).perform(click());
        long timeAfterRefresh = CachingDataHandler.getDateTimeAsMillis(ApplicationContextProvider.getContext());
        Assert.assertNotSame(timeAfterRefresh,cachedDateTime);
    }
}
