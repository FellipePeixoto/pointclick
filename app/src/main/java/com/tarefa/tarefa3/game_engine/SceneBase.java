package com.tarefa.tarefa3.game_engine;

import android.content.Context;
import android.view.SurfaceView;

import com.tarefa.tarefa3.game_engine.GameObject;

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

    public void render(){
        for (GameObject gameObject : gameObjects) {
            gameObject.render();
        }
    }
}
