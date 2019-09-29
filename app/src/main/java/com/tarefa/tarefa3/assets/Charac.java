package com.tarefa.tarefa3.assets;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.tarefa.tarefa3.components.SpriteSheet;
import com.tarefa.tarefa3.game_engine.GameObject;
import com.tarefa.tarefa3.game_engine.Touchable;
import com.tarefa.tarefa3.game_engine.Vector2;

public class Charac extends GameObject implements Touchable {

    private SpriteSheet spriteSheet;

    public volatile boolean selected;
    private float speed = 100;

    public Charac(Bitmap bitmap) {
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
    public void render(Canvas canvas) {

        spriteSheet.render(canvas, new Vector2(x, y));

        if (selected) {
            Paint paint = new Paint();
            paint.setColor(Color.RED);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);

            canvas.drawRect(new RectF(
                            x,
                            y,
                            x + spriteSheet.getRect().right,
                            y + spriteSheet.getRect().bottom),
                    paint);
        }
    }

    public SpriteSheet getSpriteSheet() {
        return spriteSheet;
    }

    void Lerp(Vector2 destiny) {
        Vector2 pos = new Vector2(x, y);
        Vector2 dir = destiny.Sub(pos);
        dir.Normalize();
        x += dir.x * speed;
        y += dir.y * speed;
    }

    @Override
    public void onTouchTrigger(View v, MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:

                if (new RectF(x,
                        y,
                        x + spriteSheet.getRect().right,
                        y + spriteSheet.getRect().bottom).contains(event.getX(), event.getY())) {

                    /*Caso seja selecionado*/
                }

                break;
        }
    }
}
