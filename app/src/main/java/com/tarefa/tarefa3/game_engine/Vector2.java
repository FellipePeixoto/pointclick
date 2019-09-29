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

    public static Vector2 lerp(Vector2 point1, Vector2 point2, float dst) {
        Vector2 point = new Vector2((point1.x + point2.x) * dst, (point1.y + point2.y) * dst);
        return new Vector2(point.x + point1.x, point.y + point1.y);
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
