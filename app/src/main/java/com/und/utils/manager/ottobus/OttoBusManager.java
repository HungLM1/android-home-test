package com.und.utils.manager.ottobus;

import android.util.Log;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;
import com.und.utils.manager.ottobus.model.JobModel;

import java.util.ArrayList;

/**
 * Created by hungle on 22/06/2018.
 */

public class OttoBusManager {
    String TAG = "OttoBusManager";
    /**
     * Save object register OttoBug if register 2time -> crash
     */
    private ArrayList registeredObjects;
    private static volatile OttoBusManager instance;
    private Bus bus;

    public static OttoBusManager getInstance() {
        if (instance == null) {
            instance = new OttoBusManager();
        }
        return instance;
    }

    private OttoBusManager() {
        registeredObjects = new ArrayList<>();
        bus = new Bus(ThreadEnforcer.ANY);
    }

    public void register(Object o) {
        if(!isRegister(o)) {
            Log.d(TAG, "Registed object");
            registeredObjects.add(o);
            bus.register(o);
        }
        else{
            Log.d(TAG, "Object already exist");
        }
    }

    public boolean isRegister(Object o){
        return registeredObjects.contains(o);
    }

    public void unRegister(Object o) {
        if(isRegister(o)) {
            Log.d(TAG, "Unegisted object");
            bus.unregister(o);
        }
        else{
            Log.d(TAG, "Object not exist");
        }
    }

    public void Notification(JobModel n) {
        bus.post(n);
    }
}
