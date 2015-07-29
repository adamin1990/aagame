package com.lt.adamlee.aagame;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.media.browse.MediaBrowser;
import android.os.Handler;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

//import com.google.android.gms.common.ConnectionResult;
//import com.google.android.gms.common.GooglePlayServicesUtil;
//import com.google.android.gms.common.api.GoogleApiClient;
////import com.google.android.gms.common.api.GoogleApiClient.Builder;
//import com.google.android.gms.games.Games;
//import com.google.android.gms.games.GamesActivityResultCodes;
//import com.google.android.gms.games.Player;
//import com.google.android.gms.games.request.GameRequest;
////import com.google.android.gms.plus.Plus;

import java.util.ArrayList;


public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    static final int DEFAULT_MAX_SIGN_IN_ATTEMPTS = 3;
    protected static String PlayerName = null;
    static final int RC_RESOLVE = 9001;
    private static final int RC_SIGN_IN = 9001;
    static final int RC_UNUSED = 9002;
    public static final int REQUEST_CODE_RECOVER_PLAY_SERVICES = 1001;
    private static final String TAG;
    public static int gameLevel;
    public static boolean isResume;
    protected static boolean isScoreSubmitted;
    public static int page;
//    static VimapAdService vimapad;
    private final String GAMEHELPER_SHARED_PREFS;
    public int HighScore;
    private final String KEY_SIGN_IN_CANCELLATIONS;
    private String LEADERBOARD_ID;
    final int REQUEST_LEADERBOARD;
    protected Context context;
    AppCompatActivity mActivity;
    Context mAppContext;
    boolean mConnectOnStart;
    protected boolean mConnecting;
//    ConnectionResult mConnectionResult;
    boolean mDebugLog;
    boolean mExpectingResolution;
//    private GoogleApiClient mGoogleApiClient;
    Handler mHandler;
    private int mMaxAutoSignInAttempts;
    boolean mShowErrorDialogs;
    boolean mSignInCancelled;
    boolean mUserInitiatedSignIn;
    RelativeLayout rolLayout;


    public GameActivity() {
        this.HighScore = 0;
        this.mConnectOnStart = true;
        this.mUserInitiatedSignIn = false;
//        this.mConnectionResult = null;
        this.mMaxAutoSignInAttempts = DEFAULT_MAX_SIGN_IN_ATTEMPTS;
        this.mConnecting = false;
        this.mExpectingResolution = false;
        this.mSignInCancelled = false;
        this.REQUEST_LEADERBOARD = 1;
        this.GAMEHELPER_SHARED_PREFS = "GAMEHELPER_SHARED_PREFS";
        this.KEY_SIGN_IN_CANCELLATIONS = "KEY_SIGN_IN_CANCELLATIONS";
        this.mActivity = null;
        this.mAppContext = null;
        this.mShowErrorDialogs = true;
        this.mDebugLog = false;

    }

    static {
        isResume = true;
        page = 1;
        gameLevel = 1;
//        vimapad = new VimapAdService();
        PlayerName = "?????";
        TAG = null;
        isScoreSubmitted = false;

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getState();
        getWindow().setFlags(AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT, AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
        getWindow().setFlags(TransportMediator.FLAG_KEY_MEDIA_NEXT, TransportMediator.FLAG_KEY_MEDIA_NEXT);

        super.onCreate(savedInstanceState);
        isScoreSubmitted = false;
//        checkGooglPlayService();
//        this.mGoogleApiClient = new Builder(this).addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
//            @Override
//            public void onConnected(Bundle bundle) {
//
//            }
//
//            @Override
//            public void onConnectionSuspended(int i) {
//
//            }
//        }).addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener() {
//            @Override
//            public void onConnectionFailed(ConnectionResult connectionResult) {
//
//            }
//        }).addApi(Plus.API).addScope(Plus.SCOPE_PLUS_LOGIN).addApi(Games.API).addScope(Games.SCOPE_GAMES).build();
        this.LEADERBOARD_ID = getString(R.string.leaderboard_id);
        this.mActivity = this;
//        if (DefaultData.cid == GamesActivityResultCodes.RESULT_LICENSE_FAILED) {
//            DefaultData.defaultUrl = "https://play.google.com/store/search?q=Cool%20Tiny%20Games&c=apps";
//            DefaultData.RateUrl = "https://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName();
//            System.out.println("rate url" + DefaultData.RateUrl);
//        } else if (DefaultData.cid == GamesActivityResultCodes.RESULT_SEND_REQUEST_FAILED) {
//            DefaultData.defaultUrl = "sam://search?pub:{vimapservices12}";
//            DefaultData.RateUrl = "sam://details?id=" + getApplicationContext().getPackageName();
//        }
        setContentView(R.layout.activity_game);
        this.rolLayout = (RelativeLayout) findViewById(R.id.RelativeLayout1   );
//        vimapad.addView(this, this.rolLayout, true, true, DefaultData.cid, Integer.parseInt(DefaultData.pid_game), true);
//        vimapad.isBottomAdVisible(true);
//        vimapad.isTopAdVisible(false);

    }

    public void getState() {
        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
        if (preferences.contains("currentLevel")) {
            gameLevel = Integer.parseInt(preferences.getString("currentLevel", null));
        }
    }
    protected void onStart() {
        super.onStart();
        this.context = getApplicationContext();
        this.mActivity = this;
//        if (!this.mConnectOnStart) {
//            Log.d(TAG, "Not attempting to connect becase mConnectOnStart=false");
//        } else if (this.mGoogleApiClient.isConnected()) {
//            Log.w(TAG, "GameHelper: client was already connected on onStart()");
//        } else {
//            Log.d(TAG, "Connecting client.");
//            this.mConnecting = true;
//            this.mGoogleApiClient.connect();
//        }
    }

    protected void onResume() {
        super.onResume();
        isResume = true;
        GameView.mainpage = page;
    }

    protected void onPause() {
        super.onPause();
        isResume = false;
        page = GameView.mainpage;
    }

    protected void onStop() {
        super.onStop();
//        if (this.mGoogleApiClient.isConnected()) {
//            this.mGoogleApiClient.disconnect();
//        }
        this.mConnecting = false;
        this.mExpectingResolution = false;
        this.mActivity = null;
    }

    public void saveState() {
        SharedPreferences.Editor editor = getPreferences(0).edit();
        if (gameLevel > GameView.levelcounter) {

            editor.putString("currentLevel", String.valueOf(gameLevel));
            editor.commit();
            return;
        }
        editor = getPreferences(0).edit();
        editor.putString("currentLevel", String.valueOf(GameView.levelcounter));
        editor.commit();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4 && event.getRepeatCount() == 0) {
            if (GameView.mainpage == 1 && !GameView.bak4) {
                GameView.mainpage = -1;
//                vimapad.isBottomAdVisible(true);
//                vimapad.isTopAdVisible(false);
            }
            if (GameView.mainpage == DEFAULT_MAX_SIGN_IN_ATTEMPTS) {
                GameView.mainpage = 1;
//                vimapad.isBottomAdVisible(true);
//                vimapad.isTopAdVisible(false);
//                beginUserInitiatedSignIn();
//                if (isSignedIn()) {
//                    submitScoreAndShowLeaderBoard();
//                }
                saveState();
                GameView.reset();
            }
            if (GameView.mainpage == 4) {
                GameView.mainpage = 1;
                GameView.reset();
            }
            if (GameView.mainpage == 5) {
                GameView.mainpage = 1;
                GameView.reset();
            }
            if (GameView.mainpage == 6) {
                int j;
                GameView.mainpage = DEFAULT_MAX_SIGN_IN_ATTEMPTS;
//                vimapad.isBottomAdVisible(true);
//                vimapad.isTopAdVisible(false);
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
            if (GameView.mainpage == 7) {
                GameView.mainpage = 1;
                GameView.reset();
            }
        }
        return true;
    }

//    boolean checkGooglPlayService() {
//        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
//        if (status == 0) {
//            return true;
//        }
//        if (GooglePlayServicesUtil.isUserRecoverableError(status)) {
//            showErrorDialog(status);
//        } else {
//            Toast.makeText(this, "This device is not supported.", Toast.LENGTH_SHORT).show();
//            finish();
//        }
//        return false;
//    }

//    void showErrorDialog(int code) {
//        GooglePlayServicesUtil.getErrorDialog(code, this, REQUEST_CODE_RECOVER_PLAY_SERVICES).show();
//    }

//    protected void submitScoreAndShowLeaderBoard() {
//        if (isSignedIn()) {
//            Games.Leaderboards.submitScore(this.mGoogleApiClient, this.LEADERBOARD_ID, (long) gameLevel);
//            Toast.makeText(this, getString(R.string.Your_Score_uploading), Toast.LENGTH_SHORT).show();
//            onShowLeaderboardsRequested();
//            isScoreSubmitted = true;
//        }
//    }

    public void onClick(View v) {
    }

//    public void onConnected(Bundle bundle) {
//        try {
//            succeedSignIn();
////            Player p = Games.Players.getCurrentPlayer(this.mGoogleApiClient);
//            if (p != null) {
//                PlayerName = p.getDisplayName();
//            }
//            if (bundle != null) {
//                String TAG = "SubmitScore";
//                ArrayList<GameRequest> requests = Games.Requests.getGameRequestsFromBundle(bundle);
//                if (!requests.isEmpty()) {
//                    Log.d(TAG, "onConnected: connection hint has " + requests.size() + " request(s)");
//                }
//                Log.d(TAG, "===========\nRequests count " + requests.size());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    protected boolean isSignedIn() {
//        return this.mGoogleApiClient != null && this.mGoogleApiClient.isConnected();
//    }
//
//    protected void onShowLeaderboardsRequested() {
//        if (isSignedIn()) {
//            startActivityForResult(Games.Leaderboards.getLeaderboardIntent(this.mGoogleApiClient, this.LEADERBOARD_ID), 1);
//        }
//    }

    public static Dialog makeSimpleDialog(Activity activity, String text) {
        return new AlertDialog.Builder(activity).setMessage(text).setNeutralButton(R.string.app_name, null).create();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == REQUEST_CODE_RECOVER_PLAY_SERVICES && resultCode == 0) {
            Toast.makeText(this, "Google Play Services must be installed.", Toast.LENGTH_SHORT).show();
            finish();
        }
        int prevCancellations;
        if (requestCode == 1) {
            if (requestCode == RC_SIGN_IN && this.mConnecting) {
                this.mExpectingResolution = false;
                if (requestCode != RC_SIGN_IN) {
                }
                if (resultCode == -1) {
//                    this.mGoogleApiClient.connect();
                }
//                else if (resultCode == GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED) {
//                    Log.d(TAG, "onAR: Resolution was RECONNECT_REQUIRED, so reconnecting.");
//                    connect();
//                }
                else if (resultCode != 0) {
                    Log.d(TAG, "onAR: Got a cancellation result, so disconnecting.");
                    this.mSignInCancelled = true;
                    this.mConnectOnStart = false;
                    this.mUserInitiatedSignIn = false;
                    this.mConnecting = false;
//                    this.mGoogleApiClient.disconnect();
                    prevCancellations = getSignInCancellations();
                    Log.d(TAG, "onAR: # of cancellations " + prevCancellations + " --> " + incrementSignInCancellations() + ", max " + this.mMaxAutoSignInAttempts);
                } else {
//                    showActivityResultError(this, requestCode, resultCode, R.string.SignIn_Failure);
                }
            }
        } else if (requestCode == RC_SIGN_IN) {
            this.mExpectingResolution = false;
            if (requestCode != RC_SIGN_IN) {
                if (resultCode == -1) {
//                    this.mGoogleApiClient.connect();
                }
//                else if (resultCode == GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED) {
//                    Log.d(TAG, "onAR: Resolution was RECONNECT_REQUIRED, so reconnecting.");
//                    connect();
//                }
                else if (resultCode != 0) {
//                    showActivityResultError(this, requestCode, resultCode, R.string.SignIn_Failure);
                } else {
                    Log.d(TAG, "onAR: Got a cancellation result, so disconnecting.");
                    this.mSignInCancelled = true;
                    this.mConnectOnStart = false;
                    this.mUserInitiatedSignIn = false;
                    this.mConnecting = false;
//                    this.mGoogleApiClient.disconnect();
                    prevCancellations = getSignInCancellations();
                    Log.d(TAG, "onAR: # of cancellations " + prevCancellations + " --> " + incrementSignInCancellations() + ", max " + this.mMaxAutoSignInAttempts);
                }
            }
        }
    }

//    public void showActivityResultError(Activity activity, int requestCode, int actResp, int errorDescription) {
//        if (activity == null) {
//            Log.e("BaseGameUtils", "*** No Activity. Can't show failure dialog!");
//            return;
//        }
//        Dialog errorDialog;
//        switch (actResp) {
//            case GamesActivityResultCodes.RESULT_SIGN_IN_FAILED /*10002*/:
//                errorDialog = null;
//                AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
//                alertbox.setMessage(R.string.SignIn_Failure);
//                alertbox.setNeutralButton("ok", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface arg0, int arg1) {
//                    }
//                });
//                alertbox.show();
//                break;
//            case GamesActivityResultCodes.RESULT_LICENSE_FAILED /*10003*/:
//                errorDialog = makeSimpleDialog(activity, activity.getString(R.string.License_expired));
//                break;
//            case GamesActivityResultCodes.RESULT_APP_MISCONFIGURED /*10004*/:
//                errorDialog = makeSimpleDialog(activity, activity.getString(R.string.app_misconfigured));
//                break;
//            default:
//                errorDialog = GooglePlayServicesUtil.getErrorDialog(GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity), activity, requestCode, null);
//                if (errorDialog == null) {
//                    Log.e("BaseGamesUtils", "No standard error dialog available. Making fallback dialog.");
//                    errorDialog = makeSimpleDialog(activity, activity.getString(errorDescription));
//                    break;
//                }
//                break;
//        }
//        if (errorDialog != null) {
//            errorDialog.show();
//        }
//    }

//    public static boolean resolveConnectionFailure(Activity activity, GoogleApiClient client, ConnectionResult result, int requestCode, String fallbackErrorMessage) {
//        if (result.hasResolution()) {
//            try {
//                result.startResolutionForResult(activity, requestCode);
//                return true;
//            } catch (IntentSender.SendIntentException e) {
//                client.connect();
//                return false;
//            }
//        }
//        Dialog dialog = GooglePlayServicesUtil.getErrorDialog(result.getErrorCode(), activity, requestCode);
//        if (dialog != null) {
//            dialog.show();
//            return false;
//        }
//        showAlert(activity, fallbackErrorMessage);
//        return false;
//    }

    public static void showAlert(Activity activity, String message) {
        new AlertDialog.Builder(activity).setMessage(message).setNeutralButton(R.string.app_name, null).create().show();
    }

    int getSignInCancellations() {
        return this.context.getSharedPreferences("GAMEHELPER_SHARED_PREFS", 0).getInt("KEY_SIGN_IN_CANCELLATIONS", 0);
    }

    int incrementSignInCancellations() {
        int cancellations = getSignInCancellations();
        SharedPreferences.Editor editor = this.context.getSharedPreferences("GAMEHELPER_SHARED_PREFS", 0).edit();
        editor.putInt("KEY_SIGN_IN_CANCELLATIONS", cancellations + 1);
        editor.commit();
        return cancellations + 1;
    }

    void resetSignInCancellations() {
        SharedPreferences.Editor editor = this.context.getSharedPreferences("GAMEHELPER_SHARED_PREFS", 0).edit();
        editor.putInt("KEY_SIGN_IN_CANCELLATIONS", 0);
        editor.commit();
    }

//    void connect() {
//        String Tag = "connect";
//        if (this.mGoogleApiClient.isConnected()) {
//            Log.d(Tag, "Already connected.");
//            return;
//        }
//        Log.d(Tag, "Starting connection.");
//        this.mConnecting = true;
//        this.mGoogleApiClient.connect();
//    }

//    public void disconnect() {
//        String TAG = "SignIn";
//        if (this.mGoogleApiClient.isConnected()) {
//            Log.d(TAG, "Disconnecting client.");
//            this.mGoogleApiClient.disconnect();
//            return;
//        }
//        Log.d(TAG, "disconnect() called when client was already disconnected.");
//    }

    public void setMaxAutoSignInAttempts(int max) {
        this.mMaxAutoSignInAttempts = max;
    }

//    public GoogleApiClient getApiClient() {
//        if (this.mGoogleApiClient != null) {
//            return this.mGoogleApiClient;
//        }
//        throw new IllegalStateException("No GoogleApiClient. Did you call setup()?");
//    }

    public boolean isConnecting() {
        return this.mConnecting;
    }

    public void setShowErrorDialogs(boolean show) {
        this.mShowErrorDialogs = show;
    }

    public void enableDebugLog(boolean enabled) {
        this.mDebugLog = enabled;
        if (enabled) {
            debugLog("Debug log enabled.");
        }
    }

    @Deprecated
    public void enableDebugLog(boolean enabled, String tag) {
        Log.w(TAG, "GameHelper.enableDebugLog(boolean,String) is deprecated. Use GameHelper.enableDebugLog(boolean)");
        enableDebugLog(enabled);
    }

//    public void beginUserInitiatedSignIn() {
//        debugLog("beginUserInitiatedSignIn: resetting attempt count.");
//        resetSignInCancellations();
//        this.mSignInCancelled = false;
//        this.mConnectOnStart = true;
//        if (this.mGoogleApiClient.isConnected()) {
//            logWarn("beginUserInitiatedSignIn() called when already connected. Calling listener directly to notify of success.");
//            return;
//        }
//        logWarn("beginUserInitiatedSignIn() called when already connecting. Be patient! You can only call this method after you get an onSignInSucceeded() or onSignInFailed() callback. Suggestion: disable the sign-in button on startup and also when it's clicked, and re-enable when you get the callback.");
//        connect();
//        this.mConnecting = true;
//        debugLog("Starting USER-INITIATED sign-in flow.");
//        this.mUserInitiatedSignIn = true;
//        if (this.mConnectionResult != null) {
//            debugLog("beginUserInitiatedSignIn: continuing pending sign-in flow.");
//            this.mConnecting = true;
//            resolveConnectionResult();
//        }
//        debugLog("beginUserInitiatedSignIn: starting new sign-in flow.");
//    }

//    public void reconnectClient() {
//        if (this.mGoogleApiClient.isConnected()) {
//            debugLog("Reconnecting client.");
//            this.mGoogleApiClient.reconnect();
//            return;
//        }
//        Log.w(TAG, "reconnectClient() called when client is not connected.");
//        connect();
//    }

    void succeedSignIn() {
        debugLog("succeedSignIn");
        this.mConnectOnStart = true;
        this.mUserInitiatedSignIn = false;
        this.mConnecting = false;
    }
//
//    public void onConnectionFailed(ConnectionResult result) {
//        boolean shouldResolve;
//        debugLog("onConnectionFailed");
//        this.mConnectionResult = result;
//        debugLog("Connection failure:");
//        debugLog("   - resolvable: " + this.mConnectionResult.hasResolution());
//        debugLog("   - details: " + this.mConnectionResult.toString());
//        int cancellations = getSignInCancellations();
//        if (this.mUserInitiatedSignIn) {
//            debugLog("onConnectionFailed: WILL resolve because user initiated sign-in.");
//            shouldResolve = true;
//        } else if (this.mSignInCancelled) {
//            debugLog("onConnectionFailed WILL NOT resolve (user already cancelled once).");
//            shouldResolve = false;
//        } else if (cancellations < this.mMaxAutoSignInAttempts) {
//            debugLog("onConnectionFailed: WILL resolve because we have below the max# of attempts, " + cancellations + " < " + this.mMaxAutoSignInAttempts);
//            shouldResolve = true;
//        } else {
//            shouldResolve = false;
//            debugLog("onConnectionFailed: Will NOT resolve; not user-initiated and max attempts reached: " + cancellations + " >= " + this.mMaxAutoSignInAttempts);
//        }
//        if (shouldResolve) {
//            debugLog("onConnectionFailed: resolving problem...");
//            resolveConnectionResult();
//            return;
//        }
//        debugLog("onConnectionFailed: since we won't resolve, failing now.");
//        this.mConnectionResult = result;
//        this.mConnecting = false;
//    }

//    void resolveConnectionResult() {
//        if (this.mExpectingResolution) {
//            debugLog("We're already expecting the result of a previous resolution.");
//            return;
//        }
//        System.out.println("resolveConnectionResult() 11111111111111111");
//        debugLog("resolveConnectionResult: trying to resolve result: " + this.mConnectionResult);
//        if (this.mActivity == null || !this.mConnectionResult.hasResolution()) {
//            debugLog("resolveConnectionResult: result has no resolution. Giving up.");
//            return;
//        }
//        debugLog("Result has resolution. Starting it.");
//        try {
//            this.mExpectingResolution = true;
//            this.mConnectionResult.startResolutionForResult(this.mActivity, RC_SIGN_IN);
//        } catch (IntentSender.SendIntentException e) {
//            debugLog("SendIntentException, so connecting again.");
//            connect();
//        }
//    }

    static Dialog makeSimpleDialog(Activity activity, String title, String text) {
        return new AlertDialog.Builder(activity).setMessage(text).setTitle(title).setNeutralButton(R.string.app_name, null).create();
    }

    public Dialog makeSimpleDialog(String text) {
        if (this.mActivity != null) {
            return makeSimpleDialog(this.mActivity, text);
        }
        logError("*** makeSimpleDialog failed: no current Activity!");
        return null;
    }

    public Dialog makeSimpleDialog(String title, String text) {
        if (this.mActivity != null) {
            return makeSimpleDialog(this.mActivity, title, text);
        }
        logError("*** makeSimpleDialog failed: no current Activity!");
        return null;
    }

    void debugLog(String message) {
        if (this.mDebugLog) {
            Log.d(TAG, "GameHelper: " + message);
        }
    }

    void logWarn(String message) {
        Log.w(TAG, "!!! GameHelper WARNING: " + message);
    }

    void logError(String message) {
        Log.e(TAG, "*** GameHelper ERROR: " + message);
    }

    public void setConnectOnStart(boolean connectOnStart) {
        debugLog("Forcing mConnectOnStart=" + connectOnStart);
        this.mConnectOnStart = connectOnStart;
    }

    public void onConnectionSuspended(int cause) {
        debugLog("onConnectionSuspended, cause=" + cause);
//        disconnect();
        debugLog("Making extraordinary call to onSignInFailed callback");
        this.mConnecting = false;
    }




}
