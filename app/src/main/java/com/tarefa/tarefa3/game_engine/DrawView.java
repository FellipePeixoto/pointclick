package com.tarefa.tarefa3.game_engine;

import android.content.Context;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.tarefa.tarefa3.assets.Charac;
import com.tarefa.tarefa3.assets.MainScene;

public class DrawView extends SurfaceView implements Runnable, SensorEventListener {

    boolean isRunning;
    static SceneBase currentScene;
    SurfaceHolder surfaceHolder;
    Thread thread;
    public static Vector2 screenSize;

    int x,y;

    public DrawView(Context context, int width, int height) {
        super(context);
        screenSize = new Vector2();
        screenSize.x = width;
        screenSize.y = height;
        currentScene = new MainScene(context);
        surfaceHolder = getHolder();
    }

    @Override
    public void run() {

        while (isRunning) {

            update();
            render(surfaceHolder);

            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {

            }
        }

    }

    public void resume() {
        isRunning = true;

        thread = new Thread(this);
        thread.start();
    }

    public void stop() {
        isRunning = false;

        try {
            thread.join();
        } catch (InterruptedException ie) {

        }
    }

    public void update() {
        ((Charac)currentScene.gameObjects[0]).move(x,y);
        currentScene.update();
    }

    public void render(SurfaceHolder surfaceHolder) {
        if (!surfaceHolder.getSurface().isValid())
            return;

        Canvas canvas = surfaceHolder.lockCanvas();

        currentScene.render(canvas);

        surfaceHolder.unlockCanvasAndPost(canvas);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        switch (event.sensor.getType()){
            case Sensor.TYPE_ACCELEROMETER:
                x = (int) event.values[0];
                y = (int) event.values[1];
                //Log.d("SENSORA",x + " -- " + y);
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
