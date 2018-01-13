package com.balthild.asymcexample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.coroutines.experimental.EmptyCoroutineContext
import kotlin.coroutines.experimental.startCoroutine

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

        invokeSuspendWithoutDispatcher {
            println("Suspend log")
            tv.text = "Suspend message"
        }

        return layout
    }

    private fun invokeSuspendWithoutDispatcher(block: suspend () -> Unit) {
        block.startCoroutine(object: Continuation<Unit> {
            override val context: CoroutineContext get() = EmptyCoroutineContext
            override fun resume(value: Unit) {}
            override fun resumeWithException(exception: Throwable) {}
        })
    }
}
