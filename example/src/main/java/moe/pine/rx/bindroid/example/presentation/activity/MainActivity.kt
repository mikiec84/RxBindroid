package moe.pine.rx.bindroid.example.presentation.activity

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import moe.pine.rx.bindroid.example.R
import moe.pine.rx.bindroid.example.business.Models
import moe.pine.rx.bindroid.example.business.viewmodel.activity.FragmentTransactionViewModel

/**
 * MainActivity
 * Created by pine on 2016/03/06.
 */
class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.bindViewModel()
    }

    private fun bindViewModel() {
        FragmentTransactionViewModel(Models.viewPath).subscribe(this)
    }
}
