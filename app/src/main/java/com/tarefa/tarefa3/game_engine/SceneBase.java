package com.tarefa.tarefa3.game_engine;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public abstract class SceneBase extends SurfaceView {

    protected GameObject[] gameObjects;

    public SceneBase(Context context) {
        super(context);
    }

    public void update(){
        for (GameObject gameObject : gameObjects) {
            gameObject.update();
        }
    }

    public void render(SurfaceHolder surfaceHolder){

        if (!surfaceHolder.getSurface().isValid())
            return;

        Canvas canvas = surfaceHolder.lockCanvas();

        canvas.drawColor(Color.WHITE);

        surfaceHolder.unlockCanvasAndPost(canvas);

        for (GameObject gameObject : gameObjects) {
            gameObject.render(surfaceHolder);
        }
    }
}
