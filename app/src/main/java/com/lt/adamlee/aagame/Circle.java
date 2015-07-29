package com.lt.adamlee.aagame;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.ViewCompat;

import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.location.LocationRequest;

/**
 * Created by Administrator on 2015/7/29.
 */
public class Circle {
    static int a;
    static boolean bak1;
    static boolean blink;
    static boolean blinkcolor;
    static int counter;
    static int counter1;
    static int displaycount;
    static int h;
    static int increaserect;
    static int internalcounter1;
    public static Bitmap mainpageimage1;
    static int moveline;
    static int p;
    static Paint paint20;
    static Paint paint9;
    static float radious;
    static boolean rotate;
    static int textsize;
    static int textsize1;
    static int textsize2;
    static int textsize3;
    static int value;
    static int var;
    static int var1;
    static int var2;
    static int var3;
    static int var4;
    static int w;
    static float x;
    static int y;
    public Bitmap background;
    private Paint jumpcircle;
    private int m;
    private int n;
    Paint paint;
    Paint paint1;
    private Paint paint13;
    Paint paint2;
    Paint paint5;
    Paint paint8;
    private Paint ppp;
    private int q;
    Typeface tf;

    Circle() {
        mainpageimage1 = BitmapFactory.decodeResource(GameView.ctx.getResources(), R.drawable.mainpageimage1);
        mainpageimage1 = Bitmap.createScaledBitmap(mainpageimage1, GameView.screenW, GameView.screenH, true);
        this.paint = new Paint();
        this.paint1 = new Paint();
        this.paint2 = new Paint();
        paint20 = new Paint();
        this.paint5 = new Paint();
        this.paint8 = new Paint();
        paint9 = new Paint();
        this.paint13 = new Paint();
        this.paint5.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.paint5.setAntiAlias(true);
        this.paint5.setFilterBitmap(true);
        this.paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.paint.setAntiAlias(true);
        this.paint.setFilterBitmap(true);
        this.paint1.setColor(-1);
        textsize3 = 10;
        this.paint1.setTextSize(F.hf((float) textsize3));
        this.paint1.setTypeface(this.tf);
        this.paint1.setTextAlign(Paint.Align.CENTER);
        this.paint1.setAntiAlias(true);
        this.paint1.setFilterBitmap(true);
        this.jumpcircle = new Paint();
        textsize = 18;
        textsize1 = 15;
        this.tf = Typeface.createFromAsset(GameView.ctx.getAssets(), "Russo_One.ttf");
        paint20.setTextSize(F.hf((float) textsize));
        this.tf = Typeface.createFromAsset(GameView.ctx.getAssets(), "Russo_One.ttf");
        var = 6;
        a = 1200;
        var1 = 6;
        var2 = 1;
        var3 = 2;
        var4 = 6;
        textsize2 = 21;
        this.tf = Typeface.createFromAsset(GameView.ctx.getAssets(), "Russo_One.ttf");
        this.paint13.setTextSize(F.hf((float) textsize2));
    }

    void drawRectangle(Canvas c) {
        increaserect = var3;
        counter = var4;
        x = (float) ((int) F.wf(160.0f));
        y = (int) F.hf(100.0f);
        radious = (float) ((int) F.wf(10.0f));
        w = (int) F.wf(160.0f);
        h = (int) F.hf(103.0f);
        if (bak1) {
            internalcounter1++;
            if (internalcounter1 % 10 == 0) {
                counter1++;
            }
            if (counter1 >= 2) {
                counter1 = 0;
                internalcounter1 = 0;
                bak1 = false;
            }
        }
        if (GameView.levelcounter > 0 && GameView.levelcounter < 4) {
            counter = var4;
            var = var4;
            GameView.NoOfInitialLines = 6;
        }
        if (GameView.levelcounter > 3 && GameView.levelcounter < 7) {
            counter = var4 + 10;
            var = var4 + 10;
            GameView.NoOfInitialLines = 8;
        }
        if (GameView.levelcounter > 6 && GameView.levelcounter < 10) {
            counter = var4 + 15;
            var = var4 + 15;
            GameView.NoOfInitialLines = 2;
        }
        if (GameView.levelcounter > 9 && GameView.levelcounter < 13) {
            counter = var4 + 8;
            var = var4 + 8;
            GameView.NoOfInitialLines = 4;
        }
        if (GameView.levelcounter > 12 && GameView.levelcounter < 16) {
            counter = var4 + 12;
            var = var4 + 12;
            GameView.NoOfInitialLines = 6;
        }
        if (GameView.levelcounter > 15 && GameView.levelcounter < 19) {
            counter = var4 + 16;
            var = var4 + 16;
            GameView.NoOfInitialLines = 3;
        }
        if (GameView.levelcounter > 18 && GameView.levelcounter < 22) {
            counter = var4 + 14;
            var = var4 + 14;
            GameView.NoOfInitialLines = 5;
        }
        if (GameView.levelcounter > 21 && GameView.levelcounter < 25) {
            counter = var4 + 10;
            var = var4 + 10;
            GameView.NoOfInitialLines = 8;
        }
        if (GameView.levelcounter > 24 && GameView.levelcounter < 28) {
            counter = var4 + 8;
            var = var4 + 8;
            GameView.NoOfInitialLines = 4;
        }
        if (GameView.levelcounter > 27 && GameView.levelcounter < 31) {
            counter = var4 + 9;
            var = var4 + 9;
            GameView.NoOfInitialLines = 2;
        }
        if (GameView.levelcounter > 30 && GameView.levelcounter < 34) {
            counter = var4 + 13;
            var = var4 + 13;
            GameView.NoOfInitialLines = 1;
        }
        if (GameView.levelcounter > 33 && GameView.levelcounter < 37) {
            counter = var4 + 8;
            var = var4 + 8;
            GameView.NoOfInitialLines = 8;
        }
        if (GameView.levelcounter > 36 && GameView.levelcounter < 40) {
            counter = var4 + 15;
            var = var4 + 15;
            GameView.NoOfInitialLines = 2;
        }
        if (GameView.levelcounter > 39 && GameView.levelcounter < 43) {
            counter = var4 + 7;
            var = var4 + 7;
            GameView.NoOfInitialLines = 4;
        }
        if (GameView.levelcounter > 42 && GameView.levelcounter < 46) {
            counter = var4 + 12;
            var = var4 + 12;
            GameView.NoOfInitialLines = 6;
        }
        if (GameView.levelcounter > 45 && GameView.levelcounter < 49) {
            counter = var4 + 16;
            var = var4 + 16;
            GameView.NoOfInitialLines = 3;
        }
        if (GameView.levelcounter > 48 && GameView.levelcounter < 52) {
            counter = var4 + 14;
            var = var4 + 14;
            GameView.NoOfInitialLines = 5;
        }
        if (GameView.levelcounter > 51 && GameView.levelcounter < 55) {
            counter = var4 + 12;
            var = var4 + 12;
            GameView.NoOfInitialLines = 7;
        }
        if (GameView.levelcounter > 54 && GameView.levelcounter < 58) {
            counter = var4 + 10;
            var = var4 + 10;
            GameView.NoOfInitialLines = 8;
        }
        if (GameView.levelcounter > 57 && GameView.levelcounter < 61) {
            counter = var4 + 9;
            var = var4 + 9;
            GameView.NoOfInitialLines = 2;
        }
        if (GameView.levelcounter > 606 && GameView.levelcounter < 64) {
            counter = var4 + 11;
            var = var4 + 11;
            GameView.NoOfInitialLines = 4;
        }
        if (GameView.levelcounter > 63 && GameView.levelcounter < 67) {
            counter = var4 + 16;
            var = var4 + 16;
            GameView.NoOfInitialLines = 3;
        }
        if (GameView.levelcounter > 66 && GameView.levelcounter < 70) {
            counter = var4 + 13;
            var = var4 + 13;
            GameView.NoOfInitialLines = 5;
        }
        if (GameView.levelcounter > 69 && GameView.levelcounter < 73) {
            counter = var4 + 14;
            var = var4 + 14;
            GameView.NoOfInitialLines = 5;
        }
        if (GameView.levelcounter > 72 && GameView.levelcounter < 76) {
            counter = var4 + 4;
            var = var4 + 4;
            GameView.NoOfInitialLines = 9;
        }
        if (GameView.levelcounter > 75 && GameView.levelcounter < 79) {
            counter = var4 + 13;
            var = var4 + 13;
            GameView.NoOfInitialLines = 5;
        }
        if (GameView.levelcounter > 78 && GameView.levelcounter < 82) {
            counter = var4 + 13;
            var = var4 + 13;
            GameView.NoOfInitialLines = 5;
        }
        if (GameView.levelcounter > 81 && GameView.levelcounter < 85) {
            counter = var4 + 10;
            var = var4 + 10;
            GameView.NoOfInitialLines = 5;
        }
        if (GameView.levelcounter > 84 && GameView.levelcounter < 88) {
            counter = var4 + 10;
            var = var4 + 10;
            GameView.NoOfInitialLines = 5;
        }
        if (GameView.levelcounter > 87 && GameView.levelcounter < 91) {
            counter = var4 + 11;
            var = var4 + 11;
            GameView.NoOfInitialLines = 5;
        }
        if (GameView.levelcounter > 90 && GameView.levelcounter < 94) {
            counter = var4 + 13;
            var = var4 + 13;
            GameView.NoOfInitialLines = 5;
        }
        if (GameView.levelcounter > 93 && GameView.levelcounter < 97) {
            counter = var4 + 10;
            var = var4 + 10;
            GameView.NoOfInitialLines = 5;
        }
        if (GameView.levelcounter > 96 && GameView.levelcounter < Quests.SELECT_COMPLETED_UNCLAIMED) {
            counter = var4 + 10;
            var = var4 + 10;
            GameView.NoOfInitialLines = 5;
        }
        if (GameView.levelcounter > 100 && GameView.levelcounter < LocationRequest.PRIORITY_NO_POWER) {
            textsize = 23;
            this.paint5.setTextSize(F.hf((float) textsize));
            counter = var4 + 10;
            var = var4 + 10;
            GameView.NoOfInitialLines = 8;
        }
        if (GameView.levelcounter > LocationRequest.PRIORITY_LOW_POWER && GameView.levelcounter < 108) {
            textsize = 23;
            this.paint5.setTextSize(F.hf((float) textsize));
            counter = var4 + 22;
            var = var4 + 22;
            GameView.NoOfInitialLines = 3;
        }
        if (GameView.levelcounter > 107 && GameView.levelcounter < 111) {
            textsize = 23;
            this.paint5.setTextSize(F.hf((float) textsize));
            counter = var4 + 18;
            var = var4 + 18;
            GameView.NoOfInitialLines = 5;
        }
        if (GameView.levelcounter > 110 && GameView.levelcounter < 114) {
            textsize = 23;
            this.paint5.setTextSize(F.hf((float) textsize));
            counter = var4 + 20;
            var = var4 + 20;
            GameView.NoOfInitialLines = 4;
        }
        if (GameView.levelcounter > 113 && GameView.levelcounter < 117) {
            textsize = 23;
            this.paint5.setTextSize(F.hf((float) textsize));
            counter = var4 + 16;
            var = var4 + 16;
            GameView.NoOfInitialLines = 6;
        }
        if (GameView.levelcounter > 116 && GameView.levelcounter < 121) {
            textsize = 23;
            this.paint5.setTextSize(F.hf((float) textsize));
            counter = var4 + 22;
            var = var4 + 22;
            GameView.NoOfInitialLines = 3;
        }
        if (GameView.levelcounter > 120 && GameView.levelcounter < MetadataChangeSet.CUSTOM_PROPERTY_SIZE_LIMIT_BYTES) {
            textsize = 23;
            this.paint5.setTextSize(F.hf((float) textsize));
            counter = var4 + 12;
            var = var4 + 12;
            GameView.NoOfInitialLines = 8;
        }
        if (GameView.levelcounter > 123 && GameView.levelcounter < TransportMediator.KEYCODE_MEDIA_PAUSE) {
            textsize = 23;
            this.paint5.setTextSize(F.hf((float) textsize));
            counter = var4 + 22;
            var = var4 + 22;
            GameView.NoOfInitialLines = 2;
        }
        if (GameView.levelcounter > TransportMediator.KEYCODE_MEDIA_PLAY && GameView.levelcounter < 131) {
            textsize = 23;
            this.paint5.setTextSize(F.hf((float) textsize));
            counter = var4 + 20;
            var = var4 + 20;
            GameView.NoOfInitialLines = 4;
        }
        if (GameView.levelcounter > TransportMediator.KEYCODE_MEDIA_RECORD && GameView.levelcounter < 134) {
            textsize = 23;
            this.paint5.setTextSize(F.hf((float) textsize));
            counter = var4 + 19;
            var = var4 + 19;
            GameView.NoOfInitialLines = 6;
        }
        if (GameView.levelcounter > 133 && GameView.levelcounter < 137) {
            textsize = 23;
            this.paint5.setTextSize(F.hf((float) textsize));
            counter = var4 + 22;
            var = var4 + 22;
            GameView.NoOfInitialLines = 3;
        }
        if (GameView.levelcounter > 136 && GameView.levelcounter < 140) {
            textsize = 23;
            this.paint5.setTextSize(F.hf((float) textsize));
            counter = var4 + 10;
            var = var4 + 10;
            GameView.NoOfInitialLines = 8;
        }
        if (GameView.levelcounter > 139 && GameView.levelcounter < 144) {
            textsize = 23;
            this.paint5.setTextSize(F.hf((float) textsize));
            counter = var4 + 18;
            var = var4 + 18;
            GameView.NoOfInitialLines = 5;
        }
        if (GameView.levelcounter > 143 && GameView.levelcounter < 146) {
            textsize = 23;
            this.paint5.setTextSize(F.hf((float) textsize));
            counter = var4 + 20;
            var = var4 + 20;
            GameView.NoOfInitialLines = 4;
        }
        if (GameView.levelcounter > 146 && GameView.levelcounter < 151) {
            textsize = 23;
            this.paint5.setTextSize(F.hf((float) textsize));
            counter = var4 + 22;
            var = var4 + 22;
            GameView.NoOfInitialLines = 2;
        }
        if (GameView.levelcounter > 150 && GameView.levelcounter < 155) {
            textsize = 23;
            this.paint5.setTextSize(F.hf((float) textsize));
            counter = var4 + 13;
            var = var4 + 13;
            GameView.NoOfInitialLines = 8;
        }
        if (GameView.levelcounter > 154 && GameView.levelcounter < 158) {
            textsize = 23;
            this.paint5.setTextSize(F.hf((float) textsize));
            counter = var4 + 22;
            var = var4 + 22;
            GameView.NoOfInitialLines = 3;
        }
        if (GameView.levelcounter > 157 && GameView.levelcounter < 161) {
            textsize = 23;
            this.paint5.setTextSize(F.hf((float) textsize));
            counter = var4 + 19;
            var = var4 + 19;
            GameView.NoOfInitialLines = 6;
        }
        if (GameView.levelcounter > 160 && GameView.levelcounter < 164) {
            textsize = 23;
            this.paint5.setTextSize(F.hf((float) textsize));
            counter = var4 + 18;
            var = var4 + 18;
            GameView.NoOfInitialLines = 5;
        }
        if (GameView.levelcounter > 163 && GameView.levelcounter < 167) {
            textsize = 23;
            this.paint5.setTextSize(F.hf((float) textsize));
            counter = var4 + 22;
            var = var4 + 22;
            GameView.NoOfInitialLines = 2;
        }
        if (GameView.levelcounter > 166 && GameView.levelcounter < 171) {
            textsize = 23;
            this.paint5.setTextSize(F.hf((float) textsize));
            counter = var4 + 13;
            var = var4 + 13;
            GameView.NoOfInitialLines = 8;
        }
        if (GameView.levelcounter > 170 && GameView.levelcounter < 174) {
            textsize = 23;
            this.paint5.setTextSize(F.hf((float) textsize));
            counter = var4 + 22;
            var = var4 + 22;
            GameView.NoOfInitialLines = 3;
        }
        if (GameView.levelcounter > 173 && GameView.levelcounter < 177) {
            textsize = 23;
            this.paint5.setTextSize(F.hf((float) textsize));
            counter = var4 + 18;
            var = var4 + 18;
            GameView.NoOfInitialLines = 5;
        }
        if (GameView.levelcounter > 176 && GameView.levelcounter < 180) {
            textsize = 23;
            this.paint5.setTextSize(F.hf((float) textsize));
            counter = var4 + 20;
            var = var4 + 20;
            GameView.NoOfInitialLines = 4;
        }
        if (GameView.levelcounter > 179 && GameView.levelcounter < 184) {
            textsize = 23;
            this.paint5.setTextSize(F.hf((float) textsize));
            counter = var4 + 22;
            var = var4 + 22;
            GameView.NoOfInitialLines = 2;
        }
        if (GameView.levelcounter > 183 && GameView.levelcounter < 187) {
            textsize = 23;
            this.paint5.setTextSize(F.hf((float) textsize));
            counter = var4 + 19;
            var = var4 + 19;
            GameView.NoOfInitialLines = 6;
        }
        if (GameView.levelcounter > 186 && GameView.levelcounter < 191) {
            textsize = 23;
            this.paint5.setTextSize(F.hf((float) textsize));
            counter = var4 + 13;
            var = var4 + 13;
            GameView.NoOfInitialLines = 8;
        }
        if (GameView.levelcounter > 190 && GameView.levelcounter < 194) {
            textsize = 23;
            this.paint5.setTextSize(F.hf((float) textsize));
            counter = var4 + 22;
            var = var4 + 22;
            GameView.NoOfInitialLines = 3;
        }
        if (GameView.levelcounter > 193 && GameView.levelcounter < 197) {
            textsize = 23;
            this.paint5.setTextSize(F.hf((float) textsize));
            counter = var4 + 19;
            var = var4 + 19;
            GameView.NoOfInitialLines = 6;
        }
        if (GameView.levelcounter > 196 && GameView.levelcounter < 202) {
            textsize = 23;
            this.paint5.setTextSize(F.hf((float) textsize));
            counter = var4 + 5;
            var = var4 + 5;
            GameView.NoOfInitialLines = 8;
        }
        c.drawBitmap(mainpageimage1, 0.0f, 0.0f, null);
        this.paint2.setStyle(Paint.Style.STROKE);
        this.paint2.setAntiAlias(true);
        this.paint2.setStrokeWidth(2.0f);
        this.paint2.setColor(-1);
        this.paint2.setAlpha(70);
        this.paint2.setPathEffect(new DashPathEffect(new float[]{19.0f, 2.0f}, 0.0f));
        c.drawCircle(F.wf(160.0f), F.hf(272.0f), F.hf(104.0f) + ((float) (GameView.r * 2)), this.paint2);
        c.drawCircle((float) (GameView.screenW / 2), F.hf(272.0f), F.wf(39.0f), this.paint5);
        this.paint13.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.paint13.setTypeface(this.tf);
        this.paint13.setAntiAlias(true);
        this.paint13.setFilterBitmap(true);
        c.drawText(GameView.ctx.getString(R.string.level), F.wf(10.0f), F.hf(20.0f), this.paint13);
        this.paint13.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.paint13.setTypeface(this.tf);
        this.paint13.setAntiAlias(true);
        this.paint13.setFilterBitmap(true);
        c.drawText(GameView.levelcounter+"", F.wf(80.0f), F.hf(20.0f), this.paint13);
        if (blink) {
            paint20.setColor(SupportMenu.CATEGORY_MASK);
            paint20.setTypeface(this.tf);
            paint20.setAlpha(a);
            paint20.setTextAlign(Paint.Align.CENTER);
            c.drawText(String.valueOf(GameView.levelcounter), F.wf(160.0f), F.hf(278.0f), paint20);
            displaycount++;
            if (displaycount > 50) {
                a += 80;
            } else {
                a -= 80;
            }
        }
        for (int i = 0; i <= increaserect; i++) {
            if (counter > 0 && value > (-var)) {
                c.drawCircle(x, (float) y, radious, this.paint);
                y = (int) (((float) y) - F.hf(41.0f));
                if (i == 0) {
                    counter += value;
                }
                c.drawText(String.valueOf(counter), (float) w, (float) h, this.paint1);
                counter--;
                h = (int) (((float) h) - F.hf(41.0f));
            }
        }
    }

}
