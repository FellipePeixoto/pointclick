package com.tarefa.tarefa3.assets;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.SurfaceHolder;

import com.tarefa.tarefa3.components.SpriteSheet;
import com.tarefa.tarefa3.game_engine.GameObject;

public class TheBoy extends GameObject {

    SpriteSheet spriteSheet;

    public TheBoy(Bitmap bitmap) {
        this.spriteSheet = new SpriteSheet(
                bitmap,
                new int[]{8, 8},
                0,
                new Rect(0, 0, 108, 140)
        );
    }

    @Override
    public void update() {

    }

    @Override
    public void render(SurfaceHolder surfaceHolder) {

        if (!surfaceHolder.getSurface().isValid())
            return;

        Canvas canvas = surfaceHolder.lockCanvas();

        if (spriteSheet == null) {
            surfaceHolder.unlockCanvasAndPost(canvas);
            return;
        }

        Rect tA = new Rect(spriteSheet.getSrc());
        Rect tB = new Rect(spriteSheet.getDst());

        canvas.drawBitmap(spriteSheet.getBitmap(),
                tA,
                tB,
                null
        );

        spriteSheet.nextFrame();

        surfaceHolder.unlockCanvasAndPost(canvas);
    }
}
