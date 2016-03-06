package moe.pine.rx.bindroid.example.business.viewmodel.count

import android.widget.Button
import com.jakewharton.rxbinding.view.clicks
import moe.pine.rx.bindroid.example.business.model.CountModel
import rx.Subscription
import java.util.concurrent.TimeUnit

/**
 * CountDownButtonViewModel
 * Created by pine on 2016/03/06.
 */
class CountDownButtonViewModel(
        private val button: Button,
        private val count: CountModel
) {
    fun subscribe(): Subscription {
        return this.button.clicks().throttleFirst(100, TimeUnit.MILLISECONDS).subscribe {
            this.count.decrement()
        }
    }
}