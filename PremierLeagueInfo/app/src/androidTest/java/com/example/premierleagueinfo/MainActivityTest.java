package com.example.premierleagueinfo;


import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void CheckTeamsDisplayed() {
        ViewInteraction textView = onView(
                allOf(withId(R.id.textView4), withText("Arsenal"),

                        isDisplayed()));
        textView.check(matches(isDisplayed()));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.textView4), withText("Bournemouth"),

                        isDisplayed()));
        textView2.check(matches(isDisplayed()));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.textView4), withText("Brighton"),

                        isDisplayed()));
        textView3.check(matches(isDisplayed()));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.textView4), withText("Burnley"),

                        isDisplayed()));
        textView4.check(matches(isDisplayed()));

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.textView4), withText("Cardiff City"),

                        isDisplayed()));
        textView5.check(matches(isDisplayed()));

        ViewInteraction textView6 = onView(
                allOf(withId(R.id.textView4), withText("Chelsea"),

                        isDisplayed()));
        textView6.check(matches(isDisplayed()));


    }



    @Test
    public void mainActivityArsenal() {
        ViewInteraction textView = onView(
                allOf(withId(R.id.textView4), withText("Arsenal"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        textView.check(matches(isDisplayed()));

        DataInteraction linearLayout = onData(anything())
                .inAdapterView(allOf(withId(R.id.listview),
                        childAtPosition(
                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                1)))
                .atPosition(0);
        linearLayout.perform(click());

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.txtItem), withText("Team Name: Arsenal\nHome Kit: Red\nAway Kit: Black\nThird Kit: Green\nClub Value: £ 2200000000\nPremier League's won: 3\nChampions League's won:0\nFa Cup Titles: 13\nEuropa League's won: 0\nLeague cups won: 2\n"),

                        isDisplayed()));
        textView2.check(matches(isDisplayed()));

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.returnButton), withText("Return"),

                        isDisplayed()));
        appCompatButton.perform(click());
    }



    @Test
    public void mainActivityBournemouth() {
        ViewInteraction textView = onView(
                allOf(withId(R.id.textView4), withText("Bournemouth"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        textView.check(matches(isDisplayed()));

        DataInteraction linearLayout = onData(anything())
                .inAdapterView(allOf(withId(R.id.listview),
                        childAtPosition(
                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                1)))
                .atPosition(1);
        linearLayout.perform(click());

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.txtItem), withText("Team Name: Bournemouth\nHome Kit: Red/Black\nAway Kit: White\nThird Kit: Blue\nClub Value: £ 200000000\nPremier League's won: 0\nChampions League's won:0\nFa Cup Titles: 0\nEuropa League's won: 0\nLeague cups won: 0\n"),

                        isDisplayed()));
        textView2.check(matches(isDisplayed()));

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.returnButton), withText("Return"),

                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.textView4), withText("Bournemouth"),

                        isDisplayed()));
        textView3.check(matches(isDisplayed()));
    }



    @Test
    public void mainActivityTestBrighton() {
        ViewInteraction textView = onView(
                allOf(withId(R.id.textView4), withText("Brighton"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        textView.check(matches(isDisplayed()));

        DataInteraction linearLayout = onData(anything())
                .inAdapterView(allOf(withId(R.id.listview),
                        childAtPosition(
                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                1)))
                .atPosition(2);
        linearLayout.perform(click());

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.txtItem), withText("Team Name: Brighton\nHome Kit: White/Blue\nAway Kit: Green\nThird Kit: Yellow\nClub Value: £ 178000000\nPremier League's won: 0\nChampions League's won:0\nFa Cup Titles: 0\nEuropa League's won: 0\nLeague cups won: 0\n"),

                        isDisplayed()));
        textView2.check(matches(isDisplayed()));



        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.returnButton), withText("Return"),

                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.textView4), withText("Brighton"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        textView3.check(matches(isDisplayed()));
    }




















    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
