package com.tarefa.tarefa3.assets;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.tarefa.tarefa3.components.SpriteSheet;
import com.tarefa.tarefa3.game_engine.GameObject;

public class TheBoy extends GameObject {

    SpriteSheet spriteSheet;

    public TheBoy(Bitmap bitmap) {
        this.spriteSheet = new SpriteSheet(
                bitmap,
                new int[] {8, 8},
                0,
                new Rect(0,0,108,140)
        );
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {

    }
}
