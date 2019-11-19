package com.tarefa.tarefa3.components;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

import com.tarefa.tarefa3.game_engine.Vector2;

public class SpriteSheet {

    private int actualRow;
    private int actualFrame;
    private Bitmap bitmap;
    private int frameCount;
    private int[] frameCountByRow;
    private Rect rect;

    public SpriteSheet(Bitmap bitmap, int[] frameCountByRow, Rect rect) {
        this.bitmap = bitmap;
        this.frameCountByRow = frameCountByRow;
        rect.right = rect.right * 2;
        rect.bottom = rect.bottom * 2;
        this.rect = rect;
        this.actualRow = 0;
        this.actualFrame = 0;
    }

    public SpriteSheet(Bitmap bitmap, int[] frameCountByRow, int defaultAnimation, Rect rect) {
        this.bitmap = bitmap;
        this.frameCountByRow = frameCountByRow;
        rect.right = rect.right * 2;
        rect.bottom = rect.bottom * 2;
        this.rect = rect;
        this.actualRow = defaultAnimation;
        this.frameCount = this.frameCountByRow[this.actualRow];
        this.actualFrame = 0;
    }

    public void render(Canvas canvas, Vector2 position) {
        canvas.drawBitmap(bitmap,
                getSrc(),
                new RectF(position.x, position.y, position.x + rect.right, position.y + rect.bottom),
                null
        );

        nextFrame();
    }

    public void SetAnimation(int value) {
        if (value < 0 || value > frameCountByRow.length)
            return;

        this.actualRow = value;
        frameCount = frameCountByRow[this.actualRow];
        //this.actualFrame = 0;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public int nextFrame() {
        if (actualFrame >= frameCountByRow[actualRow] - 1) {
            actualFrame = 0;
            return actualFrame;
        }

        actualFrame++;
        return actualFrame;
    }

    public Rect getSrc() {
        return new Rect(
                rect.right * actualFrame,
                actualRow * rect.bottom,
                rect.right * actualFrame + (rect.right),
                actualRow * rect.bottom + (rect.bottom));
    }

    public Rect getRect() {
        return rect;
    }
}
