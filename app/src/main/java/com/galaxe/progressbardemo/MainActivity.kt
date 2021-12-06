package com.galaxe.progressbardemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var progressBar: ProgressBar
    lateinit var button: Button
    lateinit var textV: TextView

    var handler = Handler()
    var i: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.myProgress)
        button = findViewById(R.id.myButton)
        textV = findViewById(R.id.myText)

        button.setOnClickListener(View.OnClickListener {

            progressBar.visibility = View.VISIBLE
            i = progressBar.progress


            Thread {
                while (i < 100) {
                    i += 1
                    handler.post {

                        progressBar.progress = i

                        textV.text = i.toString() + "/" + progressBar.max
                    }
                    try {
                        Thread.sleep(100)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
                progressBar.visibility = View.INVISIBLE

            }.start()

        })
    }
}