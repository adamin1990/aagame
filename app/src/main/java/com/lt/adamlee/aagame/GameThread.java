package com.lt.adamlee.aagame;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Created by Administrator on 2015/7/29.
 */
class GameThread extends Thread {
    private static final int FRAME_PERIOD = 33;
    private static final int MAX_FPS = 30;
    private GameView game;
    public boolean running;
    private SurfaceHolder surfaceHolder;

    public GameThread(SurfaceHolder surfaceHolder, GameView game) {
        this.surfaceHolder = surfaceHolder;
        this.game = game;
    }

    public void setRunning(boolean run) {
        this.running = run;
    }

    public SurfaceHolder getSurfaceHolder() {
        return this.surfaceHolder;
    }

    @SuppressLint({"WrongCall"})
    public void run() {
        while (this.running) {
            Canvas canvas = null;
            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (this.surfaceHolder) {
                    long beginTime = System.currentTimeMillis();
                    this.game.onDraw(canvas);
                    int sleepTime = (int) (33 - (System.currentTimeMillis() - beginTime));
                    if (sleepTime > 0) {
                        try {
                            Thread.sleep((long) sleepTime);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (canvas != null) {
                    this.surfaceHolder.unlockCanvasAndPost(canvas);
                }
            } catch (Exception e2) {
                try {
                    e2.printStackTrace();
                    if (canvas != null) {
                        this.surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                } catch (Throwable th) {
                    if (canvas != null) {
                        this.surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                }
            }
        }
    }
}
