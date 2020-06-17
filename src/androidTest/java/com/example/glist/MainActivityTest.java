package com.example.glist;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.fragment.app.FragmentManager;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewAssertion;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    private static final String STRING_TO_BE_TYPED = "";

    @Rule
    public ActivityScenarioRule<MainActivity> activityActivityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    private Object ViewAction;
    private Object ViewAssertion;
    private Object ListView;

    @Test
    public void ensureListViewIsPresent() {
        FragmentManager rule = null;
        assert false;
        MainActivity activity = (MainActivity) rule();
        View viewById = activity.findViewById(R.id.list_view);
        assertThat(viewById, instanceOf(ListView.class));
        ListView listView = (ListView) viewById;
        ListAdapter adapter = listView.getAdapter();
        assertThat(adapter, instanceOf(ArrayAdapter.class));
    }

    private Object rule() {
        return ListView;
    }


    @Test
    public void changeText_sameActivity() {
        // Type text and then press the button.
        onView(withId(R.id.add_item))
                .perform(typeText(STRING_TO_BE_TYPED), closeSoftKeyboard());
        onView(withId(R.id.add_item)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.add_item)).check(matches(withText(STRING_TO_BE_TYPED)));
    }

    private ViewAssertion matches(Matcher<View> withText) {
        return (androidx.test.espresso.ViewAssertion) ViewAssertion;
    }

    private ViewAction click() {
        return (androidx.test.espresso.ViewAction) ViewAction;
    }

    @Test
    public void changeText_newActivity() {
        // Type text and then press the button.
        onView(withId(R.id.item_update)).perform(typeText(STRING_TO_BE_TYPED),
                closeSoftKeyboard());
        onView(withId(R.id.item_update)).perform(click());

        // This view is in a different Activity, no need to tell Espresso.
        onView(withId(R.id.etItem)).check(matches(withText(STRING_TO_BE_TYPED)));
    }

   @Test

   public void canPopupMenu() {


    onView(withId(R.id.etItem))            // withId(R.id.my_view) is a ViewMatcher
        .perform(click())               // click() is a ViewAction
               .check(matches(isDisplayed())); // matches(isDisplayed()) is a ViewAssertion
   }

}











