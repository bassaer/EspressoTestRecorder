package com.github.bassaer.espressotestrecorder


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val textView = onView(
            allOf(
                withId(R.id.text_view), withText("0"),
                childAtPosition(
                    childAtPosition(
                        IsInstanceOf.instanceOf(android.view.ViewGroup::class.java),
                        1
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textView.check(matches(withText("0")))

        val floatingActionButton = onView(
            allOf(
                withId(R.id.fab),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        floatingActionButton.perform(click())

        val textView2 = onView(
            allOf(
                withId(R.id.text_view), withText("1"),
                childAtPosition(
                    childAtPosition(
                        IsInstanceOf.instanceOf(android.view.ViewGroup::class.java),
                        1
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("1")))

        val overflowMenuButton = onView(
            allOf(
                withContentDescription("More options"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.toolbar),
                        1
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        overflowMenuButton.perform(click())

        val appCompatTextView = onView(
            allOf(
                withId(R.id.title), withText("Reset"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.content),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatTextView.perform(click())

        val textView3 = onView(
            allOf(
                withId(R.id.text_view), withText("0"),
                childAtPosition(
                    childAtPosition(
                        IsInstanceOf.instanceOf(android.view.ViewGroup::class.java),
                        1
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textView3.check(matches(withText("0")))

        val floatingActionButton2 = onView(
            allOf(
                withId(R.id.fab),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        floatingActionButton2.perform(click())

        val floatingActionButton3 = onView(
            allOf(
                withId(R.id.fab),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        floatingActionButton3.perform(click())

        val floatingActionButton4 = onView(
            allOf(
                withId(R.id.fab),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        floatingActionButton4.perform(click())

        val textView4 = onView(
            allOf(
                withId(R.id.text_view), withText("3"),
                childAtPosition(
                    childAtPosition(
                        IsInstanceOf.instanceOf(android.view.ViewGroup::class.java),
                        1
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textView4.check(matches(withText("3")))

        val overflowMenuButton2 = onView(
            allOf(
                withContentDescription("More options"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.toolbar),
                        1
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        overflowMenuButton2.perform(click())

        val appCompatTextView2 = onView(
            allOf(
                withId(R.id.title), withText("Jump"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.content),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatTextView2.perform(click())

        val textView5 = onView(
            allOf(
                withText("OK"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textView5.check(matches(withText("OK")))

        pressBack()

        val textView7 = onView(
            allOf(
                withId(R.id.text_view), withText("3"),
                childAtPosition(
                    childAtPosition(
                        IsInstanceOf.instanceOf(android.view.ViewGroup::class.java),
                        1
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textView7.check(matches(withText("3")))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
