package com.example.consultants.thread.jobs;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.example.consultants.thread.ThreadUtils;

public class MyAsynctask extends AsyncTask<String, Integer, String> {
    public static final String TAG = AsyncTask.class.getSimpleName() + "_tag";

    public MyAsynctask(TextView tvMain) {

        this.tvMain = tvMain;
    }

    TextView tvMain;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(TAG, "onPreExecute: " + ThreadUtils.printCurrentThread(Thread.currentThread()));
        tvMain.setText("task starting");

    }

    @Override
    protected String doInBackground(String... strings) {
        //Log.d(TAG, "doInBackground: " + ThreadUtils.printCurrentThread(Thread.currentThread()));
        //Log.d(TAG, "doInBackground: Params " + strings[0]);

        //Mytask
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(i);

        }
        return "Background task result";
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d(TAG, "onPostExecute: " + ThreadUtils.printCurrentThread(Thread.currentThread()));
        Log.d(TAG, "onPostExecute: Result " + s);

        tvMain.setText("Task Complete");
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Log.d(TAG, "onProgressUpdate: " + ThreadUtils.printCurrentThread(Thread.currentThread()));

        tvMain.setText("" + values[0]);
    }
}
