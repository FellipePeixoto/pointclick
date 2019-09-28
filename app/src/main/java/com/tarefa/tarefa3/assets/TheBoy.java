package com.tarefa.tarefa3.assets;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.tarefa.tarefa3.components.SpriteSheet;
import com.tarefa.tarefa3.game_engine.GameObject;
import com.tarefa.tarefa3.game_engine.Vector2;

public class TheBoy extends GameObject {

    SpriteSheet spriteSheet;
    float speed = 100;
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

    void Lerp(Vector2 destiny) {
        Vector2 pos = new Vector2(x, y);
        Vector2 dir = destiny.Sub(pos);
        dir.Normalize();
        x += dir.x * speed;
        y += dir.y * speed;
    }



}
