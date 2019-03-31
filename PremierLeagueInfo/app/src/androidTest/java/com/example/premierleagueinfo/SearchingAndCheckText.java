package com.example.premierleagueinfo;


import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.KeyEvent;
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
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.pressKey;
import static android.support.test.espresso.action.ViewActions.replaceText;
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
public class SearchingAndCheckText {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);




    //test checks that the user can search and select team
    //then return via the return button
    //and click another team
    @Test
    public void SearchATeam_RtrnToList() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.editText),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                        1),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.editText),

                        isDisplayed()));
        appCompatEditText2.perform(replaceText("a"), closeSoftKeyboard());

            pressKey(KeyEvent.KEYCODE_ENTER);

        ViewInteraction textView = onView(
                allOf(withId(R.id.textView4), withText("Arsenal"),

                        isDisplayed()));
        textView.check(matches(isDisplayed()));

        DataInteraction linearLayout = onData(anything())
                .inAdapterView(allOf(withId(R.id.listview),
                        childAtPosition(
                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                2)))
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

        DataInteraction linearLayout2 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listview),
                        childAtPosition(
                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                2)))
                .atPosition(1);
        linearLayout2.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.returnButton), withText("Return"),

                        isDisplayed()));
        appCompatButton2.perform(click());
    }



    //test checks that the user can search and select team
    //then return via the back button
    //text entered should still be there as on create is not called
    //when back is press
    //and user clicks another team

    @Test
    public void SearchTeam_PressBack() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.editText),

                        isDisplayed()));
        appCompatEditText.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.editText),

                        isDisplayed()));
        appCompatEditText2.perform(replaceText("b"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.editText), withText("b"),

                        isDisplayed()));
        appCompatEditText3.perform(pressImeActionButton());

        ViewInteraction textView = onView(
                allOf(withId(R.id.textView4), withText("Bournemouth"),

                        isDisplayed()));
        textView.check(matches(isDisplayed()));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.textView4), withText("Brighton"),

                        isDisplayed()));
        textView2.check(matches(isDisplayed()));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.textView4), withText("Burnley"),

                        isDisplayed()));
        textView3.check(matches(isDisplayed()));

        DataInteraction linearLayout = onData(anything())
                .inAdapterView(allOf(withId(R.id.listview),
                        childAtPosition(
                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                2)))
                .atPosition(0);
        linearLayout.perform(click());

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.txtItem), withText("Team Name: Bournemouth\nHome Kit: Red/Black\nAway Kit: White\nThird Kit: Blue\nClub Value: £ 200000000\nPremier League's won: 0\nChampions League's won:0\nFa Cup Titles: 0\nEuropa League's won: 0\nLeague cups won: 0\n"),

                        isDisplayed()));
        textView4.check(matches(isDisplayed()));

        pressBack();

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.editText), withText("b"),

                        isDisplayed()));
        appCompatEditText4.perform(replaceText(""));

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.editText),
                        isDisplayed()));
        appCompatEditText5.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.editText),
                        isDisplayed()));
        appCompatEditText6.perform(pressImeActionButton());

        DataInteraction linearLayout2 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listview),
                        childAtPosition(
                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                2)))
                .atPosition(3);
        linearLayout2.perform(click());

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.txtItem), withText("Team Name: Burnley\nHome Kit: Claret\nAway Kit: Black\nThird Kit: White\nClub Value: £ 190000000\nPremier League's won: 0\nChampions League's won:0\nFa Cup Titles: 1\nEuropa League's won: 0\nLeague cups won: 0\n"),
                        isDisplayed()));
        textView5.check(matches(isDisplayed()));
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
