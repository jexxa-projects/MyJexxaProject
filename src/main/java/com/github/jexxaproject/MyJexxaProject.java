package com.github.jexxaproject;

import io.jexxa.core.JexxaMain;
import io.jexxa.drivingadapter.rest.RESTfulRPCAdapter;

public final class MyJexxaProject
{
    public static void main(String[] args)
    {
        var jexxaMain = new JexxaMain(MyJexxaProject.class);

        jexxaMain
                .bind(RESTfulRPCAdapter.class).to(jexxaMain.getBoundedContext()) // Provide REST access to BoundedContext

                .run(); // Finally run the application
    }
}
