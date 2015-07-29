package com.lt.adamlee.aagame;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

//import com.google.android.gms.drive.MetadataChangeSet;
//import com.google.android.gms.games.quest.Quests;
//import com.google.android.gms.location.LocationRequest;
//import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/**
 * Created by Administrator on 2015/7/29.
 */
public class GameView extends SurfaceView implements SurfaceHolder.Callback{


    static int NoOfInitialLines;
    static int a1;
    static int a2;
    static boolean bak2;
    static boolean bak4;
    static boolean baka;
    public static boolean[] blinedraw;
    public static boolean[] blinedraw1;
    static boolean blink1;
    static double changeangle;
    public static boolean[] circleanimation;
    static boolean circleblink;
    public static boolean[] circledrawboolean;
    static boolean colcircle;
    static boolean colorcircle;
    static int counter;
    static int counter1234;
    public static Context ctx;
    static long delaycounter;
    static int displaycount1;
    static boolean drawrect;
    static boolean errorcircle;
    static int h;
    static int hcm;
    static int holdcounter;
    static int internalcounter2;
    static int j;
    static int k;
    static int levelcounter;
    static boolean levelfailed;
    static int linecounter;
    public static int mainpage;
    static Paint paint13;
    static Paint paint2;
    static Paint paint3;
    static Paint paint4;
    static Paint paint5;
    static Paint paint6;
    static Paint paint7;
    static int r;
    public static float[] rotation;
    private static int saveline;
    public static int[] savex;
    public static int[] savey;
    public static int screenH;
    public static int screenW;
    static boolean textdisplayboolean;
    static int textsize;
    static int textsize4;
    static Typeface tf;
    static Circle view;
    static int x;
    static int y;
    public Bitmap about;
    public Bitmap ad;
    private int addx;
    private int addy;
    Levelfailedanimation anim;
    private int animx;
    private int animy;
    private boolean bak8;
    private boolean bakc;
    public Bitmap cartoonbomb;
    private int choosex;
    private int choosey;
    private int counter12346;
    private int counter8;
    private int countera;
    private int counterc;
    private int directioncounter;
    private int displaycount3;
    private int downx;
    private int downy;
    ExitGame eg;
    public Bitmap help;
    private Paint innercircletext;
    private int internalcounter4;
    private int internalcounter8;
    private int internalcountera;
    private int internalcounterc;
    private int jj;
    public Bitmap leaderboard;
    private int leaderx;
    private int leadery;
    private boolean leftrotation;
    LevelPage level;
    public Bitmap localAd;
    GameView logic;
    private int m;
    public Bitmap mainpageimage;
    public Bitmap moreapps;
    private int n;
    private Paint p9;
    private Paint paint10;
    private Paint paint20;
    private Paint paint21;
    public Bitmap play;
    private Paint pp;
    private Paint ppp;
    private Object pppp;
    private int q;
    private Object qq;
    public Bitmap rect;
    private Object rr;
    private RectF ss;
    private int textsize3;
    private float textsizetext;
    private GameThread thread;
    private boolean touch;
    private int touchx;
    private int touchy;
    private int viewx;
    private int viewy;

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        ctx = context;
        getHolder().addCallback(this);
        setFocusable(true);
        DisplayMetrics DisplayMetrics = new DisplayMetrics();
        DisplayMetrics = context.getResources().getDisplayMetrics();
        screenW = DisplayMetrics.widthPixels;
        screenH = DisplayMetrics.heightPixels;
        this.mainpageimage = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.mainpageimage);
        this.mainpageimage = Bitmap.createScaledBitmap(this.mainpageimage, screenW, screenH, true);
        this.play = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.play);
        this.play = Bitmap.createScaledBitmap(this.play, (int) F.wf(90.0f), (int) F.wf(90.0f), true);
        this.cartoonbomb = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.cartoonbomb);
        this.cartoonbomb = Bitmap.createScaledBitmap(this.cartoonbomb, (int) F.hf(20.0f), (int) F.hf(20.0f), true);
        this.leaderboard = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.leaderboard);
        this.leaderboard = Bitmap.createScaledBitmap(this.leaderboard, (int) F.wf(70.0f), (int) F.wf(70.0f), true);
        this.moreapps = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.moreapps);
        this.moreapps = Bitmap.createScaledBitmap(this.moreapps, (int) F.wf(70.0f), (int) F.wf(70.0f), true);
        this.help = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.help);
        this.help = Bitmap.createScaledBitmap(this.help, (int) F.wf(70.0f), (int) F.wf(70.0f), true);
        this.about = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.about);
        this.about = Bitmap.createScaledBitmap(this.about, (int) F.wf(70.0f), (int) F.wf(70.0f), true);
        this.localAd = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.addimagebottom);
        view = new Circle();
        paint2 = new Paint();
        paint3 = new Paint();
        paint4 = new Paint();
        paint5 = new Paint();
        paint6 = new Paint();
        paint7 = new Paint();
        paint13 = new Paint();
        this.paint10 = new Paint();
        this.level = new LevelPage();
        circledrawboolean = new boolean[100];
        this.innercircletext = new Paint();
        this.innercircletext.setColor(-1);
        this.textsizetext = 10.0f;
        this.innercircletext.setTextSize(F.hf(this.textsizetext));
        this.innercircletext.setTypeface(tf);
        this.innercircletext.setTextAlign(Paint.Align.CENTER);
        this.innercircletext.setAntiAlias(true);
        this.innercircletext.setFilterBitmap(true);
        this.p9 = new Paint();
        this.paint20 = new Paint();
        this.paint21 = new Paint();
        this.pp = new Paint();
        this.eg = new ExitGame();
        paint4.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint4.setAntiAlias(true);
        paint4.setFilterBitmap(true);
        paint4.setPathEffect(new DashPathEffect(new float[]{30.0f, 0.0f}, 0.0f));
        paint4.setStrokeWidth(2.0f);
        paint4.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint3.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint3.setAntiAlias(true);
        paint3.setFilterBitmap(true);
        counter = 0;
        linecounter = -1;
        blinedraw = new boolean[100];
        blinedraw1 = new boolean[100];
        circleanimation = new boolean[100];
        savex = new int[100];
        savey = new int[100];
        rotation = new float[100];
        textsize = 20;
        a2 = 1200;
        tf = Typeface.createFromAsset(ctx.getAssets(), "Russo_One.ttf");
        textsize4 = 20;
        this.paint21.setTextSize(F.hf((float) textsize4));
        paint2.setTextSize(F.hf((float) textsize));
        textsize = 25;
        tf = Typeface.createFromAsset(ctx.getAssets(), "Russo_One.ttf");
        paint6.setTextSize(F.hf((float) textsize));
        this.textsize3 = 22;
        tf = Typeface.createFromAsset(ctx.getAssets(), "Russo_One.ttf");
        this.pp.setTextSize(F.hf((float) this.textsize3));
        a1 = MotionEventCompat.ACTION_MASK;
        changeangle = 2.0d;
        this.directioncounter = 1;
        NoOfInitialLines = 6;
        holdcounter = 0;
        hcm = 0;
        this.anim = new Levelfailedanimation();
        levelcounter = 1;
        textdisplayboolean = true;
        if (levelcounter > 0 && levelcounter < 4) {
            NoOfInitialLines = 6;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 3 && levelcounter < 7) {
            NoOfInitialLines = 8;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 6 && levelcounter < 10) {
            NoOfInitialLines = 2;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 9 && levelcounter < 13) {
            NoOfInitialLines = 4;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 12 && levelcounter < 16) {
            NoOfInitialLines = 6;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 15 && levelcounter < 19) {
            NoOfInitialLines = 3;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 18 && levelcounter < 22) {
            NoOfInitialLines = 5;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 21 && levelcounter < 25) {
            NoOfInitialLines = 8;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 24 && levelcounter < 28) {
            NoOfInitialLines = 4;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 27 && levelcounter < 31) {
            NoOfInitialLines = 2;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 30 && levelcounter < 34) {
            NoOfInitialLines = 1;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 33 && levelcounter < 37) {
            NoOfInitialLines = 8;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 36 && levelcounter < 40) {
            NoOfInitialLines = 2;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 39 && levelcounter < 43) {
            NoOfInitialLines = 4;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 42 && levelcounter < 46) {
            NoOfInitialLines = 6;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 45 && levelcounter < 49) {
            NoOfInitialLines = 3;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 48 && levelcounter < 52) {
            NoOfInitialLines = 5;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 51 && levelcounter < 55) {
            NoOfInitialLines = 7;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 54 && levelcounter < 58) {
            NoOfInitialLines = 8;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 57 && levelcounter < 61) {
            NoOfInitialLines = 2;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 606 && levelcounter < 64) {
            NoOfInitialLines = 4;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 63 && levelcounter < 67) {
            NoOfInitialLines = 3;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 66 && levelcounter < 70) {
            NoOfInitialLines = 5;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 69 && levelcounter < 73) {
            NoOfInitialLines = 5;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 72 && levelcounter < 76) {
            NoOfInitialLines = 9;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 75 && levelcounter < 79) {
            NoOfInitialLines = 5;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 78 && levelcounter < 82) {
            NoOfInitialLines = 5;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 81 && levelcounter < 85) {
            NoOfInitialLines = 5;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 84 && levelcounter < 88) {
            NoOfInitialLines = 5;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 87 && levelcounter < 91) {
            NoOfInitialLines = 5;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 90 && levelcounter < 94) {
            NoOfInitialLines = 5;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 93 && levelcounter < 97) {
            NoOfInitialLines = 5;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 96 && levelcounter < 101) {
            NoOfInitialLines = 5;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 100 && levelcounter < 105) {
            NoOfInitialLines = 8;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 104 && levelcounter < 108) {
            NoOfInitialLines = 3;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 107 && levelcounter < 111) {
            NoOfInitialLines = 5;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 110 && levelcounter < 114) {
            NoOfInitialLines = 4;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 113 && levelcounter < 117) {
            NoOfInitialLines = 3;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 116 && levelcounter < 121) {
            NoOfInitialLines = 4;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 120 && levelcounter < 124) {
            NoOfInitialLines = 8;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 123 && levelcounter < TransportMediator.KEYCODE_MEDIA_PAUSE) {
            NoOfInitialLines = 2;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > TransportMediator.KEYCODE_MEDIA_PLAY && levelcounter < 131) {
            NoOfInitialLines = 4;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > TransportMediator.KEYCODE_MEDIA_RECORD && levelcounter < 134) {
            NoOfInitialLines = 6;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 133 && levelcounter < 137) {
            NoOfInitialLines = 3;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 136 && levelcounter < 140) {
            NoOfInitialLines = 8;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 139 && levelcounter < 144) {
            NoOfInitialLines = 5;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 143 && levelcounter < 146) {
            NoOfInitialLines = 4;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 146 && levelcounter < 151) {
            NoOfInitialLines = 2;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 150 && levelcounter < 155) {
            NoOfInitialLines = 8;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 154 && levelcounter < 158) {
            NoOfInitialLines = 3;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 157 && levelcounter < 161) {
            NoOfInitialLines = 6;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 160 && levelcounter < 164) {
            NoOfInitialLines = 5;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 163 && levelcounter < 167) {
            NoOfInitialLines = 2;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 166 && levelcounter < 171) {
            NoOfInitialLines = 8;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 170 && levelcounter < 174) {
            NoOfInitialLines = 3;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 173 && levelcounter < 177) {
            NoOfInitialLines = 5;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 176 && levelcounter < 180) {
            NoOfInitialLines = 4;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 179 && levelcounter < 184) {
            NoOfInitialLines = 2;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 183 && levelcounter < 187) {
            NoOfInitialLines = 6;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 186 && levelcounter < 191) {
            NoOfInitialLines = 8;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 190 && levelcounter < 194) {
            NoOfInitialLines = 3;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 193 && levelcounter < 197) {
            NoOfInitialLines = 6;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 196 && levelcounter < 202) {
            NoOfInitialLines = 8;
            saveline = NoOfInitialLines;
        }
    }

    public void onDraw(Canvas c) {
        try {
            if (mainpage == -1) {
                this.eg.exitdialog(c);
            }
            if (mainpage == 1) {
                if (bak2) {
                    internalcounter2++;
                    if (internalcounter2 % 10 == 0) {
                        counter1234++;
                    }
                    if (counter1234 >= 2) {
                        counter1234 = 0;
                        internalcounter2 = 0;
                        bak2 = false;
                    }
                }
                if (bak4) {
                    this.internalcounter4++;
                    if (this.internalcounter4 % 10 == 0) {
                        this.counter12346++;
                    }
                    if (this.counter12346 >= 2) {
                        this.counter12346 = 0;
                        this.internalcounter4 = 0;
                        bak4 = false;
                    }
                }
                c.drawBitmap(this.mainpageimage, 0.0f, 0.0f, null);
                c.drawBitmap(this.play, F.wf(110.0f), F.hf(175.0f), null);
                c.drawBitmap(this.moreapps, F.wf(45.0f), F.hf(340.0f), null);
                c.drawBitmap(this.help, F.wf(130.0f), F.hf(340.0f), null);
                c.drawBitmap(this.leaderboard, F.wf(215.0f), F.hf(340.0f), null);
            }
            if (mainpage == 5) {
                help(c);
            }
            if (mainpage == 6) {
                this.anim.levelanim(c);
            }
            if (mainpage == 7) {
                if (this.bakc) {
                    this.internalcounterc++;
                    if (this.internalcounterc % 10 == 0) {
                        this.counterc++;
                    }
                    if (this.counterc >= 2) {
                        this.counterc = 0;
                        this.internalcounterc = 0;
                        this.bakc = false;
                    }
                }
                this.level.Level_Canvas(c);
            }
            if (mainpage == 3) {
                float[] fArr;
                if (baka) {
                    this.internalcountera++;
                    if (this.internalcountera % 10 == 0) {
                        this.countera++;
                    }
                    if (this.countera >= 2) {
                        this.countera = 0;
                        this.internalcountera = 0;
                        baka = false;
                    }
                }
                view.drawRectangle(c);
                if (levelcounter % 3 == 0) {
                    if (rotation[0] <= 0.0f && rotation[0] <= 0.0f) {
                        changeangle = 2.0d;
                    }
                    if (rotation[0] > 0.0f && rotation[0] >= 360.0f) {
                        changeangle = -2.0d;
                    }
                }
                if (levelcounter % 3 == 1) {
                    changeangle = 2.0d;
                }
                if (levelcounter % 3 == 2) {
                    changeangle = -2.0d;
                }
                x = (int) F.wf(160.0f);
                y = (int) F.hf(159.0f);
                r = (int) F.wf(10.0f);
                int i = 0;
                while (i < blinedraw.length) {
                    if (blinedraw[i]) {
                        c.save();
                        c.rotate(rotation[i], (float) (screenW / 2), F.hf(272.0f));
                        c.drawLine((float) (screenW / 2), F.hf(272.0f), (float) (screenW / 2), F.hf(272.0f) - F.hf(105.0f), paint4);
                        c.drawCircle((float) x, (float) y, (float) r, paint3);
                        c.drawBitmap(this.cartoonbomb, new Rect(0, 0, this.cartoonbomb.getWidth(), this.cartoonbomb.getHeight()), new Rect(x - (this.cartoonbomb.getWidth() / 2), y - (this.cartoonbomb.getHeight() / 2), x + (this.cartoonbomb.getWidth() / 2), y + (this.cartoonbomb.getHeight() / 2)), null);
                        if (i >= saveline) {
                            c.drawText((Circle.var - (i - saveline)+""), (float) x, (float) ((int) F.hf(163.0f)), this.innercircletext);
                        }
                        savex[i] = x;
                        savey[i] = y;
                        if (changeangle > 0.0d && rotation[i] >= 360.0f) {
                            rotation[i] = 0.0f;
                        }
                        if (changeangle < 0.0d && rotation[i] <= -360.0f) {
                            rotation[i] = 0.0f;
                        }
                        if (!(errorcircle || !GameActivity.isResume || circleblink)) {
                            fArr = rotation;
                            fArr[i] = (float) (((double) fArr[i]) + changeangle);
                        }
                        c.restore();
                        if (circleblink) {
                            holdcounter++;
                            if (holdcounter > 32000) {
                                holdcounter = 0;
                            }
                            if (holdcounter % 5 == 0) {
                                hcm++;
                            }
                            if (hcm > 32000) {
                                hcm = 0;
                            }
                            if (hcm <= 9) {
                                h = (int) F.wf(160.0f);
                                j = (int) F.hf(159.0f);
                                k = (int) F.wf(11.0f);
                                paint7.setAlpha(a1);
                                paint7.setColor(SupportMenu.CATEGORY_MASK);
                                paint7.setAntiAlias(true);
                                paint7.setFilterBitmap(true);
                                paint7.setStrokeWidth(2.0f);
                                c.drawCircle((float) h, (float) j, (float) k, paint7);
                                c.drawCircle((float) x, (float) y, (float) r, paint3);
                                if (i >= saveline) {
                                    c.drawText((Circle.var - (i - saveline)+""), (float) x, (float) ((int) F.hf(163.0f)), this.innercircletext);
                                }
                            }
                            if (hcm >= 11) {
                                circleblink = false;
                                mainpage = 6;
//                                GameActivity.vimapad.isBottomAdVisible(true);
//                                GameActivity.vimapad.isTopAdVisible(true);
                                holdcounter = 0;
                                hcm = 0;
                            }
                        }
                    }
                    i++;
                }
                i = 0;
                while (i < circledrawboolean.length) {
                    if (circledrawboolean[i]) {
                        c.save();
                        c.rotate(rotation[i], (float) (screenW / 2), F.hf(272.0f));
                        c.drawLine((float) (screenW / 2), F.hf(272.0f), (float) (screenW / 2), F.hf(272.0f) - F.hf(105.0f), paint4);
                        c.drawCircle((float) x, (float) y, (float) r, paint3);
                        if (i >= saveline) {
                            c.drawText((Circle.var - (i - saveline)+""), (float) x, (float) ((int) F.hf(163.0f)), this.innercircletext);
                        }
                        savex[i] = x;
                        savey[i] = y;
                        if (changeangle > 0.0d && rotation[i] >= 360.0f) {
                            rotation[i] = 0.0f;
                        }
                        if (changeangle < 0.0d && rotation[i] <= -360.0f) {
                            rotation[i] = 0.0f;
                        }
                        if (!(errorcircle || !GameActivity.isResume || circleblink)) {
                            fArr = rotation;
                            fArr[i] = (float) (((double) fArr[i]) + changeangle);
                        }
                        c.restore();
                        if (colcircle) {
                            this.displaycount3++;
                            textdisplayboolean = false;
                            if (this.displaycount3 <= 70 || (this.displaycount3 >= 80 && this.displaycount3 <= 90)) {
                                paint6.setAntiAlias(true);
                            }
                            paint6.setFilterBitmap(true);
                            paint6.setColor(ViewCompat.MEASURED_STATE_MASK);
                            c.drawCircle((float) (screenW / 2), F.hf(272.0f), F.wf(39.0f), paint6);
                            paint6.setColor(SupportMenu.CATEGORY_MASK);
                            paint6.setAntiAlias(true);
                            paint6.setFilterBitmap(true);
                            paint6.setTypeface(tf);
                            paint6.setAlpha(Circle.a);
                            paint6.setTextAlign(Paint.Align.CENTER);
                            c.drawText(String.valueOf(levelcounter), F.wf(160.0f), F.hf(278.0f), paint6);
                            paint6.setColor(getResources().getColor(R.color.common_signin_btn_default_background));
                            paint6.setAlpha(20);
                            paint6.setAntiAlias(true);
                            paint6.setFilterBitmap(true);
                            c.drawRect(0.0f, 0.0f, (float) screenW, (float) screenH, paint6);
                            if (this.displaycount3 <= 70 || this.displaycount3 >= 80) {
                            }
                            if (this.displaycount3 > 90) {
                                int j;
                                this.displaycount3 = 0;
                                colcircle = false;
                                circleblink = false;
                                bak4 = true;
                                reset();
                                levelcounter++;
                                errorcircle = false;
                                linecounter = NoOfInitialLines - 1;
                                for (j = 0; j < NoOfInitialLines; j++) {
                                    blinedraw[j] = true;
                                }
                                for (j = 0; j < rotation.length; j++) {
                                    rotation[j] = 0.0f;
                                }
                                for (j = 0; j < NoOfInitialLines; j++) {
                                    rotation[j] = (float) ((j + 1) * (360 / NoOfInitialLines));
                                    if (rotation[j] > 360.0f) {
                                        rotation[j] = rotation[j] - 360.0f;
                                    }
                                }
                            }
                        }
                    }
                    i++;
                }
                this.paint21.setColor(-1);
                this.paint21.setTypeface(tf);
                this.paint21.setTextAlign(Paint.Align.CENTER);
                this.paint21.setAntiAlias(true);
                this.paint21.setFilterBitmap(true);
                if (textdisplayboolean) {
                    c.drawText(String.valueOf(levelcounter), F.wf(160.0f), F.hf(278.0f), this.paint21);
                }
            }
        } catch (Exception e) {
        }
    }

    double getDistance(float f, float angle) {
        return Math.abs(((double) (2.0f * f)) * Math.sin((double) (((float) (((double) angle) * 0.017453292519943295d)) / 2.0f)));
    }

    public void about(Canvas c) {
        int textsize = (int) F.hf(20.0f);
        Paint p3 = new Paint();
        p3.setTypeface(tf);
        p3.setColor(ViewCompat.MEASURED_STATE_MASK);
        p3.setFlags(1);
        p3.setTextSize((float) textsize);
        Paint pagepaint = new Paint();
        pagepaint.setColor(getResources().getColor(R.color.abc_secondary_text_material_light));
        c.drawRect(0.0f, 0.0f, (float) screenW, (float) screenH, pagepaint);
        p3.setTextSize(F.hf(30.0f));
        c.drawText(ctx.getString(R.string.about), ((float) (screenW / 2)) - (p3.measureText(ctx.getString(R.string.about)) / 2.0f), (float) (screenH / 4), p3);
        p3.setTextSize((float) textsize);
        c.drawText(ctx.getString(R.string.app_name), ((float) (screenW / 2)) - (p3.measureText(ctx.getString(R.string.app_name)) / 2.0f), (float) (((textsize * 2) + 1) + ((screenH - (textsize * 7)) / 2)), p3);
        c.drawText("License Version 1.7", ((float) (screenW / 2)) - (p3.measureText("License Version 1.7") / 2.0f), (float) (((textsize * 3) + 1) + ((screenH - (textsize * 7)) / 2)), p3);
        p3.setTextSize(F.hf(17.0f));
        c.drawText("Powered by Map Game Studio", ((float) (screenW / 2)) - (p3.measureText("Powered by Map Game Studio") / 2.0f), (float) (((textsize * 4) + 1) + ((screenH - (textsize * 7)) / 2)), p3);
        p3.setTextSize(F.hf(17.0f));
        c.drawText("Email:mapgamestudio@gmail.com", ((float) (screenW / 2)) - (p3.measureText("Email:mapgamestudio@gmail.com") / 2.0f), (float) (((textsize * 5) + 1) + ((screenH - (textsize * 7)) / 2)), p3);
    }

    public void help(Canvas c) {
        String x = "";
        float textsize = F.hf(19.0f);
        Paint p4 = new Paint();
        Paint p5 = new Paint();
        Paint p6 = new Paint();
        String text = ctx.getString(R.string.helptext);
        p4.setColor(getResources().getColor(R.color.bright_foreground_inverse_material_light));
        p4.setFlags(1);
        p5.setTypeface(tf);
        p5.setTextSize(F.hf(30.0f));
        p6.setTextSize(textsize);
        p5.setColor(ViewCompat.MEASURED_STATE_MASK);
        c.drawRect(0.0f, 0.0f, (float) screenW, (float) screenH, p4);
        c.drawText(ctx.getString(R.string.help), ((float) (screenW / 2)) - (p5.measureText(ctx.getString(R.string.help)) / 2.0f), (float) (screenH / 8), p5);
        int i = 0;
        int xv1 = 0;
        int yv1 = (int) textsize;
        while (i < ctx.getString(R.string.helptext).length()) {
            if (text.charAt(i) != '$') {
                c.drawText("  " + ctx.getString(R.string.helptext).charAt(i), (float) xv1, ((float) ((screenH / 8) + yv1)) + (4.0f * textsize), p6);
                xv1 = (int) (((float) xv1) + p6.measureText(Character.toString(ctx.getString(R.string.helptext).charAt(i))));
            }
            if (ctx.getString(R.string.helptext).charAt(i) == '$') {
                i++;
                x = " ";
                yv1 = (int) (((float) yv1) + textsize);
                xv1 = 0;
            }
            i++;
        }
    }

    public static void reset() {
        int i;
        counter = 0;
        linecounter = -1;
        holdcounter = 0;
        hcm = 0;
        blinedraw = new boolean[100];
        savex = new int[100];
        savey = new int[100];
        for (i = 0; i < blinedraw.length; i++) {
            blinedraw[i] = false;
            savex[i] = x;
            savey[i] = y;
        }
        for (i = 0; i < circledrawboolean.length; i++) {
            circledrawboolean[i] = false;
            savex[i] = x;
            savey[i] = y;
        }
        Circle.var = Circle.var4;
        Circle.increaserect = Circle.var3;
        Circle.counter = Circle.var4;
        Circle.value = 0;
        textsize4 = 20;
        Circle.textsize = 18;
        textdisplayboolean = true;
        if (levelcounter > 0 && levelcounter < 4) {
            counter = Circle.var4;
            Circle.var = Circle.var4;
            NoOfInitialLines = 6;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 3 && levelcounter < 7) {
            counter = Circle.var4 + 4;
           Circle.var = Circle.var4;
            NoOfInitialLines = 8;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 6 && levelcounter < 10) {
            counter = Circle.var4 + 15;
            Circle.var = Circle.var4 + 15;
            NoOfInitialLines = 2;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 9 && levelcounter < 13) {
            counter = Circle.var4 + 8;
            Circle.var = Circle.var4 + 8;
            NoOfInitialLines = 4;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 12 && levelcounter < 16) {
            counter = Circle.var4 + 12;
            Circle.var = Circle.var4 + 12;
            NoOfInitialLines = 6;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 15 && levelcounter < 19) {
            counter = Circle.var4 + 16;
            Circle.var = Circle.var4 + 16;
            NoOfInitialLines = 3;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 18 && levelcounter < 22) {
            counter = Circle.var4 + 14;
            Circle.var = Circle.var4 + 14;
            NoOfInitialLines = 5;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 21 && levelcounter < 25) {
            counter = Circle.var4 + 10;
            Circle.var = Circle.var4 + 10;
            NoOfInitialLines = 8;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 24 && levelcounter < 28) {
            counter = Circle.var4 + 8;
            Circle.var = Circle.var4 + 8;
            NoOfInitialLines = 4;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 27 && levelcounter < 31) {
            counter = Circle.var4 + 9;
            Circle.var = Circle.var4 + 9;
            NoOfInitialLines = 2;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 30 && levelcounter < 34) {
            counter = Circle.var4 + 13;
            Circle.var = Circle.var4 + 13;
            NoOfInitialLines = 1;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 33 && levelcounter < 37) {
            counter = Circle.var4 + 8;
            Circle.var = Circle.var4 + 8;
            NoOfInitialLines = 8;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 36 && levelcounter < 40) {
            counter = Circle.var4 + 15;
            Circle.var = Circle.var4 + 15;
            NoOfInitialLines = 2;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 39 && levelcounter < 43) {
            counter = Circle.var4 + 7;
            Circle.var = Circle.var4 + 7;
            NoOfInitialLines = 4;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 42 && levelcounter < 46) {
            counter = Circle.var4 + 12;
            Circle.var = Circle.var4 + 12;
            NoOfInitialLines = 6;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 45 && levelcounter < 49) {
            counter = Circle.var4 + 16;
            Circle.var = Circle.var4 + 16;
            NoOfInitialLines = 3;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 48 && levelcounter < 52) {
            counter = Circle.var4 + 14;
            Circle.var = Circle.var4 + 14;
            NoOfInitialLines = 5;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 51 && levelcounter < 55) {
            counter = Circle.var4 + 12;
            Circle.var = Circle.var4 + 12;
            NoOfInitialLines = 7;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 54 && levelcounter < 58) {
            counter = Circle.var4 + 10;
            Circle.var = Circle.var4 + 10;
            NoOfInitialLines = 8;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 57 && levelcounter < 61) {
            counter = Circle.var4 + 9;
            Circle.var = Circle.var4 + 9;
            NoOfInitialLines = 2;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 606 && levelcounter < 64) {
            counter = Circle.var4 + 11;
            Circle.var = Circle.var4 + 11;
            NoOfInitialLines = 4;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 63 && levelcounter < 67) {
            counter = Circle.var4 + 16;
            Circle.var = Circle.var4 + 16;
            NoOfInitialLines = 3;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 66 && levelcounter < 70) {
            counter = Circle.var4 + 13;
            Circle.var = Circle.var4 + 13;
            NoOfInitialLines = 5;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 69 && levelcounter < 73) {
            counter = Circle.var4 + 14;
            Circle.var = Circle.var4 + 14;
            NoOfInitialLines = 5;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 72 && levelcounter < 76) {
            counter = Circle.var4 + 4;
            Circle.var = Circle.var4 + 4;
            NoOfInitialLines = 9;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 75 && levelcounter < 79) {
            counter = Circle.var4 + 13;
            Circle.var = Circle.var4 + 13;
            NoOfInitialLines = 5;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 78 && levelcounter < 82) {
            counter = Circle.var4 + 13;
            Circle.var = Circle.var4 + 13;
            NoOfInitialLines = 5;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 81 && levelcounter < 85) {
            counter = Circle.var4 + 10;
            Circle.var = Circle.var4 + 10;
            NoOfInitialLines = 5;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 84 && levelcounter < 88) {
            counter = Circle.var4 + 10;
            Circle.var = Circle.var4 + 10;
            NoOfInitialLines = 5;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 87 && levelcounter < 91) {
            counter = Circle.var4 + 11;
            Circle.var = Circle.var4 + 11;
            NoOfInitialLines = 5;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 90 && levelcounter < 94) {
            counter = Circle.var4 + 13;
            Circle.var = Circle.var4 + 13;
            NoOfInitialLines = 5;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 93 && levelcounter < 97) {
            counter = Circle.var4 + 10;
            Circle.var = Circle.var4 + 10;
            NoOfInitialLines = 5;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 96 && levelcounter < 101) {
            counter = Circle.var4 + 10;
            Circle.var = Circle.var4 + 10;
            NoOfInitialLines = 5;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 100 && levelcounter < 105) {
            counter = Circle.var4 + 6;
            Circle.var = Circle.var4 + 6;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 104 && levelcounter < 108) {
            counter = Circle.var4 + 22;
            Circle.var = Circle.var4 + 22;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 107 && levelcounter < 111) {
            counter = Circle.var4 + 18;
            Circle.var = Circle.var4 + 18;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 110 && levelcounter < 114) {
            counter = Circle.var4 + 20;
            Circle.var = Circle.var4 + 20;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 113 && levelcounter < 117) {
            counter = Circle.var4 + 16;
            Circle.var = Circle.var4 + 16;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 116 && levelcounter < 121) {
            counter = Circle.var4 + 22;
            Circle.var = Circle.var4 + 22;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 120 && levelcounter < 124) {
            counter = Circle.var4 + 12;
            Circle.var = Circle.var4 + 12;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 123 && levelcounter < TransportMediator.KEYCODE_MEDIA_PAUSE) {
            counter = Circle.var4 + 22;
            Circle.var = Circle.var4 + 22;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > TransportMediator.KEYCODE_MEDIA_PLAY && levelcounter < 131) {
            counter = Circle.var4 + 20;
            Circle.var = Circle.var4 + 20;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > TransportMediator.KEYCODE_MEDIA_RECORD && levelcounter < 134) {
            counter = Circle.var4 + 19;
            Circle.var = Circle.var4 + 19;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 133 && levelcounter < 137) {
            counter = Circle.var4 + 22;
            Circle.var = Circle.var4 + 22;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 136 && levelcounter < 140) {
            counter = Circle.var4 + 10;
            Circle.var = Circle.var4 + 10;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 139 && levelcounter < 144) {
            counter = Circle.var4 + 18;
            Circle.var = Circle.var4 + 18;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 143 && levelcounter < 146) {
            counter = Circle.var4 + 20;
            Circle.var = Circle.var4 + 20;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 146 && levelcounter < 151) {
            counter = Circle.var4 + 22;
            Circle.var = Circle.var4 + 22;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 150 && levelcounter < 155) {
            counter = Circle.var4 + 13;
            Circle.var = Circle.var4 + 13;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 154 && levelcounter < 158) {
            counter = Circle.var4 + 22;
            Circle.var = Circle.var4 + 22;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 157 && levelcounter < 161) {
            counter = Circle.var4 + 19;
            Circle.var = Circle.var4 + 19;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 160 && levelcounter < 164) {
            counter = Circle.var4 + 18;
            Circle.var = Circle.var4 + 18;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 163 && levelcounter < 167) {
            counter = Circle.var4 + 22;
            Circle.var = Circle.var4 + 22;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 166 && levelcounter < 171) {
            counter = Circle.var4 + 13;
            Circle.var = Circle.var4 + 13;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 170 && levelcounter < 174) {
            counter = Circle.var4 + 22;
            Circle.var = Circle.var4 + 22;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 173 && levelcounter < 177) {
            counter = Circle.var4 + 18;
            Circle.var = Circle.var4 + 18;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 176 && levelcounter < 180) {
            counter = Circle.var4 + 20;
            Circle.var = Circle.var4 + 20;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 179 && levelcounter < 184) {
            counter = Circle.var4 + 22;
            Circle.var = Circle.var4 + 22;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 183 && levelcounter < 187) {
            counter = Circle.var4 + 19;
            Circle.var = Circle.var4 + 19;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 186 && levelcounter < 191) {
            counter = Circle.var4 + 13;
            Circle.var = Circle.var4 + 13;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 193 && levelcounter < 197) {
            counter = Circle.var4 + 19;
            Circle.var = Circle.var4 + 19;
            saveline = NoOfInitialLines;
        }
        if (levelcounter > 196 && levelcounter < 202) {
            counter = Circle.var4 + 5;
            Circle.var = Circle.var4 + 5;
            saveline = NoOfInitialLines;
        }
        x = (int) F.wf(160.0f);
        y = (int) F.hf(160.0f);
        Circle.radious = (float) ((int) F.wf(10.0f));
        Circle.w = (int) F.wf(160.0f);
        Circle.h = (int) F.hf(103.0f);
        errorcircle = false;
        Circle.blink = false;
        colcircle = false;
        circleblink = false;
        drawrect = false;
        Levelfailedanimation.angle1 = 0;
        Levelfailedanimation.angle3 = 45;
        Levelfailedanimation.angle2 = -45;
        Levelfailedanimation.angle4 = 225;
        Levelfailedanimation.angle5 = 180;
        Levelfailedanimation.angle6 = 135;
        Levelfailedanimation.textsize4 = 24;
        Levelfailedanimation.pp2.setTextSize(F.hf((float) Levelfailedanimation.textsize4));
        Levelfailedanimation.textsize5 = 17;
        Levelfailedanimation.paint13.setTypeface(tf);
        Levelfailedanimation.paint13.setTextSize(F.hf((float) Levelfailedanimation.textsize5));
        Levelfailedanimation.holdlevelanim = 0;
        Levelfailedanimation.holdanim = 0;
        Levelfailedanimation.textsize3 = 22;
        Levelfailedanimation.textsize1 = 25;
        Levelfailedanimation.textsize8 = 33;
        Levelfailedanimation.textsize6 = 20;
        Levelfailedanimation.textpaint.setTextSize(F.hf((float) Levelfailedanimation.textsize6));
        Levelfailedanimation.cx = (float) (screenW / 2);
        Levelfailedanimation.cy = F.hf(150.0f);
        Levelfailedanimation.radious = F.hf(100.0f);
        Levelfailedanimation.x1 = (float) (screenW / 2);
        Levelfailedanimation.y1 = F.hf(150.0f);
        Levelfailedanimation.r = F.wf(31.0f);
        Levelfailedanimation.animboolean = new boolean[13];
        for (i = 0; i < Levelfailedanimation.animboolean.length; i++) {
            Levelfailedanimation.animboolean[i] = false;
        }
        Levelfailedanimation.showtransparencyflag = false;
        Levelfailedanimation.shortradious = (int) F.wf(10.0f);
    }

    public boolean onTouchEvent(MotionEvent event) {
        int i;
        int j;
        if (mainpage == -1 && event.getAction() == 1) {
            this.touchx = (int) event.getX();
            this.touchy = (int) event.getY();
            if (new Rect(screenW / 16, (int) (((double) ((screenH * 5) / 8)) - (1.5d * ((double) ExitGame.exittextsize))), (int) (((float) (screenW / 6)) + (ExitGame.pcolored.measureText(ctx.getString(R.string.yes)) / 2.0f)), (int) (((double) ((screenH * 5) / 8)) + (0.5d * ((double) ExitGame.exittextsize)))).contains((int) event.getX(), (int) event.getY())) {
                System.exit(0);
            }
            if (new Rect((int) (((float) (screenW - (screenW / 5))) - (ExitGame.pcolored.measureText(ctx.getString(R.string.cancel)) / 2.0f)), (int) (((double) ((screenH * 5) / 8)) - (1.5d * ((double) ExitGame.exittextsize))), screenW - (screenW / 16), (int) (((double) ((screenH * 5) / 8)) + (0.5d * ((double) ExitGame.exittextsize)))).contains((int) event.getX(), (int) event.getY())) {
                mainpage = 1;
                reset();
            }
            if (new Rect((int) (((float) (screenW / 2)) - (ExitGame.pcolored.measureText(ctx.getString(R.string.rateit)) / 2.0f)), (int) (((double) ((screenH * 5) / 8)) - (1.5d * ((double) ExitGame.exittextsize))), (int) (((float) (screenW / 2)) + (ExitGame.pcolored.measureText(ctx.getString(R.string.rateit)) / 2.0f)), (int) (((double) ((screenH * 5) / 8)) + (0.5d * ((double) ExitGame.exittextsize)))).contains((int) event.getX(), (int) event.getY())) {
                ctx.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(DefaultData.RateUrl)));
            }
        }
        if (!bak2) {
            if (mainpage == 1) {
                errorcircle = false;
                linecounter = NoOfInitialLines - 1;
                for (i = 0; i < NoOfInitialLines; i++) {
                    blinedraw[i] = true;
                }
                for (i = 0; i < rotation.length; i++) {
                    rotation[i] = 0.0f;
                }
                for (i = 0; i < NoOfInitialLines; i++) {
                    rotation[i] = (float) ((i + 1) * (360 / NoOfInitialLines));
                    if (rotation[i] > 360.0f) {
                        rotation[i] = rotation[i] - 360.0f;
                    }
                }
                if (!bak4 && event.getAction() == 0) {
                    this.touchx = (int) event.getX();
                    this.touchy = (int) event.getY();
                    if (new RectF(F.wf(110.0f), F.hf(175.0f), F.wf(110.0f) + ((float) ((int) F.wf(90.0f))), F.hf(175.0f) + ((float) ((int) F.wf(90.0f)))).contains((float) this.touchx, (float) this.touchy)) {
                        levelcounter = GameActivity.gameLevel;
                        mainpage = 3;
//                        GameActivity.vimapad.isBottomAdVisible(true);
//                        GameActivity.vimapad.isTopAdVisible(false);
                        Circle.bak1 = true;
                    }
                }
            }
            if (!bak4 && mainpage == 1 && event.getAction() == 0) {
                this.touchx = (int) event.getX();
                this.touchy = (int) event.getY();
                if (new Rect((int) F.wf(45.0f), (int) F.hf(340.0f), ((int) F.wf(85.0f)) + ((int) F.wf(70.0f)), ((int) F.hf(340.0f)) + ((int) F.wf(70.0f))).contains(this.touchx, this.touchy)) {
                    ctx.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(DefaultData.defaultUrl)));
                }
            }
        }
        if (!bak4 && mainpage == 1 && event.getAction() == 0) {
            this.touchx = (int) event.getX();
            this.touchy = (int) event.getY();
            if (new Rect((int) F.wf(130.0f), (int) F.hf(340.0f), ((int) F.wf(165.0f)) + ((int) F.wf(70.0f)), ((int) F.hf(340.0f)) + ((int) F.wf(70.0f))).contains(this.touchx, this.touchy)) {
                mainpage = 5;
            }
        }
        if (!bak4 && mainpage == 1 && event.getAction() == 0) {
            this.leaderx = (int) event.getX();
            this.leadery = (int) event.getY();
            if (new Rect((int) F.wf(215.0f), (int) F.hf(340.0f), ((int) F.wf(246.0f)) + ((int) F.wf(70.0f)), ((int) F.hf(340.0f)) + ((int) F.wf(70.0f))).contains(this.leaderx, this.leadery)) {
                GameActivity start = (GameActivity) ctx;
//                start.checkGooglPlayService();
//                start.beginUserInitiatedSignIn();
//                start.onShowLeaderboardsRequested();
            }
        }
        if (Levelfailedanimation.holdanim >= 5 && mainpage == 6) {
            if (event.getAction() == 0) {
                this.animx = (int) event.getX();
                this.animy = (int) event.getY();
                if (new Rect((int) F.wf(140.0f), (int) F.hf(210.0f), (int) F.wf(190.0f), (int) F.hf(260.0f)).contains(this.animx, this.animy)) {
                    mainpage = 3;
//                    GameActivity.vimapad.isBottomAdVisible(true);
//                    GameActivity.vimapad.isTopAdVisible(false);
                    circleblink = false;
                    reset();
                    errorcircle = false;
                    linecounter = NoOfInitialLines - 1;
                    for (j = 0; j < NoOfInitialLines; j++) {
                        blinedraw[j] = true;
                    }
                    for (j = 0; j < rotation.length; j++) {
                        rotation[j] = 0.0f;
                    }
                    for (j = 0; j < NoOfInitialLines; j++) {
                        rotation[j] = (float) ((j + 1) * (360 / NoOfInitialLines));
                        if (rotation[j] > 360.0f) {
                            rotation[j] = rotation[j] - 360.0f;
                        }
                        baka = true;
                        this.bakc = true;
                    }
                }
            }
            if (event.getAction() == 1) {
                this.choosex = (int) event.getX();
                this.choosey = (int) event.getY();
                if (new Rect((int) F.wf(85.0f), (int) F.hf(290.0f), (int) F.wf(235.0f), (int) F.hf(310.0f)).contains(this.choosex, this.choosey)) {
//                    GameActivity.vimapad.isBottomAdVisible(true);
//                    GameActivity.vimapad.isTopAdVisible(false);
                    Levelfailedanimation.showtransparencyflag = false;
                    Levelfailedanimation.holdlevelanim = 0;
                    Levelfailedanimation.holdanim = 0;
                    for (i = 0; i < Levelfailedanimation.animboolean.length; i++) {
                        Levelfailedanimation.animboolean[i] = false;
                    }
                    Levelfailedanimation.showtransparencyflag = false;
                    mainpage = 7;
                    baka = true;
                    this.bakc = true;
                }
            }
        }
        if (!(baka || circleblink || colcircle || mainpage != 3 || Circle.bak1 || event.getAction() != 0)) {
            this.downx = (int) event.getX();
            this.downy = (int) event.getY();
            if (new RectF(0.0f, 0.0f, (float) (screenW + 0), ((float) (screenH / 2)) + F.hf(200.0f)).contains((float) this.downx, (float) this.downy)) {
                GameActivity mainActivity;
                linecounter++;
                if (!levelfailed) {
                    circledrawboolean[linecounter] = true;
                }
                if (Circle.counter > (-Circle.var)) {
                    Circle.value--;
                }
                if (linecounter > 0) {
                    j = 0;
                    while (j < linecounter) {
                        if ((rotation[j] >= 0.0f && ((rotation[j] < 180.0f && getDistance(Math.abs((F.hf(272.0f) - F.hf(105.0f)) - F.hf(272.0f)) + F.wf(10.0f), rotation[j]) < ((double) (2.0f * F.wf(10.0f)))) || (rotation[j] > 180.0f && getDistance(Math.abs((F.hf(272.0f) - F.hf(105.0f)) - F.hf(272.0f)) + F.wf(10.0f), 360.0f - rotation[j]) < ((double) (2.0f * F.wf(10.0f)))))) || (rotation[j] < 0.0f && ((rotation[j] > -180.0f && getDistance(Math.abs((F.hf(272.0f) - F.hf(105.0f)) - F.hf(272.0f)) + F.wf(10.0f), Math.abs(rotation[j])) < ((double) (2.0f * F.wf(10.0f)))) || (rotation[j] < -180.0f && getDistance(Math.abs((F.hf(272.0f) - F.hf(105.0f)) - F.hf(272.0f)) + F.wf(10.0f), 360.0f - Math.abs(rotation[j])) < ((double) (2.0f * F.wf(10.0f))))))) {
                            errorcircle = true;
                            circleblink = true;
                        }
                        mainActivity = (GameActivity) ctx;
                        mainActivity.saveState();
                        mainActivity.getState();
                        j++;
                    }
                }
                if (!circleblink && Circle.value == (-Circle.var)) {
                    errorcircle = true;
                    colcircle = true;
//                    GameActivity.vimapad.isBottomAdVisible(true);
//                    GameActivity.vimapad.isTopAdVisible(false);
                    Circle.blink = true;
                    if (levelcounter == 202) {
                        levelcounter = 1;
                    }
                    mainActivity = (GameActivity) ctx;
                    mainActivity.saveState();
                    mainActivity.getState();
                }
                bak2 = true;
            }
        }
        if (mainpage == 7 && !this.bakc) {
            this.level.onTouchEvent(event);
        }
        return true;
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        this.thread = new GameThread(getHolder(), this);
        this.thread.setRunning(true);
        this.thread.start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        this.thread.setRunning(false);
        while (retry) {
            try {
                this.thread.join();
                retry = false;
            } catch (InterruptedException e) {
            }
        }


    }
}
