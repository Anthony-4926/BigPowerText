package com.example.batteryinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class Pow extends AppCompatActivity {

    private TextView batteryLevelTextView;
    int pow;
    //创建BroadcastReceiver


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pow);
        getBatteryPercentage();
        batteryLevelTextView = findViewById(R.id.textView2);
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