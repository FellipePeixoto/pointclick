package com.tarefa.tarefa3.assets;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Bitmap;
import com.tarefa.tarefa3.components.SpriteSheet;
import com.tarefa.tarefa3.game_engine.GameObject;
import com.tarefa.tarefa3.game_engine.Vector2;

public class CollisionRegion extends GameObject {

    public SpriteSheet spriteSheet;

    public CollisionRegion(Bitmap bitmap){
        this.spriteSheet = new SpriteSheet(
                bitmap,
                new int[]{4, 4},
                0,
                new Rect(0, 0, 115, 120)
        );

        scale.x = spriteSheet.getRect().right;
        scale.y = spriteSheet.getRect().bottom;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Canvas canvas) {
        spriteSheet.render(canvas, position);
    }

    public void SetRect(){
        rect.left = position.x + 10;
        rect.top = position.y + 10;
        rect.right = (position.x + scale.x) - 10;
        rect.bottom = (position.y + scale.y) - 10;
    }
}
