package moe.pine.rx.bindroid;

import android.app.Activity;
import android.app.Fragment;
import android.view.View;

import moe.pine.rx.bindroid.app.AppObservable;
import moe.pine.rx.bindroid.view.ViewObservable;
import rx.Observable;

/**
 * RxBindroid
 * Created by pine on 2016/03/06.
 */
public class RxBindroid {
    public static <T> Observable<T> bindActivity(Activity activity, Observable<T> observable) {
        return AppObservable.bindActivity(activity, observable);
    }

    public static <T> Observable<T> bindFragment(Fragment fragment, Observable<T> observable) {
        return AppObservable.bindFragment(fragment, observable);
    }

    public static <T> Observable<T> bindFragment(android.support.v4.app.Fragment fragment, Observable<T> observable) {
        return AppObservable.bindSupportFragment(fragment, observable);
    }

    public static <T> Observable<T> bindView(View view, Observable<T> observable) {
        return ViewObservable.bindView(view, observable);
    }
}
