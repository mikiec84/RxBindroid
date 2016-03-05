package moe.pine.rx.bindroid.example.business.data

import android.support.v4.app.Fragment
import moe.pine.rx.bindroid.example.presentation.fragment.DefaultFragment
import moe.pine.rx.bindroid.example.presentation.fragment.ViewPathFragmentInterface

/**
 * ViewPath
 * Created by pine on 2016/03/06.
 */
enum class ViewPath(
        private val fragment: ViewPathFragmentInterface
) {
    Default(DefaultFragment.Companion)

    ;

    fun getInstance(): Fragment {
        return this.fragment.getInstance()
    }
}