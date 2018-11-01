package com.example.consultants.thread;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.consultants.thread.jobs.MyAsynctask;
import com.example.consultants.thread.jobs.MyThread;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MainActivity extends AppCompatActivity {

    ProgressBar determinateBar, determinateBar2, determinateBar3, determinateBar4;
    TextView tvOne, tvTwo;
    private ThreadPoolExecutor executor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        determinateBar = findViewById(R.id.determinateBar);
        determinateBar2 = findViewById(R.id.determinateBar2);
        determinateBar3 = findViewById(R.id.determinateBar3);
        determinateBar4 = findViewById(R.id.determinateBar4);

        tvOne = findViewById(R.id.tvOne);
        tvTwo = findViewById(R.id.tvTwo);

        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);

    }

    public void onUpdateBar(View view) {
        ThreadUtils.printCurrentThread(Thread.currentThread());
        MyThread myThread = new MyThread(determinateBar);
        MyThread myThread2 = new MyThread(determinateBar2);
        MyThread myThread3 = new MyThread(determinateBar3);
        MyThread myThread4 = new MyThread(determinateBar4);
        if (!executor.isShutdown()) {
            executor.submit(myThread);
            executor.submit(myThread2);
            executor.submit(myThread3);
            executor.submit(myThread4);
        }

    }

    public void onRunAsync(View view) {
        ThreadUtils.printCurrentThread(Thread.currentThread());
        MyAsynctask myAsynctask = new MyAsynctask(tvOne);
        MyAsynctask myAsynctask2 = new MyAsynctask(tvTwo);
        myAsynctask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        myAsynctask2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
}
