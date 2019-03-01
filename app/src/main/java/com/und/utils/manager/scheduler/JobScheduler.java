package com.und.utils.manager.scheduler;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.und.utils.manager.ottobus.OttoBusManager;
import com.und.utils.manager.ottobus.model.JobModel;

/**
 * Created by hungle on 01/03/2019.
 */

public class JobScheduler extends IntentService {

    private boolean run = true;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public JobScheduler(String name) {
        super(name);
    }

    public JobScheduler()
    {
        super("JobScheduler");
    }


    @Override
    public void onDestroy() {

        this.run = false;
        super.onDestroy();
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        while (run) {

            try {

                Thread.sleep(1000);

                OttoBusManager.getInstance().Notification(new JobModel(true));

            } catch (InterruptedException e) {e.printStackTrace();}
        }
    }
}
