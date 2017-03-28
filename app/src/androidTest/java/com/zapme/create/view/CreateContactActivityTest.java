package com.zapme.create.view;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.zapme.R;
import com.zapme.RxSchedulersOverrideRule;
import com.zapme.Service;
import com.zapme.ZapmeApplication;
import com.zapme.di.TestRestApiComponent;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static android.support.test.espresso.Espresso.onView;

/**
 * Created by jalmei14 on 3/24/17.
 */
@RunWith(AndroidJUnit4.class)
public class CreateContactActivityTest {

    private static final int TIME = 2000;

    @Inject
    Service service;

    @Rule
    public ActivityTestRule<CreateContactActivity> createContactActivity =
            new ActivityTestRule<>(CreateContactActivity.class, true, false);

    @Rule
    public RxSchedulersOverrideRule rxSchedulersOverrideRule = new RxSchedulersOverrideRule();

    @Before
    public void setUp() throws Exception {
        ZapmeApplication application = (ZapmeApplication)
                InstrumentationRegistry.getTargetContext().getApplicationContext();

        TestRestApiComponent restApiComponent =
                (TestRestApiComponent) application.getRestApiComponent();

        restApiComponent.inject(this);

    }

    @Test
    public void createContactTest() throws Exception {

        createContactActivity.launchActivity(new Intent());

        Thread.sleep(TIME);
        onView(ViewMatchers.withId(R.id.phone_number)).perform(ViewActions.typeText("+5511989214699"));
        Thread.sleep(TIME);
        onView(ViewMatchers.withId(R.id.name)).perform(ViewActions.typeText("Jefferson"));
        Thread.sleep(TIME);
        onView(ViewMatchers.withId(R.id.description)).perform(ViewActions.typeText("Handsome"));
        Thread.sleep(TIME);
        onView(ViewMatchers.withId(R.id.fab_create_contact)).perform(ViewActions.click());
        Thread.sleep(TIME);

    }

}