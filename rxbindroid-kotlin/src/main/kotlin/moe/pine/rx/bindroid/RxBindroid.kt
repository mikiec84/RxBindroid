package moe.pine.rx.bindroid

import android.app.Activity
import android.app.Fragment
import android.view.View
import rx.Observable

/**
 * RxBindroid Extensions for Observable
 * Created by pine on 2016/03/06.
 */

fun <T> Observable<T>.bindActivity(activity: Activity): Observable<T> {
    return RxBindroid.bindActivity(activity, this)
}

fun <T> Observable<T>.bindFragment(fragment: Fragment): Observable<T> {
    return RxBindroid.bindFragment(fragment, this)
}

fun <T> Observable<T>.bindFragment(fragment: android.support.v4.app.Fragment): Observable<T> {
    return RxBindroid.bindFragment(fragment, this)
}

fun <T> Observable<T>.bindView(view: View): Observable<T> {
    return RxBindroid.bindView(view, this)
}