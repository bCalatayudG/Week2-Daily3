package com.example.consultants.thread.jobs;

import android.os.Handler;
import android.util.Log;

public class MyRunnable implements Runnable {
    int iterations;
    Handler handler;
    public static final String TAG = MyTask.class.getSimpleName() + "_tag";


    public MyRunnable(int iterations, Handler handler) {
        this.iterations = iterations;
        this.handler = handler;
    }

    @Override
    public void run() {

        Log.d(TAG, "run: Task Starting");

//        try {
//            MyTask.start(iterations, Thread.currentThread().getName());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Log.d(TAG, "run: TaskEnding");
    }
}
