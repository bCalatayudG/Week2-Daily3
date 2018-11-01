package com.example.consultants.thread;

public class ThreadUtils {
    public static String printCurrentThread(Thread thread) {
        return "CurrentThread " + thread.getName();
    }
}
