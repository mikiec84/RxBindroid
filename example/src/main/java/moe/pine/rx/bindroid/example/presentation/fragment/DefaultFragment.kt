package moe.pine.rx.bindroid.example.presentation.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import butterknife.bindView
import com.jakewharton.rxbinding.view.clicks
import moe.pine.rx.bindroid.bindFragment
import moe.pine.rx.bindroid.bindView
import moe.pine.rx.bindroid.example.R
import rx.Observable

/**
 * DefaultFragment
 * Created by pine on 2016/03/06.
 */
class DefaultFragment : Fragment() {
    val addButton: Button by bindView(R.id.default_add_button)

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

        this.addButton.clicks().bindView(this.addButton).subscribe {
            println("clicks")
        }
    }
}