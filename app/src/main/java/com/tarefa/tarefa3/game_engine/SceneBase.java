package com.tarefa.tarefa3.game_engine;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceView;

public abstract class SceneBase extends SurfaceView {

    protected GameObject[] gameObjects;

    public SceneBase(Context context) {
        super(context);
    }

    public abstract void update();

    public abstract void render(Canvas canvas);

    protected void updateObjects() {
        for (GameObject gameObject : gameObjects) {
            gameObject.update();
        }
    }

    protected void renderObjects(Canvas canvas) {
        for (GameObject gameObject : gameObjects) {
            gameObject.render(canvas);
        }
    }

    public GameObject[] getGameObjects(){
        return this.gameObjects;
    }
}
