package com.count.phrases;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.count.phrases.MainActivity;
import com.testapp.testapp.R;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class CounterActivityTestCase {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void whenUserEntersAValidPhraseItGetsTheLengthCount() {
        onView(ViewMatchers.withId(R.id.phrase))
                .perform(typeText("Hello World!"), ViewActions.closeSoftKeyboard());

        onView(withId(R.id.count_button)).perform(click());

        onView(withId(R.id.count_result))
                .check(matches(withText("12 letters")));
    }

    @Test
    public void whenUserEntersNoPhraseItGetsAnError() {
        onView(withId(R.id.count_button)).perform(click());

        onView(withId(R.id.count_result))
                .check(matches(withText("I cannot count no characters")));
    }
}