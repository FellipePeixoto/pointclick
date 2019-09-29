package com.tarefa.tarefa3.assets;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.tarefa.tarefa3.R;
import com.tarefa.tarefa3.game_engine.GameObject;
import com.tarefa.tarefa3.game_engine.SceneBase;

public class MainScene extends SceneBase {

    public static GameObject selected = null;

    public MainScene(Context context) {
        super(context);


        GameObject theBoy = new Charac(BitmapFactory.decodeResource(getResources(), R.drawable.theboy));
        theBoy.x = 100;
        theBoy.y = 100;

        this.gameObjects = new GameObject[]{
                theBoy
        };
    }

    @Override
    public void update() {
        updateObjects();
    }

    @Override
    public void render(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        renderObjects(canvas);
    }

}
