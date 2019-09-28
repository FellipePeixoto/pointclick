package com.tarefa.tarefa3.game_engine;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.tarefa.tarefa3.assets.MainScene;

public class DrawView extends SurfaceView implements Runnable {

    boolean isRunning;
    SceneBase currentScene;
    SurfaceHolder surfaceHolder;
    Thread thread;

    public DrawView(Context context, int width, int height) {
        super(context);

        currentScene = new MainScene(context);
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

    public void render(SurfaceHolder surfaceHolder){
        currentScene.render(surfaceHolder);
    }
}
