package com.tassioauad.trackercoach;

import android.app.Application;

import com.tassioauad.trackercoach.dagger.ApiModule;
import com.tassioauad.trackercoach.dagger.AppModule;
import com.tassioauad.trackercoach.dagger.DaoModule;

import dagger.ObjectGraph;

public class TrackerCoachApplication extends Application {

    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();

        objectGraph = ObjectGraph.create(
                new Object[]{
                        new AppModule(TrackerCoachApplication.this),
                        new ApiModule(),
                        new DaoModule()
                }
        );
    }

    public ObjectGraph getObjectGraph() {
        return objectGraph;
    }
}
