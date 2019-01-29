package vn.com.newsviet.Utils;

import android.util.Log;

public class MyLog {
    private static boolean candebug = true;

    public static void Log(String msg) {
        if (candebug) {
            Log.e("tusinh", msg);
        }
    }
}
