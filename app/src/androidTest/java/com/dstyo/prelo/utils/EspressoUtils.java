package com.dstyo.prelo.utils;

import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.espresso.PerformException;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.espresso.util.HumanReadables;
import android.support.test.espresso.util.TreeIterables;
import android.util.Log;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.concurrent.TimeoutException;

import okhttp3.mockwebserver.RecordedRequest;

/**
 * @author Dwi Setiyono <dwi.setiyono@ovo.id>
 * @since 2017.08.12
 */
public class EspressoUtils {

    private static final String TAG = "EspressoUtils";

    public EspressoUtils() {
    }

    public static void intentMatcher(Matcher<Intent> intentMatcher, Intent intent) {
        Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(-1, intent);
        Intents.intending(intentMatcher).respondWith(result);
    }

    public static ViewAction viewShowMatcher(int viewId) {
        return viewMatcher(viewId, false);
    }

    public static ViewAction viewMatcher(final int viewId, final boolean hide) {
        return new ViewAction() {

            public Matcher<View> getConstraints() {
                return ViewMatchers.isDisplayed();
            }

            public String getDescription() {
                return "wait for a specific view with id to " + (hide ? "hide" : "show") + "<" + viewId + "> during " + 5000 + " millis.";
            }

            public void perform(UiController uiController, View view) {
                uiController.loopMainThreadUntilIdle();
                long startTime = System.currentTimeMillis();
                long endTime = startTime + 5000L;
                Matcher viewMatcher = ViewMatchers.withId(viewId);

                do {
                    boolean visible = false;

                    for (View child : TreeIterables.breadthFirstViewTraversal(view)) {
                        if (viewMatcher.matches(child)) {
                            visible = child.getVisibility() == View.VISIBLE;
                            break;
                        }
                    }

                    if (hide != visible) {
                        return;
                    }

                    uiController.loopMainThreadForAtLeast(100L);
                } while (System.currentTimeMillis() < endTime);

                throw (new PerformException.Builder()).withActionDescription(this.getDescription()).withViewDescription(HumanReadables.describe(view)).withCause(new TimeoutException()).build();
            }
        };
    }

    public static Matcher<RecordedRequest> recordedRequestMatcher(final String path) {
        return new TypeSafeMatcher<RecordedRequest>() {
            @Override
            protected boolean matchesSafely(RecordedRequest item) {
                String incomingRequest = item.getPath().trim();
                boolean match = incomingRequest.startsWith(path);
                if (!match) {
                    Log.d(TAG, String.format("Incoming request %s does not start with path %s", incomingRequest, path));
                }
                return match;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("getPath should return");
            }
        };
    }

}
