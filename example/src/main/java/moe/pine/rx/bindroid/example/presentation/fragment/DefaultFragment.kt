package moe.pine.rx.bindroid.example.presentation.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import butterknife.bindView
import com.jakewharton.rxbinding.widget.text
import moe.pine.rx.bindroid.bindView
import moe.pine.rx.bindroid.example.R
import moe.pine.rx.bindroid.example.business.Models
import moe.pine.rx.bindroid.example.business.viewmodel.count.CountDownButtonViewModel
import moe.pine.rx.bindroid.example.business.viewmodel.count.CountUpButtonViewModel

/**
 * DefaultFragment
 * Created by pine on 2016/03/06.
 */
class DefaultFragment : Fragment() {
    val countTextView: TextView by bindView(R.id.default_count)
    val incrementButton: Button by bindView(R.id.default_incr_button)
    val decrementButton: Button by bindView(R.id.default_decr_button)

    companion object : ViewPathFragmentInterface {
        override fun getInstance(): Fragment {
            return DefaultFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_default, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.bindViewModel()
    }

    private fun bindViewModel() {
        val count = Models.count
        CountUpButtonViewModel(this.incrementButton, count).subscribe()
        CountDownButtonViewModel(this.decrementButton, count).subscribe()
        count.count.map { it.toString() }.bindView(this.countTextView).subscribe(this.countTextView.text())
    }
}