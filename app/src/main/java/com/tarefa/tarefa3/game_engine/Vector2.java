package com.tarefa.tarefa3.game_engine;

public class Vector2 {

    public float x;
    public float y;

    public Vector2() {
        x = 0;
        y = 0;
    }

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void Normalize() {
        float total = 0;
        if (x < 0)
            total += x * -1;

        if (y < 0)
            total += y * -1;

        x = x / total;
        y = y / total;
    }

    public static float distance(Vector2 vectorA, Vector2 vectorB) {
        return ( (vectorA.y - vectorA.x) * (vectorB.y - vectorB.x) +
                (vectorB.y - vectorB.x) * (vectorB.y - vectorB.x) ) * 0.5f;
    }

    public static Vector2 lerp(Vector2 origin, Vector2 destiny, float dst) {

        float xLerp = origin.x + (destiny.x - origin.x) * dst;
        float yLerp = origin.y + (destiny.y - origin.y) * ((xLerp - origin.x) / (destiny.x - origin.x));

        return new Vector2(xLerp, yLerp);
    }

    public Vector2 Sub(Vector2 value) {
        return new Vector2(
                x - value.x,
                y - value.y);
    }

    public String toString() {
        return "{X: " + Float.toString(x) + ", Y: " + Float.toString(y) + "}";
    }
}
