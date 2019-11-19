package com.tarefa.tarefa3.assets;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

import com.tarefa.tarefa3.components.SpriteSheet;
import com.tarefa.tarefa3.game_engine.DrawView;
import com.tarefa.tarefa3.game_engine.GameObject;
import com.tarefa.tarefa3.game_engine.Vector2;

public class Charac extends GameObject {

    public volatile boolean selected;

    public SpriteSheet spriteSheet;
    private float speed = 4;
    private boolean moving;

    public Charac(Bitmap bitmap) {
        this.spriteSheet = new SpriteSheet(
                bitmap,
                new int[]{8, 8},
                1,
                new Rect(0, 0, 108, 140)
        );

        scale.x = spriteSheet.getRect().right;
        scale.y = spriteSheet.getRect().bottom;
    }

    @Override
    public void update() {
        rect.left = position.x + 50;
        rect.top = position.y + 50;
        rect.right = (position.x + scale.x) - 50;
        rect.bottom = (position.y + scale.y) - 50;
    }

    @Override
    public void render(Canvas canvas) {

        spriteSheet.render(canvas, position);
    }

    public void move(int x, int y){

        float newX = position.x - x * speed;
        float newY = position.y + y * speed;

        if (newX > position.x){
            spriteSheet.SetAnimation(0);
        }
        else {
            spriteSheet.SetAnimation(1);
        }

        if (newX >= 0 && newX + scale.x <= DrawView.screenSize.x)
            position.x = newX;

        if (newY >= 0 && newY + scale.y <= DrawView.screenSize.y)
            position.y = newY;
    }

    public SpriteSheet getSpriteSheet() {
        return spriteSheet;
    }
}
