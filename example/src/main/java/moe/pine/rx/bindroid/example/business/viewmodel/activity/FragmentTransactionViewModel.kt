package moe.pine.rx.bindroid.example.business.viewmodel.activity

import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentTransaction
import moe.pine.rx.bindroid.bindActivity
import moe.pine.rx.bindroid.example.R
import moe.pine.rx.bindroid.example.business.model.ViewPathModel
import rx.Subscription

/**
 * FragmentTransactionViewModel
 * Created by pine on 2016/03/06.
 */
class FragmentTransactionViewModel(
        private val viewPath: ViewPathModel
) {
    fun subscribe(activity: FragmentActivity): Subscription {
        return this.viewPath.viewPath.bindActivity(activity).subscribe {
            val transaction: FragmentTransaction = activity.supportFragmentManager.beginTransaction()
            transaction.replace(R.id.layer_content, it.getInstance())
            transaction.commit()
        }
    }
}