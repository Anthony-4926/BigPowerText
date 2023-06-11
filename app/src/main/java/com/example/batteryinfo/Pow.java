package com.example.batteryinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Pow extends AppCompatActivity {

    private TextView batteryLevelTextView;
    int pow;
    //创建BroadcastReceiver
    float size = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pow);
        getBatteryPercentage();
        batteryLevelTextView = findViewById(R.id.textView2);
        Button small = findViewById(R.id.small);
        Button bigger = findViewById(R.id.bigger);
        batteryLevelTextView.setTextSize(size);
        small.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                size = size - 20;
                batteryLevelTextView.setTextSize(size);

            }
        });
        bigger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                size = size + 40;
                batteryLevelTextView.setTextSize(size);

            }
        });

    }

    public void getBatteryPercentage() {
        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                pow = intent.getIntExtra("level", -1);
                if(pow < 20) {
                    batteryLevelTextView.setTextColor(Color.RED);
                }else{
                    batteryLevelTextView.setTextColor(Color.GREEN);
                }
                batteryLevelTextView.setText(""+pow);
            }
        };
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(receiver, intentFilter);

    }

}