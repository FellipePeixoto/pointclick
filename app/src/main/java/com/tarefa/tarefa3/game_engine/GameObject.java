package com.tarefa.tarefa3.game_engine;

import android.graphics.Canvas;

public abstract class GameObject {

    public float x,y,sX,sY,rX,rY;

    public GameObject() { }

    public abstract void update();

    public abstract void render(Canvas canvas);
}
