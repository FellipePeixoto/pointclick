package com.tarefa.tarefa3.assets;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.tarefa.tarefa3.R;
import com.tarefa.tarefa3.game_engine.GameObject;
import com.tarefa.tarefa3.game_engine.SceneBase;

public class MainScene extends SceneBase {
    public MainScene(Context context) {
        super(context);

        GameObject theBoy = new TheBoy(BitmapFactory.decodeResource(getResources(), R.drawable.theboy));
        theBoy.x = 100;
        theBoy.y = 100;

        this.gameObjects = new GameObject[]{
                theBoy
        };
    }
}
