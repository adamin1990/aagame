package com.lt.adamlee.aagame;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;

//import com.google.android.gms.drive.events.CompletionEvent;
//import com.google.android.gms.location.DetectedActivity;

import java.util.Date;

/**
 * Created by Administrator on 2015/7/29.
 */
public class LevelPage {

    static boolean d_vel;
    static boolean i_vel;
    private static int levelLimit;
    static boolean start_down;
    static boolean start_up;
    private float acc;
    private Paint backgroundpaint;
    private boolean btp;
    private int cur_x;
    private int cur_y;
    private Date date;
    RectF dest;
    private int lcount;
    private Bitmap levellock1;
    private Bitmap levelpage;
    private Bitmap levelpagebutton;
    private Bitmap levelpagedown;
    private Bitmap levelpageup;
    private Paint leveltextpaint;
    private float lx;
    private float ly;
    private Bitmap mainpageimage1;
    private boolean move;
    private Paint re;
    Rect sRect;
    private int t_i;
    private int t_j;
    private Typeface tf;
    private long time_down;
    private long time_up;
    private float vel;
    private Paint withoutStroke;
    private float y;

    LevelPage() {
        this.withoutStroke = new Paint();
        this.re = new Paint();
        this.y = 0.0f;
        this.lcount = 0;
        this.mainpageimage1 = BitmapFactory.decodeResource(GameView.ctx.getResources(), R.drawable.mainpageimage1);
        this.mainpageimage1 = Bitmap.createScaledBitmap(this.mainpageimage1, GameView.screenW, GameView.screenH, true);
        this.levelpagebutton = BitmapFactory.decodeResource(GameView.ctx.getResources(), R.drawable.unlock);
        this.levelpagebutton = Bitmap.createScaledBitmap(this.levelpagebutton, (int) F.wf(80.0f), (int) F.wf(80.0f), true);
        this.levellock1 = BitmapFactory.decodeResource(GameView.ctx.getResources(), R.drawable.lock);
        this.levellock1 = Bitmap.createScaledBitmap(this.levellock1, (int) F.wf(80.0f), (int) F.wf(80.0f), true);
        this.tf = Typeface.createFromAsset(GameView.ctx.getAssets(), "Russo_One.ttf");
        this.backgroundpaint = new Paint();
        this.backgroundpaint.setColor(GameView.ctx.getResources().getColor(R.color.Gray));
        this.leveltextpaint = new Paint();
        this.leveltextpaint.setColor(-1);
        this.leveltextpaint.setTextSize(F.hf(22.0f));
        this.leveltextpaint.setAntiAlias(true);
        this.tf = Typeface.createFromAsset(GameView.ctx.getAssets(), "Russo_One.ttf");
        this.leveltextpaint.setTypeface(this.tf);
    }

    public void getLevelNo() {
        if (GameView.levelcounter >= GameActivity.gameLevel) {
           GameActivity.gameLevel = GameView.levelcounter;
            levelLimit = GameActivity.gameLevel;
        }
        this.withoutStroke.setTextSize((float) (GameView.screenH / 20));
        this.withoutStroke.setAntiAlias(true);
        this.withoutStroke.setSubpixelText(true);
        this.withoutStroke.setTypeface(this.tf);
        this.withoutStroke.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.re.setAlpha(150);
    }

    public void Level_Canvas(Canvas canvas) {
        getLevelNo();
        this.lcount = 0;
        canvas.drawBitmap(this.mainpageimage1, 0.0f, 0.0f, null);
        levelLimit = GameActivity.gameLevel;
        this.sRect = new Rect(0, 0, this.levelpagebutton.getWidth(), this.levelpagebutton.getHeight());
        for (int i = 0; i < 67; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.lcount < levelLimit) {
                    this.dest = new RectF((((float) j) * F.wf(100.0f)) + F.wf(20.0f), ((((float) i) * F.hf(100.0f)) + F.hf(40.0f)) + this.y, ((((float) j) * F.wf(100.0f)) + F.wf(20.0f)) + ((float) this.levelpagebutton.getWidth()), (((((float) i) * F.hf(100.0f)) + F.hf(40.0f)) + this.y) + ((float) this.levelpagebutton.getHeight()));
                    canvas.drawBitmap(this.levelpagebutton, this.sRect, this.dest, this.leveltextpaint);
                    StringBuilder stringBuilder = new StringBuilder();
                    int i2 = this.lcount + 1;
                    this.lcount = i2;
                    canvas.drawText(stringBuilder.append(i2).toString(), (((((float) j) * F.wf(100.0f)) + F.wf(20.0f)) + ((float) (this.levelpagebutton.getWidth() / 2))) - (this.leveltextpaint.measureText(String.valueOf(this.lcount)) / 2.0f), (((((float) i) * F.hf(100.0f)) + F.hf(45.0f)) + ((float) (this.levelpagebutton.getHeight() / 2))) + this.y, this.leveltextpaint);
                } else {
                    this.dest = new RectF((((float) j) * F.wf(100.0f)) + F.wf(20.0f), ((((float) i) * F.hf(100.0f)) + F.hf(40.0f)) + this.y, ((((float) j) * F.wf(100.0f)) + F.wf(20.0f)) + ((float) this.levelpagebutton.getWidth()), (((((float) i) * F.hf(100.0f)) + F.hf(40.0f)) + this.y) + ((float) this.levelpagebutton.getHeight()));
                    canvas.drawBitmap(this.levellock1, this.sRect, this.dest, this.leveltextpaint);
                }
            }
        }
        if (start_up) {
            if (i_vel) {
                this.acc = (float) (((double) this.acc) + (((double) GameView.screenH) * 0.00125d));
            }
            if (d_vel) {
                this.acc = (float) (((double) this.acc) - (((double) GameView.screenH) * 0.00125d));
            }
            if (this.acc >= this.vel) {
                i_vel = false;
                d_vel = true;
            }
            if (this.acc <= 0.0f) {
                d_vel = false;
                start_up = false;
                this.acc = 0.0f;
            }
            if ((0.25d * ((double) GameView.screenH)) + ((double) this.y) >= ((double) (GameView.screenH * -13))) {
                this.y -= ((float) GameView.screenH) * Math.abs((this.acc * 2.0f) / 800.0f);
            }
        }
        if (start_down) {
            if (i_vel) {
                this.acc = (float) (((double) this.acc) + (((double) GameView.screenH) * 0.00125d));
            }
            if (d_vel) {
                this.acc = (float) (((double) this.acc) - (((double) GameView.screenH) * 0.00125d));
            }
            if (this.acc >= this.vel) {
                i_vel = false;
                d_vel = true;
            }
            if (this.acc <= 0.0f) {
                d_vel = false;
                start_down = false;
                this.acc = 0.0f;
            }
            if (((float) (GameView.screenH * 13)) + this.y <= ((float) (GameView.screenH * 13))) {
                this.y += ((float) GameView.screenH) * Math.abs((this.acc * 2.0f) / 800.0f);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        int i;
        int j;
        switch (event.getAction()) {
            case 0 /*0*/:
                this.cur_y = (int) event.getY();
                this.cur_x = (int) event.getX();
                this.date = new Date();
                this.acc = 0.0f;
                this.time_down = this.date.getTime();
                this.move = false;
                i = 0;
                while (i < 67) {
                    j = 0;
                    while (j < 3) {
                        if (((float) this.cur_x) > (((float) j) * F.wf(100.0f)) + F.wf(20.0f) && ((float) this.cur_x) < ((((float) j) * F.wf(100.0f)) + F.wf(20.0f)) + ((float) this.levelpagebutton.getWidth()) && ((float) this.cur_y) > (((float) i) * F.hf(100.0f)) + F.hf(40.0f) && ((float) this.cur_y) < ((((float) i) * F.hf(100.0f)) + F.hf(40.0f)) + ((float) this.levelpagebutton.getHeight()) && ((float) this.cur_y) > F.hf(40.0f) && ((float) this.cur_y) < ((float) GameView.screenH) - F.hf(40.0f)) {
                            this.t_i = i;
                            this.t_j = j;
                            this.btp = true;
                            GameView.baka = true;
                        }
                        j++;
                    }
                    i++;
                }
                break;
            case 1 /*1*/:
                this.lx = (float) ((int) event.getX());
                this.ly = (float) ((int) event.getY());
                this.btp = false;
                this.date = new Date();
                this.time_up = this.date.getTime();
                this.vel = 10.0f * Math.abs((this.ly - ((float) this.cur_y)) / ((float) (this.time_up - this.time_down)));
                if (((double) (this.ly - ((float) this.cur_y))) <= 0.00625d * ((double) GameView.screenH) && ((double) (this.ly - ((float) this.cur_y))) >= -0.00625d * ((double) GameView.screenH)) {
                    this.move = false;
                }
                if (((double) this.vel) >= 0.015625d * ((double) GameView.screenH)) {
                    this.move = true;
                    if (((double) (this.ly - ((float) this.cur_y))) < ((double) (-GameView.screenH)) * 0.03d) {
                        start_up = true;
                        i_vel = true;
                        start_down = false;
                    }
                    if (((double) (this.ly - ((float) this.cur_y))) > ((double) GameView.screenH) * 0.03d) {
                        start_down = true;
                        start_up = false;
                        i_vel = true;
                    }
                }
                int levelcount = 1;
                i = 0;
                while (i < 67) {
                    j = 0;
                    while (j < 3) {
                        if (this.lx <= (((float) j) * F.wf(100.0f)) + F.wf(20.0f) || this.lx >= ((((float) j) * F.wf(100.0f)) + F.wf(20.0f)) + ((float) this.levelpagebutton.getWidth()) || this.ly <= ((((float) i) * F.hf(100.0f)) + F.hf(40.0f)) + this.y || this.ly >= (((((float) i) * F.hf(100.0f)) + F.hf(40.0f)) + this.y) + ((float) this.levelpagebutton.getHeight()) || levelcount > levelLimit || this.move || this.ly <= F.hf(40.0f) || this.ly >= ((float) GameView.screenH) - F.hf(40.0f)) {
                            levelcount++;
                        } else {
                            GameView.levelcounter = levelcount;
                            reset1();
                            GameView.mainpage = 3;
                            levelcount = 0;
                            this.lcount = 0;
                            this.lx = 0.0f;
                            this.ly = 0.0f;
                        }
                        GameView.baka = true;
                        j++;
                    }
                    i++;
                }
                break;
            case 2 /*2*/:
                this.lx = (float) ((int) event.getX());
                this.ly = (float) ((int) event.getY());
                this.move = true;
                if (((double) (this.ly - ((float) this.cur_y))) < ((double) (-GameView.screenH)) * 0.03d && (0.25d * ((double) GameView.screenH)) + ((double) this.y) >= ((double) (GameView.screenH * -13))) {
                    this.y = (float) (((double) this.y) - (((double) GameView.screenH) * 0.009375d));
                }
                if (((double) (this.ly - ((float) this.cur_y))) > ((double) GameView.screenH) * 0.03d && ((float) (GameView.screenH * 13)) + this.y <= ((float) (GameView.screenH * 13))) {
                    this.y = (float) (((double) this.y) + (((double) GameView.screenH) * 0.009375d));
                }
                GameView.baka = true;
                break;
        }
        return true;
    }

    public void reset1() {
        int j;
        GameView.circleblink = false;
        GameView.reset();
        GameView.errorcircle = false;
        GameView.linecounter = GameView.NoOfInitialLines - 1;
        for (j = 0; j < GameView.NoOfInitialLines; j++) {
            GameView.blinedraw[j] = true;
        }
        for (j = 0; j < GameView.rotation.length; j++) {
            GameView.rotation[j] = 0.0f;
        }
        for (j = 0; j < GameView.NoOfInitialLines; j++) {
            GameView.rotation[j] = (float) ((j + 1) * (360 / GameView.NoOfInitialLines));
            if (GameView.rotation[j] > 360.0f) {
                GameView.rotation[j] = GameView.rotation[j] - 360.0f;
            }
        }
    }

}
