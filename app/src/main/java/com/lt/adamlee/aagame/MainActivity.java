package com.lt.adamlee.aagame;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Handler;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static int progress;
    private Handler handler;
    public boolean isClosed;
    @Bind(R.id.progressBar1)
    ProgressBar progressBar;

    private int progressStatus;

    public MainActivity() {
        this.progressStatus = 0;
        this.handler = new Handler();
    }

    static {
        progress = 0;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT, AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
        getWindow().setFlags(TransportMediator.FLAG_KEY_MEDIA_NEXT, TransportMediator.FLAG_KEY_MEDIA_NEXT);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        this.isClosed = false;
        Rect bounds = progressBar.getProgressDrawable().getBounds();
        this.progressBar.setProgressDrawable(getResources().getDrawable(R.drawable.progress));
        this.progressBar.getProgressDrawable().setBounds(bounds);
        thread();

    }


    public void thread() {
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                   progressStatus = doSomeWork();
                   handler.post(new Runnable() {
                       public void run() {
                           progressBar.setProgress(progressStatus);
                       }
                   });
                }
               handler.post(new Runnable() {
                    public void run() {
                        if (!isClosed) {
                            startActivity(new Intent(MainActivity.this, MainActivity.class));
                        }
                        progressBar.setVisibility(View.INVISIBLE);
                        finish();
                    }
                });
            }

            private int doSomeWork() {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }
                int access = progress + 1;
                progress = access;
                return access;
            }
        }).start();
    }




}
