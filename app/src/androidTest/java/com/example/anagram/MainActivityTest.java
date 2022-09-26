package com.example.anagram;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)

public class MainActivityTest {

    @Rule public ActivityScenarioRule activityTestRule =
            new ActivityScenarioRule(MainActivity.class);

    @Test
    public void checkClick() {
        // text in EditText
        onView(withId(R.id.editText))
                .perform(typeText("Foxminded cool 24/7"));

        // ignoredCharacters
        onView(withId(R.id.ignoredCharacters))
                .perform(typeText("0123456789/"), closeSoftKeyboard());

        // press button
        onView(withId(R.id.button))
                .perform(click());

        // check that outText contains error text
        onView(withId(R.id.outText))
                .check(matches(withText("dednimxoF looc 24/7")));
    }

    @Test
    public void checkClickVoid() {
      //"" in EditText
      onView(withId(R.id.editText))
              .perform(typeText(""));

      // "" in ignoredCharacters
      onView(withId(R.id.ignoredCharacters))
              .perform(typeText(""), closeSoftKeyboard());

      // press button
      onView(withId(R.id.button))
              .perform(click());

      // check that outText contains error text
      onView(withId(R.id.outText))
              .check(matches(withText("")));
    }

    @Test
    public void checkClickNoSymvol () {
      // "a1bcd efg!h" in EditText
      onView(withId(R.id.editText))
              .perform(typeText("a1bcd efg!h"));

      // "" in ignoredCharacters
      onView(withId(R.id.ignoredCharacters))
              .perform(typeText(""), closeSoftKeyboard());

      // press button
      onView(withId(R.id.button))
              .perform(click());

      // check that outText contains error text
      onView(withId(R.id.outText))
              .check(matches(withText("dcb1a h!gfe")));
    }

    @Test
    public void checkClickNoText() {
        // notext in EditText
        onView(withId(R.id.editText))
                .perform(typeText(""));

        // ignoredCharacters
        onView(withId(R.id.ignoredCharacters))
                .perform(typeText("asd0123456789/"), closeSoftKeyboard());

        // press button
        onView(withId(R.id.button))
                .perform(click());

        // check that outText contains error text
        onView(withId(R.id.outText))
                .check(matches(withText("")));
    }
}