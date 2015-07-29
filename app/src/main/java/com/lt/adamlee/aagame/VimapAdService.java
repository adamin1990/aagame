/*
package com.lt.adamlee.aagame;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

//import com.google.android.gms.ads.identifier.AdvertisingIdClient;
//import com.google.android.gms.cast.TextTrackStyle;
//import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
//import com.google.android.gms.common.GooglePlayServicesRepairableException;
//import com.google.android.gms.drive.DriveFile;
//import com.google.android.gms.location.GeofenceStatusCodes;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

*/
/**
 * Created by Administrator on 2015/7/29.
 *//*

public class VimapAdService {
    private static String AdLINK;
    private static String AdPath;
    private static boolean BottomAd;
    private static WebView BottomWebView;
    private static int CompantyID;
    private static String GoogleAdId;
    private static String IMEI;
    private static int ProductID;
    private static boolean Self_Open_BottomAd;
    private static boolean Self_Open_TopAd;
    private static boolean TopAd;
    private static WebView TopWebView;
    private static String UserAgent;
    private static String bottomUrl;
    private static Context ct;
    private static RelativeLayout rl;
    static String ssb;
    static String sst;
    private static WebView tempwebview;
    private static String topUrl;
    final int AD_INTERVAL;
    final float BOTTOM_XPOS;
    final float BOTTOM_YPOS;
    final int FIRST_AD_DELAY;
    final int REQUEST_DELAY;
    final float TOP_XPOS;
    final float TOP_YPOS;
    private Timer timer;
    private boolean top;

    */
/* renamed from: com.vimap.adservice.VimapAdService.1 *//*

    class AnonymousClass1 implements Runnable {
        private final */
/* synthetic *//*
 WebView val$topView;

        AnonymousClass1(WebView webView) {
            this.val$topView = webView;
        }

        public void run() {
            this.val$topView.loadUrl("about:blank");
            this.val$topView.getSettings().setLoadsImagesAutomatically(true);
            this.val$topView.getSettings().setJavaScriptEnabled(true);
            this.val$topView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            this.val$topView.setPadding(0, 0, 0, 0);
            this.val$topView.loadData(VimapAdService.topUrl, "text/html", null);
        }
    }

    */
/* renamed from: com.vimap.adservice.VimapAdService.2 *//*

    class AnonymousClass2 implements Runnable {
        private final */
/* synthetic *//*
 WebView val$bottomView;

        AnonymousClass2(WebView webView) {
            this.val$bottomView = webView;
        }

        public void run() {
            this.val$bottomView.loadUrl("about:blank");
            this.val$bottomView.getSettings().setLoadsImagesAutomatically(true);
            this.val$bottomView.getSettings().setJavaScriptEnabled(true);
            this.val$bottomView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            this.val$bottomView.setPadding(0, 0, 0, 0);
            this.val$bottomView.loadData(VimapAdService.bottomUrl, "text/html", null);
        }
    }

    */
/* renamed from: com.vimap.adservice.VimapAdService.3 *//*

    class AnonymousClass3 implements Runnable {
        private final */
/* synthetic *//*
 WebView val$topView;

        AnonymousClass3(WebView webView) {
            this.val$topView = webView;
        }

        public void run() {
            this.val$topView.loadUrl("about:blank");
            this.val$topView.getSettings().setLoadsImagesAutomatically(true);
            this.val$topView.getSettings().setJavaScriptEnabled(true);
            this.val$topView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            this.val$topView.loadUrl(VimapAdService.sst);
        }
    }

    */
/* renamed from: com.vimap.adservice.VimapAdService.4 *//*

    class AnonymousClass4 implements Runnable {
        private final */
/* synthetic *//*
 WebView val$bottomView;

        AnonymousClass4(WebView webView) {
            this.val$bottomView = webView;
        }

        public void run() {
            this.val$bottomView.loadUrl("about:blank");
            this.val$bottomView.getSettings().setLoadsImagesAutomatically(true);
            this.val$bottomView.getSettings().setJavaScriptEnabled(true);
            this.val$bottomView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            this.val$bottomView.loadUrl(VimapAdService.ssb);
        }
    }

    private class MyBrowserBottom extends WebViewClient {
        private MyBrowserBottom() {
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            view.setWebViewClient(new WebViewClient() {
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    if (url.contains("market://")) {
                        url = url.replace("market://", "http://market.android.com/");
                    }
                    if (url == null) {
                        return false;
                    }
                    if (VimapAdService.Self_Open_BottomAd) {
                        VimapAdService.tempwebview.loadUrl(url);
                    } else {
                        view.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                    }
                    return true;
                }
            });
            return true;
        }
    }

    private class MyBrowserTemp extends WebViewClient {
        private MyBrowserTemp() {
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.contains("market://")) {
                url = url.replace("market://", "http://market.android.com/");
            }
            view.loadUrl(url);
            VimapAdService.Self_Open_BottomAd = false;
            VimapAdService.Self_Open_TopAd = false;
            return false;
        }
    }

    private class MyBrowserTop extends WebViewClient {
        private MyBrowserTop() {
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            view.setWebViewClient(new WebViewClient() {
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    if (url.contains("market://")) {
                        url = url.replace("market://", "http://market.android.com/");
                    }
                    if (url == null) {
                        return false;
                    }
                    if (VimapAdService.Self_Open_TopAd) {
                        VimapAdService.tempwebview.loadUrl(url);
                    } else {
                        view.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                    }
                    return true;
                }
            });
            return true;
        }
    }

    public VimapAdService() {
        this.FIRST_AD_DELAY = GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE;
        this.AD_INTERVAL = 20000;
        this.REQUEST_DELAY = 10000;
        this.TOP_XPOS = 0.5f;
        this.TOP_YPOS = 0.05f;
        this.BOTTOM_XPOS = 0.5f;
        this.BOTTOM_YPOS = 0.5f;
        this.top = false;
        this.timer = null;
    }

    static {
        AdLINK = "http://www.vimapservices.com/ads/AndroidHAdsReqv1.aspx";
        TopAd = false;
        BottomAd = false;
        Self_Open_TopAd = false;
        Self_Open_BottomAd = false;
        sst = null;
        ssb = null;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void addView(Context CURRENT_CONTEXT, RelativeLayout RELATIVE_LAYOUT, boolean ENABLE_TopAD, boolean ENABLE_BottomAD, int COMPANY_ID, int PRODUCT_ID, boolean START_ShowingAds) {
        RelativeLayout.LayoutParams params;
        RelativeLayout.LayoutParams params1;
        try {
            getGoogleAdID();
        } catch (Exception e) {
        }
        rl = RELATIVE_LAYOUT;
        TopAd = ENABLE_TopAD;
        BottomAd = ENABLE_BottomAD;
        ct = CURRENT_CONTEXT;
        IMEI = ((TelephonyManager) ct.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
        TopWebView = new WebView(CURRENT_CONTEXT);
        BottomWebView = new WebView(CURRENT_CONTEXT);
        tempwebview = new WebView(CURRENT_CONTEXT);
        UserAgent = tempwebview.getSettings().getUserAgentString();
        RelativeLayout.LayoutParams paramst = new RelativeLayout.LayoutParams(0, 0);
        paramst.addRule(14);
        paramst.addRule(15);
        tempwebview.setLayoutParams(paramst);
        rl.addView(tempwebview);
        tempwebview.setWebViewClient(new MyBrowserTemp());
        tempwebview.getSettings().setLoadsImagesAutomatically(true);
        tempwebview.getSettings().setJavaScriptEnabled(true);
        tempwebview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        DisplayMetrics DisplayMetrics = new DisplayMetrics();
        DisplayMetrics = CURRENT_CONTEXT.getResources().getDisplayMetrics();
        float W = (float) DisplayMetrics.widthPixels;
        float H = (float) DisplayMetrics.heightPixels;
        if (TopAd) {
            params = new RelativeLayout.LayoutParams((int) (TextTrackStyle.DEFAULT_FONT_SCALE * W), (int) (((double) H) * 0.15d));
        } else {
            params = new RelativeLayout.LayoutParams(0, 0);
        }
        params.addRule(14);
        params.addRule(10);
        TopWebView.setLayoutParams(params);
        rl.addView(TopWebView);
        TopWebView.setWebViewClient(new MyBrowserTop());
        try {
            TopWebView.setBackgroundColor(0);
        } catch (Exception e2) {
        }
        if (BottomAd) {
            params1 = new RelativeLayout.LayoutParams((int) (TextTrackStyle.DEFAULT_FONT_SCALE * W), (int) (((double) H) * 0.1d));
        } else {
            params1 = new RelativeLayout.LayoutParams(0, 0);
        }
        params1.addRule(14);
        params1.addRule(12);
        BottomWebView.setLayoutParams(params1);
        rl.addView(BottomWebView);
        BottomWebView.setWebViewClient(new MyBrowserBottom());
        try {
            BottomWebView.setBackgroundColor(0);
        } catch (Exception e3) {
        }
        CompantyID = COMPANY_ID;
        ProductID = PRODUCT_ID;
        if (START_ShowingAds) {
            ShowAds();
        }
    }

    private void CallNet(WebView topView, WebView bottomView) {
        topView.post(new AnonymousClass1(topView));
        bottomView.post(new AnonymousClass2(bottomView));
    }

    private void Calllocal(WebView topView, WebView bottomView) {
        if (this.top) {
            sst = "file:///android_asset/AdBanner/adBanner1.html";
            ssb = "file:///android_asset/AdBanner/adBanner2.html";
            this.top = false;
        } else {
            ssb = "file:///android_asset/AdBanner/adBanner1.html";
            sst = "file:///android_asset/AdBanner/adBanner2.html";
            this.top = true;
        }
        topView.post(new AnonymousClass3(topView));
        bottomView.post(new AnonymousClass4(bottomView));
    }

    private void getGoogleAdID() {
        new Thread(new Runnable() {
            public void run() {
                getIdThread();
            }

            private void getIdThread() {
                AdvertisingIdClient.Info adInfo = null;
                try {
                    adInfo = AdvertisingIdClient.getAdvertisingIdInfo(VimapAdService.ct);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesRepairableException e2) {
                    e2.printStackTrace();
                } catch (IOException e3) {
                    e3.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e4) {
                    e4.printStackTrace();
                }
                try {
                    VimapAdService.GoogleAdId = adInfo.getId();
                } catch (Exception e5) {
                }
            }
        }).start();
    }

    protected void CheckForCounter(int TopAdCounter, int BottomAdCounter) {
        if (TopAdCounter == 1) {
            new Timer().schedule(new TimerTask() {
                public void run() {
                    VimapAdService.this.InitiateWebAddress("Top");
                }
            }, 10000);
        }
        if (BottomAdCounter == 1) {
            new Timer().schedule(new TimerTask() {
                public void run() {
                    VimapAdService.this.InitiateWebAddress("Bottom");
                }
            }, 10000);
        }
    }

    private void InitiateWebAddress(String place) {
        try {
            if (place == "Top") {
                Self_Open_TopAd = true;
            } else if (place == "Bottom") {
                Self_Open_BottomAd = true;
            }
            long downTime = SystemClock.uptimeMillis();
            long eventTime = SystemClock.uptimeMillis() + 100;
            float x = 0.0f;
            float y = 0.0f;
            DisplayMetrics DisplayMetrics = new DisplayMetrics();
            DisplayMetrics = ct.getResources().getDisplayMetrics();
            float W = (float) DisplayMetrics.widthPixels;
            float H = (float) DisplayMetrics.heightPixels;
            if (place == "Top") {
                x = W * 0.5f;
                y = H * 0.05f;
            } else if (place == "Bottom") {
                x = W * 0.5f;
                y = H * 0.5f;
            }
            MotionEvent motionEvent = MotionEvent.obtain(downTime, eventTime, 0, x, y, 0);
            MotionEvent motionEvent1 = MotionEvent.obtain(downTime, eventTime, 1, x, y, 0);
            if (place == "Top") {
                TopWebView.dispatchTouchEvent(motionEvent);
                TopWebView.dispatchTouchEvent(motionEvent1);
            } else if (place == "Bottom") {
                BottomWebView.dispatchTouchEvent(motionEvent);
                BottomWebView.dispatchTouchEvent(motionEvent1);
            }
            motionEvent.recycle();
            motionEvent1.recycle();
        } catch (Exception e) {
        }
    }

    private void ShowAds() {
        this.timer = new Timer();
        if (this.timer != null) {
            this.timer.scheduleAtFixedRate(new TimerTask() {
                public void run() {
                    EstablishLink();
                }

                private void EstablishLink() {
                    try {
                        VimapAdService.AdPath = VimapAdService.AdLINK + "?pid=" + VimapAdService.ProductID + "&Cid=" + VimapAdService.CompantyID + "&imei=" + VimapAdService.IMEI + "&GAdId=" + VimapAdService.GoogleAdId;
                        HttpClient hc = new DefaultHttpClient();
                        HttpGet request = new HttpGet(VimapAdService.AdPath);
                        request.setHeader("User-Agent", VimapAdService.UserAgent);
                        HttpResponse rp = hc.execute(request);
                        if (rp.getStatusLine().getStatusCode() == 200) {
                            StringSplitter(EntityUtils.toString(rp.getEntity()));
                        }
                    } catch (IOException e) {
                        VimapAdService.this.Calllocal(VimapAdService.TopWebView, VimapAdService.BottomWebView);
                    }
                }

                @SuppressLint({"SetJavaScriptEnabled"})
                private void StringSplitter(String response_String) {
                    try {
                        String[] ArrAdd = new String[2];
                        String[] ArrAdsTopRaw = new String[3];
                        String[] ArrAdsBottomRaw = new String[3];
                        if (response_String != null) {
                            ArrAdd = response_String.split("~~~~~");
                            if (ArrAdd.length > 0) {
                                ArrAdsTopRaw = ArrAdd[0].split(":::::");
                                ArrAdsBottomRaw = ArrAdd[1].split(":::::");
                            }
                            try {
                                VimapAdService.topUrl = ArrAdsTopRaw[0];
                                VimapAdService.bottomUrl = ArrAdsBottomRaw[0];
                                VimapAdService.this.CallNet(VimapAdService.TopWebView, VimapAdService.BottomWebView);
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            VimapAdService.this.CheckForCounter(Integer.parseInt(ArrAdsTopRaw[2].trim()), Integer.parseInt(ArrAdsBottomRaw[2].trim()));
                        }
                    } catch (Exception e2) {
                    }
                }
            }, 1000, 20000);
        }
    }

    public void StopAdService() {
        if (this.timer != null) {
            this.timer.cancel();
            this.timer = null;
            TopWebView.setVisibility(View.GONE);
            BottomWebView.setVisibility(View.GONE);
        }
    }

    public void StartAdService() {
        if (this.timer == null) {
            ShowAds();
        }
    }

    public void isTopAdVisible(boolean _bool) {
        if (_bool) {
            TopWebView.post(new Runnable() {
                public void run() {
                    VimapAdService.TopWebView.setVisibility(View.VISIBLE);
                }
            });
        } else {
            TopWebView.post(new Runnable() {
                public void run() {
                    VimapAdService.TopWebView.setVisibility(View.GONE);
                }
            });
        }
    }

    public void isBottomAdVisible(boolean _bool) {
        if (_bool) {
            BottomWebView.post(new Runnable() {
                public void run() {
                    VimapAdService.BottomWebView.setVisibility(View.VISIBLE);
                }
            });
        } else {
            BottomWebView.post(new Runnable() {
                public void run() {
                    VimapAdService.BottomWebView.setVisibility(View.GONE);
                }
            });
        }
    }

    public void ShareUrl(String url) {
        Intent sharingIntent = new Intent("android.intent.action.SEND");
        sharingIntent.setFlags(DriveFile.MODE_READ_ONLY);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra("android.intent.extra.TEXT", Uri.parse(url));
        ct.startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

}
*/
