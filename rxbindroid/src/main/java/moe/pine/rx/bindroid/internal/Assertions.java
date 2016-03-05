package moe.pine.rx.bindroid.internal;

import android.os.Looper;

/**
 * Assertion Utilities
 * Created by pine on 2016/03/06.
 */
public class Assertions {
    public static void assertUiThread() {
        assert (Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
