package com.balthild.asymcexample

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.coroutines.experimental.async

/**
 * A placeholder fragment containing a simple view.
 */
class MainActivityFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // return inflater.inflate(R.layout.fragment_main, container, false)

        val layout = inflater.inflate(R.layout.fragment_main, container, false)
        val tv = layout.findViewById<TextView>(R.id.tv)

        println("Some log")

        async {
            println("Async log")

            activity.runOnUiThread {
                tv.text = "Async message"
            }
        }

        return layout
    }
}
