package moe.pine.rx.bindroid

import android.app.Activity
import android.app.Fragment
import android.view.View
import moe.pine.rx.bindroid.app.AppObservable
import moe.pine.rx.bindroid.view.ViewObservable
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import rx.Observable
import kotlin.test.assertTrue

/**
 * Test for RxBindroid
 * Created by pine on 2016/03/06.
 */
@RunWith(PowerMockRunner::class)
@PrepareForTest(AppObservable::class, ViewObservable::class)
class RxBindroidTest {
    @Test
    fun bindActivity() {
        PowerMockito.mockStatic(AppObservable::class.java)

        val activity = Mockito.mock(Activity::class.java)
        val observable = Observable.just(Unit)

        Mockito.`when`(AppObservable.bindActivity(activity, observable)).thenReturn(observable)

        assertTrue(observable === RxBindroid.bindActivity(activity, observable))

        PowerMockito.verifyStatic()
        AppObservable.bindActivity(activity, observable)
    }

    @Test
    fun bindFragment() {
        PowerMockito.mockStatic(AppObservable::class.java)

        run {
            val fragment = Mockito.mock(Fragment::class.java)
            val observable = Observable.just(Unit)

            Mockito.`when`(AppObservable.bindFragment(fragment, observable)).thenReturn(observable)

            assertTrue(observable === RxBindroid.bindFragment(fragment, observable))

            PowerMockito.verifyStatic()
            AppObservable.bindFragment(fragment, observable)
        }

        run {
            val fragment = Mockito.mock(android.support.v4.app.Fragment::class.java)
            val observable = Observable.just(Unit)

            Mockito.`when`(AppObservable.bindSupportFragment(fragment, observable)).thenReturn(observable)

            assertTrue(observable === RxBindroid.bindFragment(fragment, observable))

            PowerMockito.verifyStatic()
            AppObservable.bindSupportFragment(fragment, observable)
        }
    }

    @Test
    fun bindView() {
        PowerMockito.mockStatic(ViewObservable::class.java)

        val view = Mockito.mock(View::class.java)
        val observable = Observable.just(Unit)

        Mockito.`when`(ViewObservable.bindView(view, observable)).thenReturn(observable)

        assertTrue(observable === RxBindroid.bindView(view, observable))

        PowerMockito.verifyStatic()
        ViewObservable.bindView(view, observable)
    }
}