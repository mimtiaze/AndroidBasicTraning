package com.mimtiaze.android.training.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServiceMainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bStart, bStop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_main);

        bStart = findViewById(R.id.bStart);
        bStop = findViewById(R.id.bStop);

        bStart.setOnClickListener(this);
        bStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bStart:
                startService(new Intent(this, MyService.class));
                break;
            case R.id.bStop:
                stopService(new Intent(this, MyService.class));
                break;
        }
    }
}