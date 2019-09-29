package com.tarefa.tarefa3.game_engine;

import android.graphics.Canvas;

public abstract class GameObject {

    public Vector2 position;
    public Vector2 scale;


    public GameObject() {
        position = new Vector2(0,0);
        scale = new Vector2(1,1);
    }

    public abstract void update();

    public abstract void render(Canvas canvas);
}
