package com.tarefa.tarefa3;

import android.hardware.Sensor;
import android.os.Bundle;
import com.tarefa.tarefa3.game_engine.DrawView;
import com.tarefa.tarefa3.game_engine.Vector2;

import androidx.appcompat.app.AppCompatActivity;
import android.hardware.SensorManager;
import android.util.DisplayMetrics;

public class MainActivity extends AppCompatActivity {

    DrawView drawView;
    DisplayMetrics displayMetrics;
    SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        displayMetrics = new DisplayMetrics();
        getWindow().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        drawView = new DrawView(this,
                displayMetrics.widthPixels,
                displayMetrics.heightPixels);

        setContentView(drawView);

        getSystemService(SENSOR_SERVICE);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        drawView.stop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        drawView.resume();
        sensorManager.registerListener(drawView,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                5);
    }
}
