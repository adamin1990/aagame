package com.lt.adamlee.aagame;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v4.view.ViewCompat;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/**
 * Created by Administrator on 2015/7/29.
 */
public class Levelfailedanimation {

    static int angle1;
    static int angle2;
    static int angle3;
    static int angle4;
    static int angle5;
    static int angle6;
    static boolean[] animboolean;
    static Paint circlepaint;
    static float cx;
    static float cy;
    static int holdanim;
    static int holdlevelanim;
    static Paint linepaint;
    static Paint paint13;
    static Paint paint4;
    static Paint pp2;
    static float r;
    static float radious;
    static int shortradious;
    static boolean showtransparencyflag;
    static int tempy;
    static Paint textpaint;
    static int textsize;
    static int textsize1;
    static int textsize3;
    static int textsize4;
    static int textsize5;
    static int textsize6;
    static int textsize8;
    static float x1;
    static float y1;
    public Bitmap alertbox;
    private Paint levelfailpaint;
    private Paint paint;
    private Paint paint20;
    private Paint paint5;
    private Paint pp;
    private Paint pp1;
    private boolean radiousboolean;
    private Paint textpaint1;
    Typeface tf;
    private Paint transparentpaint;
    float x10;
    float x11;
    float x12;
    float x13;
    float x15;
    float x2;
    float x3;
    float x4;
    float x5;
    float x6;
    float x7;
    float x8;
    float x9;
    float y10;
    float y11;
    float y12;
    float y13;
    float y15;
    float y2;
    float y3;
    float y4;
    float y5;
    float y6;
    float y7;
    float y8;
    float y9;

    public Levelfailedanimation() {
        this.alertbox = BitmapFactory.decodeResource(GameView.ctx.getResources(), R.drawable.alertbox);
        this.alertbox = Bitmap.createScaledBitmap(this.alertbox, GameView.screenW, GameView.screenH, true);
        this.paint = new Paint();
        this.pp1 = new Paint();
        pp2 = new Paint();
        this.paint5 = new Paint();
        this.paint20 = new Paint();
        paint13 = new Paint();
        paint4 = new Paint();
        this.pp = new Paint();
        circlepaint = new Paint();
        linepaint = new Paint();
        textpaint = new Paint();
        this.levelfailpaint = new Paint();
        holdlevelanim = 0;
        holdanim = 0;
        textsize3 = 22;
        this.tf = Typeface.createFromAsset(GameView.ctx.getAssets(), "Russo_One.ttf");
        this.pp.setTextSize(F.hf((float) textsize3));
        this.levelfailpaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.tf = Typeface.createFromAsset(GameView.ctx.getAssets(), "Russo_One.ttf");
        textsize1 = 25;
        this.levelfailpaint.setTypeface(this.tf);
        this.levelfailpaint.setTextSize(F.hf((float) textsize1));
        textsize4 = 24;
        pp2.setTextSize(F.hf((float) textsize4));
        paint13.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint13.setAntiAlias(true);
        paint13.setFilterBitmap(true);
        textpaint.setTextAlign(Paint.Align.CENTER);
        textsize5 = 17;
        paint13.setTypeface(this.tf);
        paint13.setTextSize(F.hf((float) textsize5));
        circlepaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        circlepaint.setAntiAlias(true);
        circlepaint.setFilterBitmap(true);
        circlepaint.setStrokeWidth(2.0f);
        linepaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        linepaint.setAntiAlias(true);
        linepaint.setFilterBitmap(true);
        linepaint.setStrokeWidth(4.0f);
        textpaint.setColor(-1);
        textpaint.setAntiAlias(true);
        textpaint.setFilterBitmap(true);
        this.tf = Typeface.createFromAsset(GameView.ctx.getAssets(), "Russo_One.ttf");
        textsize6 = 20;
        textpaint.setTypeface(this.tf);
        textpaint.setTextAlign(Paint.Align.CENTER);
        textpaint.setTextSize(F.hf((float) textsize6));
        this.transparentpaint = new Paint();
        this.transparentpaint.setColor(-1);
        this.transparentpaint.setAlpha(0);
        this.textpaint1 = new Paint();
        this.textpaint1.setColor(-1);
        textsize8 = 33;
        this.textpaint1.setTextSize((float) textsize8);
        this.tf = Typeface.createFromAsset(GameView.ctx.getAssets(), "Russo_One.ttf");
        this.textpaint1.setTypeface(this.tf);
        this.textpaint1.setAntiAlias(true);
        this.textpaint1.setFilterBitmap(true);
        this.paint5.setAntiAlias(true);
        this.paint5.setFilterBitmap(true);
        paint4.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint4.setAntiAlias(true);
        paint4.setFilterBitmap(true);
        paint4.setStrokeWidth(4.0f);
        cx = (float) (GameView.screenW / 2);
        cy = F.hf(150.0f);
        radious = F.hf(100.0f);
        angle1 = 0;
        angle3 = 45;
        angle2 = -45;
        angle4 = 225;
        angle5 = 180;
        angle6 = 135;
        x1 = (float) (GameView.screenW / 2);
        y1 = F.hf(150.0f);
        r = F.wf(31.0f);
        animboolean = new boolean[13];
        for (int i = 0; i < animboolean.length; i++) {
            animboolean[i] = false;
        }
        showtransparencyflag = false;
        shortradious = (int) F.wf(10.0f);
    }

    void levelanim(Canvas c) {
        holdlevelanim++;
        if (holdlevelanim > 32000) {
            holdlevelanim = 0;
        }
        c.drawBitmap(Circle.mainpageimage1, 0.0f, 0.0f, null);
        if (showtransparencyflag) {
            Canvas canvas = c;
            canvas.drawLine(x1, y1, x1, radious + y1, circlepaint);
        }
        c.drawCircle(cx, cy, r, paint4);
        this.x3 = ((float) (((double) radious) * Math.cos((((double) angle1) * 3.141592653589793d) / 180.0d))) + cx;
        this.y3 = ((float) (((double) radious) * Math.sin((((double) angle1) * 3.141592653589793d) / 180.0d))) + cy;
        if (angle1 <= 88) {
            angle1 += 5;
        } else {
            animboolean[1] = true;
        }
        if (!animboolean[1]) {
            c.drawLine(x1, y1, this.x3, this.y3, linepaint);
            c.drawCircle(this.x3, this.y3, (float) shortradious, paint4);
        }
        this.x4 = ((float) (((double) radious) * Math.cos((((double) angle2) * 3.141592653589793d) / 180.0d))) + cx;
        this.y4 = ((float) (((double) radious) * Math.sin((((double) angle2) * 3.141592653589793d) / 180.0d))) + cy;
        if (angle2 <= 88) {
            angle2 += 5;
        } else {
            animboolean[2] = true;
        }
        if (!animboolean[2]) {
            c.drawLine(x1, y1, this.x4, this.y4, linepaint);
            c.drawCircle(this.x4, this.y4, (float) shortradious, paint4);
        }
        this.x5 = ((float) (((double) radious) * Math.cos((((double) angle3) * 3.141592653589793d) / 180.0d))) + cx;
        this.y5 = ((float) (((double) radious) * Math.sin((((double) angle3) * 3.141592653589793d) / 180.0d))) + cy;
        if (angle3 <= 88) {
            angle3 += 5;
        } else {
            animboolean[3] = true;
        }
        if (!animboolean[3]) {
            c.drawLine(x1, y1, this.x5, this.y5, linepaint);
            c.drawCircle(this.x5, this.y5, (float) shortradious, paint4);
        }
        this.x6 = ((float) (((double) radious) * Math.cos((((double) angle4) * 3.141592653589793d) / 180.0d))) + cx;
        this.y6 = ((float) (((double) radious) * Math.sin((((double) angle4) * 3.141592653589793d) / 180.0d))) + cy;
        if (angle4 >= 88) {
            angle4 -= 5;
        } else {
            animboolean[4] = true;
            showtransparencyflag = true;
        }
        if (!animboolean[4]) {
            c.drawLine(x1, y1, this.x6, this.y6, linepaint);
            c.drawCircle(this.x6, this.y6, (float) shortradious, paint4);
        }
        this.x7 = ((float) (((double) radious) * Math.cos((((double) angle5) * 3.141592653589793d) / 180.0d))) + cx;
        this.y7 = ((float) (((double) radious) * Math.sin((((double) angle5) * 3.141592653589793d) / 180.0d))) + cy;
        if (angle5 >= 88) {
            angle5 -= 5;
        } else {
            animboolean[5] = true;
        }
        if (!animboolean[5]) {
            c.drawLine(x1, y1, this.x7, this.y7, linepaint);
            c.drawCircle(this.x7, this.y7, (float) shortradious, paint4);
        }
        this.x8 = ((float) (((double) radious) * Math.cos((((double) angle6) * 3.141592653589793d) / 180.0d))) + cx;
        this.y8 = ((float) (((double) radious) * Math.sin((((double) angle6) * 3.141592653589793d) / 180.0d))) + cy;
        if (angle6 >= 88) {
            angle6 -= 5;
        } else {
            animboolean[6] = true;
        }
        if (!animboolean[6]) {
            c.drawLine(x1, y1, this.x8, this.y8, linepaint);
            c.drawCircle(this.x8, this.y8, (float) shortradious, paint4);
        }
        c.drawText(String.valueOf(GameView.levelcounter), F.wf(160.0f), F.hf(156.0f), textpaint);
        if (showtransparencyflag) {
            if (holdlevelanim % 5 == 0) {
                holdanim++;
            }
            if (radious >= 0.0f) {
                radious -= 15.0f;
            }
            if (r > 0.0f) {
                r -= 3.0f;
            }
            if (textpaint.getTextSize() > 0.0f) {
                textpaint.setTextSize(textpaint.getTextSize() - 3.0f);
            }
            if (shortradious > 0) {
                shortradious = (int) (((float) shortradious) - 1.0E-5f);
            }
            if (circlepaint.getStrokeWidth() > 0.0f) {
                circlepaint.setStrokeWidth(circlepaint.getStrokeWidth() - 8.0f);
            }
            if (holdanim >= 5) {
                c.drawBitmap(this.alertbox, 0.0f, 0.0f, null);
                c.drawRect(F.wf(85.0f), F.hf(290.0f), F.wf(235.0f), F.hf(310.0f), this.transparentpaint);
                c.drawText(GameView.levelcounter+"", F.wf(154.0f), F.hf(242.0f), paint13);
                c.drawRect(F.wf(140.0f), F.hf(BitmapDescriptorFactory.HUE_AZURE), F.wf(190.0f), F.hf(260.0f), this.transparentpaint);
            }
        }
    }

}
