package com.lt.adamlee.aagame;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.v4.view.ViewCompat;

/**
 * Created by Administrator on 2015/7/29.
 */
public class ExitGame {
    static int exittextsize;
    static Paint paint1;
    static Paint pcolored;
    Bitmap about;
    Bitmap help;
    Bitmap leaderboard;
    Bitmap mainpageimage;
    Bitmap moreapps;
    Paint pexit;
    Bitmap play;
    Bitmap rect;
    Typeface tf;

    public ExitGame() {
        this.pexit = new Paint();
        this.mainpageimage = BitmapFactory.decodeResource(GameView.ctx.getResources(), R.drawable.mainpageimage);
        this.mainpageimage = Bitmap.createScaledBitmap(this.mainpageimage, GameView.screenW, GameView.screenH, true);
        this.leaderboard = BitmapFactory.decodeResource(GameView.ctx.getResources(), R.drawable.leaderboard);
        this.leaderboard = Bitmap.createScaledBitmap(this.leaderboard, (int) F.wf(70.0f), (int) F.wf(70.0f), true);
        this.moreapps = BitmapFactory.decodeResource(GameView.ctx.getResources(), R.drawable.moreapps);
        this.moreapps = Bitmap.createScaledBitmap(this.moreapps, (int) F.wf(70.0f), (int) F.wf(70.0f), true);
        this.help = BitmapFactory.decodeResource(GameView.ctx.getResources(), R.drawable.help);
        this.help = Bitmap.createScaledBitmap(this.help, (int) F.wf(70.0f), (int) F.wf(70.0f), true);
        this.about = BitmapFactory.decodeResource(GameView.ctx.getResources(), R.drawable.about);
        this.about = Bitmap.createScaledBitmap(this.about, (int) F.wf(70.0f), (int) F.wf(70.0f), true);
        exittextsize = (int) F.hf(20.0f);
        pcolored = new Paint();
        this.pexit.setColor(Color.GRAY);
        paint1 = new Paint();
        pcolored.setColor(ViewCompat.MEASURED_STATE_MASK);
        pcolored.setTextSize((float) exittextsize);
        pcolored.setFlags(1);
        this.tf = Typeface.createFromAsset(GameView.ctx.getAssets(), "Russo_One.ttf");
    }

    void exitdialog(Canvas c) {
        c.drawBitmap(this.mainpageimage, 0.0f, 0.0f, null);
        c.drawBitmap(this.moreapps, F.wf(45.0f), F.hf(340.0f), null);
        c.drawBitmap(this.help, F.wf(130.0f), F.hf(340.0f), null);
        c.drawBitmap(this.leaderboard, F.wf(215.0f), F.hf(340.0f), null);
        pcolored.setTypeface(this.tf);
        c.drawRoundRect(new RectF((float) (GameView.screenW / 16), (float) (GameView.screenH / 5), (float) (GameView.screenW - (GameView.screenW / 16)), (float) (GameView.screenH - (GameView.screenH / 3))), (float) (GameView.screenW / 16), (float) (GameView.screenH / 16), this.pexit);
        c.drawText(GameView.ctx.getString(R.string.wantexit), ((float) (GameView.screenW / 2)) - (pcolored.measureText(GameView.ctx.getString(R.string.wantexit)) / 2.0f), (float) ((GameView.screenH * 3) / 9), pcolored);
        c.drawText(GameView.ctx.getString(R.string.yes), ((float) (GameView.screenW / 6)) - (pcolored.measureText(GameView.ctx.getString(R.string.yes)) / 2.0f), (float) ((GameView.screenH * 5) / 8), pcolored);
        c.drawText(GameView.ctx.getString(R.string.rateit), ((float) (GameView.screenW / 2)) - (pcolored.measureText(new StringBuilder(String.valueOf(GameView.ctx.getString(R.string.rateit))).append(" ").toString()) / 2.0f), (float) ((GameView.screenH * 5) / 8), pcolored);
        c.drawText(GameView.ctx.getString(R.string.cancel), ((float) (GameView.screenW - (GameView.screenW / 5))) - (pcolored.measureText(GameView.ctx.getString(R.string.cancel)) / 2.0f), (float) ((GameView.screenH * 5) / 8), pcolored);
    }

}
