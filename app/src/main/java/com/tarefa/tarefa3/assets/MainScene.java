package com.tarefa.tarefa3.assets;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.tarefa.tarefa3.R;
import com.tarefa.tarefa3.game_engine.GameObject;
import com.tarefa.tarefa3.game_engine.SceneBase;

public class MainScene extends SceneBase {
    public MainScene(Context context) {
        super(context);

        this.gameObjects = new GameObject[]{
                new TheBoy(BitmapFactory.decodeResource(getResources(), R.drawable.theboy))
        };
    }
}
