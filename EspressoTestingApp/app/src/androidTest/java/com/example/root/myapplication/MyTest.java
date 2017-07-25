package com.example.root.myapplication;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

/**
 * Created by root on 18/7/17.
 */
@RunWith(JUnit4.class)
public class MyTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void dataTest(){
        onView(allOf(withId(R.id.tv_1),withText("Item 1"))).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.tv_1),withText("Item 10"))).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.btn))).check(matches(withText("Remove Item"))).perform(click());
        onView(allOf(withId(R.id.tv_1),withText("Item 10"))).check(doesNotExist());
    }
//    @After
//    public void viewDataTest(){
//        onView(allOf(withId(R.id.tv_1),withText("Item 4"))).check(matches(isDisplayed()));
//    }



}
