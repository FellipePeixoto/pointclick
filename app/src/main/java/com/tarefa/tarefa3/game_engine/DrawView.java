package com.tarefa.tarefa3.game_engine;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.tarefa.tarefa3.assets.Charac;
import com.tarefa.tarefa3.assets.MainScene;

public class DrawView extends SurfaceView implements Runnable, View.OnTouchListener {

    boolean isRunning;
    SceneBase currentScene;
    SurfaceHolder surfaceHolder;
    Thread thread;

    public DrawView(Context context, int width, int height) {
        super(context);
        setOnTouchListener(this);

        currentScene = new MainScene(context);
        surfaceHolder = getHolder();

    }

    @Override
    public void run() {

        while (isRunning){

            update();
            render(surfaceHolder);

            try {
                Thread.sleep(100);
            } catch (InterruptedException ie){

            }
        }

    }

    public void resume(){
        isRunning = true;

        thread = new Thread(this);
        thread.start();

    }

    public void stop(){
        isRunning = false;

        try {
            thread.join();
        } catch (InterruptedException ie){

        }
    }

    public void update(){
        currentScene.update();
    }

    public void render(SurfaceHolder surfaceHolder)
    {
        if (!surfaceHolder.getSurface().isValid())
            return;

        Canvas canvas = surfaceHolder.lockCanvas();

        currentScene.render(canvas);

        surfaceHolder.unlockCanvasAndPost(canvas);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()) {

            case MotionEvent.ACTION_UP:

                for (GameObject gameObject: currentScene.getGameObjects()) {

                }
                return true;

            case MotionEvent.ACTION_DOWN:
                for (GameObject gameObject: currentScene.getGameObjects()) {

                }
                return  true;
        }

        return false;
    }
}
