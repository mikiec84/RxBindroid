package moe.pine.rx.bindroid

import android.app.Activity
import android.app.Fragment
import android.view.View
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import rx.Observable
import kotlin.test.assertTrue

@RunWith(PowerMockRunner::class)
@PrepareForTest(RxBindroid::class)
class RxBindroidKotlinTest {
    @Before
    fun setup() {
        PowerMockito.mockStatic(RxBindroid::class.java)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun bindActivity() {
        val activity = Mockito.mock(Activity::class.java)
        val observable = Observable.just(Unit)

        Mockito.`when`(RxBindroid.bindActivity(activity, observable)).thenReturn(observable)

        assertTrue(observable === observable.bindActivity(activity))

        PowerMockito.verifyStatic()
        RxBindroid.bindActivity(activity, observable)
    }

    @Test
    fun bindFragment() {
        run {
            val fragment = Mockito.mock(Fragment::class.java)
            val observable = Observable.just(Unit)

            Mockito.`when`(RxBindroid.bindFragment(fragment, observable)).thenReturn(observable)

            assertTrue(observable === observable.bindFragment(fragment))

            PowerMockito.verifyStatic()
            RxBindroid.bindFragment(fragment, observable)
        }

        run {
            val fragment = Mockito.mock(android.support.v4.app.Fragment::class.java)
            val observable = Observable.just(Unit)

            Mockito.`when`(RxBindroid.bindFragment(fragment, observable)).thenReturn(observable)

            assertTrue(observable === observable.bindFragment(fragment))

            PowerMockito.verifyStatic()
            RxBindroid.bindFragment(fragment, observable)
        }
    }

    @Test
    fun bindView() {
        val view = Mockito.mock(View::class.java)
        val observable = Observable.just(Unit)

        Mockito.`when`(RxBindroid.bindView(view, observable)).thenReturn(observable)

        assertTrue(observable === observable.bindView(view))

        PowerMockito.verifyStatic()
        RxBindroid.bindView(view, observable)
    }
}
