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
import com.tarefa.tarefa3.game_engine.Vector2;

public class MainScene extends SceneBase {

    public static GameObject selected = null;

    public MainScene(Context context) {
        super(context);


        GameObject go1 = new Charac(BitmapFactory.decodeResource(getResources(), R.drawable.theboy));
        go1.position= new Vector2(100,100);

        GameObject go2 = new Charac(BitmapFactory.decodeResource(getResources(), R.drawable.theboy));
        go1.position= new Vector2(150,520);

        this.gameObjects = new GameObject[]{ go1, go2};
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
