package com.tarefa.tarefa3.assets;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

import com.tarefa.tarefa3.components.SpriteSheet;
import com.tarefa.tarefa3.game_engine.GameObject;
import com.tarefa.tarefa3.game_engine.Touchable;
import com.tarefa.tarefa3.game_engine.Vector2;

public class Charac extends GameObject implements Touchable {

    public volatile boolean selected;

    Vector2 destiny;

    private SpriteSheet spriteSheet;
    private float speed = 100;
    private boolean moving;



    public Charac(Bitmap bitmap) {
        this.spriteSheet = new SpriteSheet(
                bitmap,
                new int[]{8, 8},
                0,
                new Rect(0, 0, 108, 140)
        );

        destiny = new Vector2(100, 100);
    }

    @Override
    public void update() {

        if (!moving)
            return;

        double dst = Vector2.distance(position, destiny);

        if (dst < 2)
            moving = false;

        else
            position = Vector2.lerp(position, destiny, 0.5f);
    }

    @Override
    public void render(Canvas canvas) {

        spriteSheet.render(canvas, position);

        if (selected) {
            Paint paint = new Paint();
            paint.setColor(Color.RED);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);

            canvas.drawRect(new RectF(
                            position.x,
                            position.y,
                            position.x + spriteSheet.getRect().right,
                            position.y + spriteSheet.getRect().bottom),
                    paint);
        }
    }

    public SpriteSheet getSpriteSheet() {
        return spriteSheet;
    }

    @Override
    public void onTouchTrigger(View v, MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:

                if (moving)
                    return;

                if (new RectF(position.x,
                        position.y,
                        position.x + spriteSheet.getRect().right,
                        position.y + spriteSheet.getRect().bottom).contains(event.getX(), event.getY())) {

                    if (selected){
                        MainScene.selected = null;
                        selected = false;
                    } else {
                        MainScene.selected = this;
                        selected = true;
                    }

                    return;
                }

                if (MainScene.selected == this){
                    destiny = new Vector2(event.getX(), event.getY());
                    moving = true;
                }

                break;
        }
    }
}
