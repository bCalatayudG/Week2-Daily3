package com.example.consultants.thread.jobs;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.ProgressBar;

import java.util.Random;

public class MyTask {

    static int progressStatus;
    private static Handler handler = new Handler(Looper.getMainLooper());
    public static final String TAG = MyTask.class.getSimpleName() + "_tag";

    public static void start(final ProgressBar determinateBar, String thread) throws InterruptedException {

        progressStatus = 0;
        Random rand = new Random();
        int n = rand.nextInt(500) + 1;
        while (progressStatus < 100) {
            progressStatus += 1;
            handler.post(new Runnable() {
                public void run() {
                    determinateBar.setProgress(progressStatus);
                    Log.d(TAG, "run: " + determinateBar.getId() + " ___ " + progressStatus);
                }
            });
            try {
                Thread.sleep(n);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.d(TAG, "start: Task completed on Thread: " + thread);
    }

}
