import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {

    public static  final Intent MAIN_ACTIVITY_INTENT = new Intent(InstrumentationRegistry.getTargetContext(), MainActivity.class);

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    private IdlingResource  jokeIdlingResource;
    private IdlingRegistry idlingRegistry = IdlingRegistry.getInstance();

    @Before
    public void setup() {
        jokeIdlingResource = mActivityTestRule.getActivity().getIdlingResource();

        idlingRegistry.register(jokeIdlingResource);
        mActivityTestRule.launchActivity(MAIN_ACTIVITY_INTENT);
    }

    /**
     * Verifies that Tell Joke button shows a Joke from local GCE server
     * in android library fragment view
     */
    @Test
    public void ClickShowJoke_OpenJokeFragment() {
            onView(withId(R.id.show_joke)).perform(ViewActions.click());
            onView(withId(R.id.joke_container)).check(matches(not(withText(""))));
}


    @After
    public void unregisterIdlingResource()
    {
        if(jokeIdlingResource != null) {
            idlingRegistry.unregister(jokeIdlingResource);
        }
    }

}
