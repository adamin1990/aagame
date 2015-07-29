package com.lt.adamlee.aagame;

import com.google.android.gms.games.GamesActivityResultCodes;

/**
 * Created by Administrator on 2015/7/29.
 */
public class DefaultData {
    public static String RateUrl;
    public static int cid;
    public static String defaultUrl;
    public static String pid_game;
    public static String score_row;

    static {
        cid = GamesActivityResultCodes.RESULT_LICENSE_FAILED;
        score_row = "10";
        pid_game = "814";
        RateUrl = "http://www.vimapservices.com/wap/index.aspx?Cid=" + cid + "&Appid=" + pid_game;
        defaultUrl = "http://www.vimapservices.com/wap/index.aspx?Cid=" + cid;
    }

}
