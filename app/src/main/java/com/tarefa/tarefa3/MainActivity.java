package com.tarefa.tarefa3;

import android.os.Bundle;

import com.tarefa.tarefa3.game_engine.DrawView;

import androidx.appcompat.app.AppCompatActivity;

import android.util.DisplayMetrics;

public class MainActivity extends AppCompatActivity {

    DrawView drawView;
    DisplayMetrics displayMetrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        displayMetrics = new DisplayMetrics();
        getWindow().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        drawView = new DrawView(this,
                displayMetrics.widthPixels,
                displayMetrics.heightPixels);

        setContentView(drawView);
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
    }
}
