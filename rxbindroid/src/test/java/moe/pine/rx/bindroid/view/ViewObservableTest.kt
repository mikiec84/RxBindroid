package moe.pine.rx.bindroid.view

import android.app.Activity
import android.view.View
import android.widget.LinearLayout
import moe.pine.rx.bindroid.DebugBuildConfig
import moe.pine.rx.bindroid.RxBindroid
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import rx.observers.TestSubscriber
import rx.subjects.PublishSubject

/**
 * ViewObservableTest
 * Created by matsushita on 2016/03/07.
 */
@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE, constants = DebugBuildConfig::class)
class ViewObservableTest {
    @Test
    fun bindView() {
        // Setup views
        val activity = Robolectric.buildActivity(Activity::class.java).create()
        val layout = LinearLayout(activity.get())
        val view = View(activity.get())

        // Bind
        val observable = PublishSubject.create<Int>()
        val subscriber = TestSubscriber<Int>()
        RxBindroid.bindView(view, observable).subscribe(subscriber)

        // Assert

        // 1. view has not beed added to activity
        observable.onNext(0)
        subscriber.assertValueCount(1)

        // 2. view has beed added to activity
        layout.addView(view)
        activity.get().setContentView(layout)
        activity.start().resume().visible()

        observable.onNext(1)
        subscriber.assertValueCount(2)

        // 3. view has beed removed from activity
        layout.removeAllViews()

        observable.onNext(2)
        subscriber.assertValueCount(2) // not increased
        subscriber.assertValues(0, 1)
    }
}
