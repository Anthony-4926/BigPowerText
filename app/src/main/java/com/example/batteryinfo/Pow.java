package com.example.batteryinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

public class Pow extends AppCompatActivity {

    private TextView batteryLevelTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pow);

        batteryLevelTextView = findViewById(R.id.textView2);
        int pow = getBatteryPercentage();
        if(pow < 20) {
            batteryLevelTextView.setTextColor(Color.RED);
        }else{
            batteryLevelTextView.setTextColor(Color.GREEN);
        }
        batteryLevelTextView.setText(""+pow);
    }

    public int getBatteryPercentage() {
        BatteryManager batteryManager = (BatteryManager) Pow.this.getSystemService(Pow.BATTERY_SERVICE);
        int pow = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
        System.out.println(pow);
        return pow;

    }

}