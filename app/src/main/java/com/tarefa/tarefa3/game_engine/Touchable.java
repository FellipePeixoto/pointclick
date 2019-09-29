package com.tarefa.tarefa3.game_engine;

import android.view.MotionEvent;
import android.view.View;

public interface Touchable {
    public void onTouchTrigger(View v, MotionEvent event);
}
