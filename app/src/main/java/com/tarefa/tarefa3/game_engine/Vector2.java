package com.tarefa.tarefa3.game_engine;

import android.graphics.RectF;

public class Vector2 {

    public float x;
    public float y;

    public Vector2(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void Normalize(){
        float total = 0;
        if(x<0)
            total += x*-1;

        if(y<0)
            total += y*-1;

        x = x/total;
        y = y/total;
    }

    public Vector2 Sub(Vector2 value){
        return new Vector2(x - value.x,y-value.y);
    }
}
