package com.tarefa.tarefa3.assets;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;

import com.tarefa.tarefa3.R;
import com.tarefa.tarefa3.game_engine.DrawView;
import com.tarefa.tarefa3.game_engine.GameObject;
import com.tarefa.tarefa3.game_engine.SceneBase;

public class MainScene extends SceneBase {

    boolean win;
    float timeToRestart = 1000;
    long wonTime;

    public MainScene(Context context) {
        super(context);

        gameObjects = new GameObject[] {
                new Charac(BitmapFactory.decodeResource(getResources(), R.drawable.theboy)),
                new CollisionRegion(BitmapFactory.decodeResource(getResources(), R.drawable.obstacle)),
                new CollisionRegion(BitmapFactory.decodeResource(getResources(), R.drawable.obstacle)),
                new CollisionRegion(BitmapFactory.decodeResource(getResources(), R.drawable.obstacle)),
                new CollisionRegion(BitmapFactory.decodeResource(getResources(), R.drawable.obstacle)),
                new CollisionRegion(BitmapFactory.decodeResource(getResources(), R.drawable.win))
        };

        setGame();
    }

    @Override
    public void update() {
        updateObjects();

        if (win){
            if (System.currentTimeMillis() - wonTime >= timeToRestart){
                setGame();
            }
            return;
        }

        boolean flagEnd = false;

        if (!win)
            for (int i = 1; i < gameObjects.length - 1; i++) {
                if (gameObjects[i].rect.intersect(gameObjects[0].rect)) {
                    flagEnd = true;
                    break;
                }
            }

        if (flagEnd){
            setGame();
            return;
        }

        if (gameObjects[5].rect.intersect(gameObjects[0].rect)){
            win = true;
            wonTime = System.currentTimeMillis();
            ((CollisionRegion)gameObjects[gameObjects.length - 1]).spriteSheet.SetAnimation(1);
        }
    }

    void setGame() {
        win = false;
        wonTime = 0;

        gameObjects[0].position.x = 500;
        gameObjects[0].position.y = DrawView.screenSize.y - gameObjects[0].scale.y;

        gameObjects[1].position.x = 100;
        gameObjects[1].position.y = 850;

        gameObjects[2].position.x = 600;
        gameObjects[2].position.y = 500;

        gameObjects[3].position.x = -150;
        gameObjects[3].position.y = 80;

        gameObjects[4].position.x = 300;
        gameObjects[4].position.y = 300;

        gameObjects[5].position.x = 500;
        gameObjects[5].position.y = 100;

        ((CollisionRegion)gameObjects[5]).spriteSheet.SetAnimation(0);

        for (int i = 1; i < gameObjects.length; i++){
            ((CollisionRegion)gameObjects[i]).SetRect();
        }
    }

    @Override
    public void render(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        renderObjects(canvas);
    }

}
