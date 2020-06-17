package com.example.groupproject_groceryapp;


import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


@RunWith(JUnit4.class)
public class allergyTest {



    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);



    @Test
    public void hasTextOnScreen(){
        onView(withId(R.id.Allergies)).perform(ViewActions.click());
        onView(withId(R.id.allergyT1)).check(ViewAssertions.matches(withText(R.string.add_allergies)));
        onView(withId(R.id.Blue_box)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        onView(withId(R.id.AllergyAdd)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        onView(withId(R.id.allergyB1)).check(ViewAssertions.matches(withText("Back")));
        onView(withId(R.id.allergyB2)).check(ViewAssertions.matches(withText("Submit")));
        onView(withId(R.id.allergyB3)).check(ViewAssertions.matches(withText("Clear")));
        onView(withId(R.id.allergyT2)).check(ViewAssertions.matches(withText("Current Allergies")));
    }
}

