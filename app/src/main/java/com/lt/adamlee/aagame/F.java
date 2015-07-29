package com.lt.adamlee.aagame;

/**
 * Created by Administrator on 2015/7/29.
 */
public class F {
    public static float wf(float x) {
        return (x / 320.0f) * ((float) GameView.screenW);
    }

    public static float hf(float y) {
        return (y / 480.0f) * ((float) GameView.screenH);
    }
}
