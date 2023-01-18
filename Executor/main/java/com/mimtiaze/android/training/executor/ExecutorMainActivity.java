package com.mimtiaze.android.training.executor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ExecutorMainActivity extends AppCompatActivity {
    public static final String TAG = "Executor";

    Toast mToast;
    Context mContest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_main);

        mContest = getApplicationContext();
        mToast = Toast.makeText(mContest, "", Toast.LENGTH_SHORT);


        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "Inside executor");

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mToast.cancel();
                        mToast = Toast.makeText(mContest, "Executor Test", Toast.LENGTH_SHORT);
                        mToast.show();
                    }
                });

            }
        });
    }
}