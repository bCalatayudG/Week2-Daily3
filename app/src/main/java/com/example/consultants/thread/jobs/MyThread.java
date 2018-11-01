package com.example.consultants.thread.jobs;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.ProgressBar;

import com.example.consultants.thread.ThreadUtils;


import static com.example.consultants.thread.jobs.MyTask.progressStatus;

public class MyThread extends Thread {

    public static final String TAG = MyThread.class.getSimpleName() + "_tag";

    ProgressBar determinateBar;

    public MyThread(ProgressBar determinateBar) {
        this.determinateBar = determinateBar;
    }

    @Override
    public void run() {
        super.run();

        try {
            MyTask.start(determinateBar, Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
