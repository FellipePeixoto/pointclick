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
    Vector2 destiny;

    public Charac(Bitmap bitmap) {
        this.spriteSheet = new SpriteSheet(
                bitmap,
                new int[]{8, 8},
                0,
                new Rect(0, 0, 108, 140)
        );

        destiny = new Vector2(100, 100);

        Vector2 a1 = new Vector2(1,1);
        Vector2 a2 = new Vector2(2,1);
        Vector2 a1a2 = Vector2.lerp(a1,a1,0.5f);

        Log.i("TESTE", a1.toString());
        Log.i("TESTE", a2.toString());
        Log.i("TESTE", a1a2.toString());
        Log.i("TESTE","");

        a1 = new Vector2(1,1);
        a2 = new Vector2(2,2);
        a1a2 = Vector2.lerp(a1,a1,0.5f);

        Log.i("TESTE", a1.toString());
        Log.i("TESTE", a2.toString());
        Log.i("TESTE", a1a2.toString());
        Log.i("TESTE","");
    }

    @Override
    public void update() {

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

                boolean flagContains = false;

                if (new RectF(position.x,
                        position.y,
                        position.x + spriteSheet.getRect().right,
                        position.y + spriteSheet.getRect().bottom).contains(event.getX(), event.getY())) {

                    flagContains = true;
                }

                if (selected && flagContains) {
                    selected = false;
                    MainScene.selected = null;
                    return;
                }
                else if (MainScene.selected == null && flagContains){
                    MainScene.selected = this;
                    selected = true;
                    destiny = new Vector2(event.getX(), event.getY());
                }

                break;
        }
    }
}
