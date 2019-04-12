package com.gandan.android.hyperconnect

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = this.findViewById<TextView>(R.id.tv)
        Observable.timer(1, TimeUnit.SECONDS, Schedulers.io())
                .subscribe {unused ->
                    (textView.setText("Hello, World"));
                }
    }
}
