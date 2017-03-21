package com.zapme;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

/**
 * Created by jalmei14 on 3/21/17.
 */

public class ZapmeRunner extends AndroidJUnitRunner {

    @Override
    public Application newApplication(ClassLoader cl, String className, Context context)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {

        return super.newApplication(cl, MockZapMeApplication.class.getCanonicalName(), context);
    }
}
