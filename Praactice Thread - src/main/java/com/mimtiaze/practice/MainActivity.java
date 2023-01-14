package com.mimtiaze.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "StopWatch";

    TextView mtexTextView;
    Button bStart;
    Button bStop;

    boolean threadRun;
    int count;
    StopWatchThread stopWatchThread;
    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_main);

        init();
        registerListener();
    }

    private void init() {
        Log.d(TAG, "init");
        mtexTextView = findViewById(R.id.tv);
        bStart = findViewById(R.id.bStart);
        bStop = findViewById(R.id.bStop);

    }

    private void registerListener() {
        Log.d(TAG, "registerListener");
        bStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "bStart clicked");

                count = 0;
                threadRun = true;
                stopWatchThread = new StopWatchThread();
                thread = new Thread(stopWatchThread);
                thread.start();
            }
        });

        bStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "bStop clicked");

                threadRun = false;
            }
        });
    }



    class StopWatchThread implements Runnable {
        @Override
        public void run() {
            while (threadRun) {
                count++;
                Log.d(TAG, Integer.toString(count));

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }


}